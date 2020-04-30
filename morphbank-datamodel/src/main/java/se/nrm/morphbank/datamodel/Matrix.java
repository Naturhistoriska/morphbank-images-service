package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "Matrix")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Matrix.findAll", query = "SELECT m FROM Matrix m"),
  @NamedQuery(name = "Matrix.findById", query = "SELECT m FROM Matrix m WHERE m.id = :id"),
  @NamedQuery(name = "Matrix.findByNumRows", query = "SELECT m FROM Matrix m WHERE m.numRows = :numRows"),
  @NamedQuery(name = "Matrix.findByNumChars", query = "SELECT m FROM Matrix m WHERE m.numChars = :numChars"),
  @NamedQuery(name = "Matrix.findByGap", query = "SELECT m FROM Matrix m WHERE m.gap = :gap"),
  @NamedQuery(name = "Matrix.findByMissing", query = "SELECT m FROM Matrix m WHERE m.missing = :missing")})
public class Matrix implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Column(name = "numRows")
  private Integer numRows;
  
  @Column(name = "numChars")
  private Integer numChars;
  
  @Size(max = 5)
  @Column(name = "gap")
  private String gap;
  
  @Size(max = 5)
  @Column(name = "missing")
  private String missing;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;
  
  @OneToMany(mappedBy = "matrixId", fetch = FetchType.LAZY)
  private Collection<MatrixCell> matrixCellCollection;
  
  @OneToMany(mappedBy = "matrixId", fetch = FetchType.LAZY)
  private Collection<MatrixCellValue> matrixCellValueCollection;

  public Matrix() {
  }

  public Matrix(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getNumRows() {
    return numRows;
  }

  public void setNumRows(Integer numRows) {
    this.numRows = numRows;
  }

  public Integer getNumChars() {
    return numChars;
  }

  public void setNumChars(Integer numChars) {
    this.numChars = numChars;
  }

  public String getGap() {
    return gap;
  }

  public void setGap(String gap) {
    this.gap = gap;
  }

  public String getMissing() {
    return missing;
  }

  public void setMissing(String missing) {
    this.missing = missing;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
  }

  @XmlTransient
  public Collection<MatrixCell> getMatrixCellCollection() {
    return matrixCellCollection;
  }

  public void setMatrixCellCollection(Collection<MatrixCell> matrixCellCollection) {
    this.matrixCellCollection = matrixCellCollection;
  }

  @XmlTransient
  public Collection<MatrixCellValue> getMatrixCellValueCollection() {
    return matrixCellValueCollection;
  }

  public void setMatrixCellValueCollection(Collection<MatrixCellValue> matrixCellValueCollection) {
    this.matrixCellValueCollection = matrixCellValueCollection;
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
    if (!(object instanceof Matrix)) {
      return false;
    }
    Matrix other = (Matrix) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Matrix[ id=" + id + " ]";
  }
  
}
