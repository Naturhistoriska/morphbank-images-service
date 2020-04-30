/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "IptSpecimen")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "IptSpecimen.findAll", query = "SELECT i FROM IptSpecimen i"),
  @NamedQuery(name = "IptSpecimen.findByOccurrenceID", query = "SELECT i FROM IptSpecimen i WHERE i.occurrenceID = :occurrenceID"),
  @NamedQuery(name = "IptSpecimen.findByType", query = "SELECT i FROM IptSpecimen i WHERE i.type = :type"),
  @NamedQuery(name = "IptSpecimen.findByTsn", query = "SELECT i FROM IptSpecimen i WHERE i.tsn = :tsn")})
public class IptSpecimen implements Serializable {

  private static final long serialVersionUID = 1L;
   
  @Size(max = 36)
  @Column(name = "occurrenceID")
  private String occurrenceID;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "type")
  private String type;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "informationWithheld")
  private String informationWithheld;
  
  @Size(max = 255)
  @Column(name = "institutionCode")
  private String institutionCode;
  
  @Size(max = 255)
  @Column(name = "collectionCode")
  private String collectionCode;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "basisOfRecord")
  private String basisOfRecord;
  
  @Column(name = "modified")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modified;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "language")
  private String language;
  
  @Size(max = 255)
  @Column(name = "catalogNumber")
  private String catalogNumber;
  
  @Size(max = 255)
  @Column(name = "sex")
  private String sex;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "occurrenceRemarks")
  private String occurrenceRemarks;
  
  @Size(max = 255)
  @Column(name = "recordNumber")
  private String recordNumber;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "recordedBy")
  private String recordedBy;
  
  @Column(name = "individualCount")
  private Integer individualCount;
  
  @Size(max = 255)
  @Column(name = "lifeStage")
  private String lifeStage;
  
  @Size(max = 255)
  @Column(name = "preparations")
  private String preparations;
  
  @Size(max = 255)
  @Column(name = "otherCatalogNumbers")
  private String otherCatalogNumbers;
  
  @Column(name = "eventDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date eventDate;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "verbatimEventDate")
  private String verbatimEventDate;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "fieldNotes")
  private String fieldNotes;
  
  @Size(max = 255)
  @Column(name = "continent")
  private String continent;
  
  @Size(max = 255)
  @Column(name = "country")
  private String country;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "locality")
  private String locality;
  
  @Size(max = 255)
  @Column(name = "county")
  private String county;
  
  @Size(max = 255)
  @Column(name = "waterbody")
  private String waterbody;
  
  @Size(max = 255)
  @Column(name = "stateProvince")
  private String stateProvince;
  
  @Column(name = "maximumElevationInMeters")
  private Short maximumElevationInMeters;
  
  @Column(name = "minimumelevationInMeters")
  private Short minimumelevationInMeters;
  
  @Column(name = "minimumDepthInMeters")
  private Short minimumDepthInMeters;
  
  @Column(name = "maximumDepthInMeters")
  private Short maximumDepthInMeters;
  
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "verbatimLatitude")
  private Double verbatimLatitude;
  
  @Column(name = "verbatimLongitude")
  private Double verbatimLongitude;
  
  @Column(name = "coordinatePrecision")
  private Integer coordinatePrecision;
  
  @Size(max = 36)
  @Column(name = "locationId")
  private String locationId;
  
  @Size(max = 255)
  @Column(name = "group")
  private String group;
  
  @Size(max = 255)
  @Column(name = "formation")
  private String formation;
  
  @Size(max = 255)
  @Column(name = "member")
  private String member;
  
  @Size(max = 255)
  @Column(name = "bed")
  private String bed;
  
  @Size(max = 255)
  @Column(name = "typeStatus")
  private String typeStatus;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "identifiedBy")
  private String identifiedBy;
  
  @Column(name = "dateIdentified")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateIdentified;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "identificationRemarks")
  private String identificationRemarks;
  
  @Size(max = 255)
  @Column(name = "scientificname")
  private String scientificname;
  
  @Size(max = 255)
  @Column(name = "kingdom")
  private String kingdom;
  
  @Size(max = 255)
  @Column(name = "taxonRank")
  private String taxonRank;
  
  @Size(max = 255)
  @Column(name = "scientificNameAuthorship")
  private String scientificNameAuthorship;
  
  @Size(max = 255)
  @Column(name = "nomenclaturalStatus")
  private String nomenclaturalStatus;
  
  @Column(name = "groupId")
  private Integer groupId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "specimenId")
  private int specimenId;
  
  @Column(name = "userId")
  private Integer userId;
  
  @Column(name = "tsn")
  private BigInteger tsn;

  public IptSpecimen() {
  }

  public String getOccurrenceID() {
    return occurrenceID;
  }

  public void setOccurrenceID(String occurrenceID) {
    this.occurrenceID = occurrenceID;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getInformationWithheld() {
    return informationWithheld;
  }

  public void setInformationWithheld(String informationWithheld) {
    this.informationWithheld = informationWithheld;
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

  public String getBasisOfRecord() {
    return basisOfRecord;
  }

  public void setBasisOfRecord(String basisOfRecord) {
    this.basisOfRecord = basisOfRecord;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getCatalogNumber() {
    return catalogNumber;
  }

  public void setCatalogNumber(String catalogNumber) {
    this.catalogNumber = catalogNumber;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getOccurrenceRemarks() {
    return occurrenceRemarks;
  }

  public void setOccurrenceRemarks(String occurrenceRemarks) {
    this.occurrenceRemarks = occurrenceRemarks;
  }

  public String getRecordNumber() {
    return recordNumber;
  }

  public void setRecordNumber(String recordNumber) {
    this.recordNumber = recordNumber;
  }

  public String getRecordedBy() {
    return recordedBy;
  }

  public void setRecordedBy(String recordedBy) {
    this.recordedBy = recordedBy;
  }

  public Integer getIndividualCount() {
    return individualCount;
  }

  public void setIndividualCount(Integer individualCount) {
    this.individualCount = individualCount;
  }

  public String getLifeStage() {
    return lifeStage;
  }

  public void setLifeStage(String lifeStage) {
    this.lifeStage = lifeStage;
  }

  public String getPreparations() {
    return preparations;
  }

  public void setPreparations(String preparations) {
    this.preparations = preparations;
  }

  public String getOtherCatalogNumbers() {
    return otherCatalogNumbers;
  }

  public void setOtherCatalogNumbers(String otherCatalogNumbers) {
    this.otherCatalogNumbers = otherCatalogNumbers;
  }

  public Date getEventDate() {
    return eventDate;
  }

  public void setEventDate(Date eventDate) {
    this.eventDate = eventDate;
  }

  public String getVerbatimEventDate() {
    return verbatimEventDate;
  }

  public void setVerbatimEventDate(String verbatimEventDate) {
    this.verbatimEventDate = verbatimEventDate;
  }

  public String getFieldNotes() {
    return fieldNotes;
  }

  public void setFieldNotes(String fieldNotes) {
    this.fieldNotes = fieldNotes;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
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

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getWaterbody() {
    return waterbody;
  }

  public void setWaterbody(String waterbody) {
    this.waterbody = waterbody;
  }

  public String getStateProvince() {
    return stateProvince;
  }

  public void setStateProvince(String stateProvince) {
    this.stateProvince = stateProvince;
  }

  public Short getMaximumElevationInMeters() {
    return maximumElevationInMeters;
  }

  public void setMaximumElevationInMeters(Short maximumElevationInMeters) {
    this.maximumElevationInMeters = maximumElevationInMeters;
  }

  public Short getMinimumelevationInMeters() {
    return minimumelevationInMeters;
  }

  public void setMinimumelevationInMeters(Short minimumelevationInMeters) {
    this.minimumelevationInMeters = minimumelevationInMeters;
  }

  public Short getMinimumDepthInMeters() {
    return minimumDepthInMeters;
  }

  public void setMinimumDepthInMeters(Short minimumDepthInMeters) {
    this.minimumDepthInMeters = minimumDepthInMeters;
  }

  public Short getMaximumDepthInMeters() {
    return maximumDepthInMeters;
  }

  public void setMaximumDepthInMeters(Short maximumDepthInMeters) {
    this.maximumDepthInMeters = maximumDepthInMeters;
  }

  public Double getVerbatimLatitude() {
    return verbatimLatitude;
  }

  public void setVerbatimLatitude(Double verbatimLatitude) {
    this.verbatimLatitude = verbatimLatitude;
  }

  public Double getVerbatimLongitude() {
    return verbatimLongitude;
  }

  public void setVerbatimLongitude(Double verbatimLongitude) {
    this.verbatimLongitude = verbatimLongitude;
  }

  public Integer getCoordinatePrecision() {
    return coordinatePrecision;
  }

  public void setCoordinatePrecision(Integer coordinatePrecision) {
    this.coordinatePrecision = coordinatePrecision;
  }

  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getFormation() {
    return formation;
  }

  public void setFormation(String formation) {
    this.formation = formation;
  }

  public String getMember() {
    return member;
  }

  public void setMember(String member) {
    this.member = member;
  }

  public String getBed() {
    return bed;
  }

  public void setBed(String bed) {
    this.bed = bed;
  }

  public String getTypeStatus() {
    return typeStatus;
  }

  public void setTypeStatus(String typeStatus) {
    this.typeStatus = typeStatus;
  }

  public String getIdentifiedBy() {
    return identifiedBy;
  }

  public void setIdentifiedBy(String identifiedBy) {
    this.identifiedBy = identifiedBy;
  }

  public Date getDateIdentified() {
    return dateIdentified;
  }

  public void setDateIdentified(Date dateIdentified) {
    this.dateIdentified = dateIdentified;
  }

  public String getIdentificationRemarks() {
    return identificationRemarks;
  }

  public void setIdentificationRemarks(String identificationRemarks) {
    this.identificationRemarks = identificationRemarks;
  }

  public String getScientificname() {
    return scientificname;
  }

  public void setScientificname(String scientificname) {
    this.scientificname = scientificname;
  }

  public String getKingdom() {
    return kingdom;
  }

  public void setKingdom(String kingdom) {
    this.kingdom = kingdom;
  }

  public String getTaxonRank() {
    return taxonRank;
  }

  public void setTaxonRank(String taxonRank) {
    this.taxonRank = taxonRank;
  }

  public String getScientificNameAuthorship() {
    return scientificNameAuthorship;
  }

  public void setScientificNameAuthorship(String scientificNameAuthorship) {
    this.scientificNameAuthorship = scientificNameAuthorship;
  }

  public String getNomenclaturalStatus() {
    return nomenclaturalStatus;
  }

  public void setNomenclaturalStatus(String nomenclaturalStatus) {
    this.nomenclaturalStatus = nomenclaturalStatus;
  }

  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public int getSpecimenId() {
    return specimenId;
  }

  public void setSpecimenId(int specimenId) {
    this.specimenId = specimenId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public BigInteger getTsn() {
    return tsn;
  }

  public void setTsn(BigInteger tsn) {
    this.tsn = tsn;
  }
  
}
