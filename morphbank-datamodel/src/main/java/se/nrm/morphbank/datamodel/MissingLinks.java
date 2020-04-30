package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "MissingLinks")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "MissingLinks.findAll", query = "SELECT m FROM MissingLinks m"),
  @NamedQuery(name = "MissingLinks.findById", query = "SELECT m FROM MissingLinks m WHERE m.id = :id"),
  @NamedQuery(name = "MissingLinks.findByRemoteDetailUrl", query = "SELECT m FROM MissingLinks m WHERE m.remoteDetailUrl = :remoteDetailUrl")})
public class MissingLinks implements Serializable {

  private static final long serialVersionUID = 1L; 
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "linkType")
  private String linkType;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "sourceId")
  private int sourceId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "targetId")
  private int targetId;
  
  @Column(name = "objectOrder")
  private Integer objectOrder;
  
  @Size(max = 255)
  @Column(name = "objectRole")
  private String objectRole;
  
  @Size(max = 255)
  @Column(name = "objectTitle")
  private String objectTitle;
  
  @Column(name = "dateRecorded")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateRecorded;
  
  @Size(max = 512)
  @Column(name = "remoteDetailUrl")
  private String remoteDetailUrl;

  public MissingLinks() {
  }

  public MissingLinks(Integer id) {
    this.id = id;
  }

  public MissingLinks(Integer id, String linkType, int sourceId, int targetId) {
    this.id = id;
    this.linkType = linkType;
    this.sourceId = sourceId;
    this.targetId = targetId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLinkType() {
    return linkType;
  }

  public void setLinkType(String linkType) {
    this.linkType = linkType;
  }

  public int getSourceId() {
    return sourceId;
  }

  public void setSourceId(int sourceId) {
    this.sourceId = sourceId;
  }

  public int getTargetId() {
    return targetId;
  }

  public void setTargetId(int targetId) {
    this.targetId = targetId;
  }

  public Integer getObjectOrder() {
    return objectOrder;
  }

  public void setObjectOrder(Integer objectOrder) {
    this.objectOrder = objectOrder;
  }

  public String getObjectRole() {
    return objectRole;
  }

  public void setObjectRole(String objectRole) {
    this.objectRole = objectRole;
  }

  public String getObjectTitle() {
    return objectTitle;
  }

  public void setObjectTitle(String objectTitle) {
    this.objectTitle = objectTitle;
  }

  public Date getDateRecorded() {
    return dateRecorded;
  }

  public void setDateRecorded(Date dateRecorded) {
    this.dateRecorded = dateRecorded;
  }

  public String getRemoteDetailUrl() {
    return remoteDetailUrl;
  }

  public void setRemoteDetailUrl(String remoteDetailUrl) {
    this.remoteDetailUrl = remoteDetailUrl;
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
    if (!(object instanceof MissingLinks)) {
      return false;
    }
    MissingLinks other = (MissingLinks) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.MissingLinks[ id=" + id + " ]";
  }
  
}
