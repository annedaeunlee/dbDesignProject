package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sections")
public class Section {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer CRN;
  private String professor;
  private String lectureTime;
  private Integer capacity;
  private Integer capacityRemaining;
  private String campus;

  @ManyToOne
  @JsonIgnore
  private Course course;

  @Transient
  public Integer getCourseId() {
    return course.getIdcourse();
  }

  @Transient
  public String getCourseTitle() {
    return course.getTitle();
  }

  @OneToMany(mappedBy="section")
  private List<Enrollment> students;

  public void addStudent(Student student, Float grade) {
    Enrollment enrollment = new Enrollment();
    enrollment.setStudent(student);
    enrollment.setSection(this);
    enrollment.setStudentId(student.getStudentId());
    enrollment.setSectionId(this.getCRN());
    enrollment.setGrade(grade);
    if(this.students == null) {
      this.students = new ArrayList<>();
    }
    this.students.add(enrollment);
    student.getSections().add(enrollment);
  }

  public Integer getCRN() {
    return CRN;
  }

  public void setCRN(Integer CRN) {
    this.CRN = CRN;
  }

  public String getProfessor() {
    return professor;
  }

  public void setProfessor(String professor) {
    this.professor = professor;
  }

  public String getLectureTime() {
    return lectureTime;
  }

  public void setLectureTime(String lectureTime) {
    this.lectureTime = lectureTime;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public Integer getCapacityRemaining() {
    return capacityRemaining;
  }

  public void setCapacityRemaining(Integer capacityRemaining) {
    this.capacityRemaining = capacityRemaining;
  }

  public String getCampus() {
    return campus;
  }

  public void setCampus(String campus) {
    this.campus = campus;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public List<Enrollment> getStudents() {
    return students;
  }

  public void setStudents(List<Enrollment> students) {
    this.students = students;
  }
}
