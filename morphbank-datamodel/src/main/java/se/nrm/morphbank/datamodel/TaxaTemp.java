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
@Table(name = "TaxaTemp")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TaxaTemp.findAll", query = "SELECT t FROM TaxaTemp t"),
  @NamedQuery(name = "TaxaTemp.findByTsn", query = "SELECT t FROM TaxaTemp t WHERE t.tsn = :tsn"),
  @NamedQuery(name = "TaxaTemp.findByKeywords", query = "SELECT t FROM TaxaTemp t WHERE t.keywords = :keywords")})
public class TaxaTemp implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "tsn")
  private Integer tsn;
  
  @Size(max = 4000)
  @Column(name = "keywords")
  private String keywords;

  public TaxaTemp() {
  }

  public TaxaTemp(Integer tsn) {
    this.tsn = tsn;
  }

  public Integer getTsn() {
    return tsn;
  }

  public void setTsn(Integer tsn) {
    this.tsn = tsn;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
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
    if (!(object instanceof TaxaTemp)) {
      return false;
    }
    TaxaTemp other = (TaxaTemp) object;
    return !((this.tsn == null && other.tsn != null) || (this.tsn != null && !this.tsn.equals(other.tsn)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.TaxaTemp[ tsn=" + tsn + " ]";
  }
  
}
