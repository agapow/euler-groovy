/*
ex10a:

The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

// This seems like a slight rehash of exercise 7, but anyway: we use a sieve
// of erasthonenes to generate primes until we exceed two million. Again, we
// iterate up from 3 in steps of 2, check each number against the list of
// previously encountered primes. If none are divisors, then its a prime, add
// it to the list. Then add up the list.

// This is the first problem that gave me any trouble, partly because of how
// long it takes to run (and then correct and run again) and partly because
// the number is just a number. The main fault was that Groovy integers top
// out at around 2 billion and so integer overflow was occuring. This can be
// corrected by setting ``sum`` as a long (which can do at least a billion
// billions). 
// However this solution is quite slow, taking a couple of minutes - which
// may indicate how slow Groovy is or that I've selected a suboptimal solution.
// The naive solution in 10a, which tests division by every odd number is nearly
// twice as fast as this sieve. 

def benchmark = { closure ->  
	start = System.currentTimeMillis()  
	closure.call()  
	now = System.currentTimeMillis()  
	now - start  
} 

def duration = benchmark {
	primes = [2]
	long sum = 2
	
	for (i=3; i < 2000000; i+=2) {
		sqrt_i = Math.sqrt(i)
		primes_cnt = primes.size()
		found_a_prime = true
		for (j=0; (j < primes_cnt) && (found_a_prime); j++) {
			curr_prime = primes[j]
			if (sqrt_i < curr_prime)
				break;
			if (i % curr_prime == 0) {
				found_a_prime = false
			}
		}
	
		if (found_a_prime) {
			primes << i
			sum += i
			// println (i)
		}
	}
	
	println ("Solution is: ${sum}")
	// => 142,913,828,922
	// time: 181194ms
}
println "Execution took ${duration} ms"