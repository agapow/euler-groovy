/*
A Pythagorean triplet is a set of three natural numbers, a  b  c, for which::

	a^2 + b^2 = c^2
	
For example, 3^2 + 4^2 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

// Again, it seems like exhaustive search is the only way to go. However, we
// can trim the search space by searching for unique combinations.


for (i=1;; i++) {
	for (j=1; j <= i; j++) {
		k = 1000 - i - j
		if (i*i + j*j == k*k) {
			println ("Solution ${i} ${j} ${k}")
			println ("Product ${i*j*k}")
			// => 31875000
			System.exit(0)
		}	
	}
}

