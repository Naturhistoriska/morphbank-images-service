package se.nrm.morphbank.image.api.logic;

import java.io.File;
import java.io.Serializable;
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

    @Inject
    private InitialProperties properties;

    public File getImageById(String id, String imageType) {
        return new File(Util.getInstance()
                .buildImagePath(id, imageType, properties.getImagesPath()));
    }

    public File getKboImage(String filePath) {
//        /kryptos/kbo/kryptobase/201804/max/324166.jpg
        filePath = StringUtils.replace(filePath, csvPath, 
                properties.getKboImagesPath());

        return new File(filePath);
    }
    
    public File getFboImage(String filePath) { 
        filePath = properties.getFboImagesPath() + filePath; 
        return new File(filePath);
    }
}
