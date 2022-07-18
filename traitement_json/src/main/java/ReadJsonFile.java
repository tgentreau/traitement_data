import bll.MovieManager;
import bo.*;
import builder.ActeurBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadJsonFile {
    public static void main(String[] args) throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        List<String> lines = Files.readAllLines(Path.of(ClassLoader.getSystemResource("films.json").toURI()));
        String content =  lines.stream().collect(Collectors.joining());
        List<Object> listJSON = mapper.readValue(content, List.class);

        ActeurBuilder acteurBuilder = new ActeurBuilder();

        for (Object acteurs : listJSON) {

            acteurBuilder.createOBJActor(acteurs);

        }
//        Naissance naissance = new Naissance();
//
//        Film film = new Film();
//        LieuTournage lieuTournage = new LieuTournage();
//        Pays pays = new Pays();
//        Role roles = new Role();
//        Genre genre = new Genre();
//        Realisateur realisateur = new Realisateur();
//
//        MovieManager service = MovieManager.getInstance();
//        for (Object o : listJSON) {
//            Map<String, Object> mapActeur = (Map) o;
//            if(mapActeur.get("identite") != null) {
//                personne.setIdentite((String) mapActeur.get("identite"));
//            } else {
//                personne.setIdentite("null");
//            }
//
////            System.out.println(mapActeur.get("identite"));
////            System.out.println(mapActeur.get("url"));
////            System.out.println(mapActeur.get("id"));
//            //map
////            System.out.println(mapActeur.get("naissance"));
//            Map<String, Object> mapNaissance = (Map) mapActeur.get("naissance");
////            System.out.println(mapNaissance.get("dateNaissance"));
////            System.out.println(mapNaissance.get("lieuNaissance"));
//            List<Object> listRoles = (List<Object>) mapActeur.get("roles");
//            for (Object role : listRoles) {
//                Map<String, Object> mapRole = (Map) role;
////                System.out.println(mapRole.get("characterName"));
////                System.out.println(mapRole.get("film"));
//                Map<String, Object> mapFilm = (Map) mapRole.get("film");
//                //map
////                if(mapFilm.get("pays") == null) {
////                    String mapPaysNull = (String) mapFilm.get("pays");
////                    Map<String, Object> mapPays = (Map) mapFilm.get("pays");
////                    System.out.println(mapPays.get("nom"));
////                    System.out.println(mapPays.get("url"));
////                }
//                Map<String, Object> mapPays = (Map) mapFilm.get("pays");
//                //Problèmes null
////                System.out.println(mapPays.get("nom"));
////                System.out.println(mapPays.get("url"));
//                if(mapPays != null) {
//                    pays.setNom((String) mapPays.get("nom"));
//                    pays.setUrl((String) mapPays.get("url"));
//                } else {
//                    pays.setNom("null");
//                    pays.setUrl("null");
//                }
//
//                //
////                System.out.println(mapFilm.get("pays"));
//                if(mapFilm.get("nom") != null) {
//                    film.setNom((String) mapFilm.get("nom"));
//                } else {
//                    film.setNom("null");
//                }
////                System.out.println(mapFilm.get("nom"));
////                System.out.println(mapFilm.get("url"));
////                System.out.println(mapFilm.get("plot"));
////                System.out.println(mapFilm.get("id"));
////                System.out.println(mapFilm.get("langue"));
//                //map
//                //Problèmes null
//                Map<String, Object> mapTournage = (Map) mapFilm.get("lieuTournage");
////                System.out.println(mapTournage.get("ville"));
////                System.out.println(mapTournage.get("etatDept"));
////                System.out.println(mapTournage.get("pays"));
////                System.out.println(mapFilm.get("lieuTournage"));
//                if(mapTournage != null) {
//                    lieuTournage.setVille((String) mapTournage.get("ville"));
//                    lieuTournage.setEtat((String) mapTournage.get("etatDept"));
//                    lieuTournage.setPays((String) mapTournage.get("pays"));
//                } else {
//                    lieuTournage.setVille("null");
//                    lieuTournage.setEtat("null");
//                    lieuTournage.setPays("null");
//                }
//
//                //
//                //map
//                List<Object> listReal = (List<Object>) mapFilm.get("realisateurs");
//                for (Object reals : listReal) {
//                    Map<String, Object> mapReal = (Map) reals;
//                    personne.setUrl((String) mapReal.get("url"));
//                    personne.setIdentite((String) mapReal.get("identite"));
////                    System.out.println(mapReal.get("identite"));
////                    System.out.println(mapReal.get("url"));
//                }
////                System.out.println(mapFilm.get("realisateurs"));
//                //list + map
//                List<Object> listCasting = (List<Object>) mapFilm.get("castingPrincipal");
//                for (Object castings : listCasting) {
//                    Map<String, Object> mapCasting = (Map) castings;
////                    System.out.println(mapCasting.get("identite"));
////                    System.out.println(mapCasting.get("url"));
////                    System.out.println(mapCasting.get("id"));
//                    Map<String, Object> mapNaissanceCasting = (Map) mapCasting.get("naissance");
//                    //Problèmes null
////                    System.out.println(mapNaissanceCasting.get("dateNaissance"));
////                    System.out.println(mapNaissanceCasting.get("lieuNaissance"));
//                    //
//                }
////                System.out.println(mapFilm.get("castingPrincipal"));
////                System.out.println(mapFilm.get("anneeSortie"));
//                //List
//                List<Object> listGenres = (List<Object>) mapFilm.get("genres");
//                for (Object genreList : listGenres) {
//                    genre.setNom((String) genreList);
//                    film.getGenre().add(genre);
//                }
////                System.out.println(mapFilm.get("genres"));
//                //list puis map
//                List<Object> listActeurs = (List<Object>) mapFilm.get("acteurs");
//                for (Object listActeur : listActeurs) {
//                    Map<String, Object> mapActeurs = (Map) listActeur;
//
////                    System.out.println(mapActeurs.get("identite"));
////                    System.out.println(mapActeurs.get("url"));
////                    System.out.println(mapActeurs.get("id"));
//                    Map<String, Object> mapNaissanceActeur = (Map) mapActeurs.get("naissance");
//                    if(mapActeurs.get("naissance") != null) {
//                        naissance.setDateNaissance((String) mapNaissanceActeur.get("dateNaissance"));
//                        naissance.setLieuNaissance((String) mapNaissanceActeur.get("lieuNaissance"));
//                    } else {
//                        naissance.setDateNaissance("null");
//                        naissance.setLieuNaissance("null");
//                    }
//                    //Problèmes null
////                    System.out.println(mapNaissanceActeur.get("dateNaissance"));
////                    System.out.println(mapNaissanceActeur.get("lieuNaissance"));
//                    //
//                    //Acteurs
//
                    /*acteur.setIdIMDB((String) mapActeurs.get("id"));
                    personne.setUrl((String) mapActeurs.get("url"));*/
//                    acteur.setPersonne(personne);
//                    acteur.setNaissance(naissance);
//                    service.createActeur(acteur);

//                    //
//                  Films
//                    film.setAnneeSortie((String) mapFilm.get("anneeSortie"));
//                    film.setIdIMDB((String) mapFilm.get("id"));
//                    film.setLangue((String) mapFilm.get("langue"));
//                    film.setPlot((String) mapFilm.get("plot"));
//                    film.setUrl((String) mapFilm.get("url"));
//                    film.setLieuTournage(lieuTournage);
//                    film.setPays(pays);
//                    service.createFilm(film);
//
//                    //                  Roles
//                    roles.setCharacterName((String) mapRole.get("characterName"));
//                    roles.setActeur(acteur);
//                    roles.setFilm(film);
//                    service.createRole(roles);
//                    acteur.getRoles().add(roles);

                    //liaisons
//                    film.getActeurs().add(acteur);
//                    acteur.getFilms().add(film);
//                    film.getRoles().add(roles);
//                    pays.getFilms().add(film);
//                    lieuTournage.getFilms().add(film);
//                    genre.getFilms().add(film);
                }
//            }
//
//        }
//    }
}
