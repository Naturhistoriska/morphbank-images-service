package se.nrm.morphbank.image.api.logic;

import java.io.File; 
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import se.nrm.morphbank.image.api.logic.config.InitialProperties;
import se.nrm.morphbank.image.api.logic.util.Util;

/**
 *
 * @author idali
 */
@Slf4j
public class ImageHandler implements Serializable {
    
    private final String csvPath = "/kryptos/kbo/";
    
    private String morphPath;
    private String fboPath;
    private String kboPath;
    private String palPath;
    private String zooEtPath;
    private String zooFishPath;
    
    private File imageFile;

    @Inject
    private InitialProperties properties;
    
    @PostConstruct
    public void init() {
        log.info("init");
        
        morphPath = properties.getImagesPath();
        fboPath = properties.getFboImagesPath();
        kboPath = properties.getKboImagesPath();
        palPath = properties.getPalImagesPath();
        zooEtPath = properties.getZooEtImagesPath();
        zooFishPath = properties.getZooFishImagesPath();
    }

    public File getImageById(String id, String imageType) {
        
        imageFile = new File(Util.getInstance()
                .buildImagePath(id, imageType, morphPath));
        
        if(imageFile.exists()) {
            return imageFile;
        }
        return null; 
    }

    public File getKboImage(String filePath) {
//        /kryptos/kbo/kryptobase/201804/max/324166.jpg
        filePath = StringUtils.replace(filePath, csvPath, kboPath);

        imageFile = new File(filePath);
        if(imageFile.exists()) {
            return imageFile;
        }
        return null; 
    }
     
    public File getFboImage(String filePath) { 
        filePath = fboPath + filePath; 
        
        imageFile = new File(filePath);
        if(imageFile.exists()) {
            return imageFile;
        }
        return null;
    }
    
    public File getPalImage(String filePath) {
        filePath = palPath + filePath; 
        imageFile = new File(filePath);
        if(imageFile.exists()) {
            return imageFile;
        }
        return null;
    }
    
    public File getZooEtImage(String filePath) {
        filePath = zooEtPath + filePath; 
        
        imageFile = new File(filePath);
        if(imageFile.exists()) {
            return imageFile;
        }
        return null;
    }
    
    public File getZooFishImage(String filePath) {
        filePath = zooFishPath + filePath; 
        imageFile = new File(filePath);  
        if(imageFile.exists()) {
            return imageFile;
        }
        return null;
    }
}
