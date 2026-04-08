package com.example.demo.serialization;

import com.example.demo.proto.UserMessages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ProtobufUserSerializer {

    public void toBinaryFile(UserMessages.User user, String filePath) throws IOException {
        Path out = Path.of(filePath);
        Files.createDirectories(out.getParent());
        Files.write(out, user.toByteArray());
    }
}