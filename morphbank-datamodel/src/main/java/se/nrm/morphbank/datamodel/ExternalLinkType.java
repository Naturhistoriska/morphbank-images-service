package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ExternalLinkType")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ExternalLinkType.findAll", query = "SELECT e FROM ExternalLinkType e"),
  @NamedQuery(name = "ExternalLinkType.findByLinkTypeId", query = "SELECT e FROM ExternalLinkType e WHERE e.linkTypeId = :linkTypeId"),
  @NamedQuery(name = "ExternalLinkType.findByName", query = "SELECT e FROM ExternalLinkType e WHERE e.name = :name"),
  @NamedQuery(name = "ExternalLinkType.findByDescription", query = "SELECT e FROM ExternalLinkType e WHERE e.description = :description")})
public class ExternalLinkType implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "linkTypeId")
  private Integer linkTypeId;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  
  @Size(max = 255)
  @Column(name = "description")
  private String description;
  
  @OneToMany(mappedBy = "extLinkTypeId", fetch = FetchType.LAZY)
  private Collection<ExternalLinkObject> externalLinkObjectCollection;

  public ExternalLinkType() {
  }

  public ExternalLinkType(Integer linkTypeId) {
    this.linkTypeId = linkTypeId;
  }

  public ExternalLinkType(Integer linkTypeId, String name) {
    this.linkTypeId = linkTypeId;
    this.name = name;
  }

  public Integer getLinkTypeId() {
    return linkTypeId;
  }

  public void setLinkTypeId(Integer linkTypeId) {
    this.linkTypeId = linkTypeId;
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

  @XmlTransient
  public Collection<ExternalLinkObject> getExternalLinkObjectCollection() {
    return externalLinkObjectCollection;
  }

  public void setExternalLinkObjectCollection(Collection<ExternalLinkObject> externalLinkObjectCollection) {
    this.externalLinkObjectCollection = externalLinkObjectCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (linkTypeId != null ? linkTypeId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ExternalLinkType)) {
      return false;
    }
    ExternalLinkType other = (ExternalLinkType) object;
    return !((this.linkTypeId == null && other.linkTypeId != null) || (this.linkTypeId != null && !this.linkTypeId.equals(other.linkTypeId)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.ExternalLinkType[ linkTypeId=" + linkTypeId + " ]";
  }
  
}
