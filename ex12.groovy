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

/*
So first we write a generator triangular numbers. This allows us to save state
and iterate over the output.
*/

class TriangGenerator {
	def curr = 1
	def sum = 0
	
	def next = {
		sum += curr
		curr++
		return (sum)
	}
}

/*
Then we need something to factorize numbers. Note that these aren't prime
factors, just any factors. What the examples given in the problem don't define
is whether these are supposed to be unique factors or all factors, i.e. are
the factors of 38 (the 8th triangular number):

	[1, 2, 3, 4, 6, 6, 9, 12, 18, 36]
	
or:

	[1, 2, 3, 4, 6, 9, 12, 18, 36]

This may not make any difference to the final answer and seems not to.
*/

def factors (n) {
	if (n < 1) {
		// throw out inappropriate cases
		return []
	} else if (n == 1) {
		// deal with simple cases
		return [n]
	} else {
		def fctrs = []
		max = Math.sqrt (n)
		for (i = 1; i <= max; i++) {
			if (n % i == 0) {
				fctrs << i
				fctrs << n/i
			}
		}
		return fctrs.sort()
	}
}

/*
Then make a generator for the triangular numbers and test each one until one
has more than 500 factors.
*/

triang = new TriangGenerator()

while (true) {
	t = triang.next()
	f = factors(t)
	if (500 < f.size) {
		println ("Solution is: ${t}")
		break
	}
}

