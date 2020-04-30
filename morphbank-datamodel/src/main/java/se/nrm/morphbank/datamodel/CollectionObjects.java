package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CollectionObjects")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "CollectionObjects.findAll", query = "SELECT c FROM CollectionObjects c"),
  @NamedQuery(name = "CollectionObjects.findByIdentifier", query = "SELECT c FROM CollectionObjects c WHERE c.identifier = :identifier"),
  @NamedQuery(name = "CollectionObjects.findByObjectOrder", query = "SELECT c FROM CollectionObjects c WHERE c.objectOrder = :objectOrder"),
  @NamedQuery(name = "CollectionObjects.findByObjectTypeId", query = "SELECT c FROM CollectionObjects c WHERE c.objectTypeId = :objectTypeId"),
  @NamedQuery(name = "CollectionObjects.findByObjectRole", query = "SELECT c FROM CollectionObjects c WHERE c.objectRole = :objectRole"),
  @NamedQuery(name = "CollectionObjects.findByObjectTitle", query = "SELECT c FROM CollectionObjects c WHERE c.objectTitle = :objectTitle"),
  @NamedQuery(name = "CollectionObjects.findByStartSubCollection", query = "SELECT c FROM CollectionObjects c WHERE c.startSubCollection = :startSubCollection"),
  @NamedQuery(name = "CollectionObjects.findByParentId", query = "SELECT c FROM CollectionObjects c WHERE c.parentId = :parentId")})
public class CollectionObjects implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "identifier")
  private Integer identifier;
  
  @Column(name = "objectOrder")
  private Integer objectOrder;
  
  @Size(max = 255)
  @Column(name = "objectTypeId")
  private String objectTypeId;
  
  @Size(max = 255)
  @Column(name = "objectRole")
  private String objectRole;
   
  @Size(max = 255)
  @Column(name = "objectTitle")
  private String objectTitle;
  
  @Column(name = "startSubCollection")
  private Short startSubCollection;
  
  @Size(max = 18)
  @Column(name = "parentId")
  private String parentId;
  
  @JoinColumn(name = "collectionId", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject collectionId;
  
  @JoinColumn(name = "objectId", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject objectId;

  public CollectionObjects() {
  }

  public CollectionObjects(Integer identifier) {
    this.identifier = identifier;
  }

  public Integer getIdentifier() {
    return identifier;
  }

  public void setIdentifier(Integer identifier) {
    this.identifier = identifier;
  }

  public Integer getObjectOrder() {
    return objectOrder;
  }

  public void setObjectOrder(Integer objectOrder) {
    this.objectOrder = objectOrder;
  }

  public String getObjectTypeId() {
    return objectTypeId;
  }

  public void setObjectTypeId(String objectTypeId) {
    this.objectTypeId = objectTypeId;
  }

  public String getObjectRole() {
    return objectRole;
  }

  public void setObjectRole(String objectRole) {
    this.objectRole = objectRole;
  }

  public String getObjectTitle() {
    return objectTitle;
  }

  public void setObjectTitle(String objectTitle) {
    this.objectTitle = objectTitle;
  }

  public Short getStartSubCollection() {
    return startSubCollection;
  }

  public void setStartSubCollection(Short startSubCollection) {
    this.startSubCollection = startSubCollection;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public BaseObject getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(BaseObject collectionId) {
    this.collectionId = collectionId;
  }

  public BaseObject getObjectId() {
    return objectId;
  }

  public void setObjectId(BaseObject objectId) {
    this.objectId = objectId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (identifier != null ? identifier.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CollectionObjects)) {
      return false;
    }
    CollectionObjects other = (CollectionObjects) object;
    return !((this.identifier == null && other.identifier != null) || (this.identifier != null && !this.identifier.equals(other.identifier)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.CollectionObjects[ identifier=" + identifier + " ]";
  }
  
}
