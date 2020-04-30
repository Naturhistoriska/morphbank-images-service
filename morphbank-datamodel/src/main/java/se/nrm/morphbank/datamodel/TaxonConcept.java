package se.nrm.morphbank.datamodel;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "TaxonConcept")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TaxonConcept.findAll", query = "SELECT t FROM TaxonConcept t"),
  @NamedQuery(name = "TaxonConcept.findById", query = "SELECT t FROM TaxonConcept t WHERE t.id = :id"),
  @NamedQuery(name = "TaxonConcept.findByNameSpace", query = "SELECT t FROM TaxonConcept t WHERE t.nameSpace = :nameSpace"),
  @NamedQuery(name = "TaxonConcept.findByStatus", query = "SELECT t FROM TaxonConcept t WHERE t.status = :status")})
public class TaxonConcept implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Size(max = 255)
  @Column(name = "nameSpace")
  private String nameSpace;
  
  @Size(max = 255)
  @Column(name = "status")
  private String status;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;
  
  @JoinColumn(name = "tsn", referencedColumnName = "tsn")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Tree tsn;

  public TaxonConcept() {
  }

  public TaxonConcept(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNameSpace() {
    return nameSpace;
  }

  public void setNameSpace(String nameSpace) {
    this.nameSpace = nameSpace;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
  }

  public Tree getTsn() {
    return tsn;
  }

  public void setTsn(Tree tsn) {
    this.tsn = tsn;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TaxonConcept)) {
      return false;
    }
    TaxonConcept other = (TaxonConcept) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.TaxonConcept[ id=" + id + " ]";
  }
  
}
