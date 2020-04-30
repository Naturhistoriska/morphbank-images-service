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
@Table(name = "User")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
  @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")  })
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Size(max = 255)
  @Column(name = "uin")
  private String uin; 
  
  @Size(max = 255)
  @Column(name = "pin")
  private String pin;
  
  @Size(max = 255)
  @Column(name = "name")
  private String name;
  
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Size(max = 255)
  @Column(name = "email")
  private String email;
  
  @Size(max = 255)
  @Column(name = "affiliation")
  private String affiliation;
  
  @Size(max = 255)
  @Column(name = "address")
  private String address;
  
  @Size(max = 255)
  @Column(name = "last_Name")
  private String lastName;
  
  @Size(max = 255)
  @Column(name = "first_Name")
  private String firstName;
  
  @Size(max = 255)
  @Column(name = "suffix")
  private String suffix;
  
  @Column(name = "middle_init")
  private Character middleInit;
  
  @Size(max = 255)
  @Column(name = "street1")
  private String street1;
  
  @Size(max = 255)
  @Column(name = "street2")
  private String street2;
  
  @Size(max = 255)
  @Column(name = "city")
  private String city;
  
  @Size(max = 255)
  @Column(name = "country")
  private String country;
  
  @Size(max = 2)
  @Column(name = "state")
  private String state;
  
  @Size(max = 255)
  @Column(name = "zipcode")
  private String zipcode;
  
  @Column(name = "status")
  private Short status;
  
  @Column(name = "isContributor")
  private Integer isContributor;
  
  @Column(name = "dateCreated")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateCreated;
  
  @Column(name = "preferredServer")
  private Integer preferredServer;
  
  @Column(name = "preferredGroup")
  private Integer preferredGroup;
  
  @Size(max = 255)
  @Column(name = "userLogo")
  private String userLogo;
  
  @Size(max = 255)
  @Column(name = "logoURL")
  private String logoURL;
  
  @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
  private Collection<Image> imageCollection;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1", fetch = FetchType.LAZY)
  private Collection<UserGroup> userGroupCollection;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
  private Collection<UserGroup> userGroupCollection1;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
  private Collection<BaseObject> baseObjectCollection;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "submittedBy", fetch = FetchType.LAZY)
  private Collection<BaseObject> baseObjectCollection1;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
  private Collection<se.nrm.morphbank.datamodel.Collection> collectionCollection;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject; 
  
  @JoinColumn(name = "privilegeTSN", referencedColumnName = "tsn")
  @ManyToOne(fetch = FetchType.LAZY)
  private Tree privilegeTSN;
  
  @JoinColumn(name = "primaryTSN", referencedColumnName = "tsn")
  @ManyToOne(fetch = FetchType.LAZY)
  private Tree primaryTSN;
  
  @JoinColumn(name = "secondaryTSN", referencedColumnName = "tsn")
  @ManyToOne(fetch = FetchType.LAZY)
  private Tree secondaryTSN;
  
  @OneToMany(mappedBy = "groupManagerId", fetch = FetchType.LAZY)
  private Collection<Groups> groupsCollection;
  
  @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
  private Collection<UserGroupKey> userGroupKeyCollection;

  public User() {
  }

  public User(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUin() {
    return uin;
  }

  public void setUin(String uin) {
    this.uin = uin;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAffiliation() {
    return affiliation;
  }

  public void setAffiliation(String affiliation) {
    this.affiliation = affiliation;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public Character getMiddleInit() {
    return middleInit;
  }

  public void setMiddleInit(Character middleInit) {
    this.middleInit = middleInit;
  }

  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public Short getStatus() {
    return status;
  }

  public void setStatus(Short status) {
    this.status = status;
  }

  public Integer getIsContributor() {
    return isContributor;
  }

  public void setIsContributor(Integer isContributor) {
    this.isContributor = isContributor;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Integer getPreferredServer() {
    return preferredServer;
  }

  public void setPreferredServer(Integer preferredServer) {
    this.preferredServer = preferredServer;
  }

  public Integer getPreferredGroup() {
    return preferredGroup;
  }

  public void setPreferredGroup(Integer preferredGroup) {
    this.preferredGroup = preferredGroup;
  }

  public String getUserLogo() {
    return userLogo;
  }

  public void setUserLogo(String userLogo) {
    this.userLogo = userLogo;
  }

  public String getLogoURL() {
    return logoURL;
  }

  public void setLogoURL(String logoURL) {
    this.logoURL = logoURL;
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
  public Collection<UserGroup> getUserGroupCollection1() {
    return userGroupCollection1;
  }

  public void setUserGroupCollection1(Collection<UserGroup> userGroupCollection1) {
    this.userGroupCollection1 = userGroupCollection1;
  }

  @XmlTransient
  public Collection<BaseObject> getBaseObjectCollection() {
    return baseObjectCollection;
  }

  public void setBaseObjectCollection(Collection<BaseObject> baseObjectCollection) {
    this.baseObjectCollection = baseObjectCollection;
  }

  @XmlTransient
  public Collection<BaseObject> getBaseObjectCollection1() {
    return baseObjectCollection1;
  }

  public void setBaseObjectCollection1(Collection<BaseObject> baseObjectCollection1) {
    this.baseObjectCollection1 = baseObjectCollection1;
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

  public Tree getPrivilegeTSN() {
    return privilegeTSN;
  }

  public void setPrivilegeTSN(Tree privilegeTSN) {
    this.privilegeTSN = privilegeTSN;
  }

  public Tree getPrimaryTSN() {
    return primaryTSN;
  }

  public void setPrimaryTSN(Tree primaryTSN) {
    this.primaryTSN = primaryTSN;
  }

  public Tree getSecondaryTSN() {
    return secondaryTSN;
  }

  public void setSecondaryTSN(Tree secondaryTSN) {
    this.secondaryTSN = secondaryTSN;
  }

  @XmlTransient
  public Collection<Groups> getGroupsCollection() {
    return groupsCollection;
  }

  public void setGroupsCollection(Collection<Groups> groupsCollection) {
    this.groupsCollection = groupsCollection;
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
    if (!(object instanceof User)) {
      return false;
    }
    User other = (User) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.User[ id=" + id + " ]";
  }
  
}
