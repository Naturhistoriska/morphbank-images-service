package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "CharacterState")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "CharacterState.findAll", query = "SELECT c FROM CharacterState c"),
  @NamedQuery(name = "CharacterState.findById", query = "SELECT c FROM CharacterState c WHERE c.id = :id"),
  @NamedQuery(name = "CharacterState.findByCharStateValue", query = "SELECT c FROM CharacterState c WHERE c.charStateValue = :charStateValue")})
public class CharacterState implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "charStateValue")
  private String charStateValue;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;

  public CharacterState() {
  }

  public CharacterState(Integer id) {
    this.id = id;
  }

  public CharacterState(Integer id, String charStateValue) {
    this.id = id;
    this.charStateValue = charStateValue;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCharStateValue() {
    return charStateValue;
  }

  public void setCharStateValue(String charStateValue) {
    this.charStateValue = charStateValue;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
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
    if (!(object instanceof CharacterState)) {
      return false;
    }
    CharacterState other = (CharacterState) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.CharacterState[ id=" + id + " ]";
  }
  
}
