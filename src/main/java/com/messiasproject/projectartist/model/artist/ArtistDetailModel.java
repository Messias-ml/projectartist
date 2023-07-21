package com.messiasproject.projectartist.model.artist;

import com.messiasproject.projectartist.model.artist.last.ArtistDetail;
import com.messiasproject.projectartist.model.artist.setlist.LastArtistSetList;
import lombok.Data;

@Data
public class ArtistDetailModel {

    private LastArtistSetList lastArtistSetList;
    private ArtistDetail artist;
}
