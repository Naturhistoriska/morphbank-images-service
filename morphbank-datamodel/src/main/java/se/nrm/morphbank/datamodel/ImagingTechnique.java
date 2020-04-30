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
@Table(name = "ImagingTechnique")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ImagingTechnique.findAll", query = "SELECT i FROM ImagingTechnique i"),
  @NamedQuery(name = "ImagingTechnique.findByName", query = "SELECT i FROM ImagingTechnique i WHERE i.name = :name"),
  @NamedQuery(name = "ImagingTechnique.findByDescription", query = "SELECT i FROM ImagingTechnique i WHERE i.description = :description")})
public class ImagingTechnique implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  
  @Size(max = 255)
  @Column(name = "description")
  private String description;

  public ImagingTechnique() {
  }

  public ImagingTechnique(String name) {
    this.name = name;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (name != null ? name.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ImagingTechnique)) {
      return false;
    }
    ImagingTechnique other = (ImagingTechnique) object;
    if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.ImagingTechnique[ name=" + name + " ]";
  }
  
}
