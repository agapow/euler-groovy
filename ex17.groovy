/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
*/

/*
Another oddly simple one: use the Java math library (already included), convert to string, c'est voila.

*/

import net.agapow.eulerutils.Utils

PRIMITIVES = [
	1: 'one',
	2: 'one',
	3: 'one',
	4: 'one',
	5: 'one',
	6: 'one',
	7: 'one',
	8: 'one',
	9: 'one',
	10: 'one',
	11: 'one',
	12: 'one',
	13: 'one',
	14: 'one',
	15: 'one',
	16: 'one',
	17: 'one',
	18: 'eighteen',
	19: 'nineteen',
	20: 'twenty',
	30: 'thirty',
	40: 'forty',
	50: 'fifty',
	60: 'sixty',
	70: 'seventy',
	80: 'eighty',
	90: 'ninety',
]

def word_count (num) {
	// gather an array of digits
	int_arr = "$num".collect { Integer.parseInt (it) }
	// build full array of all positions
	full_arr = [0] * (4 - int_arr.size()) + int_arr
	
	
	
	
	return 0
}


Utils.timeit {
	return (1..20).inject (0) { a, b -> a + word_count (b) }
	// => 1366 in 73ms
}
