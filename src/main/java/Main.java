import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String filePath = "./title.basics.tsv";
        TitleLoader loader = new FileTitleLoader(filePath, new TsvTitleDeserializer());
        List<Title> titles = loader.loadTitles();


        FromMapHistogramElementBuilder builder = new FromMapHistogramElementBuilder();
        List<HistogramElement> histogram = builder.buildHistogram(titles);


        HistogramStatsDisplayer.displayStats(histogram);
        StatsDisplayer.display(histogram);

    }
}
