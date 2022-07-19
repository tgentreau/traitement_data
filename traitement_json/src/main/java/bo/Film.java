package bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;
    @ManyToMany
    @JoinTable(name = "Film_acteur",
            joinColumns = @JoinColumn(name = "Id_Film", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Id_Acteur", referencedColumnName = "id"))
    private List<Acteur> acteurs= new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "Film_realisateur", joinColumns = @JoinColumn(name = "Id_Film", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Id_Realisateur", referencedColumnName = "id"))
    private List<Realisateur> realisateurs = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "Film_genre",
            joinColumns = @JoinColumn(name = "Id_Film", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Id_Genre", referencedColumnName = "id"))
    private List<Genre> genre = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "film")
    private List<Role> roles = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_LieuTournage")
    private LieuTournage lieuTournage;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Pays")
    private Pays pays;

    @ManyToMany
    @JoinTable(name = "casting_principal",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id", referencedColumnName = "id"))
    private List<Acteur> castingPrincipal = new ArrayList<>();

    public Film() {
    }

    @Embedded
    private Medias media;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Medias getMedia() {
        return media;
    }

    public void setMedia(Medias media) {
        this.media = media;
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

    public List<Acteur> getCastingPrincipal() {
        return castingPrincipal;
    }

    public void setCastingPrincipal(List<Acteur> castingPrincipal) {
        this.castingPrincipal = castingPrincipal;
    }
}
