
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/* 
 * File: StreamGobbler.java
 * Author: Connor S. McGarty <cmcgarty@uab.edu>
 * Assignment: template-generator - EE333 Spring 2018
 * Vers: 2.0.0 04/20/2018 csm - initial coding
 *
 * Credits: 
 */

/**
 * 
 * @author Connor S. McGarty <cmcgarty@uab.edu>
 */
public class StreamGobbler implements Runnable {
    private InputStream inputStream;
    private Consumer<String> consumer;

    public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
    }
    @Override
    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines()
                .forEach(consumer);
    }
    

}
