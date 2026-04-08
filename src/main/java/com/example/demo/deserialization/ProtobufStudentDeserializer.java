package com.example.demo.deserialization;

import com.example.demo.proto.StudentMessages;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.TextFormat;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Deserializes {@link StudentMessages.Student} from binary protobuf bytes or from TextFormat (human-readable).
 */
public final class ProtobufStudentDeserializer {

    public StudentMessages.Student fromBinaryBytes(byte[] data) throws InvalidProtocolBufferException {
        return StudentMessages.Student.parseFrom(data);
    }

    public StudentMessages.Student fromBinaryClasspathResource(String resourcePath) throws IOException {
        try (InputStream in = ProtobufStudentDeserializer.class.getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            return StudentMessages.Student.parseFrom(in.readAllBytes());
        }
    }

    public StudentMessages.Student fromTextFormatClasspathResource(String resourcePath) throws IOException {
        try (InputStream in = ProtobufStudentDeserializer.class.getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            String text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            StudentMessages.Student.Builder builder = StudentMessages.Student.newBuilder();
            TextFormat.merge(text, builder);
            return builder.build();
        }
    }

    public StudentMessages.Student fromBinaryFile(String filePath) throws IOException {
        return StudentMessages.Student.parseFrom(java.nio.file.Files.readAllBytes(java.nio.file.Path.of(filePath)));
    }
}