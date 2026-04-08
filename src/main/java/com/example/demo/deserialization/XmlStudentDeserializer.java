package com.example.demo.deserialization;

import com.example.demo.model.Student;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.InputStream;

public final class XmlStudentDeserializer {

    private final XmlMapper mapper = new XmlMapper();

    public Student fromClasspathResource(String resourcePath) throws IOException {
        try (InputStream in = XmlStudentDeserializer.class.getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            return mapper.readValue(in, Student.class);
        }
    }

    public Student fromFile(String filePath) throws IOException {
        return mapper.readValue(new java.io.File(filePath), Student.class);
    }
}