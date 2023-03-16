package home.work.fullworkersbook.Service;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;

public interface WorkerServiceDepartment {

    String getAll(String department);

    default Worker makeWorker(String firstName, String lastName, String salary, String department)
    {
            Long salaryLong = Long.parseLong(salary);
            Department departmentEnum = Department.valueOf(department.toUpperCase());
            return new Worker(firstName, lastName , salaryLong , departmentEnum);
    }

    Worker minSalary(String department);

    Worker maxSalary(String department);
}
