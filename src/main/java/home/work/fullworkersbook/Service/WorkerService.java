package home.work.fullworkersbook.Service;

import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Data.WorkersBase;
import home.work.fullworkersbook.Exceptions.WorkerAlreadyAddedException;
import home.work.fullworkersbook.Exceptions.WorkerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
@AllArgsConstructor
public class WorkerService {

    WorkersBase workersBase;

    private Worker makeWorker(String firstName, String lastName) {
        return new Worker(firstName, lastName);
    }

    public Collection<Worker> getAll() {
        return workersBase.getAll();
    }

    public Worker add(String firstName, String lastName) throws WorkerAlreadyAddedException {
        Worker worker = makeWorker(firstName, lastName);
        return workersBase.add(worker);
    }

    public Worker search(String firstName, String lastName) throws WorkerNotFoundException {
        Worker worker = makeWorker(firstName, lastName);
        return workersBase.search(worker);
    }

    public Worker remove(String firstName, String lastName) throws WorkerNotFoundException {
        Worker worker = makeWorker(firstName, lastName);
        return workersBase.remove(worker);
    }


}
