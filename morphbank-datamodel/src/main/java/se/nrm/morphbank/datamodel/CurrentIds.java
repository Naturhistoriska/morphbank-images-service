package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "CurrentIds")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "CurrentIds.findAll", query = "SELECT c FROM CurrentIds c"),
  @NamedQuery(name = "CurrentIds.findByMinId", query = "SELECT c FROM CurrentIds c WHERE c.minId = :minId"),
  @NamedQuery(name = "CurrentIds.findByMaxId", query = "SELECT c FROM CurrentIds c WHERE c.maxId = :maxId"),
  @NamedQuery(name = "CurrentIds.findByType", query = "SELECT c FROM CurrentIds c WHERE c.type = :type")})
public class CurrentIds implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Column(name = "minId")
  private int minId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "maxId")
  private int maxId;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "type")
  private String type;

  public CurrentIds() {
  }

  public CurrentIds(String type) {
    this.type = type;
  }

  public CurrentIds(String type, int minId, int maxId) {
    this.type = type;
    this.minId = minId;
    this.maxId = maxId;
  }

  public int getMinId() {
    return minId;
  }

  public void setMinId(int minId) {
    this.minId = minId;
  }

  public int getMaxId() {
    return maxId;
  }

  public void setMaxId(int maxId) {
    this.maxId = maxId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (type != null ? type.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CurrentIds)) {
      return false;
    }
    CurrentIds other = (CurrentIds) object;
    return !((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.CurrentIds[ type=" + type + " ]";
  }
  
}
