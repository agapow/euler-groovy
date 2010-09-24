/*
Print the sum of numbers less than 1000 that are divisble by 5 or 3
*/

import net.agapow.eulerutils.Utils

Utils.timeit {
	return (1..999).findAll { (it % 3 == 0) || (it % 5 == 0) }.sum()
	// => 233168 in 94ms
}
