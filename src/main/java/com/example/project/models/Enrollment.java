package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="enrollments")
public class Enrollment {
    @Id
    private Integer studentId;
    @Id
    private Integer sectionId;
    private Float grade;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="studentId", referencedColumnName="studentId")
    @JsonIgnore
    private Student student;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="sectionId", referencedColumnName="sectionId")
    @JsonIgnore
    private com.example.project.models.Section section;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public com.example.project.models.Section getSection() {
        return section;
    }

    public void setSection(com.example.project.models.Section section) {
        this.section = section;
    }
}
