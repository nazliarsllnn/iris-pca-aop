package org.example.iris.service;

import org.springframework.stereotype.Service;
import smile.feature.extraction.PCA;

@Service
public class PCAService {

    public double[][] applyPCA(double[][] data) {

        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("PCA için veri boş!");
        }

        // PCA modelini oluştur
        PCA pca = PCA.fit(data);

        // İlk 2 temel bileşeni seç
        var pca2 = pca.getProjection(2);

        // Veriyi 2 boyuta dönüştür
        double[][] transformedData = pca2.apply(data);

        System.out.println("PCA işlemi tamamlandı.");
        System.out.println("Boyut: 4 -> 2");

        return transformedData;
    }
}