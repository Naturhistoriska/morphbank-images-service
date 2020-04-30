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
import javax.persistence.Lob;
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
@Table(name = "UserProperty")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "UserProperty.findAll", query = "SELECT u FROM UserProperty u"),
  @NamedQuery(name = "UserProperty.findById", query = "SELECT u FROM UserProperty u WHERE u.id = :id"),
  @NamedQuery(name = "UserProperty.findByName", query = "SELECT u FROM UserProperty u WHERE u.name = :name"),
  @NamedQuery(name = "UserProperty.findByNamespaceURI", query = "SELECT u FROM UserProperty u WHERE u.namespaceURI = :namespaceURI")})
public class UserProperty implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 65535)
  @Column(name = "value")
  private String value;
  
  @Size(max = 255)
  @Column(name = "namespaceURI")
  private String namespaceURI;
  
  @JoinColumn(name = "objectId", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject objectId;

  public UserProperty() {
  }

  public UserProperty(Integer id) {
    this.id = id;
  }

  public UserProperty(Integer id, String name, String value) {
    this.id = id;
    this.name = name;
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getNamespaceURI() {
    return namespaceURI;
  }

  public void setNamespaceURI(String namespaceURI) {
    this.namespaceURI = namespaceURI;
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
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UserProperty)) {
      return false;
    }
    UserProperty other = (UserProperty) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.UserProperty[ id=" + id + " ]";
  }
  
}
