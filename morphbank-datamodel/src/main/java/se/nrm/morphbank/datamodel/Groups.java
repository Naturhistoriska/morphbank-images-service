package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "Groups")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
  @NamedQuery(name = "Groups.findById", query = "SELECT g FROM Groups g WHERE g.id = :id"),
  @NamedQuery(name = "Groups.findByGroupName", query = "SELECT g FROM Groups g WHERE g.groupName = :groupName"),
  @NamedQuery(name = "Groups.findByStatus", query = "SELECT g FROM Groups g WHERE g.status = :status"),
  @NamedQuery(name = "Groups.findByDateCreated", query = "SELECT g FROM Groups g WHERE g.dateCreated = :dateCreated")})
public class Groups implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Size(max = 255)
  @Column(name = "groupName")
  private String groupName;
  
  @Column(name = "status")
  private Short status;
  
  @Column(name = "dateCreated")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateCreated;
  
  @OneToMany(mappedBy = "groupId", fetch = FetchType.LAZY)
  private Collection<Image> imageCollection;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "groups1", fetch = FetchType.LAZY)
  private Collection<UserGroup> userGroupCollection;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId", fetch = FetchType.LAZY)
  private Collection<BaseObject> baseObjectCollection;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId", fetch = FetchType.LAZY)
  private Collection<se.nrm.morphbank.datamodel.Collection> collectionCollection;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;
  
  @JoinColumn(name = "tsn", referencedColumnName = "tsn")
  @ManyToOne(fetch = FetchType.LAZY)
  private Tree tsn;
   
  @JoinColumn(name = "groupManagerId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private User groupManagerId;
  
  @OneToMany(mappedBy = "groupId", fetch = FetchType.LAZY)
  private Collection<UserGroupKey> userGroupKeyCollection;

  public Groups() {
  }

  public Groups(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public Short getStatus() {
    return status;
  }

  public void setStatus(Short status) {
    this.status = status;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  @XmlTransient
  public Collection<Image> getImageCollection() {
    return imageCollection;
  }

  public void setImageCollection(Collection<Image> imageCollection) {
    this.imageCollection = imageCollection;
  }

  @XmlTransient
  public Collection<UserGroup> getUserGroupCollection() {
    return userGroupCollection;
  }

  public void setUserGroupCollection(Collection<UserGroup> userGroupCollection) {
    this.userGroupCollection = userGroupCollection;
  }

  @XmlTransient
  public Collection<BaseObject> getBaseObjectCollection() {
    return baseObjectCollection;
  }

  public void setBaseObjectCollection(Collection<BaseObject> baseObjectCollection) {
    this.baseObjectCollection = baseObjectCollection;
  }

  @XmlTransient
  public Collection<se.nrm.morphbank.datamodel.Collection> getCollectionCollection() {
    return collectionCollection;
  }

  public void setCollectionCollection(Collection<se.nrm.morphbank.datamodel.Collection> collectionCollection) {
    this.collectionCollection = collectionCollection;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
  }

  public Tree getTsn() {
    return tsn;
  }

  public void setTsn(Tree tsn) {
    this.tsn = tsn;
  }

  public User getGroupManagerId() {
    return groupManagerId;
  }

  public void setGroupManagerId(User groupManagerId) {
    this.groupManagerId = groupManagerId;
  }

  @XmlTransient
  public Collection<UserGroupKey> getUserGroupKeyCollection() {
    return userGroupKeyCollection;
  }

  public void setUserGroupKeyCollection(Collection<UserGroupKey> userGroupKeyCollection) {
    this.userGroupKeyCollection = userGroupKeyCollection;
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
    if (!(object instanceof Groups)) {
      return false;
    }
    Groups other = (Groups) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Groups[ id=" + id + " ]";
  }
  
}
