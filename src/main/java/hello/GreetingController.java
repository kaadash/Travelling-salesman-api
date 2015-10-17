package hello;

import algorithms.MatrixGenerator;
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

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/matrixGenerator")
    public MatrixGenerator matrixGenerator(@RequestParam(value = "size", defaultValue = "4") int size) {
        MatrixGenerator matrix = new MatrixGenerator(size);
        matrix.generate();
        return matrix;
    }
}
