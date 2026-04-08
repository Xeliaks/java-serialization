package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudentTest {

    @Test
    void equalsAndHashCode_useAllFields() {
        Student a = new Student(101, "David", "Martinez", "david@edgerunners.com", "Santo Domingo", 1, false);
        Student b = new Student(101, "David", "Martinez", "david@edgerunners.com", "Santo Domingo", 1, false);
        
        // Different ID
        Student c = new Student(102, "David", "Martinez", "david@edgerunners.com", "Santo Domingo", 1, false);
        // Different boolean flag
        Student d = new Student(101, "David", "Martinez", "david@edgerunners.com", "Santo Domingo", 1, true);

        assertThat(a).isEqualTo(b).hasSameHashCodeAs(b);
        assertThat(a).isNotEqualTo(c);
        assertThat(a).isNotEqualTo(d);
    }

    @Test
    void toString_includesFields() {
        Student s = new Student(204, "Lucy", "Kushinada", "lucy@netrunners.com", "Arasaka", 3, true);
        
        assertThat(s.toString()).contains(
                "204", 
                "Lucy", 
                "Kushinada", 
                "lucy@netrunners.com", 
                "Arasaka", 
                "3", 
                "true"
        );
    }
}
