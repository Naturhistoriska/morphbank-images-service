package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "TaxonAuthors")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TaxonAuthors.findAll", query = "SELECT t FROM TaxonAuthors t"),
  @NamedQuery(name = "TaxonAuthors.findByTaxonAuthorId", query = "SELECT t FROM TaxonAuthors t WHERE t.taxonAuthorId = :taxonAuthorId"),
  @NamedQuery(name = "TaxonAuthors.findByTaxonAuthor", query = "SELECT t FROM TaxonAuthors t WHERE t.taxonAuthor = :taxonAuthor"),
  @NamedQuery(name = "TaxonAuthors.findByUpdateDate", query = "SELECT t FROM TaxonAuthors t WHERE t.updateDate = :updateDate"),
  @NamedQuery(name = "TaxonAuthors.findByKingdomId", query = "SELECT t FROM TaxonAuthors t WHERE t.kingdomId = :kingdomId")})
public class TaxonAuthors implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "taxon_author_id")
  private Integer taxonAuthorId;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "taxon_author")
  private String taxonAuthor;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "update_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateDate;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "kingdom_id")
  private short kingdomId;

  public TaxonAuthors() {
  }

  public TaxonAuthors(Integer taxonAuthorId) {
    this.taxonAuthorId = taxonAuthorId;
  }

  public TaxonAuthors(Integer taxonAuthorId, String taxonAuthor, Date updateDate, short kingdomId) {
    this.taxonAuthorId = taxonAuthorId;
    this.taxonAuthor = taxonAuthor;
    this.updateDate = updateDate;
    this.kingdomId = kingdomId;
  }

  public Integer getTaxonAuthorId() {
    return taxonAuthorId;
  }

  public void setTaxonAuthorId(Integer taxonAuthorId) {
    this.taxonAuthorId = taxonAuthorId;
  }

  public String getTaxonAuthor() {
    return taxonAuthor;
  }

  public void setTaxonAuthor(String taxonAuthor) {
    this.taxonAuthor = taxonAuthor;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public short getKingdomId() {
    return kingdomId;
  }

  public void setKingdomId(short kingdomId) {
    this.kingdomId = kingdomId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (taxonAuthorId != null ? taxonAuthorId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TaxonAuthors)) {
      return false;
    }
    TaxonAuthors other = (TaxonAuthors) object;
    return !((this.taxonAuthorId == null && other.taxonAuthorId != null) || (this.taxonAuthorId != null && !this.taxonAuthorId.equals(other.taxonAuthorId)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.TaxonAuthors[ taxonAuthorId=" + taxonAuthorId + " ]";
  }
  
}
