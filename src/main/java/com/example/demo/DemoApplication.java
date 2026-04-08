package com.example.demo;

import com.example.demo.deserialization.*;
import com.example.demo.serialization.*;
import com.example.demo.model.User;
import com.example.demo.proto.UserMessages;
import com.example.demo.model.Student;
import com.example.demo.proto.StudentMessages;

public final class DemoApplication {

    public static void main(String[] args) throws Exception {
        System.out.println("--- Processing User ---");
        processUser();

        System.out.println("\n--- Processing Student ---");
        processStudent();
    }

    private static void processUser() throws Exception {
        JsonUserDeserializer jsonDeserializer = new JsonUserDeserializer();
        User pojo = jsonDeserializer.fromClasspathResource("/samples/user.json");
        System.out.println("Read POJO: " + pojo);

        UserMessages.User protoObj = UserMessages.User.newBuilder()
                .setId(pojo.getId())
                .setName(pojo.getName())
                .setEmail(pojo.getEmail())
                .build();

        String outDir = "target/output/";
        
        new JsonUserSerializer().toFile(pojo, outDir + "user_out.json");
        System.out.println("Wrote -> " + outDir + "user_out.json");

        new XmlUserSerializer().toFile(pojo, outDir + "user_out.xml");
        System.out.println("Wrote -> " + outDir + "user_out.xml");

        new ProtobufUserSerializer().toBinaryFile(protoObj, outDir + "user_out.pb");
        System.out.println("Wrote -> " + outDir + "user_out.pb");
    }

    private static void processStudent() throws Exception {

        JsonStudentDeserializer jsonDeserializer = new JsonStudentDeserializer();
        Student pojo = jsonDeserializer.fromClasspathResource("/samples/student.json");
        System.out.println("Read POJO: " + pojo);


        StudentMessages.Address protoAddress = StudentMessages.Address.newBuilder()
                .setCountry(pojo.getAddress().getCountry())
                .setCity(pojo.getAddress().getCity())
                .setStreet(pojo.getAddress().getStreet())
                .build();

        StudentMessages.Student protoObj = StudentMessages.Student.newBuilder()
                .setId(pojo.getId())
                .setFirstName(pojo.getFirstName())
                .setLastName(pojo.getLastName())
                .setEmail(pojo.getEmail())
                .setGroup(pojo.getGroup())
                .setYearOfStudy(pojo.getYearOfStudy())
                .setActive(pojo.isActive())
                .setAddress(protoAddress)
                .addAllCourses(pojo.getCourses()) // Handles the List<String>
                .build();


        String outDir = "target/output/";

        new JsonStudentSerializer().toFile(pojo, outDir + "student_out.json");
        System.out.println("Wrote -> " + outDir + "student_out.json");

        new XmlStudentSerializer().toFile(pojo, outDir + "student_out.xml");
        System.out.println("Wrote -> " + outDir + "student_out.xml");

        new ProtobufStudentSerializer().toBinaryFile(protoObj, outDir + "student_out.pb");
        System.out.println("Wrote -> " + outDir + "student_out.pb");
    }
}
