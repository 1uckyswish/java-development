package com.pluralsight;


public interface RegistrationDAO {
    public Long persistStudent(Student student);
    public Student findById(Long id);
}
