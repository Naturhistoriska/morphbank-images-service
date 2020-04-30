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
@Table(name = "Taxon")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Taxon.findAll", query = "SELECT t FROM Taxon t"),
  @NamedQuery(name = "Taxon.findByTsn", query = "SELECT t FROM Taxon t WHERE t.tsn = :tsn"),
  @NamedQuery(name = "Taxon.findByScientificName", query = "SELECT t FROM Taxon t WHERE t.scientificName = :scientificName"),
  @NamedQuery(name = "Taxon.findByKingdom", query = "SELECT t FROM Taxon t WHERE t.kingdom = :kingdom"),
  @NamedQuery(name = "Taxon.findByRank", query = "SELECT t FROM Taxon t WHERE t.rank = :rank"),
  @NamedQuery(name = "Taxon.findByTaxonAuthorId", query = "SELECT t FROM Taxon t WHERE t.taxonAuthorId = :taxonAuthorId")})
public class Taxon implements Serializable {

  private static final long serialVersionUID = 1L;
  
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
  
  @Column(name = "taxonAuthorId")
  private Integer taxonAuthorId;
   
  public Taxon() {
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

  public Integer getTaxonAuthorId() {
    return taxonAuthorId;
  }

  public void setTaxonAuthorId(Integer taxonAuthorId) {
    this.taxonAuthorId = taxonAuthorId;
  }
  
}
