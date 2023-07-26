package com.messiasproject.projectartist.model.artist.setlist;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LastArtistSetList {
    @Schema(example = "15-10-2014")
    private String eventDate;
    @Schema(example = "2014-10-15T13:05:46.000+0000")
    private String lastUpdated;
    private ArtistModelSetlist artist;
    private Vanue venue;
    @Schema(description = "url setlist played at the event", example = "url setlist played at the event (example value: https://www.setlist.fm/setlist/john-barry/2014/royal-festival-hall-london-england-73ccfa21.html)")
    private String url;
}
