package bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Embeddable
public class Personne {
    private String identite;
    private String url;

    public Personne() {
    }

    public Personne(String identite, String url) {
        this.identite = identite;
        this.url = url;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
