package bo;

import javax.persistence.*;

@Embeddable
public class Medias {

    private String nom;
    private String url;
    private String idIMDB;
    private String plot;
    private String langue;
    private String anneeSortie;

    public Medias() {
    }

    public Medias(Long id, String nom, String url, String idIMDB, String plot, String langue, String anneeSortie) {
        this.nom = nom;
        this.url = url;
        this.idIMDB = idIMDB;
        this.plot = plot;
        this.langue = langue;
        this.anneeSortie = anneeSortie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIdIMDB() {
        return idIMDB;
    }

    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(String anneeSortie) {
        this.anneeSortie = anneeSortie;
    }
}
