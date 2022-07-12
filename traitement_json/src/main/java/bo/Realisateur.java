package bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Realisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Realisateur extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;

    @ManyToMany(mappedBy = "realisateurs")
    private List<Film> films;

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
