package home.work.fullworkersbook.Service;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;

public interface WorkerServiceStandart {
    String getAll();
    default Worker makeWorker(String firstName, String lastName, String salary, String department)
    {
        Long salaryLong = Long.parseLong(salary);
        Department departmentEnum = Department.valueOf(department.toUpperCase());
        return new Worker(firstName, lastName , salaryLong , departmentEnum);
    }

    Worker minSalary();

    Worker maxSalary();


}
