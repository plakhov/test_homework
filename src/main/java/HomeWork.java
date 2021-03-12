import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWork {

    public int[] task1(int[] array) {
        List<Integer> data = new ArrayList<>();
        for (int i : array) {
            data.add(i);
        }
        int lastIndex = data.lastIndexOf(4);
        if (lastIndex < 0) {
            throw new RuntimeException();
        }
        int[] result = new int[array.length - lastIndex - 1];
        System.arraycopy(array, lastIndex+1, result, 0, result.length);
        return result;
    }

    public boolean task2(int[] array) {
        int quantityOne = 0;
        int quantityFour = 0;
        for (int i : array) {
            if (i != 1 && i != 4) {
                return false;
            }
            if (i == 4) {
                quantityFour++;
            }
            if (i == 1) {
                quantityOne++;
            }
        }
        return quantityOne != 0 && quantityFour != 0;
    }


}
