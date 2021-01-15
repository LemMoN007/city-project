package com.main;

import com.graph.*;

/**
 * The only purpose of the class is to create a new object of
 * type TestGraph and call the core method.
 * This is what the user sees so that he can't interact with
 * the other classes.
 */
public class Main {

    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        test.start();
    }
}
