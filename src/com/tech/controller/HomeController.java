package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.modal.Student;
import com.tech.servicei.ServiceI;

@Controller
public class HomeController {

	@Autowired
	ServiceI si;

	@RequestMapping("/reg")
	public String register(@ModelAttribute Student stu) {

		int id = si.saveData(stu);

		if (id > 0) {
			return "success";
		} else {
			return "regiter";
		}

	}

	@RequestMapping("/log")
	public String getData(@RequestParam("user") String user, @RequestParam("pass") String pass, Model m) {
		if (user.equals("admin") && pass.equals("bn09")) {
			List<Student> students = si.getRecords();
			m.addAttribute("data", students);

			return "ViewPage";

		}

		else if (user.equals(user) && pass.equals(pass)) {
			List<Student> singleRecord = si.getSingleRecord(user, pass);

			m.addAttribute("data", singleRecord);

			return "singleRecord";
		}

		return pass;
	}

	@RequestMapping("/delete")
	public String deletedata(@RequestParam("rd") int sid, Model m) {
		si.deleteRecord(sid);
		List<Student> stu = si.getRecords();
		m.addAttribute("data", stu);
		return "ViewPage";

	}

	@RequestMapping("/edit")
	public String editData(@RequestParam("rd") int sid, Model m) {
		Student editRecord = si.editRecord(sid);

		m.addAttribute("data", editRecord);
		return "update";
	}

	@RequestMapping("/update")
	public String updateData(@ModelAttribute Student stu, Model m) {
		si.updateRecord(stu);

		List<Student> records = si.getRecords();
		m.addAttribute("data", records);
		return "ViewPage";
	}
}
