package com.algorithm.demo;

import com.algorithm.demo.sort.HeapSorting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmApplication.class, args);

        /**
         * 堆排序
         */
        int[] arr = {4,6,8,5,9};
        HeapSorting.sort(arr);
    }

}
