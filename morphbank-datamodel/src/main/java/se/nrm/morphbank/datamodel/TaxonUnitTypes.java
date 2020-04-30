package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TaxonUnitTypes")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TaxonUnitTypes.findAll", query = "SELECT t FROM TaxonUnitTypes t"),
  @NamedQuery(name = "TaxonUnitTypes.findByUpdateDate", query = "SELECT t FROM TaxonUnitTypes t WHERE t.updateDate = :updateDate")})
public class TaxonUnitTypes implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @EmbeddedId
  protected TaxonUnitTypesPK taxonUnitTypesPK;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 15)
  @Column(name = "rank_name")
  private String rankName;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "dir_parent_rank_id")
  private short dirParentRankId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "req_parent_rank_id")
  private short reqParentRankId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "update_date")
  @Temporal(TemporalType.DATE)
  private Date updateDate;
  
  @JoinColumn(name = "kingdom_id", referencedColumnName = "kingdom_id", insertable = false, updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Kingdoms kingdoms;
  
  @OneToMany(mappedBy = "rankId", fetch = FetchType.LAZY)
  private Collection<DeterminationAnnotation> determinationAnnotationCollection;

  public TaxonUnitTypes() {
  }

  public TaxonUnitTypes(TaxonUnitTypesPK taxonUnitTypesPK) {
    this.taxonUnitTypesPK = taxonUnitTypesPK;
  }

  public TaxonUnitTypes(TaxonUnitTypesPK taxonUnitTypesPK, String rankName, short dirParentRankId, short reqParentRankId, Date updateDate) {
    this.taxonUnitTypesPK = taxonUnitTypesPK;
    this.rankName = rankName;
    this.dirParentRankId = dirParentRankId;
    this.reqParentRankId = reqParentRankId;
    this.updateDate = updateDate;
  }

  public TaxonUnitTypes(int kingdomId, short rankId) {
    this.taxonUnitTypesPK = new TaxonUnitTypesPK(kingdomId, rankId);
  }

  public TaxonUnitTypesPK getTaxonUnitTypesPK() {
    return taxonUnitTypesPK;
  }

  public void setTaxonUnitTypesPK(TaxonUnitTypesPK taxonUnitTypesPK) {
    this.taxonUnitTypesPK = taxonUnitTypesPK;
  }

  public String getRankName() {
    return rankName;
  }

  public void setRankName(String rankName) {
    this.rankName = rankName;
  }

  public short getDirParentRankId() {
    return dirParentRankId;
  }

  public void setDirParentRankId(short dirParentRankId) {
    this.dirParentRankId = dirParentRankId;
  }

  public short getReqParentRankId() {
    return reqParentRankId;
  }

  public void setReqParentRankId(short reqParentRankId) {
    this.reqParentRankId = reqParentRankId;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public Kingdoms getKingdoms() {
    return kingdoms;
  }

  public void setKingdoms(Kingdoms kingdoms) {
    this.kingdoms = kingdoms;
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
    hash += (taxonUnitTypesPK != null ? taxonUnitTypesPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TaxonUnitTypes)) {
      return false;
    }
    TaxonUnitTypes other = (TaxonUnitTypes) object;
    return !((this.taxonUnitTypesPK == null && other.taxonUnitTypesPK != null) || (this.taxonUnitTypesPK != null && !this.taxonUnitTypesPK.equals(other.taxonUnitTypesPK)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.TaxonUnitTypes[ taxonUnitTypesPK=" + taxonUnitTypesPK + " ]";
  }
  
}
