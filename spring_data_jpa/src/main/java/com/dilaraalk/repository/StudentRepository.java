package com.dilaraalk.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dilaraalk.entites.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	// HQL : sınıfın ismi ve değişken isimleri kullanılarak sorgular yazılır
//	@Query(value = "from Student" , nativeQuery = false)
//	List<Student> findAllStudents();
	
	// SQL : tablo ismi ve tablo içerisindeki kolon isimleri ile sorgular yazılır
	// 	@Query(value = "select * from student.student where first_name=" , nativeQuery = true) fisrtname ile aramak için 
//	@Query(value = "select * from student.student" , nativeQuery = true)
//	List<Student> findAllStudents();
	
	@Query(value = "from Student" , nativeQuery = false)
	List<Student> findAllStudents();
	
	@Query(value = "from Student s WHERE s.id= :studentId")
	Optional<Student> findStudentById(Integer studentId);
	
	
}
