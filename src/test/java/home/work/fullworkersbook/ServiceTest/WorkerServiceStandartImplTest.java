package home.work.fullworkersbook.ServiceTest;

import home.work.fullworkersbook.Data.Department;
import home.work.fullworkersbook.Data.Worker;
import home.work.fullworkersbook.Data.WorkersBase;
import home.work.fullworkersbook.Exceptions.WorkerAlreadyAddedException;
import home.work.fullworkersbook.Exceptions.WorkerNotFoundException;
import home.work.fullworkersbook.Service.WorkerMain;
import home.work.fullworkersbook.Service.WorkerServiceStandart;
import home.work.fullworkersbook.Service.WorkerServiceStandartImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;


@ExtendWith(MockitoExtension.class)
public class WorkerServiceStandartImplTest {
    @Mock
    private WorkersBase storageMock;
    @InjectMocks
    private WorkerServiceStandartImpl out;

    private static final String NAME = "IVAN";
    private static final String LASTNAME = "IVANOV";
    private static final String SALARY = "1000";
    private static final String DEPARTMENT = "JAVADEVELOP";
    private static final Worker WORKER_FIRST = new Worker(NAME, LASTNAME, 1000L, Department.JAVADEVELOP);
    private static final Worker WORKER_SECOND = new Worker(NAME, LASTNAME, 2000L, Department.ANALYST);

    @Test
    @DisplayName("Проверка на отклик методов добавления, поиска и удаления")
    public void test1() throws WorkerAlreadyAddedException, WorkerNotFoundException {

        final Worker WORKER_FIRST = new Worker(NAME, LASTNAME, 1000L, Department.JAVADEVELOP);


        when(storageMock.add(WORKER_FIRST)).thenReturn(WORKER_FIRST);
        when(storageMock.remove(WORKER_FIRST)).thenReturn(WORKER_FIRST);
        when(storageMock.search(WORKER_FIRST)).thenReturn(WORKER_FIRST);


        assertEquals(WORKER_FIRST, out.add(NAME, LASTNAME, SALARY, DEPARTMENT));
        assertEquals(WORKER_FIRST, out.remove(NAME, LASTNAME, SALARY, DEPARTMENT));
        assertEquals(WORKER_FIRST, out.search(NAME, LASTNAME, SALARY, DEPARTMENT));


        verify(storageMock, times(1)).add(WORKER_FIRST);
        verify(storageMock, times(1)).remove(WORKER_FIRST);
        verify(storageMock, times(1)).search(WORKER_FIRST);

    }

    @Test
    @DisplayName("Проверка работы методов min и max")
    public void test2() {

        final List<Worker> TEST_LIST = List.of(WORKER_FIRST, WORKER_SECOND);

        when(storageMock.getAll()).thenReturn(TEST_LIST);

        assertEquals(WORKER_FIRST, out.minSalary());
        assertEquals(WORKER_SECOND, out.maxSalary());
    }

    @DisplayName("Проверка работоспособоность метода makeWorker на ошибки")
    @ParameterizedTest
    @MethodSource("paramsForTest3")
    public void test3(String input1, String input2, String input3, String input4, Class expected) {
        assertThrows(expected, () -> out.makeWorker(input1, input2, input3, input4));
    }

    public static Stream<Arguments> paramsForTest3() {
        return Stream.of(
                Arguments.of("0", LASTNAME, SALARY, DEPARTMENT, IllegalArgumentException.class),
                Arguments.of("", LASTNAME, SALARY, DEPARTMENT, IllegalArgumentException.class),
                Arguments.of(" ", LASTNAME, SALARY, DEPARTMENT, IllegalArgumentException.class),
                Arguments.of(NAME, "0", SALARY, DEPARTMENT, IllegalArgumentException.class),
                Arguments.of(NAME, "", SALARY, DEPARTMENT, IllegalArgumentException.class),
                Arguments.of(NAME, " ", SALARY, DEPARTMENT, IllegalArgumentException.class),
                Arguments.of(NAME, LASTNAME, "TEST", DEPARTMENT, NumberFormatException.class),
                Arguments.of(NAME, LASTNAME, SALARY, "TEST", IllegalArgumentException.class)

        );
    }

    @DisplayName("Проверка работоспособоность метода makeWorker на значения")
    @ParameterizedTest
    @MethodSource("paramsForTest4")
    public void test4(String input1, String input2, String input3, String input4, Worker expected) {
        assertEquals(expected, out.makeWorker(input1, input2, input3, input4));
    }

    public static Stream<Arguments> paramsForTest4() {
        return Stream.of(
                Arguments.of("iVAN", LASTNAME, SALARY, DEPARTMENT, WORKER_FIRST),
                Arguments.of("I VAN", LASTNAME, SALARY, DEPARTMENT, WORKER_FIRST),
                Arguments.of("IVAN ", LASTNAME, SALARY, DEPARTMENT, WORKER_FIRST),
                Arguments.of(NAME, "iVANOV", SALARY, DEPARTMENT, WORKER_FIRST),
                Arguments.of(NAME, "IVANOV ", SALARY, DEPARTMENT, WORKER_FIRST),
                Arguments.of(NAME, "IVA NOV", SALARY, DEPARTMENT, WORKER_FIRST)
        );
    }

}
