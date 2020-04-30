package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "MissingImages")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "MissingImages.findAll", query = "SELECT m FROM MissingImages m"),
  @NamedQuery(name = "MissingImages.findById", query = "SELECT m FROM MissingImages m WHERE m.id = :id"),
  @NamedQuery(name = "MissingImages.findByAccessNum", query = "SELECT m FROM MissingImages m WHERE m.accessNum = :accessNum")})
public class MissingImages implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Column(name = "accessNum")
  private Integer accessNum;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "problems")
  private String problems;

  public MissingImages() {
  }

  public MissingImages(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAccessNum() {
    return accessNum;
  }

  public void setAccessNum(Integer accessNum) {
    this.accessNum = accessNum;
  }

  public String getProblems() {
    return problems;
  }

  public void setProblems(String problems) {
    this.problems = problems;
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
    if (!(object instanceof MissingImages)) {
      return false;
    }
    MissingImages other = (MissingImages) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.MissingImages[ id=" + id + " ]";
  }
  
}
