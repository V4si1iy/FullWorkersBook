package home.work.fullworkersbook.Controller;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Service.WorkerServiceDepartment;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    @GetMapping("/sum/{department}")
    public ResponseEntity<Long> sumDepartment(@PathVariable String department)
    {
        return ResponseEntity.ok(workerService.getSum(department));
    }
    @GetMapping("/workers")
    public ResponseEntity<Map<Department, List<Worker>>> allWorkersByDepartment()
    {
        return ResponseEntity.ok(workerService.getAllWorkersByDepartment());
    }
}
