package home.work.fullworkersbook.ServiceTest;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Data.WorkersBase;
import home.work.fullworkersbook.Service.WorkerServiceDepartmentImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class WorkerServiceDepartmentImplTest {

    @Mock
    private WorkersBase storageMock;
    @InjectMocks
    private WorkerServiceDepartmentImpl out;

    private static final String NAME = "IVAN";
    private static final String LASTNAME = "IVANOV";
    private static final String DEPARTMENT = "JAVADEVELOP";
    private static final Worker WORKER_FIRST = new Worker(NAME, LASTNAME, 1000L, Department.JAVADEVELOP);
    private static final Worker WORKER_SECOND = new Worker(NAME, LASTNAME, 2000L, Department.JAVADEVELOP);
    private static final Worker WORKER_THIRD = new Worker(NAME, LASTNAME, 2000L, Department.ANALYST);

    @Test
    @DisplayName("Проверка работы методов min и max")
    public void test1() {

        final List<Worker> TEST_LIST = List.of(WORKER_FIRST, WORKER_SECOND);

        when(storageMock.getAll()).thenReturn(TEST_LIST);
        assertEquals(WORKER_FIRST, out.minSalary(DEPARTMENT));
        assertEquals(WORKER_SECOND, out.maxSalary(DEPARTMENT));


        assertThrows(NoSuchElementException.class, () -> out.maxSalary("ANALYST"));
        assertThrows(NoSuchElementException.class, () -> out.minSalary("ANALYST"));

        assertThrows(IllegalArgumentException.class, () -> out.maxSalary("Test"));
        assertThrows(IllegalArgumentException.class, () -> out.minSalary("Test"));
        assertThrows(IllegalArgumentException.class, () -> out.maxSalary(""));
        assertThrows(IllegalArgumentException.class, () -> out.minSalary(""));
    }

    @Test
    @DisplayName("Проверка работы метода getAll")
    public void test2() {

        final List<Worker> TEST_LIST = List.of(WORKER_FIRST, WORKER_SECOND, WORKER_THIRD);
        final List<Worker> EXCEPTED_LIST = List.of(WORKER_FIRST, WORKER_SECOND);
        when(storageMock.getAll()).thenReturn(TEST_LIST);

        assertEquals(EXCEPTED_LIST.stream().map(worker -> worker.toString()).collect(Collectors.joining()), out.getAll(DEPARTMENT));

        assertThrows(IllegalArgumentException.class, () -> out.getAll("Test"));
        assertThrows(IllegalArgumentException.class, () -> out.getAll(""));

        when(storageMock.getAll()).thenThrow(NoSuchElementException.class);
        assertEquals("Collection is Empty", out.getAll(DEPARTMENT));

    }

    @Test
    @DisplayName("Проверка работы метода getSum")
    public void test3() {

        final List<Worker> TEST_LIST = List.of(WORKER_FIRST, WORKER_SECOND, WORKER_THIRD);

        when(storageMock.getAll()).thenReturn(TEST_LIST);
        assertEquals(3000L, out.getSum(DEPARTMENT));


        assertThrows(IllegalArgumentException.class, () -> out.getSum("Test"));
        assertThrows(IllegalArgumentException.class, () -> out.getSum(""));
    }

    @Test
    @DisplayName("Проверка работы метода getAllWorkersByDepartment")
    public void test4() {

        final List<Worker> TEST_LIST = List.of(WORKER_FIRST, WORKER_SECOND, WORKER_THIRD);
        when(storageMock.getAll()).thenReturn(TEST_LIST);

        assertNotNull(out.getAllWorkersByDepartment());

        when(storageMock.getAll()).thenThrow(NoSuchElementException.class);
        assertNull(out.getAllWorkersByDepartment());
    }
}
