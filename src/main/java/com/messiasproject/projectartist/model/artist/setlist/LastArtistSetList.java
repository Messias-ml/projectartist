package com.messiasproject.projectartist.model.artist.setlist;

import lombok.Data;

@Data
public class LastArtistSetList {
    private String eventDate;
    private String lastUpdated;
    private ArtistModelSetlist artist;
    private Vanue venue;
    private String url;
}
