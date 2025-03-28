package edu.du.sb0320_thymeleaf.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@ToString
@Table(name = "myuser")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String email;
    private LocalDateTime createdAt;

    @PrePersist
    // entity 객체가 entity manager에 들어가 저장되기 전 실행
    protected void onCreate() { createdAt = LocalDateTime.now(); }
}
