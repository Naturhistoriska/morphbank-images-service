package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "BaseObject")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "BaseObject.findAll", query = "SELECT b FROM BaseObject b"),
  @NamedQuery(name = "BaseObject.findById", query = "SELECT b FROM BaseObject b WHERE b.id = :id"),
  @NamedQuery(name = "BaseObject.findByDateCreated", query = "SELECT b FROM BaseObject b WHERE b.dateCreated = :dateCreated"),
  @NamedQuery(name = "BaseObject.findByDateLastModified", query = "SELECT b FROM BaseObject b WHERE b.dateLastModified = :dateLastModified"),
  @NamedQuery(name = "BaseObject.findByDateToPublish", query = "SELECT b FROM BaseObject b WHERE b.dateToPublish = :dateToPublish"),
  @NamedQuery(name = "BaseObject.findByObjectTypeId", query = "SELECT b FROM BaseObject b WHERE b.objectTypeId = :objectTypeId"),
  @NamedQuery(name = "BaseObject.findByName", query = "SELECT b FROM BaseObject b WHERE b.name = :name"),
  @NamedQuery(name = "BaseObject.findByDescription", query = "SELECT b FROM BaseObject b WHERE b.description = :description"),
  @NamedQuery(name = "BaseObject.findByObjectLogo", query = "SELECT b FROM BaseObject b WHERE b.objectLogo = :objectLogo"),
  @NamedQuery(name = "BaseObject.findByThumbURL", query = "SELECT b FROM BaseObject b WHERE b.thumbURL = :thumbURL"),
  @NamedQuery(name = "BaseObject.findByPublished", query = "SELECT b FROM BaseObject b WHERE b.published = :published"),
  @NamedQuery(name = "BaseObject.findByGeolocated", query = "SELECT b FROM BaseObject b WHERE b.geolocated = :geolocated"),
  @NamedQuery(name = "BaseObject.findByHostServer", query = "SELECT b FROM BaseObject b WHERE b.hostServer = :hostServer"),
  @NamedQuery(name = "BaseObject.findByImagesCount", query = "SELECT b FROM BaseObject b WHERE b.imagesCount = :imagesCount"), 
  @NamedQuery(name = "BaseObject.findByUuidString", query = "SELECT b FROM BaseObject b WHERE b.uuidString = :uuidString")})
