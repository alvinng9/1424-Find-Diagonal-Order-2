package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findDiagonalOrderTest() {
        Solution solution = new Solution();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1,2,3));
        input.add(Arrays.asList(4,5,6));
        input.add(Arrays.asList(7,8,9));
        assertArrayEquals(new int[]{1,4,2,7,5,3,8,6,9},solution.findDiagonalOrder(input));

        input = new ArrayList<>();
        input.add(Arrays.asList(1,2,3,4,5));
        input.add(Arrays.asList(6,7));
        input.add(Arrays.asList(8));
        input.add(Arrays.asList(9,10,11));
        input.add(Arrays.asList(12,13,14,15,16));
        assertArrayEquals(new int[]{1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16},
                solution.findDiagonalOrder(input));

    }

}