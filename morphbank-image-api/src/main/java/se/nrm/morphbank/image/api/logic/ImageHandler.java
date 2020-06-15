package se.nrm.morphbank.image.api.logic;
  
import java.io.File;
import java.io.Serializable;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j; 
import se.nrm.morphbank.image.api.logic.config.InitialProperties;
import se.nrm.morphbank.image.api.logic.util.Util;

/**
 *
 * @author idali
 */
@Slf4j
public class ImageHandler implements Serializable {
  
  @Inject
  private InitialProperties properties;
  
  public File getImageById(String id, String imageType) {  
    return new File(Util.getInstance().buildImagePath(id, imageType, properties.getImagesPath())); 
  }
  
}
