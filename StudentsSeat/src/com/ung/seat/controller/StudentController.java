package com.ung.seat.controller;

import com.ung.seat.model.dao.StudentDAO;

public class StudentController {
	private String studentArr[];
	private StudentDAO sd=new StudentDAO(); 
	public StudentController() {
		studentArr=sd.getStudent();
	}
	public String[] StudentList() {
		return studentArr;
	}
	 
	public void resultRecord(String[] result){
		sd.recordResult(result);
	} 
	public String[] recordView() {
		return sd.recordView();
	}
	
}
