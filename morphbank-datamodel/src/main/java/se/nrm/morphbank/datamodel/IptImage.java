package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "IptImage")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "IptImage.findAll", query = "SELECT i FROM IptImage i")
  , @NamedQuery(name = "IptImage.findByForeignKey", query = "SELECT i FROM IptImage i WHERE i.foreignKey = :foreignKey")
  , @NamedQuery(name = "IptImage.findByIdentifier", query = "SELECT i FROM IptImage i WHERE i.identifier = :identifier")
  , @NamedQuery(name = "IptImage.findByType", query = "SELECT i FROM IptImage i WHERE i.type = :type")
  , @NamedQuery(name = "IptImage.findByTitle", query = "SELECT i FROM IptImage i WHERE i.title = :title")
  , @NamedQuery(name = "IptImage.findByModified", query = "SELECT i FROM IptImage i WHERE i.modified = :modified")
  , @NamedQuery(name = "IptImage.findByMetadataLanguage", query = "SELECT i FROM IptImage i WHERE i.metadataLanguage = :metadataLanguage")
  , @NamedQuery(name = "IptImage.findByProviderManagedID", query = "SELECT i FROM IptImage i WHERE i.providerManagedID = :providerManagedID")
  , @NamedQuery(name = "IptImage.findByAvailable", query = "SELECT i FROM IptImage i WHERE i.available = :available")
  , @NamedQuery(name = "IptImage.findByOwner", query = "SELECT i FROM IptImage i WHERE i.owner = :owner")
  , @NamedQuery(name = "IptImage.findByAttributionLogoURL", query = "SELECT i FROM IptImage i WHERE i.attributionLogoURL = :attributionLogoURL")
  , @NamedQuery(name = "IptImage.findByProvider", query = "SELECT i FROM IptImage i WHERE i.provider = :provider")
  , @NamedQuery(name = "IptImage.findByMetadataProvider", query = "SELECT i FROM IptImage i WHERE i.metadataProvider = :metadataProvider")
  , @NamedQuery(name = "IptImage.findByMetadataCreator", query = "SELECT i FROM IptImage i WHERE i.metadataCreator = :metadataCreator")
  , @NamedQuery(name = "IptImage.findByDescription", query = "SELECT i FROM IptImage i WHERE i.description = :description")
  , @NamedQuery(name = "IptImage.findByTag", query = "SELECT i FROM IptImage i WHERE i.tag = :tag")
  , @NamedQuery(name = "IptImage.findByNameAccordingTo", query = "SELECT i FROM IptImage i WHERE i.nameAccordingTo = :nameAccordingTo")
  , @NamedQuery(name = "IptImage.findBySubjectPart", query = "SELECT i FROM IptImage i WHERE i.subjectPart = :subjectPart")
  , @NamedQuery(name = "IptImage.findBySubjectOrientation", query = "SELECT i FROM IptImage i WHERE i.subjectOrientation = :subjectOrientation")
  , @NamedQuery(name = "IptImage.findByCaptureDevice", query = "SELECT i FROM IptImage i WHERE i.captureDevice = :captureDevice")
  , @NamedQuery(name = "IptImage.findByResourceCreationTechnique", query = "SELECT i FROM IptImage i WHERE i.resourceCreationTechnique = :resourceCreationTechnique")
  , @NamedQuery(name = "IptImage.findByBestQualityAccessURI", query = "SELECT i FROM IptImage i WHERE i.bestQualityAccessURI = :bestQualityAccessURI")
  , @NamedQuery(name = "IptImage.findByBestQualityformat", query = "SELECT i FROM IptImage i WHERE i.bestQualityformat = :bestQualityformat")
  , @NamedQuery(name = "IptImage.findByBestQualityExtent", query = "SELECT i FROM IptImage i WHERE i.bestQualityExtent = :bestQualityExtent")
  , @NamedQuery(name = "IptImage.findByBestQualityFurtherInformationURL", query = "SELECT i FROM IptImage i WHERE i.bestQualityFurtherInformationURL = :bestQualityFurtherInformationURL")
  , @NamedQuery(name = "IptImage.findByMediumQualityAccessURI", query = "SELECT i FROM IptImage i WHERE i.mediumQualityAccessURI = :mediumQualityAccessURI")
  , @NamedQuery(name = "IptImage.findByMediumQualityFormat", query = "SELECT i FROM IptImage i WHERE i.mediumQualityFormat = :mediumQualityFormat")
  , @NamedQuery(name = "IptImage.findByThumbNailAccessURI", query = "SELECT i FROM IptImage i WHERE i.thumbNailAccessURI = :thumbNailAccessURI")
  , @NamedQuery(name = "IptImage.findByThumbNailFormat", query = "SELECT i FROM IptImage i WHERE i.thumbNailFormat = :thumbNailFormat")
  , @NamedQuery(name = "IptImage.findByProviderID", query = "SELECT i FROM IptImage i WHERE i.providerID = :providerID")
  , @NamedQuery(name = "IptImage.findByAssociatedSpecimenReference", query = "SELECT i FROM IptImage i WHERE i.associatedSpecimenReference = :associatedSpecimenReference")
  , @NamedQuery(name = "IptImage.findByGroupId", query = "SELECT i FROM IptImage i WHERE i.groupId = :groupId")
  , @NamedQuery(name = "IptImage.findBySpecimenId", query = "SELECT i FROM IptImage i WHERE i.specimenId = :specimenId")
  , @NamedQuery(name = "IptImage.findByUserId", query = "SELECT i FROM IptImage i WHERE i.userId = :userId")})
