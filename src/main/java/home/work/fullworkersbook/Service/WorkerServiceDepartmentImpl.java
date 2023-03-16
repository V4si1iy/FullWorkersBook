package home.work.fullworkersbook.Service;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Data.WorkersBase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkerServiceDepartmentImpl implements WorkerServiceDepartment {
    WorkersBase workersBase;

    @Override
    public Worker minSalary(String department) throws NoSuchElementException {
        Department departmentEnum = Department.valueOf(department.toUpperCase());
        return workersBase.getAll().stream()
                .filter(worker -> worker.getDepartment() == departmentEnum)
                .min(Comparator.comparingLong(worker -> worker.getSalary()))
                .get();
    }

    @Override
    public Worker maxSalary(String department) throws NoSuchElementException {
        Department departmentEnum = Department.valueOf(department.toUpperCase());
        return workersBase.getAll().stream()
                .filter(worker -> worker.getDepartment() == departmentEnum)
                .max(Comparator.comparingLong(worker -> worker.getSalary()))
                .get();
    }
    @Override
    public String getAll(String department) throws NoSuchElementException
    {
        Department departmentEnum = Department.valueOf(department.toUpperCase());
        return workersBase.getAll().stream()
                .filter(worker -> worker.getDepartment() == departmentEnum)
                .map(worker -> worker.toString())
                .collect(Collectors.joining());
    }

}
