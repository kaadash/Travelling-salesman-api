package algorithms;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class TSPNearestNeighbour
{
    private int numberOfNodes;
    private Stack<Integer> stack;
    private String path;
    public TSPNearestNeighbour()
    {
        stack = new Stack<Integer>();
    }

    public String tsp(int adjacencyMatrix[][])
    {
        int adjacent2[][] = adjacencyMatrix;
        int sum = 0;
        numberOfNodes = adjacencyMatrix[1].length - 1;
        int[] visited = new int[numberOfNodes + 1];
        visited[0] = 1;
        stack.push(0);
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        path = "a";
//        System.out.print(1 + "\t");

        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 0;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
                {
                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);
                path += (char)(dst+97);
//                System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        path += "a";
        System.out.print("sum = ");
        for (int j = 0; j < path.length()-1; j++){
            char[] c = path.toCharArray();
            sum += adjacencyMatrix[c[j]-97][c[j+1]-97];
        }
        path += "\t" + sum;
        return path;
    }

    public static void main(String... arg)
    {
        int number_of_nodes;
        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();
            int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= number_of_nodes; i++)
            {
                for (int j = 1; j <= number_of_nodes; j++)
                {
                    adjacency_matrix[i][j] = scanner.nextInt();
                }
            }
            for (int i = 1; i <= number_of_nodes; i++)
            {
                for (int j = 1; j <= number_of_nodes; j++)
                {
                    if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
                    {
                        adjacency_matrix[j][i] = 1;
                    }
                }
            }
            System.out.println("the citys are visited as follows");
            TSPNearestNeighbour tspNearestNeighbour = new TSPNearestNeighbour();
            tspNearestNeighbour.tsp(adjacency_matrix);
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input format");
        }
        scanner.close();
    }
}
