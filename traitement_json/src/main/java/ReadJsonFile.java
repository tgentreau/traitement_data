import bll.MovieManager;
import bo.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadJsonFile {
    public static void main(String[] args) throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        List<String> lines = Files.readAllLines(Path.of(ClassLoader.getSystemResource("films.json").toURI()));
        String content =  lines.stream().collect(Collectors.joining());
        List<Object> listJSON = mapper.readValue(content, List.class);

        Acteur acteur = new Acteur();
        Naissance naissance = new Naissance();

        Film film = new Film();
        LieuTournage lieuTournage = new LieuTournage();
        Pays pays = new Pays();

        Role roles = new Role();

        List<Genre> genres = new ArrayList<>();

        MovieManager service = MovieManager.getInstance();
        for (Object o : listJSON) {
            Map<String, Object> mapActeur = (Map) o;
//            System.out.println(mapActeur.get("identite"));
//            System.out.println(mapActeur.get("url"));
//            System.out.println(mapActeur.get("id"));
            //map
//            System.out.println(mapActeur.get("naissance"));
            Map<String, Object> mapNaissance = (Map) mapActeur.get("naissance");
//            System.out.println(mapNaissance.get("dateNaissance"));
//            System.out.println(mapNaissance.get("lieuNaissance"));
            List<Object> listRoles = (List<Object>) mapActeur.get("roles");
            for (Object role : listRoles) {
                Map<String, Object> mapRole = (Map) role;
//                System.out.println(mapRole.get("characterName"));
//                System.out.println(mapRole.get("film"));
                Map<String, Object> mapFilm = (Map) mapRole.get("film");
                //map
//                if(mapFilm.get("pays") == null) {
//                    String mapPaysNull = (String) mapFilm.get("pays");
//                    Map<String, Object> mapPays = (Map) mapFilm.get("pays");
//                    System.out.println(mapPays.get("nom"));
//                    System.out.println(mapPays.get("url"));
//                }
                Map<String, Object> mapPays = (Map) mapFilm.get("pays");
                //Problèmes null
//                System.out.println(mapPays.get("nom"));
//                System.out.println(mapPays.get("url"));
                //
//                System.out.println(mapFilm.get("pays"));
//                System.out.println(mapFilm.get("nom"));
//                System.out.println(mapFilm.get("url"));
//                System.out.println(mapFilm.get("plot"));
//                System.out.println(mapFilm.get("id"));
//                System.out.println(mapFilm.get("langue"));
                //map
                //Problèmes null
                Map<String, Object> mapTournage = (Map) mapFilm.get("lieuTournage");
//                System.out.println(mapTournage.get("ville"));
//                System.out.println(mapTournage.get("etatDept"));
//                System.out.println(mapTournage.get("pays"));
//                System.out.println(mapFilm.get("lieuTournage"));
                //
                //map
                List<Object> listReal = (List<Object>) mapFilm.get("realisateurs");
                for (Object reals : listReal) {
                    Map<String, Object> mapReal = (Map) reals;
//                    System.out.println(mapReal.get("identite"));
//                    System.out.println(mapReal.get("url"));
                }
//                System.out.println(mapFilm.get("realisateurs"));
                //list + map
                List<Object> listCasting = (List<Object>) mapFilm.get("castingPrincipal");
                for (Object castings : listCasting) {
                    Map<String, Object> mapCasting = (Map) castings;
//                    System.out.println(mapCasting.get("identite"));
//                    System.out.println(mapCasting.get("url"));
//                    System.out.println(mapCasting.get("id"));
                    Map<String, Object> mapNaissanceCasting = (Map) mapCasting.get("naissance");
                    //Problèmes null
//                    System.out.println(mapNaissanceCasting.get("dateNaissance"));
//                    System.out.println(mapNaissanceCasting.get("lieuNaissance"));
                    //
                }
//                System.out.println(mapFilm.get("castingPrincipal"));
//                System.out.println(mapFilm.get("anneeSortie"));
                //List
                List<Object> listGenres = (List<Object>) mapFilm.get("genres");
                for (Object genre : listGenres) {
//                    System.out.println(genre);
                }
//                System.out.println(mapFilm.get("genres"));
                //list puis map
                List<Object> listActeurs = (List<Object>) mapFilm.get("acteurs");
                for (Object listActeur : listActeurs) {
                    Map<String, Object> mapActeurs = (Map) listActeur;
//                    System.out.println(mapActeurs.get("identite"));
//                    System.out.println(mapActeurs.get("url"));
//                    System.out.println(mapActeurs.get("id"));
                    Map<String, Object> mapNaissanceActeur = (Map) mapActeurs.get("naissance");
                    //Problèmes null
//                    System.out.println(mapNaissanceActeur.get("dateNaissance"));
//                    System.out.println(mapNaissanceActeur.get("lieuNaissance"));
                    //
                    //Acteurs
                    acteur.setIdentite((String) mapActeurs.get("identite"));
                    acteur.setId_IMDB((String) mapActeurs.get("id"));
                    acteur.setUrl((String) mapActeurs.get("url"));
                    naissance.setDateNaissance((String) mapNaissanceActeur.get("dateNaissance"));
                    naissance.setLieuNaissance((String) mapNaissanceActeur.get("lieuNaissance"));
                    acteur.setNaissance(naissance);
                    service.createActeur(acteur);
                    //
                    //Films
                    film.setAnneeSortie((String) mapFilm.get("anneeSortie"));
                    film.setId_IMDB((String) mapFilm.get("id"));
                    film.setNom((String) mapFilm.get("nom"));
                    film.setLangue((String) mapFilm.get("langue"));
                    film.setPlot((String) mapFilm.get("plot"));
                    film.setUrl((String) mapFilm.get("url"));
                    lieuTournage.setVille((String) mapTournage.get("ville"));
                    lieuTournage.setEtat((String) mapTournage.get("etatDept"));
                    lieuTournage.setPays((String) mapTournage.get("pays"));
                    film.setLieuTournage(lieuTournage);
                    pays.setNom((String) mapPays.get("nom"));
                    pays.setUrl((String) mapPays.get("url"));
                    film.setPays(pays);
                    film.getGenre().add((Genre) mapFilm.get("genres"));
                    service.createFilm(film);
                    //
                    //Roles
                    roles.setCharacterName((String) mapRole.get("characterName"));
                    service.createRole(roles);
                }
//                System.out.println(mapFilm.get("acteurs"));
            }

        }
    }
}
