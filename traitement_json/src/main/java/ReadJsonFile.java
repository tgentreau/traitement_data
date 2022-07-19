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
        String content = lines.stream().collect(Collectors.joining());
        List<Object> listJSON = mapper.readValue(content, List.class);

        ActeurBuilder acteurBuilder = new ActeurBuilder();

        for (Object acteurs : listJSON) {

            acteurBuilder.createOBJActor(acteurs);

        }
    }
}
