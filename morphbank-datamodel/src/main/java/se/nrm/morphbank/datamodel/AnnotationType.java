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
@Table(name = "AnnotationType")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "AnnotationType.findAll", query = "SELECT a FROM AnnotationType a"),
  @NamedQuery(name = "AnnotationType.findByAnnotationType", query = "SELECT a FROM AnnotationType a WHERE a.annotationType = :annotationType")})
public class AnnotationType implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "annotationType")
  private String annotationType;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "annotationSchema")
  private String annotationSchema;

  public AnnotationType() {
  }

  public AnnotationType(String annotationType) {
    this.annotationType = annotationType;
  }

  public String getAnnotationType() {
    return annotationType;
  }

  public void setAnnotationType(String annotationType) {
    this.annotationType = annotationType;
  }

  public String getAnnotationSchema() {
    return annotationSchema;
  }

  public void setAnnotationSchema(String annotationSchema) {
    this.annotationSchema = annotationSchema;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (annotationType != null ? annotationType.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AnnotationType)) {
      return false;
    }
    AnnotationType other = (AnnotationType) object;
    return !((this.annotationType == null && other.annotationType != null) || (this.annotationType != null && !this.annotationType.equals(other.annotationType)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.AnnotationType[ annotationType=" + annotationType + " ]";
  }
  
}
