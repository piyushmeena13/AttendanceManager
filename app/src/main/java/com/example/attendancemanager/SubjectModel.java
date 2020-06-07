package com.example.attendancemanager;

public class SubjectModel {

    String id,subject,classesAttended,totalClasses;

    public SubjectModel(String id, String subject, String classesAttended, String totalClasses) {
        this.id = id;
        this.subject = subject;
        this.classesAttended = classesAttended;
        this.totalClasses = totalClasses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassesAttended() {
        return classesAttended;
    }

    public void setClassesAttended(String classesAttended) {
        this.classesAttended = classesAttended;
    }

    public String getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(String totalClasses) {
        this.totalClasses = totalClasses;
    }
}
