package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "Image")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i"),
  @NamedQuery(name = "Image.findById", query = "SELECT i FROM Image i WHERE i.id = :id"),
  @NamedQuery(name = "Image.findByDateToPublish", query = "SELECT i FROM Image i WHERE i.dateToPublish = :dateToPublish"),
  @NamedQuery(name = "Image.findByImageType", query = "SELECT i FROM Image i WHERE i.imageType = :imageType"),
  @NamedQuery(name = "Image.findByAccessNum", query = "SELECT i FROM Image i WHERE i.accessNum = :accessNum"),
  @NamedQuery(name = "Image.findByCopyrightText", query = "SELECT i FROM Image i WHERE i.copyrightText = :copyrightText"),
  @NamedQuery(name = "Image.findByOriginalFileName", query = "SELECT i FROM Image i WHERE i.originalFileName = :originalFileName"),
  @NamedQuery(name = "Image.findByEol", query = "SELECT i FROM Image i WHERE i.eol = :eol")})
public class Image implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Column(name = "dateToPublish")
  @Temporal(TemporalType.DATE)
  private Date dateToPublish;
  
  @Column(name = "imageHeight")
  private Integer imageHeight;
  
  @Column(name = "imageWidth")
  private Integer imageWidth;
  
  @Column(name = "resolution")
  private Integer resolution;
  
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "magnification")
  private Float magnification;
  
  @Size(max = 8)
  @Column(name = "imageType")
  private String imageType;
  
  @Column(name = "accessNum")
  private Integer accessNum;
  
  @Size(max = 255)
  @Column(name = "copyrightText")
  private String copyrightText;
  @Size(max = 127)
  @Column(name = "originalFileName")
  private String originalFileName;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "creativeCommons")
  private String creativeCommons;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "photographer")
  private String photographer;
  
  @Column(name = "eol")
  private Integer eol;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;
  
  @JoinColumn(name = "userId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private User userId;
  
  @JoinColumn(name = "groupId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Groups groupId;
  
  @JoinColumn(name = "specimenId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Specimen specimenId;
  
  @JoinColumn(name = "viewId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private View viewId;
  
  @OneToMany(mappedBy = "standardImageId", fetch = FetchType.LAZY)
  private Collection<Specimen> specimenCollection;
  
  @OneToMany(mappedBy = "standardImageId", fetch = FetchType.LAZY)
  private Collection<View> viewCollection;

  public Image() {
  }

  public Image(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDateToPublish() {
    return dateToPublish;
  }

  public void setDateToPublish(Date dateToPublish) {
    this.dateToPublish = dateToPublish;
  }

  public Integer getImageHeight() {
    return imageHeight;
  }

  public void setImageHeight(Integer imageHeight) {
    this.imageHeight = imageHeight;
  }

  public Integer getImageWidth() {
    return imageWidth;
  }

  public void setImageWidth(Integer imageWidth) {
    this.imageWidth = imageWidth;
  }

  public Integer getResolution() {
    return resolution;
  }

  public void setResolution(Integer resolution) {
    this.resolution = resolution;
  }

  public Float getMagnification() {
    return magnification;
  }

  public void setMagnification(Float magnification) {
    this.magnification = magnification;
  }

  public String getImageType() {
    return imageType;
  }

  public void setImageType(String imageType) {
    this.imageType = imageType;
  }

  public Integer getAccessNum() {
    return accessNum;
  }

  public void setAccessNum(Integer accessNum) {
    this.accessNum = accessNum;
  }

  public String getCopyrightText() {
    return copyrightText;
  }

  public void setCopyrightText(String copyrightText) {
    this.copyrightText = copyrightText;
  }

  public String getOriginalFileName() {
    return originalFileName;
  }

  public void setOriginalFileName(String originalFileName) {
    this.originalFileName = originalFileName;
  }

  public String getCreativeCommons() {
    return creativeCommons;
  }

  public void setCreativeCommons(String creativeCommons) {
    this.creativeCommons = creativeCommons;
  }

  public String getPhotographer() {
    return photographer;
  }

  public void setPhotographer(String photographer) {
    this.photographer = photographer;
  }

  public Integer getEol() {
    return eol;
  }

  public void setEol(Integer eol) {
    this.eol = eol;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
  }

  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
  }

  public Groups getGroupId() {
    return groupId;
  }

  public void setGroupId(Groups groupId) {
    this.groupId = groupId;
  }

  public Specimen getSpecimenId() {
    return specimenId;
  }

  public void setSpecimenId(Specimen specimenId) {
    this.specimenId = specimenId;
  }

  public View getViewId() {
    return viewId;
  }

  public void setViewId(View viewId) {
    this.viewId = viewId;
  }

  @XmlTransient
  public Collection<Specimen> getSpecimenCollection() {
    return specimenCollection;
  }

  public void setSpecimenCollection(Collection<Specimen> specimenCollection) {
    this.specimenCollection = specimenCollection;
  }

  @XmlTransient
  public Collection<View> getViewCollection() {
    return viewCollection;
  }

  public void setViewCollection(Collection<View> viewCollection) {
    this.viewCollection = viewCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Image)) {
      return false;
    }
    Image other = (Image) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Image[ id=" + id + " ]";
  }
  
}
