package com.example.demo.serialization;

import com.example.demo.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class JsonStudentSerializer {
    private final ObjectMapper mapper = new ObjectMapper();

    public void toFile(Student student, String filePath) throws IOException {
        File file = new File(filePath);
        Files.createDirectories(file.getParentFile().toPath());
        mapper.writeValue(file, student);
    }
}