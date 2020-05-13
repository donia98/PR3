/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stdapp;

/**
 *
 * @author Donia Hassona
 */
class Student {

    private Integer stdId;
    private String stdName;
    private String stdMajor;
    private Double stdGrade;

    public Student() {
    }

    public Student(Integer stdId, String stdName, String stdMajor, Double stdGrade) {
        this.stdId = stdId;
        this.stdName = stdName;
        this.stdMajor = stdMajor;
        this.stdGrade = stdGrade;
    }

    public Integer getStdId() {
        return stdId;
    }

    public void setStdId(Integer stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdMajor() {
        return stdMajor;
    }

    public void setStdMajor(String stdMajor) {
        this.stdMajor = stdMajor;
    }

    public Double getStdGrade() {
        return stdGrade;
    }

    public void setStdGrade(Double stdGrade) {
        this.stdGrade = stdGrade;
    }

    @Override
    public String toString() {
        return "Student{" + "stdId=" + stdId + ", stdName=" + stdName + ", stdMajor=" + stdMajor + ", stdGrade=" + stdGrade + '}';
    }

}
