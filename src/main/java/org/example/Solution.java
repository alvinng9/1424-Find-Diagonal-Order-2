package org.example;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int cols = 0;
        int[] length = new int[nums.size()];
        int index = 0;
        for (List<Integer> list : nums) {
            cols = Math.max(list.size(), cols);
            length[index++] = list.size();
        }

        int[][] mat = new int[nums.size()][cols];
        int total = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < cols; j++) {
                if (j < nums.get(i).size()) {
                    if (nums.get(i).get(j) != 0) {
                        total++;
                    }
                    mat[i][j] = nums.get(i).get(j);
                }
            }
        }

        int[] array = new int[mat.length * mat[0].length];
        int r = 0;
        int c = 0;
        int row = 0;
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList());
        for (int i = 0; i < array.length; i++) {
            if (mat[r][c] != 0) {
                list.get(row).add(mat[r][c]);
            }
            if ((r + c) % 2 == 0) {
                if (c == mat[0].length - 1) {
                    r++;
                    row++;
                    list.add(new ArrayList());
                } else if (r == 0) {
                    c++;
                    row++;
                    list.add(new ArrayList());
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == mat.length - 1) {
                    c++;
                    row++;
                    list.add(new ArrayList());
                } else if (c == 0) {
                    r++;
                    row++;
                    list.add(new ArrayList());
                } else {
                    r++;
                    c--;
                }
            }
        }
        int[] result = new int[total];
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {
                swap(list.get(i));
            }
        }
        index = 0;
        for (List<Integer> here : list) {
            for (int listHere : here) {
                result[index++] = listHere;
            }
        }
        return result;
    }

    public void swap(List<Integer> list) {
        for (int i = 0; i < list.size()/2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, temp);
        }
    }
}
