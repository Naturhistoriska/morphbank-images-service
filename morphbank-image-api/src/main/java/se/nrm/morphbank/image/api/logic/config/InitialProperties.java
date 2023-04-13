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
    private String fboImagePath;
    private String kboImagePath;

    public InitialProperties() {
    }

    @Inject
    public InitialProperties(@ConfigurationValue("swarm.imagesPath.base") String imagesPath,
            @ConfigurationValue("swarm.imagesPath.kbo") String kboImagesPath,
            @ConfigurationValue("swarm.imagesPath.fbo") String fboImagesPath) {
        this.imagesPath = imagesPath;
        this.kboImagePath = kboImagesPath;
        this.fboImagePath = fboImagesPath;
    }

    public String getImagesPath() {
        if (imagesPath == null) {
            throw new RuntimeException(CONFIG_INITIALLISING_ERROR);
        }
        return imagesPath;
    }

    public String getKboImagesPath() {
        if (kboImagePath == null) {
            throw new RuntimeException(CONFIG_INITIALLISING_ERROR);
        }
        return kboImagePath;
    }
    
    public String getFboImagesPath() {
        if (fboImagePath == null) {
            throw new RuntimeException(CONFIG_INITIALLISING_ERROR);
        }
        return fboImagePath;
    }
}
