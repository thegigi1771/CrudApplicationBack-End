package com.example.SpringBootCrud;

import com.example.SpringBootCrud.Service.StudentService;
import com.example.SpringBootCrud.Domain.Students;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SpringBootCrudApplication {
	public static StudentService studentService;
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootCrudApplication.class, args);
		studentService = context.getBean(StudentService.class);
		while (true) {
			start();
		}
	}

	public static void start(String... args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an operation: ");
		String input = scanner.nextLine();
		System.out.println("You entered: " + input);

		switch (input) {
			case "c" -> create();
			case "r" -> read();
			case "u" -> update();
			case "d" -> delete();
		}
	}

	public static void create() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an operation: ");
		String[] input = scanner.nextLine().split(" ");

		Students students = new Students(Long.parseLong(input[0]), input[1], input[2], Integer.parseInt(input[3]));
		studentService.save(students);
	}

	public static void read() {
		List<Students> allStudents = studentService.findAll();
		System.out.println(allStudents);
	}

	public static void update() {
		Scanner scanner1 = new Scanner(System.in);
		System.out.print("Enter the id you want to update: ");
		Long input = scanner1.nextLong();
		Students student = studentService.findById(input);
		System.out.print(student);
		create();
	}

	public static void delete() {
		Scanner scanner2 = new Scanner(System.in);
		System.out.print("Enter the id you want to delete: ");
		Long input = scanner2.nextLong();
		studentService.delete(input);
	}
}
