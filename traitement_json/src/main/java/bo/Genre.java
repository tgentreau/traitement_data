package bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Genre")
public class Genre {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;
    @Column
    private String nom;

    @ManyToMany
    @JoinTable(name="Film_genre",
            joinColumns = @JoinColumn(name="Id_Genre", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="Id_Film", referencedColumnName = "id")
    )
    private List<Film> films = new ArrayList<>();

    public Genre() {
    }

    public Genre(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
