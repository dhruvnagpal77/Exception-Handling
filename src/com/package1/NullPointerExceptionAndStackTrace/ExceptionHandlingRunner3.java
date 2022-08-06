package com.package1.NullPointerExceptionAndStackTrace;

import java.util.Scanner;

public class ExceptionHandlingRunner3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            int[] numbers = {1, 2, 3, 4};
            int number = numbers[5]; // ArrayIndexOutOfBoundsException
            System.out.println("Before Scanner close");
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            // We always want to close Scanner to avoid memory leakage. But in case exception occurred connection might not get close, so we putted it in finally block as it's always executed
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Scanner closed");
        }
        System.out.println("Closing Main");

    }

}