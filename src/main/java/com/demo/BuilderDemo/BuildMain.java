package com.demo.BuilderDemo;

public class BuildMain {
	public static void main(String[] args) {
		Person.Builder builder=new Person.Builder();
		Person person=builder
				.setName("张三")
				.create();
		System.out.println(person);
	}
}
