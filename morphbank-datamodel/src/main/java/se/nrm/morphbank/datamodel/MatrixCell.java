package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "MatrixCell")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "MatrixCell.findAll", query = "SELECT m FROM MatrixCell m"),
  @NamedQuery(name = "MatrixCell.findById", query = "SELECT m FROM MatrixCell m WHERE m.id = :id"),
  @NamedQuery(name = "MatrixCell.findByRowNum", query = "SELECT m FROM MatrixCell m WHERE m.rowNum = :rowNum"),
  @NamedQuery(name = "MatrixCell.findByColumnNum", query = "SELECT m FROM MatrixCell m WHERE m.columnNum = :columnNum"),
  @NamedQuery(name = "MatrixCell.findByValue", query = "SELECT m FROM MatrixCell m WHERE m.value = :value")})
public class MatrixCell implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Column(name = "rowNum")
  private Integer rowNum;
  
  @Column(name = "columnNum")
  private Integer columnNum;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "charStateList")
  private String charStateList;
  
  @Size(max = 255)
  @Column(name = "value")
  private String value;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;
  
  @JoinColumn(name = "matrixId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Matrix matrixId;

  public MatrixCell() {
  }

  public MatrixCell(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRowNum() {
    return rowNum;
  }

  public void setRowNum(Integer rowNum) {
    this.rowNum = rowNum;
  }

  public Integer getColumnNum() {
    return columnNum;
  }

  public void setColumnNum(Integer columnNum) {
    this.columnNum = columnNum;
  }

  public String getCharStateList() {
    return charStateList;
  }

  public void setCharStateList(String charStateList) {
    this.charStateList = charStateList;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
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
    if (!(object instanceof MatrixCell)) {
      return false;
    }
    MatrixCell other = (MatrixCell) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.MatrixCell[ id=" + id + " ]";
  }
  
}
