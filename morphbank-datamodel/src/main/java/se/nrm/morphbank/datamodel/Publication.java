package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Publication")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p"),
  @NamedQuery(name = "Publication.findById", query = "SELECT p FROM Publication p WHERE p.id = :id"),
  @NamedQuery(name = "Publication.findByDoi", query = "SELECT p FROM Publication p WHERE p.doi = :doi"),
  @NamedQuery(name = "Publication.findByIssn", query = "SELECT p FROM Publication p WHERE p.issn = :issn")})
public class Publication implements Serializable {

  private static final long serialVersionUID = 1L;
   
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  
  @Size(max = 255)
  @Column(name = "doi")
  private String doi;
  
  @Size(max = 18)
  @Column(name = "publicationType")
  private String publicationType;
  
  @Size(max = 255)
  @Column(name = "address")
  private String address;
  
  @Size(max = 255)
  @Column(name = "annote")
  private String annote;
  
  @Size(max = 255)
  @Column(name = "author")
  private String author;
  
  @Size(max = 255)
  @Column(name = "publicationTitle")
  private String publicationTitle; 
  
  @Size(max = 255)
  @Column(name = "chapter")
  private String chapter; 
  
  @Size(max = 255)
  @Column(name = "edition")
  private String edition;
  
  @Size(max = 255)
  @Column(name = "editor")
  private String editor;
  
  @Size(max = 255)
  @Column(name = "howPublished")
  private String howPublished;
  
  @Size(max = 255)
  @Column(name = "institution")
  private String institution;
  
  @Size(max = 255)
  @Column(name = "key")
  private String key;
  
  @Size(max = 10)
  @Column(name = "month")
  private String month;
  
  @Column(name = "day")
  private Short day;
  
  @Size(max = 255)
  @Column(name = "note")
  private String note;
  
  @Size(max = 11)
  @Column(name = "number")
  private String number;
  
  @Size(max = 255)
  @Column(name = "organization")
  private String organization; 
  
  @Size(max = 255)
  @Column(name = "pages")
  private String pages;
  
  @Size(max = 255)
  @Column(name = "publisher")
  private String publisher;
  
  @Size(max = 255)
  @Column(name = "school")
  private String school;
  
  @Size(max = 255)
  @Column(name = "series")
  private String series;
  
  @Size(max = 255)
  @Column(name = "title")
  private String title;
  
  @Size(max = 11)
  @Column(name = "volume")
  private String volume;
  
  @Size(max = 255)
  @Column(name = "year")
  private String year;
  
  @Size(max = 255)
  @Column(name = "isbn")
  private String isbn;
  
  @Size(max = 255)
  @Column(name = "issn")
  private String issn;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private BaseObject baseObject;
  
  @OneToMany(mappedBy = "publicationId", fetch = FetchType.LAZY)
  private Collection<MbCharacter> mbCharacterCollection;

  public Publication() {
  }

  public Publication(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDoi() {
    return doi;
  }

  public void setDoi(String doi) {
    this.doi = doi;
  }

  public String getPublicationType() {
    return publicationType;
  }

  public void setPublicationType(String publicationType) {
    this.publicationType = publicationType;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAnnote() {
    return annote;
  }

  public void setAnnote(String annote) {
    this.annote = annote;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublicationTitle() {
    return publicationTitle;
  }

  public void setPublicationTitle(String publicationTitle) {
    this.publicationTitle = publicationTitle;
  }

  public String getChapter() {
    return chapter;
  }

  public void setChapter(String chapter) {
    this.chapter = chapter;
  }

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public String getEditor() {
    return editor;
  }

  public void setEditor(String editor) {
    this.editor = editor;
  }

  public String getHowPublished() {
    return howPublished;
  }

  public void setHowPublished(String howPublished) {
    this.howPublished = howPublished;
  }

  public String getInstitution() {
    return institution;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public Short getDay() {
    return day;
  }

  public void setDay(Short day) {
    this.day = day;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public String getPages() {
    return pages;
  }

  public void setPages(String pages) {
    this.pages = pages;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getSeries() {
    return series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getVolume() {
    return volume;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getIssn() {
    return issn;
  }

  public void setIssn(String issn) {
    this.issn = issn;
  }

  public BaseObject getBaseObject() {
    return baseObject;
  }

  public void setBaseObject(BaseObject baseObject) {
    this.baseObject = baseObject;
  }

  @XmlTransient
  public Collection<MbCharacter> getMbCharacterCollection() {
    return mbCharacterCollection;
  }

  public void setMbCharacterCollection(Collection<MbCharacter> mbCharacterCollection) {
    this.mbCharacterCollection = mbCharacterCollection;
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
    if (!(object instanceof Publication)) {
      return false;
    }
    Publication other = (Publication) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.Publication[ id=" + id + " ]";
  }
  
}
