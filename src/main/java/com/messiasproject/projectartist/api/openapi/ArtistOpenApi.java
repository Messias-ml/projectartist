package com.messiasproject.projectartist.api.openapi;

import com.messiasproject.projectartist.model.artist.ArtistDetailModel;
import com.messiasproject.projectartist.model.artist.setlist.ListArtistModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.PathVariable;

public interface ArtistOpenApi {

    @Operation(summary = "get to bring the list artists by artist name")
    ListArtistModel findArtists(@Parameter(name = "name artist", example = "Jhon", required = true) String nameArtist,
                                @Parameter(name = "number of page", example = "1") Integer page);


    @Operation(summary = "get to bring artist detail")
    public ArtistDetailModel findDetailArtist(@Parameter(description = "mbid artist",example = "661e20c8-3d82-4da2-94a2-97d9e11691c0", required = true) @PathVariable String id);

}
