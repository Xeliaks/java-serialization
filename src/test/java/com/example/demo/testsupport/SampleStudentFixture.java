package com.example.demo.testsupport;

import com.example.demo.model.Student;
import com.example.demo.proto.StudentMessages;

public final class SampleStudentFixture {

    private SampleStudentFixture() {
        // Utility class
    }

    public static Student expectedPojo() {
        return new Student(
                101, 
                "David", 
                "Martinez", 
                "david@edgerunners.com", 
                "Santo Domingo", 
                1, 
                false
        );
    }

    public static StudentMessages.Student expectedProto() {
        return StudentMessages.Student.newBuilder()
                .setId(101)
                .setFirstName("David")
                .setLastName("Martinez")
                .setEmail("david@edgerunners.com")
                .setGroup("Santo Domingo")
                .setYearOfStudy(1)
                .setActive(false)
                .build();
    }
}