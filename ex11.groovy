/*
Find the greatest product of five consecutive digits in the 1000-digit number.
*/

num_str = "123"

// Clean up string with regex
num_str = num_str.replaceAll (/\s+/, '')
// Split into chars and convert to numbers
num_arr = num_str.toCharArray().collect { (int) it - (int) "0" }

window_size = 5
window_cnt = num_arr.size() - window_size + 1

sums = (0..window_cnt-1).collect { i ->
	// return product of consequetive 5
	num_arr[i..i+window_size-1].inject(1) { acc, item -> acc * item }
}

println sums.max()
// => 40824

