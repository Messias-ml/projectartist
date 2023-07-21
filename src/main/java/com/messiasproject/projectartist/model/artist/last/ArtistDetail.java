package com.messiasproject.projectartist.model.artist.last;

import com.messiasproject.projectartist.model.artist.ArtistModel;
import lombok.Data;

@Data
public class ArtistDetail extends ArtistModel {

    private ArtistSimilarLastModel similar;

    private ArtistBio bio;
}
