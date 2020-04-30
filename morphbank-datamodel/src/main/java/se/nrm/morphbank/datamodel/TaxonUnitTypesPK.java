package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author idali
 */
@Embeddable
public class TaxonUnitTypesPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "kingdom_id")
  private int kingdomId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "rank_id")
  private short rankId;

  public TaxonUnitTypesPK() {
  }

  public TaxonUnitTypesPK(int kingdomId, short rankId) {
    this.kingdomId = kingdomId;
    this.rankId = rankId;
  }

  public int getKingdomId() {
    return kingdomId;
  }

  public void setKingdomId(int kingdomId) {
    this.kingdomId = kingdomId;
  }

  public short getRankId() {
    return rankId;
  }

  public void setRankId(short rankId) {
    this.rankId = rankId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) kingdomId;
    hash += (int) rankId;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TaxonUnitTypesPK)) {
      return false;
    }
    TaxonUnitTypesPK other = (TaxonUnitTypesPK) object;
    if (this.kingdomId != other.kingdomId) {
      return false;
    }
    return this.rankId == other.rankId;
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.TaxonUnitTypesPK[ kingdomId=" + kingdomId + ", rankId=" + rankId + " ]";
  }
  
}
