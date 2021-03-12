import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class HomeWorkTest {

    HomeWork homeWork;

    @BeforeEach
    void setUp() {
        homeWork = new HomeWork();
    }

    private static Stream<Arguments> dataForPositiveTest() {
        List<Arguments> data = new ArrayList<>();
        data.add(Arguments.arguments(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[] {1, 7}));
        data.add(Arguments.arguments(new int[] {1, 2, 3, 5, 2, 4, 2, 1, 7}, new int[] {2, 1, 7}));
        data.add(Arguments.arguments(new int[] {1, 2, 3, 5, 2, 3, 2, 4, 7}, new int[] {7}));
        data.add(Arguments.arguments(new int[] {1, 2, 5, 4, 5, 3, 4, 1, 7}, new int[] {1, 7}));
        return data.stream();
    }

    private static Stream<Arguments> dataForNegativeTest() {
        List<Arguments> data = new ArrayList<>();
        data.add(Arguments.arguments(new int[] {1, 2, 1, 7}, new int[] {1, 7}));
        data.add(Arguments.arguments(new int[] {1, 1, 7}, new int[] {2, 1, 7}));
        return data.stream();
    }

    private static Stream<Arguments> dataForTask2() {
        List<Arguments> data = new ArrayList<>();
        data.add(Arguments.arguments(new int[] {1, 4, 4, 4, 1}, true));
        data.add(Arguments.arguments(new int[] {1, 1, 1, 1}, false));
        data.add(Arguments.arguments(new int[] {1, 2, 3, 5, 2, 3, 2, 4, 7}, false));
        data.add(Arguments.arguments(new int[] {4, 4, 4, 4}, false));
        data.add(Arguments.arguments(new int[] {4, 4, 1, 4}, true));
        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForPositiveTest")
    void task1PositiveTest(int[] array, int[] r) {
        Assertions.assertArrayEquals(r, homeWork.task1(array));
    }

    @ParameterizedTest
    @MethodSource("dataForNegativeTest")
    void task1NegativeTest(int[] array, int[] r) {
        Assertions.assertThrows(RuntimeException.class, () -> homeWork.task1(array));
    }

    @ParameterizedTest
    @MethodSource("dataForTask2")
    void task2(int[] array, boolean result) {
        Assertions.assertEquals(result, homeWork.task2(array));
    }
}