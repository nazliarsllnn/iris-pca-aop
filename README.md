# 🌸 Iris Veri Seti ile PCA Analizi ve AOP Performans İzleme

Java kullanılarak geliştirilen bu projede, Iris veri seti üzerinde **Temel Bileşen Analizi (PCA)** uygulanarak verilerin boyutu azaltılmış ve iki boyutlu grafik üzerinde görselleştirilmiştir. Ayrıca **Spring AOP** kullanılarak metot çağrıları, çalışma süreleri, hata durumları ve performans ölçümleri izlenmiştir.

---

## 📌 Projenin Amacı

Bu projenin temel amacı, Iris veri setindeki dört sayısal özellikten elde edilen verileri PCA yöntemiyle iki boyuta indirgemek, verileri görsel olarak analiz etmek ve Java uygulamalarında Aspect-Oriented Programming (AOP) kullanarak performans izleme mekanizması geliştirmektir.

Proje kapsamında:

- Iris veri seti yüklenmiştir.
- Veriler doğrulama işleminden geçirilmiştir.
- PCA yöntemi uygulanarak veri boyutu azaltılmıştır.
- Dönüştürülen veriler iki boyutlu grafik üzerinde gösterilmiştir.
- AOP ile metot çağrıları izlenmiştir.
- Metotların çalışma süreleri ölçülmüştür.
- Hata kayıtları ve performans ölçümleri oluşturulmuştur.

---

## 🌱 Kullanılan Veri Seti: Iris

Iris veri seti, makine öğrenmesi ve veri analizi çalışmalarında sıklıkla kullanılan, üç farklı iris çiçeği türüne ait ölçümleri içeren bir veri setidir.

Veri setinde toplam **150 örnek** bulunmaktadır. Her çiçek dört sayısal özellik üzerinden tanımlanmıştır.

| Özellik | Açıklama |
|---|---|
| Sepal Length | Çanak yaprağın uzunluğu |
| Sepal Width | Çanak yaprağın genişliği |
| Petal Length | Taç yaprağın uzunluğu |
| Petal Width | Taç yaprağın genişliği |
| Species | Çiçeğin türü |

### 🌼 Çiçek Türleri

- Iris Setosa
- Iris Versicolor
- Iris Virginica

---

## 🧠 Temel Bileşen Analizi (PCA)

**Principal Component Analysis (PCA)**, çok sayıda değişken içeren verileri daha az sayıda değişkenle ifade etmek amacıyla kullanılan bir boyut azaltma yöntemidir.

PCA, veri içerisindeki değişkenlerin ilişkilerini değerlendirerek verideki önemli bilgileri mümkün olduğunca koruyan yeni bileşenler oluşturur.

Bu projede:

- Başlangıçta dört sayısal özellik kullanılmıştır.
- PCA uygulanarak veri iki temel bileşene dönüştürülmüştür.
- Dönüştürülen veriler iki boyutlu düzlemde görselleştirilmiştir.

### 📉 Boyut Azaltma

**4 Sayısal Özellik → 2 Temel Bileşen (PC1 ve PC2)**

Bu dönüşüm sayesinde verilerin dağılımı daha kolay incelenebilir ve türler arasındaki farklılıklar görsel olarak gözlemlenebilir.

---

## 📊 Veri Görselleştirme

PCA sonucunda elde edilen iki temel bileşen, Java Swing kullanılarak iki boyutlu saçılım grafiği (scatter plot) üzerinde gösterilmiştir.

Grafikte her çiçek türü farklı bir renk ile temsil edilmektedir:

- 🔴 Iris Setosa
- 🔵 Iris Versicolor
- 🟢 Iris Virginica

Görselleştirme sayesinde çiçek türlerinin dağılımları ve birbirlerinden ayrılma durumları incelenebilmektedir.

---

## ⚙️ AOP (Aspect-Oriented Programming)

Projede **Spring AOP** kullanılarak uygulamadaki servis metotlarının çalışması izlenmiştir.

AOP, uygulamanın temel iş mantığını değiştirmeden metotların çalışma süresi, çağrı durumu ve hata bilgileri gibi işlemlerin takip edilmesini sağlar.

### AOP ile Gerçekleştirilen İşlemler

- **Metot İzleme:** Servis metotlarının çağrılması takip edilir.
- **Zaman Ölçümü:** Metotların çalışma süreleri ölçülür.
- **Loglama:** Metot başlangıç, başarı ve hata durumları kayıt altına alınır.
- **Hata İzleme:** Çalışma sırasında oluşan hatalar yakalanır ve loglanır.
- **Performans Ölçümü:** Metot çağrı sayısı, toplam süre, ortalama süre ve hata sayısı hesaplanır.

### 📈 Performans Raporu

Uygulama çalıştırıldığında aşağıdaki ölçümler raporlanır:

- Toplam metot çağrısı
- Toplam çalışma süresi
- Ortalama metot çalışma süresi
- Toplam hata sayısı

---

### Uygulamanın İşlem Sırası

1. Veri setinin yüklenmesi
2. Verilerin doğrulanması
3. PCA işleminin uygulanması
4. Verilerin iki boyutlu grafikte gösterilmesi
5. Metot çağrılarının AOP ile izlenmesi
6. Performans raporunun oluşturulması

---

## 🎯 Projenin Kazanımları

Bu proje kapsamında:

- Java ile veri işleme uygulaması geliştirilmiştir.
- Veri doğrulama mekanizması oluşturulmuştur.
- PCA ile boyut azaltma yöntemi uygulanmıştır.
- Veri görselleştirme gerçekleştirilmiştir.
- Spring AOP kullanımı deneyimlenmiştir.
- Metot çalışma süreleri ölçülmüştür.
- Loglama ve hata izleme mekanizmaları uygulanmıştır.
- Performans metrikleri elde edilmiştir.

---

## 👩‍💻 Proje Hakkında

Bu çalışma, Java programlama dili kullanılarak PCA ile veri analizi ve Spring AOP ile performans izleme konularını bir araya getiren akademik bir projedir.

---

⭐ Projeyi incelemek için GitHub deposunu ziyaret edebilirsiniz.
