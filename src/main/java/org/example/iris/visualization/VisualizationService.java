package org.example.iris.visualization;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class VisualizationService {

    public void plotData(double[][] data, String[] labels) {

        JFrame frame = new JFrame("Iris PCA Visualization");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                int width = getWidth();
                int height = getHeight();

                int margin = 50;

                g2.drawLine(margin, height - margin,
                        width - margin, height - margin);

                g2.drawLine(margin, margin,
                        margin, height - margin);

                g2.drawString("PC1", width / 2, height - 15);
                g2.drawString("PC2", 15, height / 2);

                double minX = Double.MAX_VALUE;
                double maxX = Double.MIN_VALUE;
                double minY = Double.MAX_VALUE;
                double maxY = Double.MIN_VALUE;

                for (double[] row : data) {
                    minX = Math.min(minX, row[0]);
                    maxX = Math.max(maxX, row[0]);
                    minY = Math.min(minY, row[1]);
                    maxY = Math.max(maxY, row[1]);
                }

                for (int i = 0; i < data.length; i++) {

                    double xValue = data[i][0];
                    double yValue = data[i][1];

                    int x = margin + (int) ((xValue - minX)
                            / (maxX - minX) * (width - 2 * margin));

                    int y = height - margin - (int) ((yValue - minY)
                            / (maxY - minY) * (height - 2 * margin));

                    if (labels[i].equals("setosa")) {
                        g2.setColor(Color.RED);
                    } else if (labels[i].equals("versicolor")) {
                        g2.setColor(Color.BLUE);
                    } else {
                        g2.setColor(Color.GREEN);
                    }

                    g2.fillOval(x - 5, y - 5, 10, 10);
                }

                g2.setColor(Color.BLACK);
                g2.drawString("Iris PCA - 2D Projection", width / 2 - 80, 25);
                // Renk açıklamaları (Legend)
                g2.setColor(Color.RED);
                g2.fillOval(width - 150, 50, 10, 10);
                g2.setColor(Color.BLACK);
                g2.drawString("Setosa", width - 135, 60);

                g2.setColor(Color.BLUE);
                g2.fillOval(width - 150, 70, 10, 10);
                g2.setColor(Color.BLACK);
                g2.drawString("Versicolor", width - 135, 80);

                g2.setColor(Color.GREEN);
                g2.fillOval(width - 150, 90, 10, 10);
                g2.setColor(Color.BLACK);
                g2.drawString("Virginica", width - 135, 100);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}