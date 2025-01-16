import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTitleLoader implements TitleLoader{

    private final String filePath;
    private final TitleDeserializer deserializer;

    public FileTitleLoader(String filePath, TitleDeserializer deserializer) {
        this.filePath = filePath;
        this.deserializer = deserializer;
    }

    @Override
    public List<Title> loadTitles() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
        return deserializer.deserialize(lines);
    }

}
