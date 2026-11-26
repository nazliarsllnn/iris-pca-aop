package org.example.iris;

import org.example.iris.aspect.PerformanceAspect;
import org.example.iris.service.DataService;
import org.example.iris.service.PCAService;
import org.example.iris.service.ValidationService;
import org.example.iris.visualization.VisualizationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.example.iris")
@EnableAspectJAutoProxy
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        try {

            DataService dataService = context.getBean(DataService.class);
            ValidationService validationService =
                    context.getBean(ValidationService.class);
            PCAService pcaService = context.getBean(PCAService.class);
            VisualizationService visualizationService =
                    context.getBean(VisualizationService.class);
            PerformanceAspect performanceAspect =
                    context.getBean(PerformanceAspect.class);

            // 1. Veriyi yükle
            dataService.loadData();
            double[][] data = dataService.getData();

            // 2. Veriyi doğrula
            validationService.validateData(data);
            
            // 3. PCA uygula
            double[][] transformedData = pcaService.applyPCA(data);

            // 4. Grafikte kullanılacak etiketler
            String[] labels = dataService.getLabels();

            // 5. Grafiği göster
            visualizationService.plotData(transformedData, labels);

            // 6. Performans raporu
            performanceAspect.printPerformanceReport();

        } catch (Exception e) {

            System.err.println("Proje çalışırken hata oluştu: "
                    + e.getMessage());

            e.printStackTrace();

        } finally {
            context.close();
        }
    }
}