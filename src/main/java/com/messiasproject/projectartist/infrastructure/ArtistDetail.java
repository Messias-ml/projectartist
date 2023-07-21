package com.messiasproject.projectartist.infrastructure;

import com.messiasproject.projectartist.model.artist.ArtistDetailModel;

public interface ArtistDetail {
    ArtistDetailModel findArtistDetail(String id);
}
