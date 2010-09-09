/*
Assorted utilities for the Project Euler solutions.
*/

/*
Call a closure, print out execution time and return value.

Should be used like this::

   timeit {
   	for (i=1; i < 2000000; i++) ...
   }
   
*/
def timeit = { closure ->  
	start = System.currentTimeMillis()  
	soln = closure.call()  
	now = System.currentTimeMillis() 
	println "Solution: ${soln}"  
	println "Execution took ${now - start} ms"  
} 

