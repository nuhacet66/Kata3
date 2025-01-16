import javax.swing.*;
import java.util.Map;

public class HistogramFrame extends JFrame {
    public HistogramFrame(Map<String, Integer> histogram) {
        setTitle("Histogram Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HistogramPanel panel = new HistogramPanel(histogram);
        add(panel);
    }
}