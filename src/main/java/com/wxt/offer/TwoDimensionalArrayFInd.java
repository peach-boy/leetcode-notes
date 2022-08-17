package com.wxt.offer;

public class TwoDimensionalArrayFInd {

    /**
     * 暴力法
     *
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean result = false;
        for (int i = 0; i < matrix.length; i++) {
            int[] array = matrix[i];
            for (int j = 0; j < array.length; j++) {
                if (array[j] == target) {
                    result = true;
                }
            }
        }
        return result;
    }

    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{new int[]{1, 4, 7, 11, 15}, new int[]{2, 5, 8, 12, 19}, new int[]{3, 6, 9, 16, 22}, new int[]{10, 13, 14, 17, 24}};
        boolean result = findNumberIn2DArray2(array, 8);
        System.out.println(result);
    }
}
