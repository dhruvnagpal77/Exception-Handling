package com.package1.NullPointerExceptionAndStackTrace;

// This program will throw NullPointerException & will show the stack trace(Order of function call)
// Code after exception is not executed since exception is not handled

public class ExceptionHandlingRunner {

    // Since main didn't handle the exception it will throw exception to ExceptionHandlingRunner
    public static void main(String[] args) {
        method1();
        System.out.println("Main ended");
    }

    // Since method1 didn't handle the exception it will throw exception to main
    private static void method1() {
        method2();
        System.out.println("Method1 ended");
    }

    // Since method2 didn't handle the exception it will throw exception to method1
    private static void method2() {
        String str = null;
        str.length(); // NullPointerException
        System.out.println("Method2 ended");
    }

}