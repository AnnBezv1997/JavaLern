package ru.netcracker.tasks;
import java.util.*;

/**
 * Реализовать класс для работы с матрицами имеющий следующий функционал
 */
public interface IMatrixWorker {
    /**
     * Выводит матрицу m
     * @param m
     */
    public void print(double[][] m);

    /**
     * Проверяет одинаковой ли размерности матрицы
     * @param m1,m2
     * @return если размерность одинаковая вернет true
     */
    public boolean haveSameDimension(double[][] m1, double[][] m2);

    /**
     * Складывает две матрицы
     * @param m1,m2
     * @return новая матрица - результат сложения
     */
    public double[][] add(double[][] m1, double[][] m2);
    /**
     * Вычитает из первой матрицы вторую
     * @param m1,m2
     * @return новая матрица - результат вычитания
     */
    public double[][] subtract(double[][] m1, double[][] m2);
    /**
     * Умножает две матрицы
     * @param m1,m2
     * @return новая матрица - результат умножения
     */
    public double[][] multiply(double[][] m1, double[][] m2);

    public class Matrix{

    private int rows;
    private int columns;
    private double[][] matrix;

        public Matrix() {
            this.rows = 1;
            this.columns = 1;
            this.matrix = new double[rows][columns];
        }

        public Matrix(int rows,int columns) {
            this.rows = rows;
            this.columns = columns;
            this.matrix = new double[rows][columns];
        }

        public Matrix(double[][] matrix) {
            this.rows = matrix.length;
            this.columns = matrix[0].length;
            this.matrix = matrix;
        }

        public double[][] getMatrix() {
            return matrix;
        }

        public void setMatrix(double[][] matrix) {
            this.matrix = matrix;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public int getColumns() {
            return columns;
        }

        public void setColumns(int columns) {
            this.columns = columns;
        }

        public double getElement(int row, int colum)
        {
            return this.matrix[row][colum];
        }

        public void setElement(int row, int colum, double value)
        {
            this.matrix[row][colum] = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[i].length; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Matrix matrix1 = (Matrix) o;

            if (rows != matrix1.rows) return false;
            if (columns != matrix1.columns) return false;
            return Arrays.deepEquals(matrix, matrix1.matrix);
        }

        @Override
        public int hashCode() {
            int result = rows;
            result = 31 * result + columns;
            result = 31 * result + Arrays.deepHashCode(matrix);
            return result;
        }
    }
}
