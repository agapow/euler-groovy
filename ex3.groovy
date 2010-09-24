/*
What is the largest prime factor of the number 600851475143?
*/

import net.agapow.eulerutils.Utils

Utils.timeit {
	target = 600851475143
	factors = []
	residue = target
	residue_is_prime = false
	
	// NOTE: ``#`` is not a comment character!
	// While the residue is not prime, keep extracting factors and adding to list
	while (! residue_is_prime) {
		// A factor could be from 2 to half the residue, try until one is found
		// NOTE: don't get integer division automatically in groovy, so have to
		// explicitly cast
		// NOTE: originally used ``each``, but ``break`` only works inside loops
		println ("Factoring ${residue} ...")
		half = (long) (residue / 2)
		found_factor = false
		for (i=2; i <= half; i++) {
			// If it's a factor, stop looking, add to list & reduce residue 
			if (residue % i == 0) {
				residue = (long) (residue / i)
				println ("Reduce to ${i} & ${residue}")
				// NOTE: this is how you append to a list
				factors << i
				found_factor = true
				break
			}
		}	
	
		// If you haven't found a factor, then the residue must be prime
		// NOTE: groovy doesn't have `not`, `and` or `or` as syntactic sugar
		if (! found_factor) {
			factors << residue
			residue_is_prime = true
		}
	} 
	
	return factors.max()
	// => 6857 in 142 ms
}



