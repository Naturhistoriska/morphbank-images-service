package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "ExternalLinkObject")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ExternalLinkObject.findAll", query = "SELECT e FROM ExternalLinkObject e"),
  @NamedQuery(name = "ExternalLinkObject.findByLinkId", query = "SELECT e FROM ExternalLinkObject e WHERE e.linkId = :linkId"),
  @NamedQuery(name = "ExternalLinkObject.findByLabel", query = "SELECT e FROM ExternalLinkObject e WHERE e.label = :label"),
  @NamedQuery(name = "ExternalLinkObject.findByUrlData", query = "SELECT e FROM ExternalLinkObject e WHERE e.urlData = :urlData"),
  @NamedQuery(name = "ExternalLinkObject.findByDescription", query = "SELECT e FROM ExternalLinkObject e WHERE e.description = :description"),
  @NamedQuery(name = "ExternalLinkObject.findByExternalId", query = "SELECT e FROM ExternalLinkObject e WHERE e.externalId = :externalId")})
public class ExternalLinkObject implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "linkId")
  private Integer linkId;
  
  @Size(max = 255)
  @Column(name = "label")
  private String label;
  
  @Size(max = 255)
  @Column(name = "urlData")
  private String urlData;
  
  @Size(max = 2000)
  @Column(name = "description")
  private String description;
  
  @Size(max = 512)
  @Column(name = "externalId")
  private String externalId;
  
  @JoinColumn(name = "mbId", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject mbId;
  
  @JoinColumn(name = "extLinkTypeId", referencedColumnName = "linkTypeId")
  @ManyToOne(fetch = FetchType.LAZY)
  private ExternalLinkType extLinkTypeId;

  public ExternalLinkObject() {
  }

  public ExternalLinkObject(Integer linkId) {
    this.linkId = linkId;
  }

  public Integer getLinkId() {
    return linkId;
  }

  public void setLinkId(Integer linkId) {
    this.linkId = linkId;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getUrlData() {
    return urlData;
  }

  public void setUrlData(String urlData) {
    this.urlData = urlData;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public BaseObject getMbId() {
    return mbId;
  }

  public void setMbId(BaseObject mbId) {
    this.mbId = mbId;
  }

  public ExternalLinkType getExtLinkTypeId() {
    return extLinkTypeId;
  }

  public void setExtLinkTypeId(ExternalLinkType extLinkTypeId) {
    this.extLinkTypeId = extLinkTypeId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (linkId != null ? linkId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ExternalLinkObject)) {
      return false;
    }
    ExternalLinkObject other = (ExternalLinkObject) object;
    return !((this.linkId == null && other.linkId != null) || (this.linkId != null && !this.linkId.equals(other.linkId)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.ExternalLinkObject[ linkId=" + linkId + " ]";
  }
  
}
