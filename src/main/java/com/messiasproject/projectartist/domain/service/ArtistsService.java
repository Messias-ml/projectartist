package com.messiasproject.projectartist.domain.service;

import com.messiasproject.projectartist.infrastructure.ArtistDetail;
import com.messiasproject.projectartist.infrastructure.SearchArtists;
import com.messiasproject.projectartist.model.artist.ArtistDetailModel;
import com.messiasproject.projectartist.model.artist.setlist.ListArtistModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArtistsService {

    private SearchArtists searchArtists;

    private ArtistDetail artistDetail;

    public ListArtistModel findArtists(String nameArtist, Integer page) {
        return searchArtists.findArtists(nameArtist, page);
    }

    public ArtistDetailModel findArtistDetail(String id) {
        return artistDetail.findArtistDetail(id);
    }
}
