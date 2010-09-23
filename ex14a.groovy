/*
Here, I we try to conserve heap space by not actually building the chain but
just counting the elements we would add to it if we were building the chain.
It requires only a few small changes to the generator.

Note: it doesn't seem to run any faster.
*/

class CollatzGenerator {

	def next_term (long n) {
		assert (1 <= n)
		if (n % 2 == 0) {
			return (long) n / 2
		} else {
			return (3*n) + 1
		}
	}

	// Return the chain length for the term ``x``
	def chain_len (x) {
		def num_terms = 1
		while (x != 1) {
			x = next_term (x)
			num_terms++
		}
		return num_terms
	}

}

gen = new CollatzGenerator()
max_len = 0
max_idx = 0
(1..20).each {
	chain_len = gen.chain_len(it)
	if (it % 1 == 0)
		println ("$it: $chain_len")
	if (max_len < chain_len) {
		max_len = chain_len
		max_idx = it
	}
}

println ("Solution is: ${max_idx}")

