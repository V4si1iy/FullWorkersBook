package home.work.fullworkersbook.Service;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Data.WorkersBase;
import home.work.fullworkersbook.Exceptions.WorkerAlreadyAddedException;
import home.work.fullworkersbook.Exceptions.WorkerNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class WorkerServiceStandartImpl implements WorkerServiceStandart {

    WorkersBase workersBase;

    @Override
    public Worker add(String firstName, String lastName, String salary, String department) throws WorkerAlreadyAddedException {
        Worker worker = makeWorker(firstName, lastName, salary, department);
        return workersBase.add(worker);
    }

    @Override
    public Worker search(String firstName, String lastName, String salary, String department) throws WorkerNotFoundException {
        Worker worker = makeWorker(firstName, lastName, salary, department);
        return workersBase.search(worker);
    }

    @Override
    public Worker remove(String firstName, String lastName, String salary, String department) throws WorkerNotFoundException {
        Worker worker = makeWorker(firstName, lastName, salary, department);
        return workersBase.remove(worker);
    }

    @Override
    public Collection<Worker> getAll() {
        return workersBase.getAll();
    }

    @Override
    public String getAllString() {
        return getAll().toString();
    }


    @Override
    public Worker minSalary() throws NoSuchElementException {
        return workersBase.getAll().stream()
                .min(Comparator.comparingLong(worker -> worker.getSalary()))
                .get();
    }

    @Override
    public Worker maxSalary() throws NoSuchElementException {
        return workersBase.getAll().stream()
                .max(Comparator.comparingLong(worker -> worker.getSalary()))
                .get();
    }


}
