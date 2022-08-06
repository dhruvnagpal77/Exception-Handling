package com.package1.NullPointerExceptionAndStackTrace;

// This code won't compile because Catch block should always be in hierarchy starting from subclass to superclasses.
// Here the subclass thus subclass exception(IndexOutOfBoundsException) will always be caught by it's super class(Exception)
// & thus it will throw a compilation error.
public class ExceptionHandlingRunner4CatchBlockHierarchy {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3, 4};
            int number = numbers[5]; // ArrayIndexOutOfBoundsException
            System.out.println("Before Scanner close");
        } catch (Exception e) { // superclass
            System.out.println("Exception handled");
        }
//        catch (IndexOutOfBoundsException e) { // subclass
//            System.out.println("IndexOutOfBoundsException handled");
//        }
    }
}