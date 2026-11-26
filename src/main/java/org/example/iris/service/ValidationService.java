package org.example.iris.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public void validateData(double[][] data) {

        if (data == null) {
            throw new IllegalArgumentException("Veri null olamaz!");
        }

        if (data.length == 0) {
            throw new IllegalArgumentException("Veri seti boş!");
        }

        for (int i = 0; i < data.length; i++) {

            if (data[i] == null || data[i].length != 4) {
                throw new IllegalArgumentException(
                        "Her satır 4 özellik içermelidir. Hatalı satır: " + i);
            }

            for (int j = 0; j < data[i].length; j++) {

                if (!Double.isFinite(data[i][j])) {
                    throw new IllegalArgumentException(
                            "Geçersiz sayısal değer bulundu. Satır: " + i);
                }
            }
        }

        System.out.println("Veri doğrulama başarılı. Toplam örnek: " + data.length);
    }
}