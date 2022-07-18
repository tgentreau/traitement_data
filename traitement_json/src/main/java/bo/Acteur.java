package bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Acteur{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;

    @Column
    private String idIMDB;

    @Embedded
    private Personne personne;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "acteurs")
    private List<Film> films = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Naissance")
    private Naissance naissance;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "acteur")
    private List<Role> roles = new ArrayList<>();


    public Acteur() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdIMDB() {
        return idIMDB;
    }

    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
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

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
