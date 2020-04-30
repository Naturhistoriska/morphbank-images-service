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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "UserGroupKey")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "UserGroupKey.findAll", query = "SELECT u FROM UserGroupKey u"),
  @NamedQuery(name = "UserGroupKey.findByKeyString", query = "SELECT u FROM UserGroupKey u WHERE u.keyString = :keyString")})
public class UserGroupKey implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "keyString")
  private String keyString;
  
  @JoinColumn(name = "userId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private User userId;
  
  @JoinColumn(name = "groupId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Groups groupId;

  public UserGroupKey() {
  }

  public UserGroupKey(String keyString) {
    this.keyString = keyString;
  }

  public String getKeyString() {
    return keyString;
  }

  public void setKeyString(String keyString) {
    this.keyString = keyString;
  }

  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
  }

  public Groups getGroupId() {
    return groupId;
  }

  public void setGroupId(Groups groupId) {
    this.groupId = groupId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (keyString != null ? keyString.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UserGroupKey)) {
      return false;
    }
    UserGroupKey other = (UserGroupKey) object;
    return !((this.keyString == null && other.keyString != null) || (this.keyString != null && !this.keyString.equals(other.keyString)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.UserGroupKey[ keyString=" + keyString + " ]";
  }
  
}
