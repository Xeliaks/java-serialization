package com.example.demo.serialization;

import com.example.demo.model.User;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class XmlUserSerializer {
    private final XmlMapper mapper = new XmlMapper();

    public void toFile(User user, String filePath) throws IOException {
        File file = new File(filePath);
        Files.createDirectories(file.getParentFile().toPath());
        mapper.writeValue(file, user);
    }
}