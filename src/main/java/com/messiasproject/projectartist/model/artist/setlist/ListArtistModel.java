package com.messiasproject.projectartist.model.artist.setlist;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ListArtistModel {
    @Schema(example = "Register total. (Exemple value: 60)")
    private BigDecimal total;
    @Schema(example = "total Page. (Exemple value: 2)")
    private Integer totalPage;
    private List<ArtistModelSetlist> artist;
}
