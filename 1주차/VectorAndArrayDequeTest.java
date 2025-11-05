package org.yogiyo;

import java.util.*;

public class VectorAndArrayDequeTest {
    private static final int LOOP = 100_000_000;

    public static void main(String[] args) {

        // ✅ JVM Warm-up (JIT 최적화 유도)
        warmup();

        System.out.println("===== Performance Test Start =====");
        testVector();
        testArrayList();
        System.out.println("===== Performance Test End =====");
    }

    private static void testVector() {
        Vector<Integer> vector = new Vector<>();
        long start = System.nanoTime();
        for (int i = 0; i < LOOP; i++) {
            vector.add(i);
        }
        long end = System.nanoTime();
        System.out.printf("Vector time: %.2f ms%n", (end - start) / 1_000_000.0);
    }

    private static void testArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < LOOP; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        System.out.printf("ArrayList time: %.2f ms%n", (end - start) / 1_000_000.0);
    }

    // ✅ JVM warm-up (JIT compilation으로 최초 실행 느린 문제 방지)
    private static void warmup() {
        Vector<Integer> v = new Vector<>();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            v.add(i);
            a.add(i);
        }
        System.gc(); // 쓰레기 수집 요청 → 본 테스트 결과 오염 방지
    }
}
