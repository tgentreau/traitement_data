package bo;

import java.time.LocalDate;

public abstract class Media {
    private String nom;
    private String url;
    private String id_IMDB;
    private String plot;
    private String langue;
    private LocalDate anneeSortie;

    public Media() {
    }

    public Media(String nom, String url, String id_IMDB, String plot, String langue, LocalDate anneeSortie) {
        this.nom = nom;
        this.url = url;
        this.id_IMDB = id_IMDB;
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

    public String getId_IMDB() {
        return id_IMDB;
    }

    public void setId_IMDB(String id_IMDB) {
        this.id_IMDB = id_IMDB;
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

    public LocalDate getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(LocalDate anneeSortie) {
        this.anneeSortie = anneeSortie;
    }
}
