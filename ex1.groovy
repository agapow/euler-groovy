// print the sum of numbers less than 1000 that are divisble by 5 or 3

answer = (1..999).findAll { (it % 3 == 0) || (it % 5 == 0) }.sum()
println answer
// => 233168

