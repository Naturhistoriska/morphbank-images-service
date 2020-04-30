package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Keywords")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Keywords.findAll", query = "SELECT k FROM Keywords k"),
  @NamedQuery(name = "Keywords.findById", query = "SELECT k FROM Keywords k WHERE k.id = :id"),
  @NamedQuery(name = "Keywords.findByDateCreated", query = "SELECT k FROM Keywords k WHERE k.dateCreated = :dateCreated")})
public class Keywords implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Column(name = "userId")
  private Integer userId;
  
  @Column(name = "groupId")
  private Integer groupId;
  
  @Column(name = "dateToPublish")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateToPublish;
  
  @Size(max = 255)
  @Column(name = "objectTypeId")
  private String objectTypeId;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "keywords")
  private String keywords;
  
  @Column(name = "submittedBy")
  private Integer submittedBy;
  
  @Column(name = "geolocated")
  private Short geolocated;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "xmlKeywords")
  private String xmlKeywords; 
  
  @Column(name = "dateCreated")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateCreated;

  public Keywords() {
  }

  public Keywords(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getObjectTypeId() {
    return objectTypeId;
  }

  public void setObjectTypeId(String objectTypeId) {
    this.objectTypeId = objectTypeId;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public Integer getSubmittedBy() {
    return submittedBy;
  }

  public void setSubmittedBy(Integer submittedBy) {
    this.submittedBy = submittedBy;
  }

  public Short getGeolocated() {
    return geolocated;
  }

  public void setGeolocated(Short geolocated) {
    this.geolocated = geolocated;
  }

  public String getXmlKeywords() {
    return xmlKeywords;
  }

  public void setXmlKeywords(String xmlKeywords) {
    this.xmlKeywords = xmlKeywords;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
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
    if (!(object instanceof Keywords)) {
      return false;
    }
    Keywords other = (Keywords) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Keywords[ id=" + id + " ]";
  }
  
}
