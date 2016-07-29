
package uber.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conducteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String loginConducteur;
    private String mdpConducteur;
    private String mailConducteur;
    private String telConducteur;
    private String immatriculation;
    
    // GETTER & SETTER

    public String getLoginConducteur() {
        return loginConducteur;
    }

    public void setLoginConducteur(String loginConducteur) {
        this.loginConducteur = loginConducteur;
    }

    public String getMdpConducteur() {
        return mdpConducteur;
    }

    public void setMdpConducteur(String mdpConducteur) {
        this.mdpConducteur = mdpConducteur;
    }

    public String getMailConducteur() {
        return mailConducteur;
    }

    public void setMailConducteur(String mailConducteur) {
        this.mailConducteur = mailConducteur;
    }

    public String getTelConducteur() {
        return telConducteur;
    }

    public void setTelConducteur(String telConducteur) {
        this.telConducteur = telConducteur;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    //------------------------------------------------
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conducteur)) {
            return false;
        }
        Conducteur other = (Conducteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uber.entity.Passager[ id=" + id + " ]";
    }
    
}
