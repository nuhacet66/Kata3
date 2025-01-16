import java.util.List;

public interface TitleDeserializer {
    List<Title> deserialize(List<String> lines);
}
