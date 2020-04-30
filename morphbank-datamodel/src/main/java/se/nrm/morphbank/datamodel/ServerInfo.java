package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ServerInfo")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ServerInfo.findAll", query = "SELECT s FROM ServerInfo s"),
  @NamedQuery(name = "ServerInfo.findByServerId", query = "SELECT s FROM ServerInfo s WHERE s.serverId = :serverId"),
  @NamedQuery(name = "ServerInfo.findByUrl", query = "SELECT s FROM ServerInfo s WHERE s.url = :url"),
  @NamedQuery(name = "ServerInfo.findByLocality", query = "SELECT s FROM ServerInfo s WHERE s.locality = :locality")})
public class ServerInfo implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "serverId")
  private Integer serverId;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "url")
  private String url;
  
  @Size(max = 255)
  @Column(name = "logo")
  private String logo;
  
  @Size(max = 255)
  @Column(name = "contact")
  private String contact;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "admin")
  private int admin;
   
  @Basic(optional = false)
  @NotNull
  @Column(name = "mirrorGroup")
  private int mirrorGroup;
   
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateCreated")
  @Temporal(TemporalType.DATE)
  private Date dateCreated;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "updatedDate")
  @Temporal(TemporalType.DATE)
  private Date updatedDate;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "basePath")
  private String basePath;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "login")
  private String login;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "passwd")
  private String passwd;
   
  @Basic(optional = false)
  @NotNull
  @Column(name = "port")
  private int port;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "imageURL")
  private String imageURL;
  
  @Size(max = 255)
  @Column(name = "locality")
  private String locality;
  
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 65535)
  @Column(name = "tsns")
  private String tsns;

  public ServerInfo() {
  }

  public ServerInfo(Integer serverId) {
    this.serverId = serverId;
  }

  public ServerInfo(Integer serverId, String url, int admin, int mirrorGroup, Date dateCreated, Date updatedDate, String basePath, String login, String passwd, int port, String imageURL, String tsns) {
    this.serverId = serverId;
    this.url = url;
    this.admin = admin;
    this.mirrorGroup = mirrorGroup;
    this.dateCreated = dateCreated;
    this.updatedDate = updatedDate;
    this.basePath = basePath;
    this.login = login;
    this.passwd = passwd;
    this.port = port;
    this.imageURL = imageURL;
    this.tsns = tsns;
  }

  public Integer getServerId() {
    return serverId;
  }

  public void setServerId(Integer serverId) {
    this.serverId = serverId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public int getAdmin() {
    return admin;
  }

  public void setAdmin(int admin) {
    this.admin = admin;
  }

  public int getMirrorGroup() {
    return mirrorGroup;
  }

  public void setMirrorGroup(int mirrorGroup) {
    this.mirrorGroup = mirrorGroup;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  public String getBasePath() {
    return basePath;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public String getTsns() {
    return tsns;
  }

  public void setTsns(String tsns) {
    this.tsns = tsns;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (serverId != null ? serverId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ServerInfo)) {
      return false;
    }
    ServerInfo other = (ServerInfo) object;
    return !((this.serverId == null && other.serverId != null) || (this.serverId != null && !this.serverId.equals(other.serverId)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.ServerInfo[ serverId=" + serverId + " ]";
  }
  
}
