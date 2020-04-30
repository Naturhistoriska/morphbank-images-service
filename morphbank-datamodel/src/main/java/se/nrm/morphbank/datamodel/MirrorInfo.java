package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "MirrorInfo")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "MirrorInfo.findAll", query = "SELECT m FROM MirrorInfo m"),
  @NamedQuery(name = "MirrorInfo.findByServerId", query = "SELECT m FROM MirrorInfo m WHERE m.mirrorInfoPK.serverId = :serverId"),
  @NamedQuery(name = "MirrorInfo.findByImageId", query = "SELECT m FROM MirrorInfo m WHERE m.mirrorInfoPK.imageId = :imageId")})
public class MirrorInfo implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @EmbeddedId
  protected MirrorInfoPK mirrorInfoPK;

  public MirrorInfo() {
  }

  public MirrorInfo(MirrorInfoPK mirrorInfoPK) {
    this.mirrorInfoPK = mirrorInfoPK;
  }

  public MirrorInfo(int serverId, int imageId) {
    this.mirrorInfoPK = new MirrorInfoPK(serverId, imageId);
  }

  public MirrorInfoPK getMirrorInfoPK() {
    return mirrorInfoPK;
  }

  public void setMirrorInfoPK(MirrorInfoPK mirrorInfoPK) {
    this.mirrorInfoPK = mirrorInfoPK;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (mirrorInfoPK != null ? mirrorInfoPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MirrorInfo)) {
      return false;
    }
    MirrorInfo other = (MirrorInfo) object;
    return !((this.mirrorInfoPK == null && other.mirrorInfoPK != null) || (this.mirrorInfoPK != null && !this.mirrorInfoPK.equals(other.mirrorInfoPK)));
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.MirrorInfo[ mirrorInfoPK=" + mirrorInfoPK + " ]";
  }
  
}
