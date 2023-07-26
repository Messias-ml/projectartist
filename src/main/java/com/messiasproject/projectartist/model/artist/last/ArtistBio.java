package com.messiasproject.projectartist.model.artist.last;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ArtistBio {
    @Schema(example = "10 Oct 2007, 14:59")
    private String published;
    private String summary;
    @Schema(example = "history artist")
    private String content;
}
