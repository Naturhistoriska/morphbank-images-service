package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "MbCharacter")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "MbCharacter.findAll", query = "SELECT m FROM MbCharacter m"),
  @NamedQuery(name = "MbCharacter.findById", query = "SELECT m FROM MbCharacter m WHERE m.id = :id"),
  @NamedQuery(name = "MbCharacter.findByLabel", query = "SELECT m FROM MbCharacter m WHERE m.label = :label"),
  @NamedQuery(name = "MbCharacter.findByCharacterNumber", query = "SELECT m FROM MbCharacter m WHERE m.characterNumber = :characterNumber"),
  @NamedQuery(name = "MbCharacter.findByDiscrete", query = "SELECT m FROM MbCharacter m WHERE m.discrete = :discrete"),
  @NamedQuery(name = "MbCharacter.findByOrdered", query = "SELECT m FROM MbCharacter m WHERE m.ordered = :ordered")})
public class MbCharacter implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Size(max = 8)
  @Column(name = "label")
  private String label; 
  
  @Size(max = 255)
  @Column(name = "characterNumber")
  private String characterNumber;
  
  @Column(name = "discrete")
  private Short discrete;
  
  @Column(name = "ordered")
  private Short ordered; 
  
  @Lob
  @Size(max = 65535)
  @Column(name = "pubComment")
  private String pubComment;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;
  
  @JoinColumn(name = "publicationId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Publication publicationId;

  public MbCharacter() {
  }

  public MbCharacter(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getCharacterNumber() {
    return characterNumber;
  }

  public void setCharacterNumber(String characterNumber) {
    this.characterNumber = characterNumber;
  }

  public Short getDiscrete() {
    return discrete;
  }

  public void setDiscrete(Short discrete) {
    this.discrete = discrete;
  }

  public Short getOrdered() {
    return ordered;
  }

  public void setOrdered(Short ordered) {
    this.ordered = ordered;
  }

  public String getPubComment() {
    return pubComment;
  }

  public void setPubComment(String pubComment) {
    this.pubComment = pubComment;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
  }

  public Publication getPublicationId() {
    return publicationId;
  }

  public void setPublicationId(Publication publicationId) {
    this.publicationId = publicationId;
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
    if (!(object instanceof MbCharacter)) {
      return false;
    }
    MbCharacter other = (MbCharacter) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.MbCharacter[ id=" + id + " ]";
  }
  
}
