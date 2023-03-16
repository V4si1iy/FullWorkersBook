package home.work.fullworkersbook.Service;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;
import org.apache.commons.lang3.StringUtils;

public interface WorkerServiceStandart {
    String getAll();
    default Worker makeWorker(String firstName, String lastName, String salary, String department)
    {

        if (StringUtils.isNumeric(firstName) || StringUtils.isNumeric(lastName) || StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
            throw new IllegalArgumentException();
        }
        firstName = StringUtils.deleteWhitespace(firstName);
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.deleteWhitespace(lastName);
        lastName = StringUtils.capitalize(lastName);
        Long salaryLong = Long.parseLong(salary);
        Department departmentEnum = Department.valueOf(department.toUpperCase());
        return new Worker(firstName, lastName , salaryLong , departmentEnum);
    }

    Worker minSalary();

    Worker maxSalary();


}
