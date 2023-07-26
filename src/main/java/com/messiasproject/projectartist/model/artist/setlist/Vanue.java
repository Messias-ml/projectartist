package com.messiasproject.projectartist.model.artist.setlist;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Vanue {
    @Schema(example = "name event (exemple value: Royal Festival Hall")
    private String name;
    private City city;
}
