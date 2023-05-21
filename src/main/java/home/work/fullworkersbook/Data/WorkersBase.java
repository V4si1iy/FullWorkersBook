package home.work.fullworkersbook.Data;

import home.work.fullworkersbook.Exceptions.WorkerAlreadyAddedException;
import home.work.fullworkersbook.Exceptions.WorkerNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class WorkersBase {
    private final List<Worker> storage = new ArrayList<>();

    private Map<Integer, Integer> lol= new HashMap<>();
    public Collection<Worker> getAll() {
        if(storage == null)
        {
            throw new NoSuchElementException();
        }
        return storage;
    }

    public Worker add(Worker worker) throws WorkerAlreadyAddedException {
        if (storage.contains(worker))
         {
            throw new WorkerAlreadyAddedException();
        }
        storage.add(worker);
        return worker;
    }

    public Worker remove(Worker worker) throws WorkerNotFoundException {
        if(storage.contains(worker))
        {
            storage.remove(worker);
            return worker;
        }
        throw new WorkerNotFoundException();

    }

    public Worker search(Worker workerToFind) throws WorkerNotFoundException  {
        if(storage.contains(workerToFind))
        {
            return workerToFind;
        }
        throw new WorkerNotFoundException();

    }
}
