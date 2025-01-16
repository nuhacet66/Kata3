import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HistogramBuilder {
    private final String filePath;

    public HistogramBuilder(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, Integer> build() {
        Map<String, Integer> histogram = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Leer línea por línea
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\t");
                if (fields.length > 4 && !fields[4].equals("\\N") && !fields[4].isEmpty()) {
                    String key = fields[5]; // Campo 5 (startYear)
                    histogram.put(key, histogram.getOrDefault(key, 0) + 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }

        return histogram;
    }
}