package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Student;
import com.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addStudent(Student student){
		Map<String,Object> map = new HashMap<String,Object>();
		map = studentService.addStudent(student);
		return map;
	}
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public List<Object> queryStudent(){
		return studentService.queryStudent();
	}
	
	@RequestMapping(value="/query/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Student queryStudentById(@PathVariable("id") String id){
		return studentService.queryStudentById(id);
	}
	
	@RequestMapping(value="/deleteStudent/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteStudentById(@PathVariable("id") String id){
		Map<String,Object> map = new HashMap<String,Object>();
		map = studentService.deleteStudent(id);
		return map;
	}
}
