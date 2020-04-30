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
@Table(name = "ContinentOcean")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ContinentOcean.findAll", query = "SELECT c FROM ContinentOcean c"),
  @NamedQuery(name = "ContinentOcean.findByDescription", query = "SELECT c FROM ContinentOcean c WHERE c.description = :description"),
  @NamedQuery(name = "ContinentOcean.findByName", query = "SELECT c FROM ContinentOcean c WHERE c.name = :name"),
  @NamedQuery(name = "ContinentOcean.findByPgorder", query = "SELECT c FROM ContinentOcean c WHERE c.pgorder = :pgorder")})
public class ContinentOcean implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Size(max = 255)
  @Column(name = "description")
  private String description;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "name")
  private String name;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "pgorder")
  private short pgorder;

  public ContinentOcean() {
  }

  public ContinentOcean(String name) {
    this.name = name;
  }

  public ContinentOcean(String name, short pgorder) {
    this.name = name;
    this.pgorder = pgorder;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public short getPgorder() {
    return pgorder;
  }

  public void setPgorder(short pgorder) {
    this.pgorder = pgorder;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (name != null ? name.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ContinentOcean)) {
      return false;
    }
    ContinentOcean other = (ContinentOcean) object;
    return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.ContinentOcean[ name=" + name + " ]";
  }
  
}
