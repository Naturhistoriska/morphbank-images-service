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
    
    private final String palDataset = "pal";
    
    private final String etDataset = "et";
    private final String evDataset = "ev";
    private final String fishDataset = "fish";

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
//    @Operation(summary = "Get images by imageId and imageType")
//    public Response getFile(@Parameter(required = true, description = "Image id") @QueryParam("id") String id,
//            @Parameter(required = false, description = "Date set") @QueryParam("dataset") String dataset, 
//            @Parameter(required = false, description = "Image type") @QueryParam("imgType") String imageType) {
     public Response getFile(@QueryParam("id") String id,
            @QueryParam("dataset") String dataset, 
            @QueryParam("imgType") String imageType) {    
        log.info("run : {} -- {}", id, dataset);

        if(dataset != null) {
            switch (dataset) {
                case kboDataset:
                    log.info("kbo");
                    return Response.ok(handler.getKboImage(id))
                            .header(inline, imageJpg)
                            .build();
                case fboDataset:
                    log.info("fbo");
                    return Response.ok(handler.getFboImage(id))
                            .header(inline, imageJpg)
                            .build();
                case palDataset:
                    log.info("pal");
                    return Response.ok(handler.getPalImage(id))
                            .header(inline, imageJpg)
                            .build();
                case etDataset:
                    log.info("et");
                    return Response.ok(handler.getZooEtImage(id))
                            .header(inline, imageJpg)
                            .build();
                case evDataset:
                    log.info("ev");
                    return Response.ok(handler.getZooEtImage(id))
                            .header(inline, imageJpg)
                            .build();
                case fishDataset:
                    log.info("fish"); 
                    return Response.ok(handler.getZooFishImage(id))
                            .header(inline, imageJpg) 
                            .build();
                default:
                    break;
            }
        } 
        
        log.info("entomology");
        return Response.ok(handler.getImageById(id, imageType), imageJpg)
                    .header(inline, imageJpg)
                    .build();
    }

}
