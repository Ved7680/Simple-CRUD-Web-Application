package com.royal.bean;

public class StudentBean {
	private String name;
	private int std;
	private int roll_no;
	private int marks;
	
	public StudentBean() {}
	
	public StudentBean(String name, int std, int roll_no, int marks) {
		this.name = name;
		this.std = std;
		this.roll_no = roll_no;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
}
