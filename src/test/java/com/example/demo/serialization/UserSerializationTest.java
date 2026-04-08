package com.example.demo.serialization;

import com.example.demo.deserialization.JsonUserDeserializer;
import com.example.demo.deserialization.ProtobufUserDeserializer;
import com.example.demo.deserialization.XmlUserDeserializer;
import com.example.demo.model.User;
import com.example.demo.proto.UserMessages;
import com.example.demo.testsupport.SampleUserFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class UserSerializationTest {

    @Test
    void json_roundTrip(@TempDir Path tempDir) throws Exception {
        User original = SampleUserFixture.expectedPojo();
        String path = tempDir.resolve("user.json").toString();

        new JsonUserSerializer().toFile(original, path);
        User deserialized = new JsonUserDeserializer().fromFile(path);

        assertThat(deserialized).isEqualTo(original);
    }

    @Test
    void xml_roundTrip(@TempDir Path tempDir) throws Exception {
        User original = SampleUserFixture.expectedPojo();
        String path = tempDir.resolve("user.xml").toString();

        new XmlUserSerializer().toFile(original, path);
        User deserialized = new XmlUserDeserializer().fromFile(path);

        assertThat(deserialized).isEqualTo(original);
    }

    @Test
    void protobuf_roundTrip(@TempDir Path tempDir) throws Exception {
        UserMessages.User original = SampleUserFixture.expectedProto();
        String path = tempDir.resolve("user.pb").toString();

        new ProtobufUserSerializer().toBinaryFile(original, path);
        UserMessages.User deserialized = new ProtobufUserDeserializer().fromBinaryFile(path);

        assertThat(deserialized).isEqualTo(original);
    }
}