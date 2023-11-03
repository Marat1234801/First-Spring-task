package kz.task.first.spring.task.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Long id;
    private String name;
    private String surname;
    private Integer exam;
    private String mark;
}
