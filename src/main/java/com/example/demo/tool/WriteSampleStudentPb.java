package com.example.demo.tool;

import com.example.demo.proto.StudentMessages;

import java.nio.file.Files;
import java.nio.file.Path;

public final class WriteSampleStudentPb {

    public static void main(String[] args) throws Exception {
        StudentMessages.Address address = StudentMessages.Address.newBuilder()
                .setCountry("NUSA")
                .setCity("Night City")
                .setStreet("Megabuilding H4")
                .build();

        StudentMessages.Student student = StudentMessages.Student.newBuilder()
                .setId(101)
                .setFirstName("David")
                .setLastName("Martinez")
                .setEmail("david@edgerunners.com")
                .setGroup("Santo Domingo")
                .setYearOfStudy(1)
                .setActive(false)
                .setAddress(address)
                .addCourses("Sandevistan Operations")
                .addCourses("Cyberware Maintenance")
                .addCourses("Netrunning 101")
                .build();
        
        Path out = Path.of("src/main/resources/samples/student.pb");
        Files.createDirectories(out.getParent()); 
        Files.write(out, student.toByteArray());
        System.out.println("Wrote " + out.toAbsolutePath() + " (" + student.toByteArray().length + " bytes)");
    }
}