package edu.du.sb0320_thymeleaf.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SampleDto {
    private int id;
    private String name;
    private int age;
    private String email;
    private LocalDateTime createdAt;
}
