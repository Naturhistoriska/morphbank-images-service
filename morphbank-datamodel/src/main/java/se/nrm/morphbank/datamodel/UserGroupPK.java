package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author idali
 */
@Embeddable
public class UserGroupPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "user")
  private int user;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "groups")
  private int groups;

  public UserGroupPK() {
  }

  public UserGroupPK(int user, int groups) {
    this.user = user;
    this.groups = groups;
  }

  public int getUser() {
    return user;
  }

  public void setUser(int user) {
    this.user = user;
  }

  public int getGroups() {
    return groups;
  }

  public void setGroups(int groups) {
    this.groups = groups;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) user;
    hash += (int) groups;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UserGroupPK)) {
      return false;
    }
    UserGroupPK other = (UserGroupPK) object;
    if (this.user != other.user) {
      return false;
    }
    if (this.groups != other.groups) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.UserGroupPK[ user=" + user + ", groups=" + groups + " ]";
  }
  
}
