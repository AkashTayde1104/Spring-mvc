package com.tech.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.daoi.DaoI;
import com.tech.modal.Student;

@Repository
public class DaoImpl implements DaoI {

	@Autowired
	SessionFactory sf;

	@Override
	public int saveData(Student stu) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int id = (int) session.save(stu);
		tx.commit();
		session.close();

		return id;
	}

	@Override
	public List<Student> getRecords() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Student");
		List stuList = q.getResultList();
		return stuList;
	}

	@Override
	public List<Student> getSingleRecord(String user, String pass) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Student where user=:us and pass=:pass");
		q.setParameter("us", user);
		q.setParameter("pass", pass);
		List rs = q.getResultList();
		return rs;
	}

	@Override
	public void deleteRecord(int sid) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Student stu = session.get(Student.class, sid);
		session.delete(stu);
		tx.commit();
		session.close();
	}

	@Override
	public Student editRecord(int sid) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Student stu = session.get(Student.class, sid);
		return stu;
	}

	@Override
	public String updateRecord(Student stu) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(stu);
		tx.commit();
		return null;
	}

}
