package com.messiasproject.projectartist.model.artist.setlist;

import lombok.Data;

@Data
public class City {
    private String name;

    private String state;

    private Country country;
}
