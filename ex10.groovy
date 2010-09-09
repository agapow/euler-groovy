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

def duration = benchmark {
	primes = [2]
	sum = 2
	
	for (i=3; i < 2000000; i+=2) {
		sqrt_i = Math.sqrt(i)
		primes_cnt = primes.size()
		found_a_prime = true
		for (j=0; (j < primes_cnt) && (found_a_prime); j++) {
			if (sqrt_i < primes[j])
				break;
			if (i % primes[j] == 0) {
				found_a_prime = false
			}
		}
	
		if (found_a_prime) {
			primes << i
			sum += i
		}
	}
	
	println (primes)
	println ("Solution is: ${sum}")
	// => 1179908154
}
println "Execution took ${duration} ms"