# student-api-spring
# Student API (Spring Boot - Learning Project)

Bu proje, Spring Boot kullanılarak geliştirilmiş basit bir öğrenci API projesidir. Temel CRUD işlemleri yapılabilmektedir.

## 🔧 Kullanılan Teknolojiler

- Java 17
- Spring Boot
- Spring Data JPA
- H2 / PostgreSQL (hangisini kullanıyorsan)
- Lombok
- Maven

## 📁 Proje Yapısı

- `entities/Student`: Öğrenci varlık sınıfı
- `dto/DtoStudent`: Veri transfer nesnesi (Data Transfer Object)
- `services/IStudentService`: Servis katmanının arayüzü
- `repository/StudentRepository`: JPA veri erişim katmanı
- `controller/StudentController`: REST API uç noktaları (eğer varsa)

## ▶️ Uygulamayı Çalıştırma

```bash
mvn spring-boot:run
