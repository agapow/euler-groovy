
def f1(n):
    def isprime(x):
        if x <= 1: return False

        c = 2

        while c <= x**0.5:
            if x%c == 0:
                return False

            if c != 2:
                c += 2
            else:
                c += 1

        return True

    # Iterate over odd numbers and test for primeness
    res = 2

    for i in xrange(3,int(n),2):
        if isprime(i):
            res += i

    # Return the sum
    return res

print f1(2000000)

