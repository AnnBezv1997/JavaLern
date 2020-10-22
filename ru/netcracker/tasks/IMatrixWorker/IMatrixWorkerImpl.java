package ru.netcracker.tasks;


import java.util.Arrays;


public class IMatrixWorkerImpl implements IMatrixWorker {

    public IMatrixWorkerImpl(){}
    @Override
    public void print(double[][] m) {
        Matrix matrix = new Matrix(m);
     System.out.print(matrix.toString());
    }

    @Override
    public boolean haveSameDimension(double[][] m1, double[][] m2) {
        Matrix matrix1 = new Matrix(m1);
        Matrix matrix2 = new Matrix(m2);
        if((matrix1.getRows() == matrix2.getRows()) && (matrix1.getColumns() == matrix2.getColumns())){
            return true;
        }else return false;
    }

    @Override
    public double[][] add(double[][] m1, double[][] m2)  {
        Matrix matrix1 = new Matrix(m1);
        Matrix matrix2 = new Matrix(m2);
        int row1 =matrix1.getRows();
        int colum1 = matrix1.getColumns();

        if((matrix1.getRows() == matrix2.getRows()) && (matrix1.getColumns() == matrix2.getColumns())){
           Matrix addition = new Matrix(row1, colum1);
           for(int i = 0 ; i < row1; i++){
               for (int j = 0 ; j < colum1; j++){
                   addition.setElement(i, j, matrix1.getElement(i,j) + matrix2.getElement(i,j));
               }
           }
           return addition.getMatrix();
        }else {
            return null;
        }
    }

    @Override
    public double[][] subtract(double[][] m1, double[][] m2) {
        Matrix matrix1 = new Matrix(m1);
        Matrix matrix2 = new Matrix(m2);
        int row1 =matrix1.getRows();
        int colum1 = matrix1.getColumns();

        if((matrix1.getRows() == matrix2.getRows()) && (matrix1.getColumns() == matrix2.getColumns())){
            Matrix subtract = new Matrix(row1, colum1);
            for(int i = 0 ; i < row1; i++){
                for (int j = 0 ; j < colum1; j++){
                    subtract.setElement(i, j, matrix1.getElement(i,j) - matrix2.getElement(i,j));
                }
            }
            return subtract.getMatrix();
        }else{
            return null;
        }
    }

    @Override
    public double[][] multiply(double[][] m1, double[][] m2) {
        Matrix matrix1 = new Matrix(m1);
        Matrix matrix2 = new Matrix(m2);
        if(matrix1.getRows() == matrix2.getColumns()){
            int row1 = matrix1.getRows();
            int colum2 = matrix2.getColumns();
            int row2 = matrix2.getRows();
            Matrix multiply = new Matrix(row1,colum2) ;
            double[][] elem = new double[row1][colum2];
            for(int i = 0 ; i < row1; i++) {
                for (int j =0; j < colum2; j++){
                    for (int n = 0 ; n< row2; n++){
                        elem[i][j] += matrix1.getElement(i,n)* matrix2.getElement(n,j);
                    }
                }
            }
              multiply.setMatrix(elem);
            return multiply.getMatrix();
        }else {
            return null;
        }
    }
}
