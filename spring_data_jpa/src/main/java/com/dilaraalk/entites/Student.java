package com.dilaraalk.entites;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat; // Tarih formatını JSON cevabında düzenlemek için

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Bu sınıf bir veritabanı tablosunu temsil eder
@Entity

// Bu entity, veritabanında "student" adlı tabloya karşılık gelir
@Table(name = "student")

// Lombok anotasyonu: getter, setter, toString, equals, hashCode hepsini otomatik oluşturur
@Data

// Parametresiz constructor
@NoArgsConstructor

// Tüm field'ları içeren constructor
@AllArgsConstructor
public class Student {

    // Bu alan primary key (birincil anahtar) olarak işaretlendi
    @Id

    // Veritabanı sütun adı "id" olacak
    @Column(name = "id")

    // ID otomatik olarak veritabanı tarafından oluşturulacak (AUTO_INCREMENT gibi)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // first_name adlı sütun olacak ve boş bırakılamaz (nullable = false)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    // last_name adlı sütun olacak ve boş bırakılamaz
    @Column(name = "last_name", nullable = false)
    private String lastName;

    // Doğum tarihi bilgisi, "dd-MM-yyyy" formatında JSON çıktısına yazılacak
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "birth_of_date", nullable = false)
    private Date birthOfDate;
}
