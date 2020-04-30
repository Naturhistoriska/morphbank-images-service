package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "BasisOfRecord")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "BasisOfRecord.findAll", query = "SELECT b FROM BasisOfRecord b"),
  @NamedQuery(name = "BasisOfRecord.findByDescription", query = "SELECT b FROM BasisOfRecord b WHERE b.description = :description"),
  @NamedQuery(name = "BasisOfRecord.findByName", query = "SELECT b FROM BasisOfRecord b WHERE b.name = :name")})
public class BasisOfRecord implements Serializable {

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
  
  @OneToMany(mappedBy = "basisOfRecordId", fetch = FetchType.LAZY)
  private Collection<Specimen> specimenCollection;

  public BasisOfRecord() {
  }

  public BasisOfRecord(String name) {
    this.name = name;
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

  @XmlTransient
  public Collection<Specimen> getSpecimenCollection() {
    return specimenCollection;
  }

  public void setSpecimenCollection(Collection<Specimen> specimenCollection) {
    this.specimenCollection = specimenCollection;
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
    if (!(object instanceof BasisOfRecord)) {
      return false;
    }
    BasisOfRecord other = (BasisOfRecord) object;
    return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.BasisOfRecord[ name=" + name + " ]";
  }
  
}
