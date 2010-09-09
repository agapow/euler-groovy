/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

// This seems like a slight rehash of exercise 7, but anyway: we use a sieve
// of erasthonenes to generate primes until we exceed two million. Again, we
// iterate up from 3 in steps of 2, check each number against the list of
// previously encountered primes. If none are divisors, then its a prime, add
// it to the list. Then add up the list.

// This takes a couple of minutes - which may indicate how slow Groovy is or
// that I've selected a suboptimal solution.

def benchmark = { closure ->  
	start = System.currentTimeMillis()  
	closure.call()  
	now = System.currentTimeMillis()  
	now - start  
} 

def is_prime (x) {
	if (x <= 1) {
		return false
	} else {
		c = 2
		root = (int) Math.sqrt (c)
		while (c < root) {
			if (x % c == 0)
				return false
			if (c != 2)
				c += 2
			else
				c += 1	
		}
		return true
	}
}
 
def duration = benchmark {

	long sum = 2
	
	for (i=3; i < 2000000; i += 2) {
		if (is_prime (i)) {
			sum += i
		}
	}

	println ("Solution is: ${sum}")
	// => 1,179,908,154
	// 142,913,828,922
}
println "Execution took ${duration} ms"