package com.messiasproject.projectartist.model.artist.setlist;

import com.messiasproject.projectartist.model.artist.ArtistModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ArtistModelSetlist extends ArtistModel {

 @Schema(example = "url artist setlist (example value: https://www.setlist.fm/setlists/john-barry-1bd6b97c.html)")
 private String url;
 @Schema(example = "Barry, Jhon")
 private String sortName;

 @Schema(example = "English score composer")
 private String disambiguation;
}