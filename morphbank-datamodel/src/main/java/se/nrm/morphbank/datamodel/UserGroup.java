package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "UserGroup")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "UserGroup.findAll", query = "SELECT u FROM UserGroup u"),
  @NamedQuery(name = "UserGroup.findByUser", query = "SELECT u FROM UserGroup u WHERE u.userGroupPK.user = :user"),
  @NamedQuery(name = "UserGroup.findByUserGroupRole", query = "SELECT u FROM UserGroup u WHERE u.userGroupRole = :userGroupRole")})
public class UserGroup implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @EmbeddedId
  protected UserGroupPK userGroupPK;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateLastModified")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateLastModified;
  
  @Column(name = "dateCreated")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateCreated;
  
  @Column(name = "dateToPublish")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateToPublish;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "userGroupRole")
  private String userGroupRole;
  
  @JoinColumn(name = "user", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private User user1;
  
  @JoinColumn(name = "groups", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Groups groups1;
  
  @JoinColumn(name = "userId", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private User userId;

  public UserGroup() {
  }

  public UserGroup(UserGroupPK userGroupPK) {
    this.userGroupPK = userGroupPK;
  }

  public UserGroup(UserGroupPK userGroupPK, Date dateLastModified, String userGroupRole) {
    this.userGroupPK = userGroupPK;
    this.dateLastModified = dateLastModified;
    this.userGroupRole = userGroupRole;
  }

  public UserGroup(int user, int groups) {
    this.userGroupPK = new UserGroupPK(user, groups);
  }

  public UserGroupPK getUserGroupPK() {
    return userGroupPK;
  }

  public void setUserGroupPK(UserGroupPK userGroupPK) {
    this.userGroupPK = userGroupPK;
  }

  public Date getDateLastModified() {
    return dateLastModified;
  }

  public void setDateLastModified(Date dateLastModified) {
    this.dateLastModified = dateLastModified;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getDateToPublish() {
    return dateToPublish;
  }

  public void setDateToPublish(Date dateToPublish) {
    this.dateToPublish = dateToPublish;
  }

  public String getUserGroupRole() {
    return userGroupRole;
  }

  public void setUserGroupRole(String userGroupRole) {
    this.userGroupRole = userGroupRole;
  }

  public User getUser1() {
    return user1;
  }

  public void setUser1(User user1) {
    this.user1 = user1;
  }

  public Groups getGroups1() {
    return groups1;
  }

  public void setGroups1(Groups groups1) {
    this.groups1 = groups1;
  }

  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (userGroupPK != null ? userGroupPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UserGroup)) {
      return false;
    }
    UserGroup other = (UserGroup) object;
    return !((this.userGroupPK == null && other.userGroupPK != null) || (this.userGroupPK != null && !this.userGroupPK.equals(other.userGroupPK)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.UserGroup[ userGroupPK=" + userGroupPK + " ]";
  }
  
}
