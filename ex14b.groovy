/*
This is an attempt to make the calculation more efficient by caching results
between chains. 
*/


class CollatzGenerator {
	def cache = [1:1]
	
	// Return the term following ``n``
	def next_term (long n) {
		assert (1 <= n)
		if (n % 2 == 0) {
			return (long) n / 2
		} else {
			return (3*n) + 1
		}
	}

	// Return the chain for the term ``x``
	def chain_len (x) {
		def terms = []
		def cached_len = 0
		while (true) {
			cached_len = cache[x]
			if (cached_len) {
				break
			} else {
				terms << x
				x = next_term (x)
			}
		}
		
		if (terms) {
			def term_cnt = terms.size()
			(0..term_cnt-1).each { i ->
				def t = terms[i]
				cache[t] = term_cnt - i + cached_len
			}
			return cache[terms[0]]
		
		} else {
			return cached_len
		}
	}

}

gen = new CollatzGenerator()
max_len = 0
max_idx = 0
(1..1000000).each {
	chain_len = gen.chain_len(it)
	if (it % 1000 == 0)
		println ("$it: $chain_len")
	if (max_len < chain_len) {
		max_len = chain_len
		max_idx = it
	}
}

println ("Solution is: ${max_idx}")

