package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Student;

public interface StudentMapper {

	public List<Object> queryStudent();
	public void addStudent(Student student);
	public Student queryStudentById(@Param("id")String id);
	public void deleteStudent(@Param("id")String id);
}
