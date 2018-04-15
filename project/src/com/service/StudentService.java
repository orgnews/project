package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.Student;

public interface StudentService {
	public Map<String,Object> addStudent(Student student);
	public List<Object> queryStudent();
	public Student queryStudentById(String id);
	public Map<String,Object> deleteStudent(String id);
}
