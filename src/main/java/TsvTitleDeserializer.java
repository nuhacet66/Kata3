import java.util.ArrayList;
import java.util.List;

public class TsvTitleDeserializer implements TitleDeserializer{
    public List<Title> deserializer(List<String> lines) {
        return List.of();
    }

    @Override
    public List<Title> deserialize(List<String> lines) {
        List<Title> titles = new ArrayList<>();
        for (String line : lines) {
            String[] fields = line.split("\\t");
            titles.add(new Title(fields[0], fields[2]));
        }
        return titles;
    }
}
