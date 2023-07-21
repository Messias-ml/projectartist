package com.messiasproject.projectartist.controller;

import com.messiasproject.projectartist.domain.service.ArtistsService;
import com.messiasproject.projectartist.model.artist.ArtistDetailModel;
import com.messiasproject.projectartist.model.artist.setlist.ListArtistModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("artist")
public class ArtistController {

    @Autowired
    private ArtistsService artistsService;

    @GetMapping
    public ListArtistModel findArtists(@RequestParam String nameArtist, @RequestParam(defaultValue = "1") Integer page) {
        return artistsService.findArtists(nameArtist, page);
    }

    @GetMapping("/{id}")
    public ArtistDetailModel findDetailArtists(@PathVariable String id) {
        return artistsService.findArtistDetail(id);
    }
}
