package com.messiasproject.projectartist.domain.service.imple;

import com.messiasproject.projectartist.infrastructure.ArtistDetail;
import com.messiasproject.projectartist.infrastructure.SearchArtists;
import com.messiasproject.projectartist.model.artist.ArtistDetailModel;
import com.messiasproject.projectartist.model.artist.setlist.LastArtistSetList;
import com.messiasproject.projectartist.model.artist.setlist.ListArtistModel;
import com.messiasproject.projectartist.model.artist.setlist.ListSetListArtist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.messiasproject.projectartist.core.config.RestTemplateConfig.getRestTemplate;
import static com.messiasproject.projectartist.core.config.RestTemplateConfig.getRestTemplateLast;

@Component
public class ArtistImplementationService implements ArtistDetail, SearchArtists {

    @Value("${api-key}")
    String apiKey;

    @Value("${url-artist-setlist}")
    String urlArtistSetList;

    @Value("${url-artist-last}")
    String urlArtistLast;
    @Value("${url-api-last}")
    String urlApiLast;
    RestTemplate restTemplateLast = getRestTemplateLast();
    RestTemplate restTemplate = getRestTemplate();

    @Override
    public ListArtistModel findArtists(String nameArtist, Integer page) {
        String urlExternalAPI = String.format(urlArtistSetList, nameArtist, page);
        ListArtistModel listArtistModel = restTemplate.getForObject(urlExternalAPI, ListArtistModel.class);
        BigDecimal pageDivisor = listArtistModel.getTotal().divide(BigDecimal.valueOf(30), RoundingMode.UP);
        listArtistModel.setTotalPage(Integer.parseInt(String.valueOf(pageDivisor)));
        return listArtistModel;
    }

    @Override
    public ArtistDetailModel findArtistDetail(String id) {
        String urlExternalAPI = String.format(urlApiLast, id, apiKey);
        ArtistDetailModel detailArtist = restTemplateLast.getForObject(urlExternalAPI, ArtistDetailModel.class);
        detailArtist.setLastArtistSetList(findLastSetListArtist(id));
        return detailArtist;
    }

    private LastArtistSetList findLastSetListArtist(String id) {
        String urlExternalAPI = String.format(urlArtistLast, id);
        ListSetListArtist listSetListArtist = restTemplate.getForObject(urlExternalAPI, ListSetListArtist.class);
        return listSetListArtist.getSetlist().get(0);
    }
}
