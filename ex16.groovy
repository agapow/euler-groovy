/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
*/

/*
Another oddly simple one: use the Java math library (already included), convert to string, and then to an array of ints, add 'em up, c'est voila.

*/

import net.agapow.eulerutils.Utils

Utils.timeit {
	// seems easier to get string form of number with formatting than toString
	num_str = "${(BigInteger) Math.pow (2, 1000)}"
	// convert to array of ints
	int_arr = num_str.collect { Integer.parseInt(it) }
	// accumulate the results & return
	// why the method is called "inject" is beyond me
	return int_arr.inject(0) { a,b -> a+b }
	// => 1366 in 73ms
}
