import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        for (Object o : listJSON) {
            Map<String, Object> mapActeur = (Map) o;
//            System.out.println(mapActeur.get("identite"));
//            System.out.println(mapActeur.get("url"));
//            System.out.println(mapActeur.get("id"));
            //map
//            System.out.println(mapActeur.get("naissance"));
            List<Object> listRoles = (List<Object>) mapActeur.get("roles");
            for (Object role : listRoles) {
                Map<String, Object> mapRole = (Map) role;
//                System.out.println(mapRole.get("characterName"));
//                System.out.println(mapRole.get("film"));
                Map<String, Object> mapFilm = (Map) mapRole.get("film");
                //map
//                System.out.println(mapFilm.get("pays"));
//                System.out.println(mapFilm.get("nom"));
//                System.out.println(mapFilm.get("url"));
//                System.out.println(mapFilm.get("plot"));
//                System.out.println(mapFilm.get("id"));
//                System.out.println(mapFilm.get("langue"));
                //map
//                System.out.println(mapFilm.get("lieuTournage"));
                //map
//                System.out.println(mapFilm.get("realisateurs"));
                //list + map
//                System.out.println(mapFilm.get("castingPrincipal"));
//                System.out.println(mapFilm.get("anneeSortie"));
                //List
//                System.out.println(mapFilm.get("genres"));
                //list puis map
//                System.out.println(mapFilm.get("acteurs"));
            }

        }
    }
}
