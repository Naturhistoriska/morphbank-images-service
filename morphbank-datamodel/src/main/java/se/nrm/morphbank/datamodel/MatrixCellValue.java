package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MatrixCellValue")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "MatrixCellValue.findAll", query = "SELECT m FROM MatrixCellValue m"),
  @NamedQuery(name = "MatrixCellValue.findById", query = "SELECT m FROM MatrixCellValue m WHERE m.id = :id"),
  @NamedQuery(name = "MatrixCellValue.findByRow", query = "SELECT m FROM MatrixCellValue m WHERE m.row = :row"),
  @NamedQuery(name = "MatrixCellValue.findByCol", query = "SELECT m FROM MatrixCellValue m WHERE m.col = :col"),
  @NamedQuery(name = "MatrixCellValue.findByValue", query = "SELECT m FROM MatrixCellValue m WHERE m.value = :value")})
public class MatrixCellValue implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "row")
  private int row;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "col")
  private int col;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "value")
  private String value;
   
  @JoinColumn(name = "matrixId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Matrix matrixId;

  public MatrixCellValue() {
  }

  public MatrixCellValue(Integer id) {
    this.id = id;
  }

  public MatrixCellValue(Integer id, int row, int col, String value) {
    this.id = id;
    this.row = row;
    this.col = col;
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Matrix getMatrixId() {
    return matrixId;
  }

  public void setMatrixId(Matrix matrixId) {
    this.matrixId = matrixId;
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
    if (!(object instanceof MatrixCellValue)) {
      return false;
    }
    MatrixCellValue other = (MatrixCellValue) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.MatrixCellValue[ id=" + id + " ]";
  }
  
}
