package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "TaxonBranchNode")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TaxonBranchNode.findAll", query = "SELECT t FROM TaxonBranchNode t"),
  @NamedQuery(name = "TaxonBranchNode.findByChild", query = "SELECT t FROM TaxonBranchNode t WHERE t.child = :child"),
  @NamedQuery(name = "TaxonBranchNode.findByTsn", query = "SELECT t FROM TaxonBranchNode t WHERE t.tsn = :tsn"),
  @NamedQuery(name = "TaxonBranchNode.findByScientificName", query = "SELECT t FROM TaxonBranchNode t WHERE t.scientificName = :scientificName"),
  @NamedQuery(name = "TaxonBranchNode.findByKingdom", query = "SELECT t FROM TaxonBranchNode t WHERE t.kingdom = :kingdom"),
  @NamedQuery(name = "TaxonBranchNode.findByRank", query = "SELECT t FROM TaxonBranchNode t WHERE t.rank = :rank"),
  @NamedQuery(name = "TaxonBranchNode.findByRankId", query = "SELECT t FROM TaxonBranchNode t WHERE t.rankId = :rankId")})
public class TaxonBranchNode implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "child")
  private long child;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "tsn")
  private long tsn;
  
  @Size(max = 255)
  @Column(name = "scientificName")
  private String scientificName;
  
  @Size(max = 10)
  @Column(name = "kingdom")
  private String kingdom;
  
  @Size(max = 15)
  @Column(name = "rank")
  private String rank;
  
  @Column(name = "rankId")
  private Short rankId;

  public TaxonBranchNode() {
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

  public String getScientificName() {
    return scientificName;
  }

  public void setScientificName(String scientificName) {
    this.scientificName = scientificName;
  }

  public String getKingdom() {
    return kingdom;
  }

  public void setKingdom(String kingdom) {
    this.kingdom = kingdom;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public Short getRankId() {
    return rankId;
  }

  public void setRankId(Short rankId) {
    this.rankId = rankId;
  }
  
}
