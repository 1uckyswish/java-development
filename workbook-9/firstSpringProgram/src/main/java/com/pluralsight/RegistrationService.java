package com.pluralsight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {
    private final RegistrationDAO registrationDAO;

    @Autowired
    public RegistrationService(RegistrationDAO registrationDAO) {
        this.registrationDAO = registrationDAO;
    }
    public Long registerStudent(Student student) throws
            Exception {
        if (this.registrationDAO.findById(student.getId())!= null) {
            throw new Exception();
        }
        return registrationDAO.persistStudent(student);
    }
}
