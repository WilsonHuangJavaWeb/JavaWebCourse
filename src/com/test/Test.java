package com.test;

import com.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nobody on 2017/7/1.
 */
public class Test {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(2, "BBB"));
        list.add(new Employee(1, "AAA"));
        list.add(new Employee(3, "CCC"));

//                System.out.println(list.indexOf(new Employee(1,null)));

        Collections.sort(list);
        System.out.println("=============================");
        System.out.println(Collections.binarySearch(list, new Employee(1, null)));

    }
}
