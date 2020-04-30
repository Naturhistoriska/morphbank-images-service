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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "ITISCounter")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ITISCounter.findAll", query = "SELECT i FROM ITISCounter i"),
  @NamedQuery(name = "ITISCounter.findByCounter", query = "SELECT i FROM ITISCounter i WHERE i.counter = :counter")})
public class ITISCounter implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "counter")
  private Integer counter;

  public ITISCounter() {
  }

  public ITISCounter(Integer counter) {
    this.counter = counter;
  }

  public Integer getCounter() {
    return counter;
  }

  public void setCounter(Integer counter) {
    this.counter = counter;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (counter != null ? counter.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ITISCounter)) {
      return false;
    }
    ITISCounter other = (ITISCounter) object;
    return !((this.counter == null && other.counter != null) || (this.counter != null && !this.counter.equals(other.counter)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.ITISCounter[ counter=" + counter + " ]";
  }
  
}
