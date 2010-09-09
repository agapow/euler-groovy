// find the sum of all even fibonacci numbers that do not exceed four million

fibos = []
a1 = 0
a2 = 1
while (true) {
	curr_term = a1 + a2
	if (4000000 <= curr_term)
		break
	fibos += [curr_term]
	a1 = a2
	a2 = curr_term
}
println fibos.findAll { it % 2 == 0 }.sum()
// => 4613732

