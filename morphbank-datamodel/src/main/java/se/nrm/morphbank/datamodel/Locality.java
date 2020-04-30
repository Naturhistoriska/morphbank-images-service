package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "Locality")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Locality.findAll", query = "SELECT l FROM Locality l"),
  @NamedQuery(name = "Locality.findById", query = "SELECT l FROM Locality l WHERE l.id = :id"),
  @NamedQuery(name = "Locality.findByOcean", query = "SELECT l FROM Locality l WHERE l.ocean = :ocean")})
public class Locality implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Size(max = 255)
  @Column(name = "continentOcean")
  private String continentOcean; 
  
  @Size(max = 255)
  @Column(name = "country")
  private String country;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "locality")
  private String locality; 
  
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "latitude")
  private Double latitude;
  
  @Column(name = "longitude")
  private Double longitude;
  
  @Column(name = "coordinatePrecision")
  private Integer coordinatePrecision;
  
  @Column(name = "minimumElevation")
  private Short minimumElevation;
  
  @Column(name = "maximumElevation")
  private Short maximumElevation;
  
  @Column(name = "minimumDepth")
  private Short minimumDepth;
  
  @Column(name = "maximumDepth")
  private Short maximumDepth;
  
  @Column(name = "imagesCount")
  private BigInteger imagesCount;
  
  @Size(max = 255)
  @Column(name = "county")
  private String county;
  
  @Size(max = 255)
  @Column(name = "state")
  private String state;
  
  @Size(max = 255)
  @Column(name = "paleoGroup")
  private String paleoGroup;
  
  @Size(max = 255)
  @Column(name = "paleoFormation")
  private String paleoFormation;
  
  @Size(max = 255)
  @Column(name = "paleoMember")
  private String paleoMember;
  
  @Size(max = 255)
  @Column(name = "paleoBed")
  private String paleoBed;
  
  @Size(max = 255)
  @Column(name = "continent")
  private String continent;
  
  @Size(max = 255)
  @Column(name = "ocean")
  private String ocean;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "informationWithheld")
  private String informationWithheld;
  
  @OneToMany(mappedBy = "localityId", fetch = FetchType.LAZY)
  private Collection<Specimen> specimenCollection;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;

  public Locality() {
  }

  public Locality(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContinentOcean() {
    return continentOcean;
  }

  public void setContinentOcean(String continentOcean) {
    this.continentOcean = continentOcean;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Integer getCoordinatePrecision() {
    return coordinatePrecision;
  }

  public void setCoordinatePrecision(Integer coordinatePrecision) {
    this.coordinatePrecision = coordinatePrecision;
  }

  public Short getMinimumElevation() {
    return minimumElevation;
  }

  public void setMinimumElevation(Short minimumElevation) {
    this.minimumElevation = minimumElevation;
  }

  public Short getMaximumElevation() {
    return maximumElevation;
  }

  public void setMaximumElevation(Short maximumElevation) {
    this.maximumElevation = maximumElevation;
  }

  public Short getMinimumDepth() {
    return minimumDepth;
  }

  public void setMinimumDepth(Short minimumDepth) {
    this.minimumDepth = minimumDepth;
  }

  public Short getMaximumDepth() {
    return maximumDepth;
  }

  public void setMaximumDepth(Short maximumDepth) {
    this.maximumDepth = maximumDepth;
  }

  public BigInteger getImagesCount() {
    return imagesCount;
  }

  public void setImagesCount(BigInteger imagesCount) {
    this.imagesCount = imagesCount;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPaleoGroup() {
    return paleoGroup;
  }

  public void setPaleoGroup(String paleoGroup) {
    this.paleoGroup = paleoGroup;
  }

  public String getPaleoFormation() {
    return paleoFormation;
  }

  public void setPaleoFormation(String paleoFormation) {
    this.paleoFormation = paleoFormation;
  }

  public String getPaleoMember() {
    return paleoMember;
  }

  public void setPaleoMember(String paleoMember) {
    this.paleoMember = paleoMember;
  }

  public String getPaleoBed() {
    return paleoBed;
  }

  public void setPaleoBed(String paleoBed) {
    this.paleoBed = paleoBed;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public String getOcean() {
    return ocean;
  }

  public void setOcean(String ocean) {
    this.ocean = ocean;
  }

  public String getInformationWithheld() {
    return informationWithheld;
  }

  public void setInformationWithheld(String informationWithheld) {
    this.informationWithheld = informationWithheld;
  }

  @XmlTransient
  public Collection<Specimen> getSpecimenCollection() {
    return specimenCollection;
  }

  public void setSpecimenCollection(Collection<Specimen> specimenCollection) {
    this.specimenCollection = specimenCollection;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
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
    if (!(object instanceof Locality)) {
      return false;
    }
    Locality other = (Locality) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Locality[ id=" + id + " ]";
  }
  
}
