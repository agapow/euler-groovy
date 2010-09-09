/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
that the 6th prime is 13.

What is the 10001st prime number?
*/

// Seems a bit cumbersome, but use a sieve of erasthonenes to generate primes
// until we have collected the 10001st.
// Basically, iterate up from 3 in steps of 2, check each number against the
// list of previously encountered primes. If none are divisors, then its a prime, add it to the list.
// We save a little time by starting at the first "real" prime (3) and stepping
// up by 2 from there, because no even number we encounter will be a prime.

primes = [2]

for (i=3; primes.size() < 10001; i+=2) {
	
	primes_cnt = primes.size()
	found_a_prime = true
	for (j=0; (j < primes_cnt) && (found_a_prime); j++) {
		if (i % primes[j] == 0) {
			found_a_prime = false
		}
	}

	if (found_a_prime) {
		primes << i
	}
}

println (primes[-1])
// => 104743