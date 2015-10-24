package algorithms;

/**
 * Created by komputerszatana on 23.10.15.
 */
public class Factorial {
    public int factorial(int n) {
        return n > 1 ? factorial(n-1)*n : n;
    }

}
