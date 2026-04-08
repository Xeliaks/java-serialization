package com.example.demo.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudentTest {

    @Test
    void equalsAndHashCode_useAllFieldsIncludingNestedAndCollections() {
        Address addr1 = new Address("NUSA", "Night City", "Megabuilding H4");
        Address addr2 = new Address("NUSA", "Night City", "Megabuilding H4");
        Address addrDifferent = new Address("Japan", "Tokyo", "Chiyoda");

        List<String> courses1 = List.of("Netrunning 101", "Cyberware Maintenance");
        List<String> courses2 = List.of("Netrunning 101", "Cyberware Maintenance");
        List<String> coursesDifferent = List.of("Edgerunning 101");

        Student a = new Student(101, "David", "M", "d@e.com", "Group", 1, false, addr1, courses1);
        Student b = new Student(101, "David", "M", "d@e.com", "Group", 1, false, addr2, courses2);
        
        // Different Address
        Student c = new Student(101, "David", "M", "d@e.com", "Group", 1, false, addrDifferent, courses1);
        
        // Different Courses
        Student d = new Student(101, "David", "M", "d@e.com", "Group", 1, false, addr1, coursesDifferent);

        assertThat(a).isEqualTo(b).hasSameHashCodeAs(b); // Deep equality check passes
        assertThat(a).isNotEqualTo(c);
        assertThat(a).isNotEqualTo(d);
    }

    @Test
    void toString_includesNestedFields() {
        Address addr = new Address("NUSA", "Night City", "Megabuilding H4");
        Student s = new Student(204, "Lucy", "Kushinada", "lucy@netrunners.com", "Arasaka", 3, true, addr, List.of("Deep Dive"));
        
        assertThat(s.toString()).contains(
                "204", 
                "Lucy", 
                "Night City", // From nested Address
                "Deep Dive"   // From list
        );
    }
}
