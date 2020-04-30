package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Taxa")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Taxa.findAll", query = "SELECT t FROM Taxa t"),
  @NamedQuery(name = "Taxa.findById", query = "SELECT t FROM Taxa t WHERE t.id = :id"),
  @NamedQuery(name = "Taxa.findByBoId", query = "SELECT t FROM Taxa t WHERE t.boId = :boId"),
  @NamedQuery(name = "Taxa.findByTaxonomicNames", query = "SELECT t FROM Taxa t WHERE t.taxonomicNames = :taxonomicNames")})
public class Taxa implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  
  @Column(name = "boId")
  private Integer boId;
  
  @Column(name = "tsn")
  private BigInteger tsn;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "scientificName")
  private String scientificName;
  
  @Column(name = "taxon_author_id")
  private Integer taxonAuthorId;
  
  @Size(max = 255)
  @Column(name = "taxon_author_name")
  private String taxonAuthorName;
  
  @Size(max = 255)
  @Column(name = "status")
  private String status;
  
  @Column(name = "parent_tsn")
  private BigInteger parentTsn;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "parent_name")
  private String parentName;
  
  @Column(name = "kingdom_id")
  private Short kingdomId;
  
  @Size(max = 255)
  @Column(name = "kingdom_name")
  private String kingdomName;
  
  @Column(name = "rank_id")
  private Short rankId;
  
  @Size(max = 255)
  @Column(name = "rank_name")
  private String rankName;
  
  @Column(name = "imagesCount")
  private BigInteger imagesCount;
  
  @Size(max = 255)
  @Column(name = "nameType")
  private String nameType;
   
  @Size(max = 255)
  @Column(name = "nameSource")
  private String nameSource;
  
  @Column(name = "publicationId")
  private Integer publicationId;
  
  @Column(name = "userId")
  private Integer userId;
  
  @Column(name = "groupId")
  private Integer groupId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateToPublish")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateToPublish;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "keywords")
  private String keywords;
  
  @Size(max = 255)
  @Column(name = "objectTypeId")
  private String objectTypeId;
  
  @Size(max = 255)
  @Column(name = "taxonomicNames")
  private String taxonomicNames;

  public Taxa() {
  }

  public Taxa(Integer id) {
    this.id = id;
  }

  public Taxa(Integer id, String scientificName, Date dateToPublish) {
    this.id = id;
    this.scientificName = scientificName;
    this.dateToPublish = dateToPublish;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getBoId() {
    return boId;
  }

  public void setBoId(Integer boId) {
    this.boId = boId;
  }

  public BigInteger getTsn() {
    return tsn;
  }

  public void setTsn(BigInteger tsn) {
    this.tsn = tsn;
  }

  public String getScientificName() {
    return scientificName;
  }

  public void setScientificName(String scientificName) {
    this.scientificName = scientificName;
  }

  public Integer getTaxonAuthorId() {
    return taxonAuthorId;
  }

  public void setTaxonAuthorId(Integer taxonAuthorId) {
    this.taxonAuthorId = taxonAuthorId;
  }

  public String getTaxonAuthorName() {
    return taxonAuthorName;
  }

  public void setTaxonAuthorName(String taxonAuthorName) {
    this.taxonAuthorName = taxonAuthorName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BigInteger getParentTsn() {
    return parentTsn;
  }

  public void setParentTsn(BigInteger parentTsn) {
    this.parentTsn = parentTsn;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public Short getKingdomId() {
    return kingdomId;
  }

  public void setKingdomId(Short kingdomId) {
    this.kingdomId = kingdomId;
  }

  public String getKingdomName() {
    return kingdomName;
  }

  public void setKingdomName(String kingdomName) {
    this.kingdomName = kingdomName;
  }

  public Short getRankId() {
    return rankId;
  }

  public void setRankId(Short rankId) {
    this.rankId = rankId;
  }

  public String getRankName() {
    return rankName;
  }

  public void setRankName(String rankName) {
    this.rankName = rankName;
  }

  public BigInteger getImagesCount() {
    return imagesCount;
  }

  public void setImagesCount(BigInteger imagesCount) {
    this.imagesCount = imagesCount;
  }

  public String getNameType() {
    return nameType;
  }

  public void setNameType(String nameType) {
    this.nameType = nameType;
  }

  public String getNameSource() {
    return nameSource;
  }

  public void setNameSource(String nameSource) {
    this.nameSource = nameSource;
  }

  public Integer getPublicationId() {
    return publicationId;
  }

  public void setPublicationId(Integer publicationId) {
    this.publicationId = publicationId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public Date getDateToPublish() {
    return dateToPublish;
  }

  public void setDateToPublish(Date dateToPublish) {
    this.dateToPublish = dateToPublish;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public String getObjectTypeId() {
    return objectTypeId;
  }

  public void setObjectTypeId(String objectTypeId) {
    this.objectTypeId = objectTypeId;
  }

  public String getTaxonomicNames() {
    return taxonomicNames;
  }

  public void setTaxonomicNames(String taxonomicNames) {
    this.taxonomicNames = taxonomicNames;
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
    if (!(object instanceof Taxa)) {
      return false;
    }
    Taxa other = (Taxa) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Taxa[ id=" + id + " ]";
  }
  
}
