package home.work.fullworkersbook.Controller;

import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Exceptions.WorkerAlreadyAddedException;
import home.work.fullworkersbook.Exceptions.WorkerNotFoundException;
import home.work.fullworkersbook.Exceptions.WorkerStorageIsFullException;
import home.work.fullworkersbook.Service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/worker")
@AllArgsConstructor
public class WorkerController {
    private WorkerService workerService;

    @GetMapping
    public String showHelloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/add")
    public Worker add(@RequestParam String firstName, @RequestParam String lastName) throws WorkerAlreadyAddedException {
        return workerService.add(firstName, lastName);
    }
    @GetMapping("/remove")
    public Worker remove(@RequestParam String firstName, @RequestParam String lastName) throws WorkerNotFoundException {
        return workerService.remove(firstName, lastName);
    }

    @GetMapping("/search")
    public Worker search(@RequestParam String firstName, @RequestParam String lastName)throws WorkerNotFoundException {
        return workerService.search(firstName, lastName);
    }

    @GetMapping("/getAll")
    public Collection<Worker> getAll() {
        return workerService.getAll();
    }

}
