package com.messiasproject.projectartist.model.artist.last;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ArtistReduceLastModel {
    @Schema(example = "name's similar artist")
    private String name;

    @Schema(example = "url last.fm of similar artist. (example value: https://www.last.fm/music/David+Arnold)")
    private String url;
}