public class IptImage implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Size(max = 36)
  @Column(name = "foreignKey")
  private String foreignKey;
  
  @Size(max = 36)
  @Column(name = "identifier")
  private String identifier;
  
  @Size(max = 8)
  @Column(name = "type")
  private String type;
  
  @Size(max = 255)
  @Column(name = "title")
  private String title; 
  
  @Column(name = "modified")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modified; 
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "metadataLanguage")
  private String metadataLanguage; 
  
  @Size(max = 36)
  @Column(name = "providerManagedID")
  private String providerManagedID;
  
  @Column(name = "available")
  @Temporal(TemporalType.DATE)
  private Date available;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "rights")
  private String rights;
  
  @Size(max = 255)
  @Column(name = "Owner")
  private String owner;
  
  @Size(max = 255)
  @Column(name = "attributionLogoURL")
  private String attributionLogoURL;
   
  @Lob
  @Size(max = 65535)
  @Column(name = "creator")
  private String creator;
  
  @Size(max = 36)
  @Column(name = "provider")
  private String provider;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "metadataProvider")
  private String metadataProvider;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "metadataCreator")
  private String metadataCreator;
  
  @Size(max = 255)
  @Column(name = "description")
  private String description;
  
  @Size(max = 255)
  @Column(name = "tag")
  private String tag;
  
  @Size(max = 255)
  @Column(name = "nameAccordingTo")
  private String nameAccordingTo;
  
  @Size(max = 255)
  @Column(name = "subjectPart")
  private String subjectPart;
  @Size(max = 255)
  @Column(name = "subjectOrientation")
  private String subjectOrientation;
  
  @Size(max = 255)
  @Column(name = "captureDevice")
  private String captureDevice;
  
  @Size(max = 255)
  @Column(name = "resourceCreationTechnique")
  private String resourceCreationTechnique;
  
  @Size(max = 57)
  @Column(name = "bestQualityAccessURI")
  private String bestQualityAccessURI;
  
  @Size(max = 8)
  @Column(name = "bestQualityformat")
  private String bestQualityformat;
  
  @Size(max = 25)
  @Column(name = "bestQualityExtent")
  private String bestQualityExtent;
  
  @Size(max = 36)
  @Column(name = "bestQualityFurtherInformationURL")
  private String bestQualityFurtherInformationURL;
  
  @Size(max = 56)
  @Column(name = "mediumQualityAccessURI")
  private String mediumQualityAccessURI;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "mediumQualityFormat")
  private String mediumQualityFormat;
  
  @Size(max = 58)
  @Column(name = "thumbNailAccessURI")
  private String thumbNailAccessURI;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "thumbNailFormat")
  private String thumbNailFormat;
  
  @Size(max = 36)
  @Column(name = "providerID")
  private String providerID;
  
  @Size(max = 36)
  @Column(name = "associatedSpecimenReference")
  private String associatedSpecimenReference;
  
  @Column(name = "groupId")
  private Integer groupId;
  
  @Column(name = "specimenId")
  private Integer specimenId;
  
  @Column(name = "userId")
  private Integer userId;

  public IptImage() {
  }

  public String getForeignKey() {
    return foreignKey;
  }

  public void setForeignKey(String foreignKey) {
    this.foreignKey = foreignKey;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public String getMetadataLanguage() {
    return metadataLanguage;
  }

  public void setMetadataLanguage(String metadataLanguage) {
    this.metadataLanguage = metadataLanguage;
  }

  public String getProviderManagedID() {
    return providerManagedID;
  }

  public void setProviderManagedID(String providerManagedID) {
    this.providerManagedID = providerManagedID;
  }

  public Date getAvailable() {
    return available;
  }

  public void setAvailable(Date available) {
    this.available = available;
  }

  public String getRights() {
    return rights;
  }

  public void setRights(String rights) {
    this.rights = rights;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getAttributionLogoURL() {
    return attributionLogoURL;
  }

  public void setAttributionLogoURL(String attributionLogoURL) {
    this.attributionLogoURL = attributionLogoURL;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public String getMetadataProvider() {
    return metadataProvider;
  }

  public void setMetadataProvider(String metadataProvider) {
    this.metadataProvider = metadataProvider;
  }

  public String getMetadataCreator() {
    return metadataCreator;
  }

  public void setMetadataCreator(String metadataCreator) {
    this.metadataCreator = metadataCreator;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getNameAccordingTo() {
    return nameAccordingTo;
  }

  public void setNameAccordingTo(String nameAccordingTo) {
    this.nameAccordingTo = nameAccordingTo;
  }

  public String getSubjectPart() {
    return subjectPart;
  }

  public void setSubjectPart(String subjectPart) {
    this.subjectPart = subjectPart;
  }

  public String getSubjectOrientation() {
    return subjectOrientation;
  }

  public void setSubjectOrientation(String subjectOrientation) {
    this.subjectOrientation = subjectOrientation;
  }

  public String getCaptureDevice() {
    return captureDevice;
  }

  public void setCaptureDevice(String captureDevice) {
    this.captureDevice = captureDevice;
  }

  public String getResourceCreationTechnique() {
    return resourceCreationTechnique;
  }

  public void setResourceCreationTechnique(String resourceCreationTechnique) {
    this.resourceCreationTechnique = resourceCreationTechnique;
  }

  public String getBestQualityAccessURI() {
    return bestQualityAccessURI;
  }

  public void setBestQualityAccessURI(String bestQualityAccessURI) {
    this.bestQualityAccessURI = bestQualityAccessURI;
  }

  public String getBestQualityformat() {
    return bestQualityformat;
  }

  public void setBestQualityformat(String bestQualityformat) {
    this.bestQualityformat = bestQualityformat;
  }

  public String getBestQualityExtent() {
    return bestQualityExtent;
  }

  public void setBestQualityExtent(String bestQualityExtent) {
    this.bestQualityExtent = bestQualityExtent;
  }

  public String getBestQualityFurtherInformationURL() {
    return bestQualityFurtherInformationURL;
  }

  public void setBestQualityFurtherInformationURL(String bestQualityFurtherInformationURL) {
    this.bestQualityFurtherInformationURL = bestQualityFurtherInformationURL;
  }

  public String getMediumQualityAccessURI() {
    return mediumQualityAccessURI;
  }

  public void setMediumQualityAccessURI(String mediumQualityAccessURI) {
    this.mediumQualityAccessURI = mediumQualityAccessURI;
  }

  public String getMediumQualityFormat() {
    return mediumQualityFormat;
  }

  public void setMediumQualityFormat(String mediumQualityFormat) {
    this.mediumQualityFormat = mediumQualityFormat;
  }

  public String getThumbNailAccessURI() {
    return thumbNailAccessURI;
  }

  public void setThumbNailAccessURI(String thumbNailAccessURI) {
    this.thumbNailAccessURI = thumbNailAccessURI;
  }

  public String getThumbNailFormat() {
    return thumbNailFormat;
  }

  public void setThumbNailFormat(String thumbNailFormat) {
    this.thumbNailFormat = thumbNailFormat;
  }

  public String getProviderID() {
    return providerID;
  }

  public void setProviderID(String providerID) {
    this.providerID = providerID;
  }

  public String getAssociatedSpecimenReference() {
    return associatedSpecimenReference;
  }

  public void setAssociatedSpecimenReference(String associatedSpecimenReference) {
    this.associatedSpecimenReference = associatedSpecimenReference;
  }

  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public Integer getSpecimenId() {
    return specimenId;
  }

  public void setSpecimenId(Integer specimenId) {
    this.specimenId = specimenId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  
}
