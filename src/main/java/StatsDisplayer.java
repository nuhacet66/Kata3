import java.util.List;

public class StatsDisplayer {


    public static void display(List<HistogramElement> histogram){
        for (HistogramElement element : histogram) {
            System.out.println("-----");
            System.out.println("La novela se llama:" + element.getKey());
        }
    }

}
