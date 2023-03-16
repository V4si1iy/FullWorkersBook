package home.work.fullworkersbook.Controller;

import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Service.WorkerServiceDepartment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class WorkerDepartmentController {
    public WorkerServiceDepartment workerService;
    @GetMapping("/min-salary/{department}")
    public Worker minSalary(@PathVariable String department)
    {
        return workerService.minSalary(department);
    }
    @GetMapping("/max-salary/{department}")
    public Worker maxSalary(@PathVariable String department)
    {
        return workerService.maxSalary(department);
    }
    @GetMapping("/all/{department}")
    public String all(@PathVariable String department)
    {
        return workerService.getAll(department);
    }
}
