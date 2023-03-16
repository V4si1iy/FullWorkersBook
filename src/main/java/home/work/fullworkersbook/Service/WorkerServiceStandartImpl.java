package home.work.fullworkersbook.Service;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Data.WorkersBase;
import home.work.fullworkersbook.Exceptions.WorkerAlreadyAddedException;
import home.work.fullworkersbook.Exceptions.WorkerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class WorkerServiceStandartImpl implements WorkerServiceStandart  {

    WorkersBase workersBase;

    public Worker add(String firstName, String lastName, String salary , String department) throws WorkerAlreadyAddedException {
        Worker worker = makeWorker(firstName, lastName , salary , department);
        return workersBase.add(worker);
    }

    public Worker search(String firstName, String lastName, String salary , String department) throws WorkerNotFoundException {
        Worker worker = makeWorker(firstName, lastName , salary , department);
        return workersBase.search(worker);
    }

    public Worker remove(String firstName, String lastName, String salary , String department) throws WorkerNotFoundException {
        Worker worker = makeWorker(firstName, lastName , salary , department);
        return workersBase.remove(worker);
    }
    @Override
    public String getAll()
    {
        return workersBase.getAll().toString();
    }



    @Override
    public Worker minSalary() {
        return workersBase.getAll().stream()
                .min(Comparator.comparingLong(worker -> worker.getSalary()))
                .get();
    }

    @Override
    public Worker maxSalary() {
        return workersBase.getAll().stream()
                .max(Comparator.comparingLong(worker -> worker.getSalary()))
                .get();
    }


}
