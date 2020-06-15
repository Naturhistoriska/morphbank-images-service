package se.nrm.morphbank.image.api.logic.config;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

/**
 *
 * @author idali
 */
@ApplicationScoped
@Slf4j
public class InitialProperties implements Serializable {
  
  private final static String CONFIG_INITIALLISING_ERROR = "Property not initialised";
  
  private String imagesPath;
   
  public InitialProperties() {
  } 
  
  @Inject
  public InitialProperties(@ConfigurationValue("swarm.imagesPath.base") String imagesPath) { 
    this.imagesPath = imagesPath;
  }
  
  public String getImagesPath() {
    if (imagesPath == null) {
      throw new RuntimeException(CONFIG_INITIALLISING_ERROR);
    }
    return imagesPath;
  }
}
