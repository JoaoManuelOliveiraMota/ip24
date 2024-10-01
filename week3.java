class week3 {
 boolean isPerfectSquare(int n) {
    double sqrt = Math.sqrt(n);
    if (sqrt == Math.floor(sqrt)) return true;
    else return false;
} 
}

class EvenOdd {
    static boolean isEven(int n) {
        return n % 2 == 0;
    }
    
    static boolean isOdd(int n) {
        return !isEven(n);
    }
}

class RandomInts {
    static int random() {
        return (int) (Math.random() * 1000000);
    }

    static int randomUntil(int max) {
        return random() * max / 1000000; // TODO
    }

    static int randomWithin(int min, int max) {
        return random() * (max - min) / 1000000 + min; // TODO
    }
}

class EvenOddRandom {
    static boolean isEven(int n) {
        return n % 2 == 0;
    }
    
    static boolean isOdd(int n) {
        return !isEven(n);
    }
    
    static int random() {
        return (int) (Math.random());
    }
    
    static int randomEven(int max) {
        int numb = (int) (Math.random() * (max + 1));
        if (isEven(numb)) return numb;
        else return(numb - 1);
    }
    
    static int randomOdd(int max) {
        int numb = (int) (Math.random() * (max + 1));
        if (isOdd(numb)) return numb;
        else if (numb + 1 < max) return (numb + 1);
        else return (numb - 1);
    }
    
}

class Divisors {
    static int countDivisors(int n) {
        int i = 1;
        int divisors = 0;
        while (i <= n) {
            if (n % i == 0) {
                divisors++;
            }
            i++;
        }
        return divisors;
    }
    
    static int sumProperDivisors(int n) {
        int i = 1;
        int sum = 0;
        while (i < n) {
            if (n % i == 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }
    
    static boolean isPrime(int n) {
        return countDivisors(n) == 2;
    }
}

class Prime {
    static int countDivisors(int n) {
        int i = 1;
        int divisors = 0;
        while (i <= n) {
            if (n % i == 0) {
                divisors++;
            }
            i++;
        }
        return divisors;
    }
    
    static boolean isPrime(int n) {
        return countDivisors(n) == 2;
    }
    
    static int countPrimes(int n) {
        int i = 1;
        int counter = 0;
        while (i <= n) {
            if (isPrime(i)) counter++;
            i++;
        }
        return counter;
    }
    
    static boolean existsPrimeBetween(int min, int max) {
        int i = min + 1;
        while (i < max) {
            if (isPrime(i)) return true;
            i++;
        }
        return false;
    }
    
}

class Perfect {
    static int sumProperDivisors(int n) {
        int i = 1;
        int sum = 0;
        while (i < n) {
            if (n % i == 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }
    
    static boolean isPerfect(int n) {
        return sumProperDivisors(n) == n;
    }
    
    static int countPerfectNumbers(int n) {
        int count = 0;
        int i = 1;
        while (i < n) {
            if (isPerfect(i)) count++;
            i++;
        }
        return count;
    }
}

class LargerPrimeDiff {
    static int countDivisors(int n) {
        int i = 1;
        int divisors = 0;
        while (i <= n) {
            if (n % i == 0) {
                divisors++;
            }
            i++;
        }
        return divisors;
    }
    
    static boolean isPrime(int n) {
        return countDivisors(n) == 2;
    }
    static int largestPrimeDiff(int n) {
        int i = 1;
        int a = 1;
        int b = 1;
        int diff = 0;
        while (i < n) {
            if (isPrime(i)) {
                a = b;
                b = i;
                if (b - a > diff) {
                    diff = b - a;
                }
            }
            i++;
        }
        return diff;
    }
}