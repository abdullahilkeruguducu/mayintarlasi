# Mayın Tarlası Oyunu (MineSweeper) - Java

Bu Java projesi, metin tabanlı bir Mayın Tarlası oyununu gerçekleştirir. Oyun, kullanıcının bir matris üzerinde nokta seçmesini ve mayınlardan kaçınarak tüm noktaları keşfetmesini amaçlar.

## Kurallar

1. Oyun metin tabanlıdır ve `MineSweeper` sınıfı içerisinde tasarlanmıştır.
2. Matris boyutu (satır ve sütun sayısı) kullanıcı tarafından belirlenir.
3. Mayınlar, matrisin çeyreği kadar rastgele konumlandırılır.
4. Kullanıcı, matris üzerinde bir nokta seçer. Seçilen noktada mayın varsa oyun kaybedilir.
5. Mayın yoksa, seçilen noktanın etrafındaki konumlar incelenir ve etrafındaki mayınların sayısı ilgili noktaya yazılır.
6. Kullanıcı, hiçbir mayına basmadan tüm noktaları seçebilirse oyun kazanılır.

## Nasıl Çalıştırılır

1. Proje dosyalarını bir dizine indirin.
2. Terminal veya komut istemcisini açın ve proje dizinine gidin.
3. `javac Main.java` komutu ile projeyi derleyin.
4. `java Main` komutu ile oyunu başlatın.

## Oyun Kontrolleri

- Kullanıcıdan satır ve sütun değerlerini girmesini isteyen bir konsol çıktısı alacaksınız.
- Seçilen nokta sınırlar içindeyse, oyun devam eder. Mayına basılmışsa oyun kaybedilir.
- Eğer mayına basılmamışsa, seçilen noktanın etrafındaki konumlar incelenir ve etrafındaki mayınların sayısı ilgili noktaya yazılır.
- Oyun, kullanıcı tüm noktaları seçene kadar devam eder. Tüm noktalar seçildiğinde, oyun kazanılır.

![Kaybetme Senaryosu](https://hizliresim.com/jbzjwax)

![Kazanma Senaryosu](https://hizliresim.com/5we2h0p)

