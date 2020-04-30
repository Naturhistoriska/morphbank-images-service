package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "KeywordsTemp")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "KeywordsTemp.findAll", query = "SELECT k FROM KeywordsTemp k"),
  @NamedQuery(name = "KeywordsTemp.findById", query = "SELECT k FROM KeywordsTemp k WHERE k.id = :id")})
public class KeywordsTemp implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "keywords")
  private String keywords;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "xmlKeywords")
  private String xmlKeywords;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "imageAltText")
  private String imageAltText;

  public KeywordsTemp() {
  }

  public KeywordsTemp(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public String getXmlKeywords() {
    return xmlKeywords;
  }

  public void setXmlKeywords(String xmlKeywords) {
    this.xmlKeywords = xmlKeywords;
  }

  public String getImageAltText() {
    return imageAltText;
  }

  public void setImageAltText(String imageAltText) {
    this.imageAltText = imageAltText;
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
    if (!(object instanceof KeywordsTemp)) {
      return false;
    }
    KeywordsTemp other = (KeywordsTemp) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.KeywordsTemp[ id=" + id + " ]";
  }
  
}
