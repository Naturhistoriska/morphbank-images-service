package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Tree")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Tree.findAll", query = "SELECT t FROM Tree t"),
  @NamedQuery(name = "Tree.findByTsn", query = "SELECT t FROM Tree t WHERE t.tsn = :tsn"),
  @NamedQuery(name = "Tree.findByPublicationId", query = "SELECT t FROM Tree t WHERE t.publicationId = :publicationId")})
public class Tree implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "tsn")
  private Long tsn;
  
  @Column(name = "unit_ind1")
  private Character unitInd1;
  
  @Size(max = 255)
  @Column(name = "unit_name1")
  private String unitName1;
  
  @Column(name = "unit_ind2")
  private Character unitInd2;
  
  @Size(max = 255)
  @Column(name = "unit_name2")
  private String unitName2;
  
  @Size(max = 255)
  @Column(name = "unit_ind3")
  private String unitInd3;
  
  @Size(max = 255)
  @Column(name = "unit_name3")
  private String unitName3;
  
  @Size(max = 255)
  @Column(name = "unit_ind4")
  private String unitInd4;
  
  @Size(max = 255)
  @Column(name = "unit_name4")
  private String unitName4;
  
  @Size(max = 255)
  @Column(name = "scientificName")
  private String scientificName;
  
  @Column(name = "taxon_author_id")
  private Integer taxonAuthorId;
  
  @Column(name = "letter")
  private Character letter;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "usage")
  private String usage;
  
  @Size(max = 255)
  @Column(name = "unaccept_reason")
  private String unacceptReason;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "credibility_rtng")
  private String credibilityRtng;
  
  @Size(max = 255)
  @Column(name = "completeness_rtng")
  private String completenessRtng;
  
  @Size(max = 255)
  @Column(name = "currency_rating")
  private String currencyRating;
  
  @Column(name = "kingdom_id")
  private Short kingdomId;
  
  @Column(name = "rank_id")
  private Short rankId;
  
  @Column(name = "lft")
  private Integer lft;
 
  @Column(name = "rgt")
  private Integer rgt;
  
  @Column(name = "imagesCount")
  private BigInteger imagesCount;
  
  @Column(name = "myImagesCount")
  private BigInteger myImagesCount;
  
  @Size(max = 255)
  @Column(name = "nameType")
  private String nameType;
  
  
  @Size(max = 255)
  @Column(name = "nameSource")
  private String nameSource;
 
  @Lob
  @Size(max = 65535)
  @Column(name = "comments")
  private String comments;
  
  @Size(max = 255)
  @Column(name = "tradeDesignationName")
  private String tradeDesignationName;
   
  @Size(max = 255)
  @Column(name = "pages")
  private String pages;
  
  @Column(name = "publicationId")
  private Integer publicationId;
  
  @OneToMany(mappedBy = "tsnId", fetch = FetchType.LAZY)
  private Collection<Specimen> specimenCollection;
  
  @OneToMany(mappedBy = "parentTsn", fetch = FetchType.LAZY)
  private Collection<Tree> treeCollection;
  
  @JoinColumn(name = "parent_tsn", referencedColumnName = "tsn")
  @ManyToOne(fetch = FetchType.LAZY)
  private Tree parentTsn;
  
  @OneToMany(mappedBy = "privilegeTSN, fetch = FetchType.LAZY")
  private Collection<User> userCollection;
  
  @OneToMany(mappedBy = "primaryTSN", fetch = FetchType.LAZY)
  private Collection<User> userCollection1;
  
  @OneToMany(mappedBy = "secondaryTSN", fetch = FetchType.LAZY)
  private Collection<User> userCollection2;
  
  @OneToMany(mappedBy = "tsn", fetch = FetchType.LAZY)
  private Collection<Groups> groupsCollection;
  
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "tree", fetch = FetchType.LAZY)
  private TaxonomicUnits taxonomicUnits;
  
  @OneToMany(mappedBy = "parentTsn", fetch = FetchType.LAZY)
  private Collection<TaxonomicUnits> taxonomicUnitsCollection;
  
  @OneToMany(mappedBy = "tsnId", fetch = FetchType.LAZY)
  private Collection<DeterminationAnnotation> determinationAnnotationCollection;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "tsn", fetch = FetchType.LAZY)
  private Collection<TaxonConcept> taxonConceptCollection;
  
  @OneToMany(mappedBy = "viewTSN", fetch = FetchType.LAZY)
  private Collection<View> viewCollection;

  public Tree() {
  }

  public Tree(Long tsn) {
    this.tsn = tsn;
  }

  public Tree(Long tsn, String usage, String credibilityRtng) {
    this.tsn = tsn;
    this.usage = usage;
    this.credibilityRtng = credibilityRtng;
  }

  public Long getTsn() {
    return tsn;
  }

  public void setTsn(Long tsn) {
    this.tsn = tsn;
  }

  public Character getUnitInd1() {
    return unitInd1;
  }

  public void setUnitInd1(Character unitInd1) {
    this.unitInd1 = unitInd1;
  }

  public String getUnitName1() {
    return unitName1;
  }

  public void setUnitName1(String unitName1) {
    this.unitName1 = unitName1;
  }

  public Character getUnitInd2() {
    return unitInd2;
  }

  public void setUnitInd2(Character unitInd2) {
    this.unitInd2 = unitInd2;
  }

  public String getUnitName2() {
    return unitName2;
  }

  public void setUnitName2(String unitName2) {
    this.unitName2 = unitName2;
  }

  public String getUnitInd3() {
    return unitInd3;
  }

  public void setUnitInd3(String unitInd3) {
    this.unitInd3 = unitInd3;
  }

  public String getUnitName3() {
    return unitName3;
  }

  public void setUnitName3(String unitName3) {
    this.unitName3 = unitName3;
  }

  public String getUnitInd4() {
    return unitInd4;
  }

  public void setUnitInd4(String unitInd4) {
    this.unitInd4 = unitInd4;
  }

  public String getUnitName4() {
    return unitName4;
  }

  public void setUnitName4(String unitName4) {
    this.unitName4 = unitName4;
  }

  public String getScientificName() {
    return scientificName;
  }

  public void setScientificName(String scientificName) {
    this.scientificName = scientificName;
  }

  public Integer getTaxonAuthorId() {
    return taxonAuthorId;
  }

  public void setTaxonAuthorId(Integer taxonAuthorId) {
    this.taxonAuthorId = taxonAuthorId;
  }

  public Character getLetter() {
    return letter;
  }

  public void setLetter(Character letter) {
    this.letter = letter;
  }

  public String getUsage() {
    return usage;
  }

  public void setUsage(String usage) {
    this.usage = usage;
  }

  public String getUnacceptReason() {
    return unacceptReason;
  }

  public void setUnacceptReason(String unacceptReason) {
    this.unacceptReason = unacceptReason;
  }

  public String getCredibilityRtng() {
    return credibilityRtng;
  }

  public void setCredibilityRtng(String credibilityRtng) {
    this.credibilityRtng = credibilityRtng;
  }

  public String getCompletenessRtng() {
    return completenessRtng;
  }

  public void setCompletenessRtng(String completenessRtng) {
    this.completenessRtng = completenessRtng;
  }

  public String getCurrencyRating() {
    return currencyRating;
  }

  public void setCurrencyRating(String currencyRating) {
    this.currencyRating = currencyRating;
  }

  public Short getKingdomId() {
    return kingdomId;
  }

  public void setKingdomId(Short kingdomId) {
    this.kingdomId = kingdomId;
  }

  public Short getRankId() {
    return rankId;
  }

  public void setRankId(Short rankId) {
    this.rankId = rankId;
  }

  public Integer getLft() {
    return lft;
  }

  public void setLft(Integer lft) {
    this.lft = lft;
  }

  public Integer getRgt() {
    return rgt;
  }

  public void setRgt(Integer rgt) {
    this.rgt = rgt;
  }

  public BigInteger getImagesCount() {
    return imagesCount;
  }

  public void setImagesCount(BigInteger imagesCount) {
    this.imagesCount = imagesCount;
  }

  public BigInteger getMyImagesCount() {
    return myImagesCount;
  }

  public void setMyImagesCount(BigInteger myImagesCount) {
    this.myImagesCount = myImagesCount;
  }

  public String getNameType() {
    return nameType;
  }

  public void setNameType(String nameType) {
    this.nameType = nameType;
  }

  public String getNameSource() {
    return nameSource;
  }

  public void setNameSource(String nameSource) {
    this.nameSource = nameSource;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getTradeDesignationName() {
    return tradeDesignationName;
  }

  public void setTradeDesignationName(String tradeDesignationName) {
    this.tradeDesignationName = tradeDesignationName;
  }

  public String getPages() {
    return pages;
  }

  public void setPages(String pages) {
    this.pages = pages;
  }

  public Integer getPublicationId() {
    return publicationId;
  }

  public void setPublicationId(Integer publicationId) {
    this.publicationId = publicationId;
  }

  @XmlTransient
  public Collection<Specimen> getSpecimenCollection() {
    return specimenCollection;
  }

  public void setSpecimenCollection(Collection<Specimen> specimenCollection) {
    this.specimenCollection = specimenCollection;
  }

  @XmlTransient
  public Collection<Tree> getTreeCollection() {
    return treeCollection;
  }

  public void setTreeCollection(Collection<Tree> treeCollection) {
    this.treeCollection = treeCollection;
  }

  public Tree getParentTsn() {
    return parentTsn;
  }

  public void setParentTsn(Tree parentTsn) {
    this.parentTsn = parentTsn;
  }

  @XmlTransient
  public Collection<User> getUserCollection() {
    return userCollection;
  }

  public void setUserCollection(Collection<User> userCollection) {
    this.userCollection = userCollection;
  }

  @XmlTransient
  public Collection<User> getUserCollection1() {
    return userCollection1;
  }

  public void setUserCollection1(Collection<User> userCollection1) {
    this.userCollection1 = userCollection1;
  }

  @XmlTransient
  public Collection<User> getUserCollection2() {
    return userCollection2;
  }

  public void setUserCollection2(Collection<User> userCollection2) {
    this.userCollection2 = userCollection2;
  }

  @XmlTransient
  public Collection<Groups> getGroupsCollection() {
    return groupsCollection;
  }

  public void setGroupsCollection(Collection<Groups> groupsCollection) {
    this.groupsCollection = groupsCollection;
  }

  public TaxonomicUnits getTaxonomicUnits() {
    return taxonomicUnits;
  }

  public void setTaxonomicUnits(TaxonomicUnits taxonomicUnits) {
    this.taxonomicUnits = taxonomicUnits;
  }

  @XmlTransient
  public Collection<TaxonomicUnits> getTaxonomicUnitsCollection() {
    return taxonomicUnitsCollection;
  }

  public void setTaxonomicUnitsCollection(Collection<TaxonomicUnits> taxonomicUnitsCollection) {
    this.taxonomicUnitsCollection = taxonomicUnitsCollection;
  }

  @XmlTransient
  public Collection<DeterminationAnnotation> getDeterminationAnnotationCollection() {
    return determinationAnnotationCollection;
  }

  public void setDeterminationAnnotationCollection(Collection<DeterminationAnnotation> determinationAnnotationCollection) {
    this.determinationAnnotationCollection = determinationAnnotationCollection;
  }

  @XmlTransient
  public Collection<TaxonConcept> getTaxonConceptCollection() {
    return taxonConceptCollection;
  }

  public void setTaxonConceptCollection(Collection<TaxonConcept> taxonConceptCollection) {
    this.taxonConceptCollection = taxonConceptCollection;
  }

  @XmlTransient
  public Collection<View> getViewCollection() {
    return viewCollection;
  }

  public void setViewCollection(Collection<View> viewCollection) {
    this.viewCollection = viewCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (tsn != null ? tsn.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Tree)) {
      return false;
    }
    Tree other = (Tree) object;
    return !((this.tsn == null && other.tsn != null) || (this.tsn != null && !this.tsn.equals(other.tsn)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Tree[ tsn=" + tsn + " ]";
  }
  
}
