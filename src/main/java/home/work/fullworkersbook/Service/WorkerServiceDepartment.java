package home.work.fullworkersbook.Service;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;

import java.util.List;
import java.util.Map;

public interface WorkerServiceDepartment {

    String getAll(String department);

    Worker minSalary(String department);

    Worker maxSalary(String department);
    Long getSum(String department);
    public Map<Department, List<Worker>> getAllWorkersByDepartment();
}
