package home.work.fullworkersbook.Service;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Data.WorkersBase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
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
    public String getAll(String department) throws NoSuchElementException {
        Department departmentEnum = Department.valueOf(department.toUpperCase());
        Collection<Worker> result = null;
        try {
            result = workersBase.getAll();
        } catch (NoSuchElementException e) {
            return "Collection is Empty";
        }
        return result.stream()
                .filter(worker -> worker.getDepartment() == departmentEnum)
                .map(worker -> worker.toString())
                .collect(Collectors.joining());
    }

    public Long getSum(String department) {
        Department departmentEnum = Department.valueOf(department.toUpperCase());
        Long sumSalary = 0L;
        List<Worker> result = workersBase.getAll().stream()
                .filter((worker -> worker.getDepartment() == departmentEnum))
                .collect(Collectors.toList());
        for (Worker worker : result) {
            sumSalary += worker.getSalary();
        }
        return sumSalary;
    }

    public Map<Department, List<Worker>> getAllWorkersByDepartment() {
        Map<Department, List<Worker>> value = new HashMap<>();
        Collection<Worker> result = null;
        try {
            result = workersBase.getAll();
        } catch (NoSuchElementException e) {
            return null;
        }
        for (Department departmentEnum : Department.values()) {
            value.put(departmentEnum, result.stream()
                    .filter(worker -> worker.getDepartment() == departmentEnum)
                    .collect(Collectors.toList()));
        }
        return value;
    }


}