public class BaseObject implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateCreated")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateCreated;
  
  @Column(name = "dateLastModified")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateLastModified;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateToPublish")
  @Temporal(TemporalType.DATE)
  private Date dateToPublish;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "objectTypeId")
  private String objectTypeId;
  
  @Size(max = 255)
  @Column(name = "name")
  private String name;
  
  @Size(max = 255)
  @Column(name = "description")
  private String description;
  
  @Size(max = 255)
  @Column(name = "objectLogo")
  private String objectLogo;
  @Lob
  @Size(max = 65535)
  @Column(name = "keywords")
  private String keywords;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "summaryHTML")
  private String summaryHTML;
  
  @Size(max = 255)
  @Column(name = "thumbURL")
  private String thumbURL;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "published")
  private String published;
  
  @Column(name = "geolocated")
  private Short geolocated;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "imageAltText")
  private String imageAltText;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "xmlKeywords")
  private String xmlKeywords;
  
  @Size(max = 500)
  @Column(name = "hostServer")
  private String hostServer;
  
  @Column(name = "imagesCount")
  private Integer imagesCount;
  
  @Size(max = 45)
  @Column(name = "uuidString")
  private String uuidString; 
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private Image image;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private Otu otu;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private Specimen specimen;
   
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "mbId", fetch = FetchType.LAZY)
  private Collection<ExternalLinkObject> externalLinkObjectCollection;
   
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private Matrix matrix;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private MatrixCell matrixCell;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private Locality locality;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private Publication publication;
  
  @JoinColumn(name = "userId", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private User userId;
   
  @JoinColumn(name = "groupId", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Groups groupId;
  
  @JoinColumn(name = "submittedBy", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private User submittedBy; 
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "objectId", fetch = FetchType.LAZY)
  private Collection<UserProperty> userPropertyCollection;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private se.nrm.morphbank.datamodel.Collection collection;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionId", fetch = FetchType.LAZY)
  private Collection<CollectionObjects> collectionObjectsCollection;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "objectId", fetch = FetchType.LAZY)
  private Collection<CollectionObjects> collectionObjectsCollection1;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private User user;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private Groups groups;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private News news;
   
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private MbCharacter mbCharacter;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private TaxonConcept taxonConcept;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private View view;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private Annotation annotation;
  
  @OneToMany(mappedBy = "objectId", fetch = FetchType.LAZY)
  private Collection<Annotation> annotationCollection;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "baseObject", fetch = FetchType.LAZY)
  private CharacterState characterState;

  public BaseObject() {
  }

  public BaseObject(Integer id) {
    this.id = id;
  }

  public BaseObject(Integer id, Date dateCreated, Date dateToPublish, String objectTypeId, String published) {
    this.id = id;
    this.dateCreated = dateCreated;
    this.dateToPublish = dateToPublish;
    this.objectTypeId = objectTypeId;
    this.published = published;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getDateLastModified() {
    return dateLastModified;
  }

  public void setDateLastModified(Date dateLastModified) {
    this.dateLastModified = dateLastModified;
  }

  public Date getDateToPublish() {
    return dateToPublish;
  }

  public void setDateToPublish(Date dateToPublish) {
    this.dateToPublish = dateToPublish;
  }

  public String getObjectTypeId() {
    return objectTypeId;
  }

  public void setObjectTypeId(String objectTypeId) {
    this.objectTypeId = objectTypeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getObjectLogo() {
    return objectLogo;
  }

  public void setObjectLogo(String objectLogo) {
    this.objectLogo = objectLogo;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public String getSummaryHTML() {
    return summaryHTML;
  }

  public void setSummaryHTML(String summaryHTML) {
    this.summaryHTML = summaryHTML;
  }

  public String getThumbURL() {
    return thumbURL;
  }

  public void setThumbURL(String thumbURL) {
    this.thumbURL = thumbURL;
  }

  public String getPublished() {
    return published;
  }

  public void setPublished(String published) {
    this.published = published;
  }

  public Short getGeolocated() {
    return geolocated;
  }

  public void setGeolocated(Short geolocated) {
    this.geolocated = geolocated;
  }

  public String getImageAltText() {
    return imageAltText;
  }

  public void setImageAltText(String imageAltText) {
    this.imageAltText = imageAltText;
  }

  public String getXmlKeywords() {
    return xmlKeywords;
  }

  public void setXmlKeywords(String xmlKeywords) {
    this.xmlKeywords = xmlKeywords;
  }

  public String getHostServer() {
    return hostServer;
  }

  public void setHostServer(String hostServer) {
    this.hostServer = hostServer;
  }

  public Integer getImagesCount() {
    return imagesCount;
  }

  public void setImagesCount(Integer imagesCount) {
    this.imagesCount = imagesCount;
  }

  public String getUuidString() {
    return uuidString;
  }

  public void setUuidString(String uuidString) {
    this.uuidString = uuidString;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public Otu getOtu() {
    return otu;
  }

  public void setOtu(Otu otu) {
    this.otu = otu;
  }

  public Specimen getSpecimen() {
    return specimen;
  }

  public void setSpecimen(Specimen specimen) {
    this.specimen = specimen;
  }

  @XmlTransient
  public Collection<ExternalLinkObject> getExternalLinkObjectCollection() {
    return externalLinkObjectCollection;
  }

  public void setExternalLinkObjectCollection(Collection<ExternalLinkObject> externalLinkObjectCollection) {
    this.externalLinkObjectCollection = externalLinkObjectCollection;
  }

  public Matrix getMatrix() {
    return matrix;
  }

  public void setMatrix(Matrix matrix) {
    this.matrix = matrix;
  }

  public MatrixCell getMatrixCell() {
    return matrixCell;
  }

  public void setMatrixCell(MatrixCell matrixCell) {
    this.matrixCell = matrixCell;
  }

  public Locality getLocality() {
    return locality;
  }

  public void setLocality(Locality locality) {
    this.locality = locality;
  }

  public Publication getPublication() {
    return publication;
  }

  public void setPublication(Publication publication) {
    this.publication = publication;
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

  public User getSubmittedBy() {
    return submittedBy;
  }

  public void setSubmittedBy(User submittedBy) {
    this.submittedBy = submittedBy;
  }

  @XmlTransient
  public Collection<UserProperty> getUserPropertyCollection() {
    return userPropertyCollection;
  }

  public void setUserPropertyCollection(Collection<UserProperty> userPropertyCollection) {
    this.userPropertyCollection = userPropertyCollection;
  }

  public se.nrm.morphbank.datamodel.Collection getCollection() {
    return collection;
  }

  public void setCollection(se.nrm.morphbank.datamodel.Collection collection) {
    this.collection = collection;
  }

  @XmlTransient
  public Collection<CollectionObjects> getCollectionObjectsCollection() {
    return collectionObjectsCollection;
  }

  public void setCollectionObjectsCollection(Collection<CollectionObjects> collectionObjectsCollection) {
    this.collectionObjectsCollection = collectionObjectsCollection;
  }

  @XmlTransient
  public Collection<CollectionObjects> getCollectionObjectsCollection1() {
    return collectionObjectsCollection1;
  }

  public void setCollectionObjectsCollection1(Collection<CollectionObjects> collectionObjectsCollection1) {
    this.collectionObjectsCollection1 = collectionObjectsCollection1;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Groups getGroups() {
    return groups;
  }

  public void setGroups(Groups groups) {
    this.groups = groups;
  }

  public News getNews() {
    return news;
  }

  public void setNews(News news) {
    this.news = news;
  }

  public MbCharacter getMbCharacter() {
    return mbCharacter;
  }

  public void setMbCharacter(MbCharacter mbCharacter) {
    this.mbCharacter = mbCharacter;
  }

  public TaxonConcept getTaxonConcept() {
    return taxonConcept;
  }

  public void setTaxonConcept(TaxonConcept taxonConcept) {
    this.taxonConcept = taxonConcept;
  }

  public View getView() {
    return view;
  }

  public void setView(View view) {
    this.view = view;
  }

  public Annotation getAnnotation() {
    return annotation;
  }

  public void setAnnotation(Annotation annotation) {
    this.annotation = annotation;
  }

  @XmlTransient
  public Collection<Annotation> getAnnotationCollection() {
    return annotationCollection;
  }

  public void setAnnotationCollection(Collection<Annotation> annotationCollection) {
    this.annotationCollection = annotationCollection;
  }

  public CharacterState getCharacterState() {
    return characterState;
  }

  public void setCharacterState(CharacterState characterState) {
    this.characterState = characterState;
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
    if (!(object instanceof BaseObject)) {
      return false;
    }
    BaseObject other = (BaseObject) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.BaseObject[ id=" + id + " ]";
  }
  
}
