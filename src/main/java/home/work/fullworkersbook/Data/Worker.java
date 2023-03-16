package home.work.fullworkersbook.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Worker {
    private String firstName;
    private String lastName;
    private Long salary;
    private Department department;
}
