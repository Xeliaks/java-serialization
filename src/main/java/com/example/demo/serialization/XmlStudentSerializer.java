package com.example.demo.serialization;

import com.example.demo.model.Student;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class XmlStudentSerializer {
    private final XmlMapper mapper = new XmlMapper();

    public void toFile(Student student, String filePath) throws IOException {
        File file = new File(filePath);
        Files.createDirectories(file.getParentFile().toPath());
        mapper.writeValue(file, student);
    }
}