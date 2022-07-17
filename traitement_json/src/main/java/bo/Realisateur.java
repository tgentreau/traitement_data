package bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Realisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Realisateur extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;

    @OneToMany
    private List<Film> films = new ArrayList<>();

    public Realisateur() {
    }

    public Realisateur(String identite, String url) {
        super(identite, url);
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
}
