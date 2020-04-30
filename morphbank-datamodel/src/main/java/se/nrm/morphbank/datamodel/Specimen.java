package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "Specimen")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Specimen.findAll", query = "SELECT s FROM Specimen s"),
  @NamedQuery(name = "Specimen.findById", query = "SELECT s FROM Specimen s WHERE s.id = :id"),
  @NamedQuery(name = "Specimen.findByLatestDateCollected", query = "SELECT s FROM Specimen s WHERE s.latestDateCollected = :latestDateCollected")})
public class Specimen implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Size(max = 255)
  @Column(name = "sex")
  private String sex;
  
  @Size(max = 255)
  @Column(name = "form")
  private String form;
  
  @Size(max = 255)
  @Column(name = "developmentalStage")
  private String developmentalStage;
  
  @Size(max = 255)
  @Column(name = "preparationType")
  private String preparationType;
  
  @Column(name = "individualCount")
  private Integer individualCount;
  
  @Size(max = 255)
  @Column(name = "typeStatus")
  private String typeStatus;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "name")
  private String name;
   
  @Column(name = "dateIdentified")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateIdentified;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "comment")
  private String comment;
  
  @Size(max = 255)
  @Column(name = "institutionCode")
  private String institutionCode;
  
  @Size(max = 255)
  @Column(name = "collectionCode")
  private String collectionCode;
  
  @Size(max = 255)
  @Column(name = "catalogNumber")
  private String catalogNumber;
  
  @Size(max = 255)
  @Column(name = "previousCatalogNumber")
  private String previousCatalogNumber;
  
  @Size(max = 255)
  @Column(name = "relatedCatalogItem")
  private String relatedCatalogItem;
   
  @Size(max = 255)
  @Column(name = "relationshipType")
  private String relationshipType;
  
  @Size(max = 255)
  @Column(name = "collectionNumber")
  private String collectionNumber;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "collectorName")
  private String collectorName;
  
  @Column(name = "dateCollected")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateCollected; 
  
  @Lob
  @Size(max = 65535)
  @Column(name = "notes")
  private String notes;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "taxonomicNames")
  private String taxonomicNames;
  
  @Column(name = "imagesCount")
  private BigInteger imagesCount;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "ocr")
  private String ocr;
   
  @Size(max = 255)
  @Column(name = "barCode")
  private String barCode;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "labelData")
  private String labelData;
  
  @Column(name = "earliestDateCollected")
  @Temporal(TemporalType.TIMESTAMP)
  private Date earliestDateCollected;
  
  @Column(name = "latestDateCollected")
  @Temporal(TemporalType.TIMESTAMP)
  private Date latestDateCollected; 
  
  @OneToMany(mappedBy = "specimenId", fetch = FetchType.LAZY)
  private Collection<Image> imageCollection;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;
  
  @JoinColumn(name = "basisOfRecordId", referencedColumnName = "name")
  @ManyToOne(fetch = FetchType.LAZY)
  private BasisOfRecord basisOfRecordId;
  
  @JoinColumn(name = "tsnId", referencedColumnName = "tsn")
  @ManyToOne(fetch = FetchType.LAZY)
  private Tree tsnId;
  
  @JoinColumn(name = "localityId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Locality localityId;
  
  @JoinColumn(name = "standardImageId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Image standardImageId;
  
  @OneToMany(mappedBy = "specimenId", fetch = FetchType.LAZY)
  private Collection<DeterminationAnnotation> determinationAnnotationCollection;

  public Specimen() {
  }

  public Specimen(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getForm() {
    return form;
  }

  public void setForm(String form) {
    this.form = form;
  }

  public String getDevelopmentalStage() {
    return developmentalStage;
  }

  public void setDevelopmentalStage(String developmentalStage) {
    this.developmentalStage = developmentalStage;
  }

  public String getPreparationType() {
    return preparationType;
  }

  public void setPreparationType(String preparationType) {
    this.preparationType = preparationType;
  }

  public Integer getIndividualCount() {
    return individualCount;
  }

  public void setIndividualCount(Integer individualCount) {
    this.individualCount = individualCount;
  }

  public String getTypeStatus() {
    return typeStatus;
  }

  public void setTypeStatus(String typeStatus) {
    this.typeStatus = typeStatus;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDateIdentified() {
    return dateIdentified;
  }

  public void setDateIdentified(Date dateIdentified) {
    this.dateIdentified = dateIdentified;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getInstitutionCode() {
    return institutionCode;
  }

  public void setInstitutionCode(String institutionCode) {
    this.institutionCode = institutionCode;
  }

  public String getCollectionCode() {
    return collectionCode;
  }

  public void setCollectionCode(String collectionCode) {
    this.collectionCode = collectionCode;
  }

  public String getCatalogNumber() {
    return catalogNumber;
  }

  public void setCatalogNumber(String catalogNumber) {
    this.catalogNumber = catalogNumber;
  }

  public String getPreviousCatalogNumber() {
    return previousCatalogNumber;
  }

  public void setPreviousCatalogNumber(String previousCatalogNumber) {
    this.previousCatalogNumber = previousCatalogNumber;
  }

  public String getRelatedCatalogItem() {
    return relatedCatalogItem;
  }

  public void setRelatedCatalogItem(String relatedCatalogItem) {
    this.relatedCatalogItem = relatedCatalogItem;
  }

  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public String getCollectionNumber() {
    return collectionNumber;
  }

  public void setCollectionNumber(String collectionNumber) {
    this.collectionNumber = collectionNumber;
  }

  public String getCollectorName() {
    return collectorName;
  }

  public void setCollectorName(String collectorName) {
    this.collectorName = collectorName;
  }

  public Date getDateCollected() {
    return dateCollected;
  }

  public void setDateCollected(Date dateCollected) {
    this.dateCollected = dateCollected;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getTaxonomicNames() {
    return taxonomicNames;
  }

  public void setTaxonomicNames(String taxonomicNames) {
    this.taxonomicNames = taxonomicNames;
  }

  public BigInteger getImagesCount() {
    return imagesCount;
  }

  public void setImagesCount(BigInteger imagesCount) {
    this.imagesCount = imagesCount;
  }

  public String getOcr() {
    return ocr;
  }

  public void setOcr(String ocr) {
    this.ocr = ocr;
  }

  public String getBarCode() {
    return barCode;
  }

  public void setBarCode(String barCode) {
    this.barCode = barCode;
  }

  public String getLabelData() {
    return labelData;
  }

  public void setLabelData(String labelData) {
    this.labelData = labelData;
  }

  public Date getEarliestDateCollected() {
    return earliestDateCollected;
  }

  public void setEarliestDateCollected(Date earliestDateCollected) {
    this.earliestDateCollected = earliestDateCollected;
  }

  public Date getLatestDateCollected() {
    return latestDateCollected;
  }

  public void setLatestDateCollected(Date latestDateCollected) {
    this.latestDateCollected = latestDateCollected;
  }

  @XmlTransient
  public Collection<Image> getImageCollection() {
    return imageCollection;
  }

  public void setImageCollection(Collection<Image> imageCollection) {
    this.imageCollection = imageCollection;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
  }

  public BasisOfRecord getBasisOfRecordId() {
    return basisOfRecordId;
  }

  public void setBasisOfRecordId(BasisOfRecord basisOfRecordId) {
    this.basisOfRecordId = basisOfRecordId;
  }

  public Tree getTsnId() {
    return tsnId;
  }

  public void setTsnId(Tree tsnId) {
    this.tsnId = tsnId;
  }

  public Locality getLocalityId() {
    return localityId;
  }

  public void setLocalityId(Locality localityId) {
    this.localityId = localityId;
  }

  public Image getStandardImageId() {
    return standardImageId;
  }

  public void setStandardImageId(Image standardImageId) {
    this.standardImageId = standardImageId;
  }

  @XmlTransient
  public Collection<DeterminationAnnotation> getDeterminationAnnotationCollection() {
    return determinationAnnotationCollection;
  }

  public void setDeterminationAnnotationCollection(Collection<DeterminationAnnotation> determinationAnnotationCollection) {
    this.determinationAnnotationCollection = determinationAnnotationCollection;
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
    if (!(object instanceof Specimen)) {
      return false;
    }
    Specimen other = (Specimen) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Specimen[ id=" + id + " ]";
  }
  
}
