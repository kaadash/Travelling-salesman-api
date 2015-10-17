package algorithms;

/**
 * Created by kadash on 17.10.15.
 */
public class MatrixGenerator {
    private int size;
    private int[][] adjacentMatrix;

    public MatrixGenerator(int size) {
        this.size = size;
        this.adjacentMatrix = new int[size][size];
    }

    public void generate() {
        int size = this.size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    this.adjacentMatrix[i][i] = 0;
                }
                else {
                    int random = (int )(Math.random() * 50 + 1);
                    this.adjacentMatrix[i][j] = random;
                }
            }
        }
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] getAdjacentMatrix() {
        return adjacentMatrix;
    }

    public void setAdjacentMatrix(int[][] adjacentMatrix) {
        this.adjacentMatrix = adjacentMatrix;
    }
}