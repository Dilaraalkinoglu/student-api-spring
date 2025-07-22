package com.dilaraalk.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilaraalk.dto.DtoStudent;
import com.dilaraalk.dto.DtoStudentIU;
import com.dilaraalk.entites.Student;
import com.dilaraalk.repository.StudentRepository;
import com.dilaraalk.services.IStudentService;

@Service  // Bu sınıf bir service bileşenidir (Spring tarafından yönetilir)
public class StudentServiceImpl implements IStudentService {

//	Spring’in bağımlılıkları otomatik enjekte etmesini sağlar.
//	StudentRepository nesnesi Spring tarafından verilir, sen new kullanmazsın.
    @Autowired
    private StudentRepository studentRepository;

    // Yeni öğrenci kaydet
    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        DtoStudent response = new DtoStudent();
        Student student = new Student();

        // DTO'dan Entity'ye kopyalama
        BeanUtils.copyProperties(dtoStudentIU, student);

        // Veritabanına kaydet
        Student dbStudent = studentRepository.save(student);

        // Kaydedilen entity'den DTO'ya dönüş
        BeanUtils.copyProperties(dbStudent, response);

        return response;
    }

    // Tüm öğrencileri getir
    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllStudents();

        for (Student student : studentList) {
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    // ID ile öğrenci getir
    @Override
    public DtoStudent getStudentById(Integer id) {
        DtoStudent dto = new DtoStudent();
        Optional<Student> optional = studentRepository.findStudentById(id);

        if (optional.isPresent()) {
            Student dbStudent = optional.get();
            BeanUtils.copyProperties(dbStudent, dto);
        }

        return dto;
    }

    // Öğrenciyi sil
    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            studentRepository.delete(optional.get());
        }
    }

    // Öğrenci güncelle
    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        DtoStudent dto = new DtoStudent();
        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            Student dbStudent = optional.get();

            // Gelen DTO verilerini güncelle
            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

            // Güncellenmiş veriyi veritabanına kaydet
            Student updatedStudent = studentRepository.save(dbStudent);

            // Güncellenen veriyi DTO'ya çevir
            BeanUtils.copyProperties(updatedStudent, dto);

            return dto;
        }

        return null;
    }
}
