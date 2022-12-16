package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Grade;

import java.util.List;

public interface GradeService {
	Grade getGrade(Long studentId, Long courseId);
	Grade saveGrade(Grade grade, Long studentId, Long courseId);
	Grade updateGrade(String score, Long studentId, Long courseId);
	void deleteGrade(Long studentId, Long courseId);
	List<Grade> getStudentGrades(Long studentId);
	List<Grade> getCourseGrades(Long courseId);
	List<Grade> getAllGrades();
}
