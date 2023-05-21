package home.work.fullworkersbook.Service;

import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Exceptions.WorkerAlreadyAddedException;
import home.work.fullworkersbook.Exceptions.WorkerNotFoundException;

import java.util.Collection;

public interface WorkerMain {
    public Worker add(String firstName, String lastName, String salary, String department) throws WorkerAlreadyAddedException ;

    public Worker search(String firstName, String lastName, String salary, String department) throws WorkerNotFoundException;

    public Worker remove(String firstName, String lastName, String salary, String department) throws WorkerNotFoundException;
    public Collection<Worker> getAll();


}
