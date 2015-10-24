package hello;

import algorithms.MatrixGenerator;
import algorithms.TSPBruteForce;
import algorithms.TSPNearestNeighbour;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by komputerszatana on 25.08.15.
 */
@RestController
public class GreetingController {
    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();
    private int[][] adjacentMatrix = new int [7][7];
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/matrixGenerator")
    public MatrixGenerator matrixGenerator(@RequestParam(value = "size", defaultValue = "7") int size) {
        MatrixGenerator matrix = new MatrixGenerator(size);
        adjacentMatrix = matrix.generate();
        return matrix;
    }

    @RequestMapping("/test")
    public String siema(@RequestParam(value = "size", defaultValue = "7") int size) {
        TSPNearestNeighbour tspNearestNeighbour = new TSPNearestNeighbour();
//        tspNearestNeighbour.tsp(adjacentMatrix);
//        return adjacentMatrix;
        return tspNearestNeighbour.tsp(adjacentMatrix);
    }

    @RequestMapping("/bruteForce")
    public String brute(@RequestParam(value = "size", defaultValue = "7") int size) {
        TSPBruteForce tspBruteForce = new TSPBruteForce(size);
        return tspBruteForce.generate(adjacentMatrix);
    }
}
