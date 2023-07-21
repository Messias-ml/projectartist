package com.messiasproject.projectartist.model.artist.setlist;

import com.messiasproject.projectartist.model.artist.ArtistModel;
import lombok.Data;

@Data
public class ArtistModelSetlist extends ArtistModel {
 private String sortName;
 private String disambiguation;
}