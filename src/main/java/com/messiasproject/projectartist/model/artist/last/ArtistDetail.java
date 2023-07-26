package com.messiasproject.projectartist.model.artist.last;

import com.messiasproject.projectartist.model.artist.ArtistModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ArtistDetail extends ArtistModel {

    @Schema(example = "url artist detail in the last.fm (example value: https://www.last.fm/music/John+Barry")
    private String url;
    @Schema(description = "similar artists")
    private ArtistSimilarLastModel similar;

    private ArtistBio bio;
}
