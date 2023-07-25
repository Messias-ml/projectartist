package com.messiasproject.projectartist.api.controller;

import com.messiasproject.projectartist.api.openapi.ArtistOpenApi;
import com.messiasproject.projectartist.domain.service.ArtistsService;
import com.messiasproject.projectartist.model.artist.ArtistDetailModel;
import com.messiasproject.projectartist.model.artist.setlist.ListArtistModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("artist")
@Tag(name = "Artist", description = "Api to integration with setlist of artist and artist")
public class ArtistController implements ArtistOpenApi {

    @Autowired
    private ArtistsService artistsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ListArtistModel findArtists(@RequestParam String nameArtist, @RequestParam(defaultValue = "1") Integer page) {
        return artistsService.findArtists(nameArtist, page);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArtistDetailModel findDetailArtist(@PathVariable String id) {
        return artistsService.findArtistDetail(id);
    }
}
