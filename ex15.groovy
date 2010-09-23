/*
How many ways are there to navigate a 20 by 20 grid?
*/

/*
Initially this seems very complicated. In an x-by-x grid, you have to make x
moves to the right and x down ... unless you allow backtracking. So disallow
backtracking, and we get a permutation of x right and x down moves. How do we
calculate this?

Thanks to `Better explained
<http://betterexplained.com/articles/navigate-a-grid-using-combinations-and-permutations/>`__
the solution is simple. Anywhere you don't move right must be a down. So imagine
a sequence of 2x right moves and we have to change x to down. How many ways can
we do that? Pick one from 2x, one from 2x-1 ... pick the last from x+1.
Initially this seems like a permutation, but actually it's a combination,
because the order in which we "convert" moves doesn't matter. (E.g. Picking
1-2-3, is the same as picking 3-2-1.) So the old faithful combination formulae
is::

   C(n,k) = n! / ((n-k)! * k!)

which in the general grid case is::

	C(2x,x) = (2x)! / (x!*x!)

or for this problem::

	C(2*20,20) = 40! / (20! * 20!)

*/

// for simplicity, a factorial function
def factorial (BigInteger n) {
	if (n == 1)
		return 1
	else
		return factorial(n-1) * n
}

// no need to calculate 20! twice
fac20 = factorial(20)
soln = factorial(40) / (fac20 * fac20)
// need type coercion to get integer representation
println ("Solution is: ${(BigInteger) soln}")
// => 137846528820


