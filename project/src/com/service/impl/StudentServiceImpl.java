package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public List<Object> queryStudent() {
		return studentMapper.queryStudent();
	}

	@Override
	public Map<String, Object> addStudent(Student student) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			studentMapper.addStudent(student);
			map.put("status", "200");
			map.put("message", "添加成功");
		} catch (Exception e) {
			map.put("status", "500");
			map.put("message", "添加失败");
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Student queryStudentById(String id) {
		return studentMapper.queryStudentById(id);
	}

	@Override
	public Map<String, Object> deleteStudent(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			studentMapper.deleteStudent(id);
			map.put("status", "200");
			map.put("message", "删除成功");
		} catch (Exception e) {
			map.put("status", "500");
			map.put("message", "删除失败");
			e.printStackTrace();
		}
		return map;
	}

}
