package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "Kingdoms")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Kingdoms.findAll", query = "SELECT k FROM Kingdoms k"),
  @NamedQuery(name = "Kingdoms.findByKingdomId", query = "SELECT k FROM Kingdoms k WHERE k.kingdomId = :kingdomId"),
  @NamedQuery(name = "Kingdoms.findByKingdomName", query = "SELECT k FROM Kingdoms k WHERE k.kingdomName = :kingdomName"),
  @NamedQuery(name = "Kingdoms.findByUpdateDate", query = "SELECT k FROM Kingdoms k WHERE k.updateDate = :updateDate")})
public class Kingdoms implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "kingdom_id")
  private Integer kingdomId;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "kingdom_name")
  private String kingdomName;
  
  @Column(name = "update_date")
  @Temporal(TemporalType.DATE)
  private Date updateDate;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "kingdoms", fetch = FetchType.LAZY)
  private Collection<TaxonUnitTypes> taxonUnitTypesCollection;
  
  @OneToMany(mappedBy = "kingdomId", fetch = FetchType.LAZY)
  private Collection<DeterminationAnnotation> determinationAnnotationCollection;

  public Kingdoms() {
  }

  public Kingdoms(Integer kingdomId) {
    this.kingdomId = kingdomId;
  }

  public Kingdoms(Integer kingdomId, String kingdomName) {
    this.kingdomId = kingdomId;
    this.kingdomName = kingdomName;
  }

  public Integer getKingdomId() {
    return kingdomId;
  }

  public void setKingdomId(Integer kingdomId) {
    this.kingdomId = kingdomId;
  }

  public String getKingdomName() {
    return kingdomName;
  }

  public void setKingdomName(String kingdomName) {
    this.kingdomName = kingdomName;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  @XmlTransient
  public Collection<TaxonUnitTypes> getTaxonUnitTypesCollection() {
    return taxonUnitTypesCollection;
  }

  public void setTaxonUnitTypesCollection(Collection<TaxonUnitTypes> taxonUnitTypesCollection) {
    this.taxonUnitTypesCollection = taxonUnitTypesCollection;
  }

  @XmlTransient
  public Collection<DeterminationAnnotation> getDeterminationAnnotationCollection() {
    return determinationAnnotationCollection;
  }

  public void setDeterminationAnnotationCollection(Collection<DeterminationAnnotation> determinationAnnotationCollection) {
    this.determinationAnnotationCollection = determinationAnnotationCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (kingdomId != null ? kingdomId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Kingdoms)) {
      return false;
    }
    Kingdoms other = (Kingdoms) object;
    return !((this.kingdomId == null && other.kingdomId != null) || (this.kingdomId != null && !this.kingdomId.equals(other.kingdomId)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Kingdoms[ kingdomId=" + kingdomId + " ]";
  }
  
}
