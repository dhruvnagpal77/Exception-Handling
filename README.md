### Thought process during exception
1. Friendly message to end user.
2. Enough info(In logs) to debug the problem.

### Important notes
1. Exception flows up the call chain(or down the call stack) & code below the exception is not executed unless the exception is handled.
2. If a method handles an exception then the methods on the call stack below this method will not know about the exception.
3. We can have multiple catch block to handle a specific exception a different way.
4. For the catch block to catch/handle a thrown exception, it should either be the exact same thrown exception or superclass of the thrown exception, else exception handling will not be executed.
5. Catch block should always be in hierarchy starting from subclass to superclasses.
6. New feature in Java 7 is, you can define multiple exception in the same block.

### Exception Hierarchy
![Hierarchy](https://www.benchresources.net/wp-content/uploads/2017/02/exception-hierarchy-in-java.png)

### Finally block
1. We generally use the finally block to execute clean up code like closing connections, closing files, or freeing up threads, as it executes regardless of an exception or return statement.
2. There are only 2 scenario where some code in finally might not get executed: If a JVM crash happens or code in the finally throws an exception & there is no try-catch inside finally to handle that exception then line of code below the point where exception happens will not get executed.

### Checked & Unchecked exceptions & Errors
1. We always either have to throw or handle checked exception else code will not compile.
2. In case of Unchecked exception code will compile even if we don't throw or handle the exception.
3. RuntimeException & it's sub-classes and Error & it's sub-classes are Unchecked Exception. All other exceptions are Checked Exception.
4. Errors are something which we cannot handle in our code, we just need to make sure we don't create them eg: StackOverflowError or OutOfMemoryError.
5. If you want ur consumer to definitely handle that exception, to definitely know about the exception then you'd force him by creating a Checked Exception. But if your consumer cannot do anything about it then in those cases you'd go with a RuntimeException/Unchecked Exception.

### Exception handling best practices
1. **Never hides exception:** If the exception happens, put the entire stack trace into ur log. Stack trace would really help & also try put some context in. Context really help somebody who's trying to handle the exception. The moment you strart hiding the exception the guy who's trying to solve it does not know where to start.
2. **Do not use it for flow control:** You cannot have exception handling to redirect traffic, you cannot use it like if-else coz exception handling is very expensive it consumes resources so, don't use it for flow control.
3. **Think about the user:** Most imp. thing about exception handling is think about ur user. If an exception happens, what does ur user wants to see ? What can he do about it?. So always think about whenever writing a code that what can go wrong & what should I tell an end user.
4. **Think about your support team:** Think about your support team, the guy whos is going to handle the call from the end user. What kind of info does he needs to solve the error?
5. **Think about the calling method:** If you are designing an API, think about what the calling method can do about this exception? If you are throwing an exception, as a checked exception & there is nothing the calling method can do about this exception, then probably there is something wrong. The imp. question u need to ask, is there a way calling method can react to this exception? Is there a way it can be solved? If it cannot, if all it would do is pass it to the next method, then, think about if u would need to make a RuntimeException, make it unchecked.
6. **Have a global exception handling:** Let's say u have 10K line of code which is starting from main. Make sure that in the main u are not throwing exception to the outside world, Make sure in main u have proper exception handling & exception does not go about main. No exception should actually go to the end user. To the end user it should always be a proper exception message which goes out. We should tell him what he can do about it. An end user will not be able to do anything with a stack trace, right? So all that u need to show him is a good msg & put the error in stack trace, so that when the end user comes & talk to the support team, he gets what he wants.