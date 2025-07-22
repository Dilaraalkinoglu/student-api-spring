package com.dilaraalk.controller;

import java.util.List;

import com.dilaraalk.dto.DtoStudent;
import com.dilaraalk.dto.DtoStudentIU;

// Bu interface, öğrenciye dair controller işlemlerinin şablonunu oluşturur
public interface IStudentController {

    // Yeni öğrenci kaydı
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    // Tüm öğrencileri listeleme
    public List<DtoStudent> getAllStudents();

    // ID ile öğrenci getirme
    public DtoStudent getStudentById(Integer id);

    // ID ile öğrenci silme
    public void deleteStudent(Integer id);

    // ID ile öğrenci güncelleme
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
