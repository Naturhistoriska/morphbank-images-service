package se.nrm.morphbank.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author idali
 */
@Embeddable
public class MirrorInfoPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "serverId")
  private int serverId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "imageId")
  private int imageId;

  public MirrorInfoPK() {
  }

  public MirrorInfoPK(int serverId, int imageId) {
    this.serverId = serverId;
    this.imageId = imageId;
  }

  public int getServerId() {
    return serverId;
  }

  public void setServerId(int serverId) {
    this.serverId = serverId;
  }

  public int getImageId() {
    return imageId;
  }

  public void setImageId(int imageId) {
    this.imageId = imageId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) serverId;
    hash += (int) imageId;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MirrorInfoPK)) {
      return false;
    }
    MirrorInfoPK other = (MirrorInfoPK) object;
    if (this.serverId != other.serverId) {
      return false;
    }
    return this.imageId == other.imageId;
  }

  @Override
  public String toString() {
    return "se.nrm.morphbank.datamodel.MirrorInfoPK[ serverId=" + serverId + ", imageId=" + imageId + " ]";
  }
  
}
