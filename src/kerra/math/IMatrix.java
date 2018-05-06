package kerra.math;

public interface IMatrix {

    public void add(IMatrix matrix);
    public void subtract(IMatrix matrix);
    public void multiply(IMatrix matrix);
    public void multiply(Number scalar);
    public void divide(Number scalar);
    public void transpose();
    public Number[][] emptyClone(Number[][] matrix);
    public void setMatrix(Number[][] matrix);
    public Number[][] getMatrix();
}
