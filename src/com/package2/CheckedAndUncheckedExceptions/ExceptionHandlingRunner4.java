package com.package2.CheckedAndUncheckedExceptions;

// Here we will talk about Checked & Unchecked exception
// We always either have to throw or handle checked exception else code will not compile
// In case of Unchecked exception code will compile even if we don't throw or handle the exception

//Thread.sleep(2000); Throws InterruptedException which is a checked exception,
// we need to either handle it or throws it to the calling method to tell that method that this method might throw an error.


public class ExceptionHandlingRunner4 {

    // Approach 1: Handling the checked exception
    private static void method1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Approach 2: Throwing the checked exception to the calling method,
    // now it's the responsibility of calling method to either handle the exception or throw the exception to its calling method.
    private static void method2() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) {
        // Since method1 has handled the exception main is not required to handle or throw the exception
        method1();

        // Since method2 has not handled the exception main is required to handle or throw the exception
        try {
            method2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}