package com.dilaraalk.services;

import java.util.List;

import com.dilaraalk.dto.DtoStudent;
import com.dilaraalk.dto.DtoStudentIU;

// Bu arayüz, öğrenci işlemlerinin iş mantığı kısmını tanımlar (sadece ne yapılacağını belirtir)
public interface IStudentService {

    // Yeni öğrenci kaydı
    public DtoStudent saveStudent(DtoStudentIU student);

    // Tüm öğrencileri getir
    public List<DtoStudent> getAllStudents();

    // ID ile öğrenci getir
    public DtoStudent getStudentById(Integer id);

    // Öğrenci sil
    public void deleteStudent(Integer id);

    // Öğrenci güncelle
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
