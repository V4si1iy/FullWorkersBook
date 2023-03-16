package home.work.fullworkersbook.Controller;

import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Exceptions.WorkerAlreadyAddedException;
import home.work.fullworkersbook.Exceptions.WorkerNotFoundException;
import home.work.fullworkersbook.Service.WorkerServiceStandart;
import home.work.fullworkersbook.Service.WorkerServiceStandartImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WorkerControllerStandart {
    private WorkerServiceStandartImpl workerServiceStandartImpl;

    @GetMapping
    public String showHelloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/add")
    public Worker add(String firstName, String lastName, @RequestParam String salary , @RequestParam String department) throws WorkerAlreadyAddedException {
        return workerServiceStandartImpl.add(firstName, lastName , salary ,department);
    }
    @GetMapping("/remove")
    public Worker remove(String firstName,  String lastName, @RequestParam String salary , @RequestParam String department) throws WorkerNotFoundException {
        return workerServiceStandartImpl.remove(firstName, lastName , salary , department);
    }

    @GetMapping("/search")
    public Worker search(String firstName,  String lastName, @RequestParam String salary , @RequestParam String department)throws WorkerNotFoundException {
        return workerServiceStandartImpl.search(firstName, lastName , salary , department);
    }

    @GetMapping("/getAll")
    public String getAll() {
        return workerServiceStandartImpl.getAll();
    }

}
