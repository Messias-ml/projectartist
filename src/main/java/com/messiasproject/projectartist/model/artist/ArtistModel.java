package com.messiasproject.projectartist.model.artist;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ArtistModel {
    @Schema(example = "name artist (example value: Jhon)")
    private String name;
    @Schema(example = "661e20c8-3d82-4da2-94a2-97d9e11691c0")
    private String mbid;
}
