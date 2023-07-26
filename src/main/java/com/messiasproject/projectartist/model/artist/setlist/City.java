package com.messiasproject.projectartist.model.artist.setlist;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class City {
    @Schema(example = "London (city of England)")
    private String name;

    @Schema(example = "Warning state is country. (exemple value: England)")
    private String state;

    @Schema(example = "Warning country is region. (exemple value: United Kingdom)")
    private Country country;
}
