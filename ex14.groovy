/*
The following iterative sequence is defined for the set of positive integers:

n -> n/2 (n is even)
n -> 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

   13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains
10 terms. Although it has not been proved yet (Collatz Problem), it is thought
that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/

/*
This problem was the first to give me any major problems, partly because of
inexperience with Groovy, partly because of silent and obscure errors. North
of 113000, Java would error out due to running out of heap space. For
reference, you can increase heap size by setting an environmental variable:

	% JAVA_OPTS=-Xmx1000M

The actual error is to do with integer overflow that would lead to negative
numbers that just ran on and on. This was patched in the ``next_term``
method by forcing things to long.
*/


/*
First we make a generator for the function. This could be done as a pair of 
standalone functions, but it's more encapsulated this way. It would be possible
to make this more efficient over sucessive calls by caching what numbers are
seen after every call, so when chains "intersect", you don't have to calculate
the whole lot.
*/
class CollatzGenerator {

	// Return the term following ``n``
	// Force the argument to be a long to prevent overflow within.
	def next_term (long n) {
		assert (1 <= n)
		if (n % 2 == 0) {
			// catch longs here as well
			return (long) n / 2
		} else {
			return (3*n) + 1
		}
	}

	// Return the chain for the term ``x``
	def generate (x) {
		// ``def`` can be thought of as an alias for ``Object``, saying "some, any
		// type"
		def terms = [x]
		// loop and collect until the term reaches 0
		while (x != 1) {
			x = next_term (x)
			// this is where the heap space runs out
			terms << x
		}
		return terms
	}

}

gen = new CollatzGenerator()
max_len = 0
max_idx = 0
(1..1000000).each {
	chain = gen.generate(it)
	if (it % 1000 == 0)
		println ("$it: $chain")
	chain_len = chain.size
	if (max_len < chain_len) {
		max_len = chain_len
		max_idx = it
	}
}

println ("Solution is: ${max_idx}")
// => 837799


