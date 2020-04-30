package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "TaxonomicUnits")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TaxonomicUnits.findAll", query = "SELECT t FROM TaxonomicUnits t"),
  @NamedQuery(name = "TaxonomicUnits.findByTsn", query = "SELECT t FROM TaxonomicUnits t WHERE t.tsn = :tsn"),
  @NamedQuery(name = "TaxonomicUnits.findByUncertainPrntInd", query = "SELECT t FROM TaxonomicUnits t WHERE t.uncertainPrntInd = :uncertainPrntInd")})
public class TaxonomicUnits implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "tsn")
  private Long tsn;
  
  @Column(name = "unit_ind1")
  private Character unitInd1;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "unit_name1")
  private String unitName1;
  
  @Column(name = "unit_ind2")
  private Character unitInd2;
  
  @Size(max = 255)
  @Column(name = "unit_name2")
  private String unitName2;
  
  @Size(max = 255)
  @Column(name = "unit_ind3")
  private String unitInd3;
  
  @Size(max = 255)
  @Column(name = "unit_name3")
  private String unitName3;
  
  @Size(max = 255)
  @Column(name = "unit_ind4")
  private String unitInd4;
  
  @Size(max = 255)
  @Column(name = "unit_name4")
  private String unitName4;
  
  @Column(name = "unnamed_taxon_ind")
  private Character unnamedTaxonInd;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "usage")
  private String usage;
  
  @Size(max = 255)
  @Column(name = "unaccept_reason")
  private String unacceptReason;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "credibility_rtng")
  private String credibilityRtng;
  
  @Size(max = 255)
  @Column(name = "completeness_rtng")
  private String completenessRtng;
  
  @Size(max = 255)
  @Column(name = "currency_rating")
  private String currencyRating;
  
  @Column(name = "phylo_sort_seq")
  private Short phyloSortSeq;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "initial_time_stamp")
  @Temporal(TemporalType.TIMESTAMP)
  private Date initialTimeStamp;
  
  @Column(name = "taxon_author_id")
  private Integer taxonAuthorId;
  
  @Column(name = "hybrid_author_id")
  private Integer hybridAuthorId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "kingdom_id")
  private int kingdomId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "rank_id")
  private short rankId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "update_date")
  @Temporal(TemporalType.DATE)
  private Date updateDate;
  
  @Size(max = 3)
  @Column(name = "uncertain_prnt_ind")
  private String uncertainPrntInd;
  
  @JoinColumn(name = "tsn", referencedColumnName = "tsn", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private Tree tree;
  
  @JoinColumn(name = "parent_tsn", referencedColumnName = "tsn")
  @ManyToOne(fetch = FetchType.LAZY)
  private Tree parentTsn;

  public TaxonomicUnits() {
  }

  public TaxonomicUnits(Long tsn) {
    this.tsn = tsn;
  }

  public TaxonomicUnits(Long tsn, String unitName1, String usage, String credibilityRtng, Date initialTimeStamp, int kingdomId, short rankId, Date updateDate) {
    this.tsn = tsn;
    this.unitName1 = unitName1;
    this.usage = usage;
    this.credibilityRtng = credibilityRtng;
    this.initialTimeStamp = initialTimeStamp;
    this.kingdomId = kingdomId;
    this.rankId = rankId;
    this.updateDate = updateDate;
  }

  public Long getTsn() {
    return tsn;
  }

  public void setTsn(Long tsn) {
    this.tsn = tsn;
  }

  public Character getUnitInd1() {
    return unitInd1;
  }

  public void setUnitInd1(Character unitInd1) {
    this.unitInd1 = unitInd1;
  }

  public String getUnitName1() {
    return unitName1;
  }

  public void setUnitName1(String unitName1) {
    this.unitName1 = unitName1;
  }

  public Character getUnitInd2() {
    return unitInd2;
  }

  public void setUnitInd2(Character unitInd2) {
    this.unitInd2 = unitInd2;
  }

  public String getUnitName2() {
    return unitName2;
  }

  public void setUnitName2(String unitName2) {
    this.unitName2 = unitName2;
  }

  public String getUnitInd3() {
    return unitInd3;
  }

  public void setUnitInd3(String unitInd3) {
    this.unitInd3 = unitInd3;
  }

  public String getUnitName3() {
    return unitName3;
  }

  public void setUnitName3(String unitName3) {
    this.unitName3 = unitName3;
  }

  public String getUnitInd4() {
    return unitInd4;
  }

  public void setUnitInd4(String unitInd4) {
    this.unitInd4 = unitInd4;
  }

  public String getUnitName4() {
    return unitName4;
  }

  public void setUnitName4(String unitName4) {
    this.unitName4 = unitName4;
  }

  public Character getUnnamedTaxonInd() {
    return unnamedTaxonInd;
  }

  public void setUnnamedTaxonInd(Character unnamedTaxonInd) {
    this.unnamedTaxonInd = unnamedTaxonInd;
  }

  public String getUsage() {
    return usage;
  }

  public void setUsage(String usage) {
    this.usage = usage;
  }

  public String getUnacceptReason() {
    return unacceptReason;
  }

  public void setUnacceptReason(String unacceptReason) {
    this.unacceptReason = unacceptReason;
  }

  public String getCredibilityRtng() {
    return credibilityRtng;
  }

  public void setCredibilityRtng(String credibilityRtng) {
    this.credibilityRtng = credibilityRtng;
  }

  public String getCompletenessRtng() {
    return completenessRtng;
  }

  public void setCompletenessRtng(String completenessRtng) {
    this.completenessRtng = completenessRtng;
  }

  public String getCurrencyRating() {
    return currencyRating;
  }

  public void setCurrencyRating(String currencyRating) {
    this.currencyRating = currencyRating;
  }

  public Short getPhyloSortSeq() {
    return phyloSortSeq;
  }

  public void setPhyloSortSeq(Short phyloSortSeq) {
    this.phyloSortSeq = phyloSortSeq;
  }

  public Date getInitialTimeStamp() {
    return initialTimeStamp;
  }

  public void setInitialTimeStamp(Date initialTimeStamp) {
    this.initialTimeStamp = initialTimeStamp;
  }

  public Integer getTaxonAuthorId() {
    return taxonAuthorId;
  }

  public void setTaxonAuthorId(Integer taxonAuthorId) {
    this.taxonAuthorId = taxonAuthorId;
  }

  public Integer getHybridAuthorId() {
    return hybridAuthorId;
  }

  public void setHybridAuthorId(Integer hybridAuthorId) {
    this.hybridAuthorId = hybridAuthorId;
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

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public String getUncertainPrntInd() {
    return uncertainPrntInd;
  }

  public void setUncertainPrntInd(String uncertainPrntInd) {
    this.uncertainPrntInd = uncertainPrntInd;
  }

  public Tree getTree() {
    return tree;
  }

  public void setTree(Tree tree) {
    this.tree = tree;
  }

  public Tree getParentTsn() {
    return parentTsn;
  }

  public void setParentTsn(Tree parentTsn) {
    this.parentTsn = parentTsn;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (tsn != null ? tsn.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TaxonomicUnits)) {
      return false;
    }
    TaxonomicUnits other = (TaxonomicUnits) object;
    return !((this.tsn == null && other.tsn != null) || (this.tsn != null && !this.tsn.equals(other.tsn)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.TaxonomicUnits[ tsn=" + tsn + " ]";
  }
  
}
