package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "DeterminationAnnotation")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "DeterminationAnnotation.findAll", query = "SELECT d FROM DeterminationAnnotation d"),
  @NamedQuery(name = "DeterminationAnnotation.findByAnnotationId", query = "SELECT d FROM DeterminationAnnotation d WHERE d.annotationId = :annotationId"),
  @NamedQuery(name = "DeterminationAnnotation.findByRankName", query = "SELECT d FROM DeterminationAnnotation d WHERE d.rankName = :rankName"),
  @NamedQuery(name = "DeterminationAnnotation.findByTypeDetAnnotation", query = "SELECT d FROM DeterminationAnnotation d WHERE d.typeDetAnnotation = :typeDetAnnotation"),
  @NamedQuery(name = "DeterminationAnnotation.findBySourceOfId", query = "SELECT d FROM DeterminationAnnotation d WHERE d.sourceOfId = :sourceOfId"),
  @NamedQuery(name = "DeterminationAnnotation.findByCollectionId", query = "SELECT d FROM DeterminationAnnotation d WHERE d.collectionId = :collectionId"),
  @NamedQuery(name = "DeterminationAnnotation.findByMaterialsUsedInId", query = "SELECT d FROM DeterminationAnnotation d WHERE d.materialsUsedInId = :materialsUsedInId"),
  @NamedQuery(name = "DeterminationAnnotation.findByPrefix", query = "SELECT d FROM DeterminationAnnotation d WHERE d.prefix = :prefix"),
  @NamedQuery(name = "DeterminationAnnotation.findBySuffix", query = "SELECT d FROM DeterminationAnnotation d WHERE d.suffix = :suffix"),
  @NamedQuery(name = "DeterminationAnnotation.findByResourcesused", query = "SELECT d FROM DeterminationAnnotation d WHERE d.resourcesused = :resourcesused"),
  @NamedQuery(name = "DeterminationAnnotation.findByAltTaxonName", query = "SELECT d FROM DeterminationAnnotation d WHERE d.altTaxonName = :altTaxonName")})
public class DeterminationAnnotation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "annotationId")
  private Integer annotationId;
  
  @Size(max = 140)
  @Column(name = "rankName")
  private String rankName;
  
  @Size(max = 255)
  @Column(name = "typeDetAnnotation")
  private String typeDetAnnotation;
  
  @Size(max = 255)
  @Column(name = "sourceOfId")
  private String sourceOfId;
  
  @Column(name = "collectionId")
  private Integer collectionId;
  
  @Size(max = 255)
  @Column(name = "materialsUsedInId")
  private String materialsUsedInId;
  
  @Size(max = 255)
  @Column(name = "prefix")
  private String prefix;
  
  @Size(max = 255)
  @Column(name = "suffix")
  private String suffix;
  
  @Size(max = 255)
  @Column(name = "resourcesused")
  private String resourcesused;
  
  @Size(max = 255)
  @Column(name = "altTaxonName")
  private String altTaxonName;
  
  @JoinColumn(name = "annotationId", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private Annotation annotation;
  
  @JoinColumn(name = "specimenId", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Specimen specimenId;
  
  @JoinColumn(name = "tsnId", referencedColumnName = "tsn")
  @ManyToOne(fetch = FetchType.LAZY)
  private Tree tsnId;
  
  @JoinColumn(name = "rankId", referencedColumnName = "rank_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private TaxonUnitTypes rankId;
  
  @JoinColumn(name = "kingdomId", referencedColumnName = "kingdom_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Kingdoms kingdomId;

  public DeterminationAnnotation() {
  }

  public DeterminationAnnotation(Integer annotationId) {
    this.annotationId = annotationId;
  }

  public Integer getAnnotationId() {
    return annotationId;
  }

  public void setAnnotationId(Integer annotationId) {
    this.annotationId = annotationId;
  }

  public String getRankName() {
    return rankName;
  }

  public void setRankName(String rankName) {
    this.rankName = rankName;
  }

  public String getTypeDetAnnotation() {
    return typeDetAnnotation;
  }

  public void setTypeDetAnnotation(String typeDetAnnotation) {
    this.typeDetAnnotation = typeDetAnnotation;
  }

  public String getSourceOfId() {
    return sourceOfId;
  }

  public void setSourceOfId(String sourceOfId) {
    this.sourceOfId = sourceOfId;
  }

  public Integer getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(Integer collectionId) {
    this.collectionId = collectionId;
  }

  public String getMaterialsUsedInId() {
    return materialsUsedInId;
  }

  public void setMaterialsUsedInId(String materialsUsedInId) {
    this.materialsUsedInId = materialsUsedInId;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public String getResourcesused() {
    return resourcesused;
  }

  public void setResourcesused(String resourcesused) {
    this.resourcesused = resourcesused;
  }

  public String getAltTaxonName() {
    return altTaxonName;
  }

  public void setAltTaxonName(String altTaxonName) {
    this.altTaxonName = altTaxonName;
  }

  public Annotation getAnnotation() {
    return annotation;
  }

  public void setAnnotation(Annotation annotation) {
    this.annotation = annotation;
  }

  public Specimen getSpecimenId() {
    return specimenId;
  }

  public void setSpecimenId(Specimen specimenId) {
    this.specimenId = specimenId;
  }

  public Tree getTsnId() {
    return tsnId;
  }

  public void setTsnId(Tree tsnId) {
    this.tsnId = tsnId;
  }

  public TaxonUnitTypes getRankId() {
    return rankId;
  }

  public void setRankId(TaxonUnitTypes rankId) {
    this.rankId = rankId;
  }

  public Kingdoms getKingdomId() {
    return kingdomId;
  }

  public void setKingdomId(Kingdoms kingdomId) {
    this.kingdomId = kingdomId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (annotationId != null ? annotationId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DeterminationAnnotation)) {
      return false;
    }
    DeterminationAnnotation other = (DeterminationAnnotation) object;
    return !((this.annotationId == null && other.annotationId != null) || (this.annotationId != null && !this.annotationId.equals(other.annotationId)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.DeterminationAnnotation[ annotationId=" + annotationId + " ]";
  }
  
}
