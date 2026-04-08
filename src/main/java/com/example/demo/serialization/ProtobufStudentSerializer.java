package com.example.demo.serialization;

import com.example.demo.proto.StudentMessages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ProtobufStudentSerializer {

    public void toBinaryFile(StudentMessages.Student student, String filePath) throws IOException {
        Path out = Path.of(filePath);
        Files.createDirectories(out.getParent());
        Files.write(out, student.toByteArray());
    }
}