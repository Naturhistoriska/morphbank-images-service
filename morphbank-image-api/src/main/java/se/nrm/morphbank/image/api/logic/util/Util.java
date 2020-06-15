package se.nrm.morphbank.image.api.logic.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author idali
 */
@Slf4j
public class Util {
  
//  private StringBuilder sb;
  private final String fileSeparate = "/";
  private final String jpgFileType = ".jpg";
    
  private static Util instance = null;
   
  public static Util getInstance() {
    synchronized (Util.class) {
      if (instance == null) {
        instance = new Util();
      }
    }
    return instance;
  }
  
  public String buildImagePath(String id, String imageType, String imagesPath) {  
    String topDirectory = StringUtils.leftPad(StringUtils.substring(id, 0, 1), 3, '0');
    
    StringBuilder sb = new StringBuilder();
    sb.append(fileSeparate);
    sb.append(imagesPath);
    sb.append(fileSeparate);
    sb.append(imageType);
    sb.append(fileSeparate);
    sb.append(topDirectory); 
    sb.append(fileSeparate);
    sb.append(StringUtils.substring(id, 1, 4));
    sb.append(fileSeparate);
    sb.append(id); 
    sb.append(jpgFileType);  
    return sb.toString().trim();
  }
  
}
