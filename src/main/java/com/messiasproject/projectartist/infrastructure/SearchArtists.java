package com.messiasproject.projectartist.infrastructure;

import com.messiasproject.projectartist.model.artist.setlist.ListArtistModel;

public interface SearchArtists {
    ListArtistModel findArtists(String nameArtist, Integer page);
}
