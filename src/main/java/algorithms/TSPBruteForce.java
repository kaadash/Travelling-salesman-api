package algorithms;

/**
 * Created by komputerszatana on 23.10.15.
 */
public class TSPBruteForce extends Factorial {
    private String string;
    private int size;

    public TSPBruteForce(int size){
        this.size = size;
        string = "";
        for (int i = 0; i < size - 1; i++) {
            this.string += (char)('b' + i);
        }
    }

    public String generate(int[][] adjacentMatrix) {
        PermutationRonisko permutationRonisko = new PermutationRonisko(this.string);
        String[] permutations;
        permutations = permutationRonisko.getPermutations();
        int max = 100000;
        String result = new String();
        int sum;
        int a = 0;
        for (String s : permutations){
            sum = 0;
//            System.out.print(s + " ");
//            System.out.print(sum);
            for(int i = 0; i < s.length()-1; i++) {
                char[] chars = s.toCharArray();
                sum += adjacentMatrix[chars[i]-97][chars[i+1]-97];
//                System.out.print(" + " + adjacentMatrix[chars[i]-97][chars[i+1]-97]);
            }
//            System.out.println(" = " + sum);
            permutations[a] += "\", a wynik wynosi: " + sum;
            if (sum < max) {
                max = sum;
                result = "Najlepsza trasa to: \"";
                result += permutations[a];
            }
            a++;
        }
        return result;
    }
}