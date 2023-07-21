package com.messiasproject.projectartist.model.artist.last;

import lombok.Data;

import java.util.List;

@Data
public class ArtistSimilarLastModel {
    private List<ArtistReduceLastModel> artist;
}
