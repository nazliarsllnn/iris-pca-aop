package org.example.iris.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    private double[][] data;
    private String[] labels;

    public void loadData() {
        List<double[]> rows = new ArrayList<>();
        List<String> species = new ArrayList<>();

        try (InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("iris.csv")) {

            if (inputStream == null) {
                throw new IllegalStateException("iris.csv bulunamadı!");
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream));

            String line;
            boolean header = true;

            while ((line = reader.readLine()) != null) {

                if (header) {
                    header = false;
                    continue;
                }

                String[] values = line.split(",");

                double[] row = new double[4];

                for (int i = 0; i < 4; i++) {
                    row[i] = Double.parseDouble(values[i]);
                }

                rows.add(row);
                species.add(values[4]);
            }

        } catch (Exception e) {
            throw new RuntimeException("Veri yükleme hatası!", e);
        }

        data = rows.toArray(new double[0][]);
        labels = species.toArray(new String[0]);

        System.out.println("Veri seti yüklendi: " + data.length + " örnek");
    }

    public double[][] getData() {
        return data;
    }

    public String[] getLabels() {
        return labels;
    }
}