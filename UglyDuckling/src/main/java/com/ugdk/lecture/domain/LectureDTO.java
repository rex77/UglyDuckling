package com.ugdk.lecture.domain;

public class LectureDTO {
	private int idx;
	private String title;
	private String lecture;
	private String quiz;
	private String quiz2;
	private String goal;
	private String assignment;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLecture() {
		return lecture;
	}
	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	public String getQuiz() {
		return quiz;
	}
	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}
	public String getQuiz2() {
		return quiz2;
	}
	public void setQuiz2(String quiz2) {
		this.quiz2 = quiz2;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
}
