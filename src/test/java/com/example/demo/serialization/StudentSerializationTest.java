package com.example.demo.serialization;

import com.example.demo.deserialization.JsonStudentDeserializer;
import com.example.demo.deserialization.ProtobufStudentDeserializer;
import com.example.demo.deserialization.XmlStudentDeserializer;
import com.example.demo.model.Student;
import com.example.demo.proto.StudentMessages;
import com.example.demo.testsupport.SampleStudentFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class StudentSerializationTest {

    @Test
    void json_roundTrip(@TempDir Path tempDir) throws Exception {
        Student original = SampleStudentFixture.expectedPojo();
        String path = tempDir.resolve("student.json").toString();

        new JsonStudentSerializer().toFile(original, path);
        Student deserialized = new JsonStudentDeserializer().fromFile(path);

        assertThat(deserialized).isEqualTo(original);
    }

    @Test
    void xml_roundTrip(@TempDir Path tempDir) throws Exception {
        Student original = SampleStudentFixture.expectedPojo();
        String path = tempDir.resolve("student.xml").toString();

        new XmlStudentSerializer().toFile(original, path);
        Student deserialized = new XmlStudentDeserializer().fromFile(path);

        assertThat(deserialized).isEqualTo(original);
    }

    @Test
    void protobuf_roundTrip(@TempDir Path tempDir) throws Exception {
        StudentMessages.Student original = SampleStudentFixture.expectedProto();
        String path = tempDir.resolve("student.pb").toString();

        new ProtobufStudentSerializer().toBinaryFile(original, path);
        StudentMessages.Student deserialized = new ProtobufStudentDeserializer().fromBinaryFile(path);

        assertThat(deserialized).isEqualTo(original);
    }
}