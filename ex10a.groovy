/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

// This is an alternative go at this question, due to the failure of my first
// attempt. Here we use a dumb, brute force way of determing primes: false if
// it's 1 or divisble by 2, true if it's 2 or 3, otherwise try to divide it
// sucessively by every odd number from 3 upwards.

def benchmark = { closure ->  
	start = System.currentTimeMillis()  
	closure.call()  
	now = System.currentTimeMillis()  
	now - start  
} 

def is_prime (x) {
	if ((x <= 1) || (x % 2 == 0)) {
		return false
	} else if ((x == 2) || (x == 3)) {
		return true
	} else {
		c = 3
		root = Math.sqrt (x)
		while (c <= root) {
			if (x % c == 0)
				return false
				c += 2	
		}
		return true
	}
}

def duration = benchmark {

	long sum = 2
	
	for (i=3; i < 1000000; i += 2) {
		if (is_prime (i)) {
			sum += i
			//println (i)
		}
	}

	println ("Solution is: ${sum}")
	// => 142913828922
	// time: 75466ms
}
println "Execution took ${duration} ms"