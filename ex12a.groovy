/*
The sequence of triangle numbers is generated by adding the natural numbers. So
the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten
terms would be:

	1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

	 1: 1
	 3: 1,3
	 6: 1,2,3,6
	10: 1,2,5,10
	15: 1,3,5,15
	21: 1,3,7,21
	28: 1,2,4,7,14,28

We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred
divisors?
*/




// So first we write a generator triangular numbers.
// This allows us to save state and iterate over the output.
class TriangGenerator {
	def curr = 1
	def sum = 0
	
	def next = {
		sum += curr
		curr++
		return (sum)
	}
}

// Then we need something to factorize numbers
// This also saves state, so we can break calculations up usefully.
class Factorizer {
	
	// Return the next (lowest) factor of n, searching up from min
	// 
	// We trim the search space by just looking between the last factor
	// extracted (min) and the root of the number.
	//
	def next_factor (n, min=2) {
		// ???: have to use defs to have them seen in inner scopes
		def max = Math.sqrt (n)
		for (def i=min; i <= max; i++) {
			if ((int) n % i == 0)
				return i
		}
		return n
	}
	
	// return a list of the factors of `n`
	def factors (n) {
		if (n < 1) {
			// throw out inappropriate cases
			return []
		} else if (n == 1) {
			// deal with simple cases
			return [n]
		} else {
			// do a brute force factorisation
			// extract factors until you have nothing left
			// ???: defs as above
			def fctrs = [1]
			def next = 2
			while (n != 1) {
				next = next_factor (n, next)
				n = n / next
				fctrs << next
			}
			return fctrs
		}
	}
}


triang = new TriangGenerator()
fac = new Factorizer()

(1..20).each {
	t = triang.next()
	println ("${it}: ${t}: ${fac.factors(t)}")
}

// println ("Solution is: ${max_prod}")

