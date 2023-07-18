package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student alin=new Student(1L,"Alin",21,"Salutare", LocalDate.of(2000, Month.JANUARY,15),"alin24@yahoo.com");
            Student gabriel=new Student("Gabriel",23,"Buna ziua", LocalDate.of(2001, Month.AUGUST,15),"gabriel32@yahoo.com");
            studentRepository.saveAll(List.of(alin,gabriel));
        };
    }
}