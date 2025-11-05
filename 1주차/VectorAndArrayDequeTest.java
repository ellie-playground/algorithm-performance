package org.yogiyo;

import java.util.*;

public class VectorAndArrayDequeTest {
    
    private static final int ITERATIONS = 1_000_000;

    public static void main(String[] args) {
        // ===== ArrayDeque Test =====
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            deque.addLast(i);
        }
        long end = System.nanoTime();
        System.out.println("ArrayDeque time: " + (end - start) / 1_000_000.0 + " ms");

        // ===== Vector Test =====
        Vector<Integer> vector = new Vector<>();
        start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            vector.add(i);
        }
        end = System.nanoTime();
        System.out.println("Vector time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
