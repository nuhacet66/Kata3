import javax.swing.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String filePath = "./title.basics.tsv";

        HistogramBuilder builder = new HistogramBuilder(filePath);
        Map<String, Integer> histogram = builder.build();


        SwingUtilities.invokeLater(() ->{
            HistogramFrame frame = new HistogramFrame(histogram);
            frame.setVisible(true);
        });

    }
}
