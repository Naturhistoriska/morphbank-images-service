package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "Spam")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Spam.findAll", query = "SELECT s FROM Spam s"),
  @NamedQuery(name = "Spam.findById", query = "SELECT s FROM Spam s WHERE s.id = :id"),
  @NamedQuery(name = "Spam.findByCode", query = "SELECT s FROM Spam s WHERE s.code = :code"),
  @NamedQuery(name = "Spam.findByGraphic", query = "SELECT s FROM Spam s WHERE s.graphic = :graphic")})
public class Spam implements Serializable {

  private static final long serialVersionUID = 1L; 
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  
  @Size(max = 255)
  @Column(name = "code")
  private String code;
  
  @Size(max = 255)
  @Column(name = "graphic")
  private String graphic;

  public Spam() {
  }

  public Spam(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getGraphic() {
    return graphic;
  }

  public void setGraphic(String graphic) {
    this.graphic = graphic;
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
    if (!(object instanceof Spam)) {
      return false;
    }
    Spam other = (Spam) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Spam[ id=" + id + " ]";
  }
  
}
