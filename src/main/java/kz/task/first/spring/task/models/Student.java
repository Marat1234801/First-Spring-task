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

    public String calculateMark(Integer exam) {
        if (exam >= 90)
            return ("A");
        else if (exam >= 75)
            return ("B");
        else if (exam >= 60)
            return ("C");
        else if (exam >= 50)
            return ("D");
        return ("F");
    }
}
