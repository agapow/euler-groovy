/*
2520 is the smallest number that can be divided by each of the numbers from 1
to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the
numbers from 1 to 20?
*/

import net.agapow.eulerutils.Utils

Utils.timeit {
	/*
	It seems the only way to do this is by exhaustive search again. So we count
	up and look for the first success. However, we don't have to check for all 
	the divisors - if something is divisible by 20, it is also divisible by 10 
	and 5 and 4 and 2 ...
	*/
	
	divisors = [20, 19, 18, 17, 16, 14, 13, 12, 11]
	num_divisors = divisors.size()
	
	/*
	We get a speedup by "stepping-up" by the smallest divisor. This also means
	that we don't have to test for that divisor
	*/
	
	step = divisors[-1]
	for (i=step;; i=i+step) {
		found_all_div = true
		for (j=0; j < (num_divisors - 1); j++) {
			d = divisors[j]
			if (i % d != 0) {
				// println ("${i} is not divisible by ${d} ...")
				found_all_div = false
				break
			}
		}
		
		if (found_all_div) {
			return i
			// => 232792560 in 96587ms
			break
		}
	}
}
