package com.package1.NullPointerExceptionAndStackTrace;

import java.util.Scanner;

public class ExceptionHandlingRunner3UsingTryWithResource {

    public static void main(String[] args) {

        // Using try with resource instead of try-finally or try-catch-finally block to make sure Scanner gets close even in case of exception
        // Any class implementing AutoCloseable Interface can be autoclosed using try with resource in case an exception occurred.
        try (Scanner scanner = new Scanner(System.in)) {
            int[] numbers = {1, 2, 3, 4};
            int number = numbers[5]; // ArrayIndexOutOfBoundsException
            System.out.println("Before Scanner close");
        }
        System.out.println("Closing Main");

    }
}