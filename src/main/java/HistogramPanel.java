import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class HistogramPanel extends JPanel {
    private final Map<String, Integer> histogram;

    public HistogramPanel(Map<String, Integer> histogram) {
        this.histogram = histogram;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (histogram == null || histogram.isEmpty()) return;

        int width = getWidth();
        int height = getHeight();
        int margin = 50; // Margen para el gráfico
        int chartWidth = width - 2 * margin;
        int chartHeight = height - 2 * margin;

        int barWidth = chartWidth / histogram.size();
        int maxCount = histogram.values().stream().max(Integer::compare).orElse(1);

        // Dibujar línea vertical (eje Y)
        g.setColor(Color.BLACK);
        g.drawLine(margin, margin, margin, height - margin);

        // Dibujar barras
        int x = margin + 5; // Asegurar que las barras no se superpongan con el eje Y
        for (Map.Entry<String, Integer> entry : histogram.entrySet()) {
            int barHeight = (int) ((double) entry.getValue() / maxCount * chartHeight);
            g.setColor(Color.RED);
            g.fillRect(x, height - margin - barHeight, barWidth - 5, barHeight);

            // Dibujar etiquetas del eje X
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString(entry.getKey(), x, height - margin + 15);

            x += barWidth;
        }
    }
}