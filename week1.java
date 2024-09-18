class week1 {
 int next(int n) {
    return n+1;
}

int previous(int n) {
     return n-1;
}

double doubleOf(double n) {
     return n*2;
}

public int square(int n) {
    return n*n;
}

int difference(int a, int b) {
    return a-b;
}

double avg(double n, double k) {
    double average = (n+k)/2;
    return average;
}

double average(int a, int b) {
    double sumInt = (double)(a+b);
    return sumInt/2;
}

int round(double n) {
    if (n >= (int) n + 0.5) {
        return (int) n+1;
    }
    return (int) n;
}

boolean isNegative(int x) {
    return x < 0;
}

boolean isDigit(int n) {
    return 0 <= n && n <= 9;
}

boolean isEven(int n) {
    return n % 2 == 0;
}

boolean isOdd(int n) {
    return n % 2 != 0;
}

double abs(double n) {
    double absolute = n < 0 ? -n : n;
    return absolute;
}

double min(double a, double b) {
    double minimum = a >= b ? b : a;
    return minimum;
}

int sum(int n) {
    int sumNat = n*(n+1)/2;
    return sumNat;
}

boolean isVowel(char c) {
    return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
}

boolean inOrder(int a, int b, int c) {
    return a < b && b < c;
}

boolean isIncluded(int n, int min, int max) {
    return n >= min && n <= max;
}

boolean isExcluded(int n, int min, int max) {
    return n < min || n > max;
}

boolean xor(boolean a, boolean b) {
    return a != b;
}

boolean sameSign(int a, int b) {
    if (a == 0 || b == 0) return false;
    return a > 0 && b > 0 || a < 0 && b < 0;
}

boolean onlyOnePositive(int a, int b) {
    return a * b < 0;
} 
}

class Util {
     static double max(double a, double b) {
         return a > b ? a : b;
     }
     static boolean inOrder(int a, int b, int c) {
         return a < b && b < c;
     }
     static double min(double a, double b) {
         double minimum = a >= b ? b : a;
         return minimum;
     }
}