package se.nrm.morphbank.image.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import se.nrm.morphbank.image.api.logic.ImageHandler;

/**
 *
 * @author idali
 */
@Path("/")
@Api(tags = {"media-service"})
@SwaggerDefinition(
        info = @Info(
                title = "Image service",
                version = "1.0.0"
        ),
        tags = {
            @Tag(name = "media-service", description = "Image tool")
        })
@Slf4j
public class ImageService {

    private final String imageJpg = "image/jpg";
    private final String inline = "Inline";

    private final String kboDataset = "kbo";
    private final String fboDataset = "fbo";

    @Inject
    private ImageHandler handler;

    @GET
    @Path("/images")
    @Produces("image/jpg")
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @ApiOperation(value = "Get images by imageId and imageType",
            notes = "image/jpg",
            response = Response.class
    )
    public Response getFile(@QueryParam("id") String id,
            @QueryParam("dataset") String dataset, @QueryParam("imgType") String imageType) {
        log.info("run : {} -- {}", id, dataset);

        if(dataset != null) {
            if (dataset.equals(kboDataset )) {
                log.info("kbo");
               return Response.ok(handler.getKboImage(id))
                        .header(inline, imageJpg)
                        .build();
            } else if(dataset.equals(fboDataset)) {
                 log.info("fbo");
                return Response.ok(handler.getFboImage(id))
                        .header(inline, imageJpg)
                        .build(); 
            }
        }
        
        log.info("entomology");
        return Response.ok(handler.getImageById(id, imageType), imageJpg)
                    .header(inline, imageJpg)
                    .build();
    }

}
