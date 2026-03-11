package com.example.studentinfo.model;

public class StudentInfo {
	
	private int rollNo;
	private String name;
	private float mark;
	
	public StudentInfo(int rollNo, String name, float mark) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.mark = mark;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	

}
