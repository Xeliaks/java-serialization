package com.example.demo.tool;

import com.example.demo.proto.StudentMessages;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Writes {@code src/main/resources/samples/student.pb} from the same values as the JSON/XML/TextFormat samples.
 * Run: {@code mvn -q compile exec:java -Dexec.mainClass=com.example.demo.tool.WriteSampleStudentPb}
 */
public final class WriteSampleStudentPb {

    public static void main(String[] args) throws Exception {
        StudentMessages.Student student = StudentMessages.Student.newBuilder()
                .setId(101)
                .setFirstName("David")
                .setLastName("Martinez")
                .setEmail("david@edgerunners.com")
                .setGroup("Santo Domingo")
                .setYearOfStudy(1)
                .setActive(false)
                .build();
        
        Path out = Path.of("src/main/resources/samples/student.pb");
        Files.createDirectories(out.getParent()); 
        Files.write(out, student.toByteArray());
        System.out.println("Wrote " + out.toAbsolutePath() + " (" + student.toByteArray().length + " bytes)");
    }
}