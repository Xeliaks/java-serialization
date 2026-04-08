package com.example.demo.testsupport;

import com.example.demo.model.Address;
import com.example.demo.model.Student;
import com.example.demo.proto.StudentMessages;

import java.util.List;

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
                false,
                new Address("NUSA", "Night City", "Megabuilding H4"),
                List.of("Sandevistan Operations", "Cyberware Maintenance", "Netrunning 101")
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
                .setAddress(StudentMessages.Address.newBuilder()
                        .setCountry("NUSA")
                        .setCity("Night City")
                        .setStreet("Megabuilding H4")
                        .build())
                .addCourses("Sandevistan Operations")
                .addCourses("Cyberware Maintenance")
                .addCourses("Netrunning 101")
                .build();
    }
}