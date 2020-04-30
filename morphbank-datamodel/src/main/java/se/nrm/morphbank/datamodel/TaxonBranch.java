package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "TaxonBranch")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TaxonBranch.findAll", query = "SELECT t FROM TaxonBranch t"),
  @NamedQuery(name = "TaxonBranch.findByChild", query = "SELECT t FROM TaxonBranch t WHERE t.child = :child"),
  @NamedQuery(name = "TaxonBranch.findByTsn", query = "SELECT t FROM TaxonBranch t WHERE t.tsn = :tsn"),
  @NamedQuery(name = "TaxonBranch.findByRankId", query = "SELECT t FROM TaxonBranch t WHERE t.rankId = :rankId"),
  @NamedQuery(name = "TaxonBranch.findByKingdomId", query = "SELECT t FROM TaxonBranch t WHERE t.kingdomId = :kingdomId")})
public class TaxonBranch implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "child")
  private long child;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "tsn")
  private long tsn;
  
  @Column(name = "rankId")
  private Short rankId;
  
  @Column(name = "kingdomId")
  private Short kingdomId;

  public TaxonBranch() {
  }

  public long getChild() {
    return child;
  }

  public void setChild(long child) {
    this.child = child;
  }

  public long getTsn() {
    return tsn;
  }

  public void setTsn(long tsn) {
    this.tsn = tsn;
  }

  public Short getRankId() {
    return rankId;
  }

  public void setRankId(Short rankId) {
    this.rankId = rankId;
  }

  public Short getKingdomId() {
    return kingdomId;
  }

  public void setKingdomId(Short kingdomId) {
    this.kingdomId = kingdomId;
  }
  
}
