package com.package1.NullPointerExceptionAndStackTrace;

// Once the exception occurred in try block, then code in catch block is executed since exception is handled. After that code after catch block is executed.
// Note code inside try block after exception will still not be executed.

public class ExceptionHandlingRunner2 {

    public static void main(String[] args) {
        method1();
        System.out.println("Main ended");
    }

    private static void method1() {
        method2();
        System.out.println("Method1 ended");
    }

    // Since method2 handled the exception method1 & main won't know about the exception
    private static void method2() {
        try {
            String str = null;
            str.length(); // NullPointerException
            System.out.println("Code inside try");
        } catch (Exception e) {
            e.printStackTrace(); // Prints a stack trace of the Throwable Object/exception
            System.out.println("Code inside catch");
        }
        System.out.println("Code outside try-catch");
    }

}