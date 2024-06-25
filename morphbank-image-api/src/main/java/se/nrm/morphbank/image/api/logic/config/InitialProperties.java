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
    private String palImagePath;
    private String zooEtImagePath;
    private String zooFishImagePagh;
    

    public InitialProperties() {
    }

    @Inject
    public InitialProperties(@ConfigurationValue("swarm.imagesPath.base") String imagesPath,
            @ConfigurationValue("swarm.imagesPath.kbo") String kboImagesPath,
            @ConfigurationValue("swarm.imagesPath.fbo") String fboImagesPath,
            @ConfigurationValue("swarm.imagesPath.pal") String palImagePath,
            @ConfigurationValue("swarm.imagesPath.zoo.et") String zooEtImagePath,
            @ConfigurationValue("swarm.imagesPath.zoo.fish") String zooFishImagePagh) {
        this.imagesPath = imagesPath;
        this.kboImagePath = kboImagesPath;
        this.fboImagePath = fboImagesPath;
        this.palImagePath = palImagePath;
        this.zooEtImagePath = zooEtImagePath;
        this.zooFishImagePagh = zooFishImagePagh;
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
    
    public String getPalImagesPath() {
        if (palImagePath == null) {
            throw new RuntimeException(CONFIG_INITIALLISING_ERROR);
        }
        return palImagePath;
    }
    
    public String getZooEtImagesPath() {
        if (zooEtImagePath == null) {
            throw new RuntimeException(CONFIG_INITIALLISING_ERROR);
        }
        return zooEtImagePath;
    }
    
    public String getZooFishImagesPath() {
        log.info("zooFishImagePath : {}", zooFishImagePagh);
        if (zooFishImagePagh == null) {
            throw new RuntimeException(CONFIG_INITIALLISING_ERROR);
        }
        return zooFishImagePagh;
    }
}
