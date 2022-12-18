package com.udemy.ltp.spring_boot_camp.grade_submission;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.grade_submission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class GradeSubmissionApp implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[] {
			new Student("Maynard Keenan", LocalDate.parse("1964-04-17")),
			new Student("Adam Jones", LocalDate.parse("1965-01-15")),
			new Student("Dan Carey", LocalDate.parse("1961-05-10")),
			new Student("Paul D'Amour", LocalDate.parse("1967-05-17")),
			new Student("Justin Chancellor", LocalDate.parse("1971-11-19"))
		};

		studentRepository.saveAll(Arrays.asList(students));
	}

	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApp.class, args);
	}
}