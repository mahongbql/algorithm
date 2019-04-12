package com.algorithm.demo;

import com.algorithm.demo.sort.HeapSorting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmApplication.class, args);

        int[] arr = {9,3,4,6,0,8,7,5,1,2};
        HeapSorting.sort(arr);
    }

}
