package com.example.demo.deserialization;

import com.example.demo.model.Student;
import com.example.demo.testsupport.SampleStudentFixture;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class XmlStudentDeserializerTest {

    private final XmlStudentDeserializer deserializer = new XmlStudentDeserializer();

    @Test
    void fromClasspathResource_readsSampleXml() throws IOException {
        Student student = deserializer.fromClasspathResource("/samples/student.xml");
        assertThat(student).isEqualTo(SampleStudentFixture.expectedPojo());
    }

    @Test
    void fromClasspathResource_missingResource_throws() {
        assertThatThrownBy(() -> deserializer.fromClasspathResource("/samples/does-not-exist.xml"))
                .isInstanceOf(IOException.class)
                .hasMessageContaining("Resource not found");
    }
}