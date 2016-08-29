
package uber.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Passager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String loginPassager;
    private String mdpPassager;
    private String mailPassager;
    private String telPassager;
    
    @OneToMany (mappedBy="passager")
    private List<Historique> historique = new ArrayList<Historique>();
    
// GETTER & SETTER

    public List<Historique> getHistorique() {
        return historique;
    }

    public void setHistorique(List<Historique> historique) {
        this.historique = historique;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginPassager() {
        return loginPassager;
    }

    public void setLoginPassager(String loginPassager) {
        this.loginPassager = loginPassager;
    }

    public String getMdpPassager() {
        return mdpPassager;
    }

    public void setMdpPassager(String mdpPassager) {
        this.mdpPassager = mdpPassager;
    }

    public String getMailPassager() {
        return mailPassager;
    }

    public void setMailPassager(String mailPassager) {
        this.mailPassager = mailPassager;
    }

    public String getTelPassager() {
        return telPassager;
    }

    public void setTelPassager(String telPassager) {
        this.telPassager = telPassager;
    }
    
    //----------------------------------------------------------------
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passager)) {
            return false;
        }
        Passager other = (Passager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uber.entity.Conducteur[ id=" + id + " ]";
    }
    
}
