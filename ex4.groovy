/*
A palindromic number reads the same both ways. The largest palindrome made from
the product of two 2-digit numbers is 9009 = 91 x 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

// The only way to work this out is to try all pairs of 3 digit numbers (100 to
// 999). However, we can trim the search space by testing a number with all
// numbers higher than it (e.g. test 998 with 998-999, 997 with 997-999), so we
// are testing all unique combinations), so we
// are testing all unique combinations

palindromes = []

(100..999).each { i -> 
	(i..999).each { j ->
		product = i * j
		// NOTE: convert string just with interpolation, could also do it with
		// ``(String)``
		prod_str = "${product}"
		// Grab the first & second halves of string, reverse second & compare
		len = prod_str.size()
		half = (int) (len / 2)
		// NOTE: ``substring`` is a little like a python slice - where do you
		str_a = prod_str.substring (0, half)
		// start, where do you stop just short of
		str_b = prod_str.substring (len - half, len).reverse()
		if (str_a == str_b) {
			palindromes << product
		}
	}
}

println palindromes.max()

