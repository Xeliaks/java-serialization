package com.example.demo.deserialization;

import com.example.demo.model.Student;
import com.example.demo.testsupport.SampleStudentFixture;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JsonStudentDeserializerTest {

    private final JsonStudentDeserializer deserializer = new JsonStudentDeserializer();

    @Test
    void fromClasspathResource_readsSampleJson() throws IOException {
        Student student = deserializer.fromClasspathResource("/samples/student.json");
        assertThat(student).isEqualTo(SampleStudentFixture.expectedPojo());
    }

    @Test
    void fromClasspathResource_missingResource_throws() {
        assertThatThrownBy(() -> deserializer.fromClasspathResource("/samples/does-not-exist.json"))
                .isInstanceOf(IOException.class)
                .hasMessageContaining("Resource not found");
    }
}