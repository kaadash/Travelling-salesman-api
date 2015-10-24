package algorithms;

import java.util.Arrays;

/**
 * Created by komputerszatana on 23.10.15.
 */
public class PermutationRonisko extends Factorial {
    int a = 0;
    private String[] permutations;

    public String[] getPermutations() {
        return permutations;
    }

    public PermutationRonisko(String s){
        permutations = new String[factorial(s.length())/2];
        permutation(s);
    }

    public void permutation(String s) {
        char[] original = s.toCharArray();
        char[] clone = new char[s.length()];
        boolean[] mark = new boolean[s.length()];
        Arrays.fill(mark, false);
        przydzielaniePierwszych(original, clone, mark, 0, s.length());
    }
    public void przydzielaniePierwszych(char[] original, char[] clone, boolean[] mark, int length, int n) {
        for (int i = 0; i < n - 1; i++) {
            clone[0] = original[i];
            mark[i] = true;
            przydzielanieOstatnich(original, clone, mark, length + 1, n);
            mark[i] = false;
        }
    }
    public void przydzielanieOstatnich(char[] original, char[] clone, boolean[] mark, int length, int n) {
        for (int i = (int)clone[0] - 97; i < n; i++) {
            clone[n-1] = original[i];
            mark[i] = true;
            permutowanie(original, clone, mark, length, n-1);
            mark[i] = false;
        }
    }
    public void permutowanie(char[] original, char[] clone, boolean[] mark, int length, int n) {
        if (length == n) {
            permutations[a] = "a" + String.valueOf(clone) + "a";
            a++;

            return;
        }
        for (int i = 0; i < n+1; i++) {
            if (mark[i] == true) continue;
            mark[i] = true;
            clone[length] = original[i];
            permutowanie(original, clone, mark, length + 1, n);
            mark[i] = false;
        }
    }
}
