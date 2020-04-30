package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "View")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "View.findAll", query = "SELECT v FROM View v"),
  @NamedQuery(name = "View.findById", query = "SELECT v FROM View v WHERE v.id = :id"),
  @NamedQuery(name = "View.findByImagesCount", query = "SELECT v FROM View v WHERE v.imagesCount = :imagesCount")})
public class View implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "viewName")
  private String viewName;
  
  @Size(max = 255)
  @Column(name = "imagingTechnique")
  private String imagingTechnique;
  
  @Size(max = 255)
  @Column(name = "imagingPreparationTechnique")
  private String imagingPreparationTechnique;
  
  @Size(max = 255)
  @Column(name = "specimenPart")
  private String specimenPart;
  
  @Size(max = 255)
  @Column(name = "viewAngle")
  private String viewAngle;
  
  @Size(max = 255)
  @Column(name = "developmentalStage")
  private String developmentalStage;
  
  @Size(max = 255)
  @Column(name = "sex")
  private String sex;
  
  @Size(max = 255)
  @Column(name = "form")
  private String form;
  
  @Column(name = "isStandardView")
  private Integer isStandardView;
  
  @Column(name = "imagesCount")
  private Integer imagesCount;
  
  @OneToMany(mappedBy = "viewId", fetch = FetchType.LAZY)
  private Collection<Image> imageCollection;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;
  
  @JoinColumn(name = "viewTSN", referencedColumnName = "tsn")
  @ManyToOne(fetch = FetchType.LAZY)
  private Tree viewTSN;
  
  @JoinColumn(name = "standardImageId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Image standardImageId;

  public View() {
  }

  public View(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getViewName() {
    return viewName;
  }

  public void setViewName(String viewName) {
    this.viewName = viewName;
  }

  public String getImagingTechnique() {
    return imagingTechnique;
  }

  public void setImagingTechnique(String imagingTechnique) {
    this.imagingTechnique = imagingTechnique;
  }

  public String getImagingPreparationTechnique() {
    return imagingPreparationTechnique;
  }

  public void setImagingPreparationTechnique(String imagingPreparationTechnique) {
    this.imagingPreparationTechnique = imagingPreparationTechnique;
  }

  public String getSpecimenPart() {
    return specimenPart;
  }

  public void setSpecimenPart(String specimenPart) {
    this.specimenPart = specimenPart;
  }

  public String getViewAngle() {
    return viewAngle;
  }

  public void setViewAngle(String viewAngle) {
    this.viewAngle = viewAngle;
  }

  public String getDevelopmentalStage() {
    return developmentalStage;
  }

  public void setDevelopmentalStage(String developmentalStage) {
    this.developmentalStage = developmentalStage;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getForm() {
    return form;
  }

  public void setForm(String form) {
    this.form = form;
  }

  public Integer getIsStandardView() {
    return isStandardView;
  }

  public void setIsStandardView(Integer isStandardView) {
    this.isStandardView = isStandardView;
  }

  public Integer getImagesCount() {
    return imagesCount;
  }

  public void setImagesCount(Integer imagesCount) {
    this.imagesCount = imagesCount;
  }

  @XmlTransient
  public Collection<Image> getImageCollection() {
    return imageCollection;
  }

  public void setImageCollection(Collection<Image> imageCollection) {
    this.imageCollection = imageCollection;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
  }

  public Tree getViewTSN() {
    return viewTSN;
  }

  public void setViewTSN(Tree viewTSN) {
    this.viewTSN = viewTSN;
  }

  public Image getStandardImageId() {
    return standardImageId;
  }

  public void setStandardImageId(Image standardImageId) {
    this.standardImageId = standardImageId;
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
    if (!(object instanceof View)) {
      return false;
    }
    View other = (View) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.View[ id=" + id + " ]";
  }
  
}
