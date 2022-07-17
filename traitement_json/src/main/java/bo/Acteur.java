package bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Acteur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Acteur extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;
    @Column
    private String id_IMDB;

    @ManyToMany(mappedBy = "acteurs")
    private List<Film> films;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Naissance")
    private Naissance naissance;

    @OneToMany
    private List<Role> roles = new ArrayList<>();


    public Acteur() {
    }

    public Acteur(String identite, String url, String id_IMDB) {
        super(identite, url);
        this.id_IMDB = id_IMDB;
    }

    public String getId_IMDB() {
        return id_IMDB;
    }

    public void setId_IMDB(String id_IMDB) {
        this.id_IMDB = id_IMDB;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public Naissance getNaissance() {
        return naissance;
    }

    public void setNaissance(Naissance naissance) {
        this.naissance = naissance;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
