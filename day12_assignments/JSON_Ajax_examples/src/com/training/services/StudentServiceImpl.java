package com.training.services;

import java.util.*;

import com.training.entity.Student;

public class StudentServiceImpl {

	
	private HashMap<Integer,Student> studentList=null;

	public StudentServiceImpl() {
		super();
		this.studentList = new HashMap();
	}
	
	public void init()
	{
		this.studentList.put(1, new Student(1,"ram"));
		this.studentList.put(2, new Student(2,"sam"));
		this.studentList.put(3, new Student(3,"raj"));
	}
	
	public Student findById(int key)
	{
		if(this.studentList.get(key)!=null)
		{
			return this.studentList.get(key);
		}
		else
		{
			throw new NoSuchElementException("not found");
		}
	}
	
	public Map findAll()
	{
		return this.studentList;
	}
}
