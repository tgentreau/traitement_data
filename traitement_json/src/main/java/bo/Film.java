package bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Film")
@Inheritance(strategy = InheritanceType.JOINED)
public class Film extends Media{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "Film_acteur", joinColumns = @JoinColumn(name = "Id_Film", referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "Id_Acteur", referencedColumnName = "Id"))
    private List<Acteur> acteurs;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "Film_realisateur", joinColumns = @JoinColumn(name = "Id_Film", referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "Id_Realisateur", referencedColumnName = "Id"))
    private List<Realisateur> realisateurs;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "Film_genre", joinColumns = @JoinColumn(name = "Id_Film", referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "Id_Genre", referencedColumnName = "Id"))
    private List<Genre> genre;

    @OneToMany(fetch=FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_LieuTournage")
    private LieuTournage lieuTournage;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Pays")
    private Pays pays;

    public Film() {
    }

    public Film(String nom, String url, String id_IMDB, String plot, String langue, String anneeSortie) {
        super(nom, url, id_IMDB, plot, langue, anneeSortie);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    public List<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(List<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public LieuTournage getLieuTournage() {
        return lieuTournage;
    }

    public void setLieuTournage(LieuTournage lieuTournage) {
        this.lieuTournage = lieuTournage;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
