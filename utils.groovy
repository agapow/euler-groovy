/*
Assorted utilities for the Project Euler solutions.
*/

package net.agapow.eulerutils

/*
Call a closure, print out execution time and return value.

Should be used like this::

   import net.agapow.eulerutils.Utils
   
   net.agapow.eulerutils.Utils.timeit {
      for (i=1; i < 2000000; i++) ...
   }
   
*/
class Utils {

   public static void timeit (Closure c) { 
   	/*
   	something about the method being static means these vars have to be def'd
   	or Groovy doesn't know if their local or what.
   	*/
      def start = System.currentTimeMillis()  
      def soln = c.call()  
      def now = System.currentTimeMillis() 
      println "Solution: ${soln}"  
      println "Execution took ${now - start} ms"  
   } 

}