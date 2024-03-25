package com.tech.daoi;

import java.util.List;

import com.tech.modal.Student;

public interface DaoI {

	public int saveData(Student stu);
	
	public List<Student> getRecords();
	
	public List<Student> getSingleRecord(String user, String pass);
	
	public void deleteRecord(int sid);
	
	public Student editRecord(int sid);
	
	public String updateRecord(Student stu);

}

