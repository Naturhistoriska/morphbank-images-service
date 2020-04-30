package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "Annotation")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Annotation.findAll", query = "SELECT a FROM Annotation a"),
  @NamedQuery(name = "Annotation.findById", query = "SELECT a FROM Annotation a WHERE a.id = :id"),
  @NamedQuery(name = "Annotation.findByObjectTypeId", query = "SELECT a FROM Annotation a WHERE a.objectTypeId = :objectTypeId"),
  @NamedQuery(name = "Annotation.findByTypeAnnotation", query = "SELECT a FROM Annotation a WHERE a.typeAnnotation = :typeAnnotation"),
  @NamedQuery(name = "Annotation.findByTitle", query = "SELECT a FROM Annotation a WHERE a.title = :title"),
  @NamedQuery(name = "Annotation.findByKeywords", query = "SELECT a FROM Annotation a WHERE a.keywords = :keywords"),
  @NamedQuery(name = "Annotation.findByExternalURL", query = "SELECT a FROM Annotation a WHERE a.externalURL = :externalURL")})
public class Annotation implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Size(max = 255)
  @Column(name = "objectTypeId")
  private String objectTypeId;
  
  @Size(max = 255)
  @Column(name = "typeAnnotation")
  private String typeAnnotation;
  
  @Column(name = "xLocation")
  private Integer xLocation;
  
  @Column(name = "yLocation")
  private Integer yLocation;
  
  @Column(name = "areaHeight")
  private Integer areaHeight;
  
  @Column(name = "areaWidth")
  private Integer areaWidth;
  
  @Column(name = "areaRadius")
  private Integer areaRadius;
  
  @Size(max = 10)
  @Column(name = "annotationQuality")
  private String annotationQuality;
  
  @Size(max = 255)
  @Column(name = "title")
  private String title;
  
  @Size(max = 255)
  @Column(name = "keywords")
  private String keywords;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "comment")
  private String comment;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "xmlData")
  private String xmlData;
  
  @Size(max = 255)
  @Column(name = "externalURL")
  private String externalURL;
  
  @Size(max = 255)
  @Column(name = "annotationLabel")
  private String annotationLabel;
  
  @Size(max = 255)
  @Column(name = "annotationMarkup")
  private String annotationMarkup;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "annotation")
  private DeterminationAnnotation determinationAnnotation;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;
  
  @JoinColumn(name = "objectId", referencedColumnName = "id")
  @ManyToOne
  private BaseObject objectId;

  public Annotation() {
  }

  public Annotation(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getObjectTypeId() {
    return objectTypeId;
  }

  public void setObjectTypeId(String objectTypeId) {
    this.objectTypeId = objectTypeId;
  }

  public String getTypeAnnotation() {
    return typeAnnotation;
  }

  public void setTypeAnnotation(String typeAnnotation) {
    this.typeAnnotation = typeAnnotation;
  }

  public Integer getXLocation() {
    return xLocation;
  }

  public void setXLocation(Integer xLocation) {
    this.xLocation = xLocation;
  }

  public Integer getYLocation() {
    return yLocation;
  }

  public void setYLocation(Integer yLocation) {
    this.yLocation = yLocation;
  }

  public Integer getAreaHeight() {
    return areaHeight;
  }

  public void setAreaHeight(Integer areaHeight) {
    this.areaHeight = areaHeight;
  }

  public Integer getAreaWidth() {
    return areaWidth;
  }

  public void setAreaWidth(Integer areaWidth) {
    this.areaWidth = areaWidth;
  }

  public Integer getAreaRadius() {
    return areaRadius;
  }

  public void setAreaRadius(Integer areaRadius) {
    this.areaRadius = areaRadius;
  }

  public String getAnnotationQuality() {
    return annotationQuality;
  }

  public void setAnnotationQuality(String annotationQuality) {
    this.annotationQuality = annotationQuality;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getXmlData() {
    return xmlData;
  }

  public void setXmlData(String xmlData) {
    this.xmlData = xmlData;
  }

  public String getExternalURL() {
    return externalURL;
  }

  public void setExternalURL(String externalURL) {
    this.externalURL = externalURL;
  }

  public String getAnnotationLabel() {
    return annotationLabel;
  }

  public void setAnnotationLabel(String annotationLabel) {
    this.annotationLabel = annotationLabel;
  }

  public String getAnnotationMarkup() {
    return annotationMarkup;
  }

  public void setAnnotationMarkup(String annotationMarkup) {
    this.annotationMarkup = annotationMarkup;
  }

  public DeterminationAnnotation getDeterminationAnnotation() {
    return determinationAnnotation;
  }

  public void setDeterminationAnnotation(DeterminationAnnotation determinationAnnotation) {
    this.determinationAnnotation = determinationAnnotation;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
  }

  public BaseObject getObjectId() {
    return objectId;
  }

  public void setObjectId(BaseObject objectId) {
    this.objectId = objectId;
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
    if (!(object instanceof Annotation)) {
      return false;
    }
    Annotation other = (Annotation) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Annotation[ id=" + id + " ]";
  }
  
}
