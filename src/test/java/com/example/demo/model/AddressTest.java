package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddressTest {

    @Test
    void equalsAndHashCode_useAllFields() {
        Address a = new Address("NUSA", "Night City", "Watson");
        Address b = new Address("NUSA", "Night City", "Watson");
        Address c = new Address("NUSA", "Night City", "Heywood");

        assertThat(a).isEqualTo(b).hasSameHashCodeAs(b);
        assertThat(a).isNotEqualTo(c);
    }

    @Test
    void toString_includesFields() {
        Address a = new Address("NUSA", "Night City", "Pacifica");
        
        assertThat(a.toString()).contains("NUSA", "Night City", "Pacifica");
    }
}