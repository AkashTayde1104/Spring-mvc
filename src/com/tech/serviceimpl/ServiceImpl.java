package com.tech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.daoi.DaoI;
import com.tech.modal.Student;
import com.tech.servicei.ServiceI;

@Service
public class ServiceImpl implements ServiceI {

	@Autowired
	DaoI di;

	@Override
	public int saveData(Student stu) {

		return di.saveData(stu);
	}

	@Override
	public List<Student> getRecords() {

		return di.getRecords();
	}

	@Override
	public List<Student> getSingleRecord(String user, String pass) {

		return di.getSingleRecord(user, pass);
	}

	@Override
	public void deleteRecord(int sid) {
		di.deleteRecord(sid);

	}

	@Override
	public Student editRecord(int sid) {

		return di.editRecord(sid);
	}

	@Override
	public String updateRecord(Student stu) {

		return di.updateRecord(stu);
	}

}
