package com.dilaraalk.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dilaraalk.controller.IStudentController;
import com.dilaraalk.dto.DtoStudent;
import com.dilaraalk.dto.DtoStudentIU;
import com.dilaraalk.services.IStudentService;

import jakarta.validation.Valid;

@RestController  // Bu sınıf bir REST Controller'dır, HTTP isteklerine yanıt verir
@RequestMapping("/rest/api/student")  // Tüm endpoint'ler bu path üzerinden başlar
public class StudentControllerImpl implements IStudentController {

    // Service katmanı çağrılır (iş mantığı burada çalışır)
    @Autowired
    private IStudentService studentService;

    // Yeni öğrenci kaydı
    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
        return studentService.saveStudent(dtoStudentIU);
    }

    // Tüm öğrencileri listele
    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    // ID'ye göre öğrenci getir
    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    // Öğrenciyi sil
    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudent(id);
    }

    // Öğrenci bilgilerini güncelle
    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.updateStudent(id, dtoStudentIU);
    }
}
