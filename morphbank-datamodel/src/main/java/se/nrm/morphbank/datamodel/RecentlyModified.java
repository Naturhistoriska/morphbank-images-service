package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "RecentlyModified")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "RecentlyModified.findAll", query = "SELECT r FROM RecentlyModified r"),
  @NamedQuery(name = "RecentlyModified.findById", query = "SELECT r FROM RecentlyModified r WHERE r.id = :id"),
  @NamedQuery(name = "RecentlyModified.findByDateLastModified", query = "SELECT r FROM RecentlyModified r WHERE r.dateLastModified = :dateLastModified"),
  @NamedQuery(name = "RecentlyModified.findByObjectTypeId", query = "SELECT r FROM RecentlyModified r WHERE r.objectTypeId = :objectTypeId")})
public class RecentlyModified implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Column(name = "dateLastModified")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateLastModified;
  
  @Size(max = 255)
  @Column(name = "objectTypeId")
  private String objectTypeId;

  public RecentlyModified() {
  }

  public RecentlyModified(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDateLastModified() {
    return dateLastModified;
  }

  public void setDateLastModified(Date dateLastModified) {
    this.dateLastModified = dateLastModified;
  }

  public String getObjectTypeId() {
    return objectTypeId;
  }

  public void setObjectTypeId(String objectTypeId) {
    this.objectTypeId = objectTypeId;
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
    if (!(object instanceof RecentlyModified)) {
      return false;
    }
    RecentlyModified other = (RecentlyModified) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.RecentlyModified[ id=" + id + " ]";
  }
  
}
