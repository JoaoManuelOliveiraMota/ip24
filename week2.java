class week2 {
 double abs(double n) {
    if (n < 0) {
        n = -n;
    }
    return n;
}


int max(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}


int min(int a, int b) {
    if (a > b) {
        return b;
    }
    return a;
}


int irsGroup(int yearlyIncome) {
    if (yearlyIncome < 10000) {
        return 1;
    } else if (yearlyIncome <= 25500) {
        return 2;
    } else if (yearlyIncome <= 48500) {
        return 3;
    }
    return 4;
}


double irsTax(int irsGroup) {
    if (irsGroup == 1) return 0.12;
    else if (irsGroup == 2) return 0.18;
    else if (irsGroup == 3) return 0.23;
    else if (irsGroup == 4) return 0.29;
    else return 0.0;
}


static void varAssign() {
int n = 1;
n = 2;
n = n + 1;
n++;
n++;

}

static void varAssignDiv() {
int v = 2024;
v /= 10;
v /= 10;
v /= 10;

}

int firstDigit(int nbr) {
    while (nbr > 10) {
        nbr /= 10;
    }
    return nbr;
}


static void naturalsIterator() {
int i = 1;
while(i < 5) {
   i = i + 1;
}

}

int sumNaturals(int max) {
    int counter = 1;
    int sum = 0;
    while (counter <= max) {
        sum += counter;
        counter++;
    }
    return sum;
}


static void reverseIteration() {
int x = 5;
while (x > 0) {
    x--;
}

}

int powerOfTwo(int n) {
    int counter = 1;
    int result = 2;
    if (n == 0) {
        result = 1;
    }
    while (counter < n) {
        result *= 2;
        counter++;
    }
    return result;
}


boolean isMultiple(int a, int b) {
    int mult = b;
    while (mult < a) {
        mult += b;
    }
    return mult == a;
}


int intDivision(int a, int b) {
    int k = 0;
    int mult = b;
    while (mult <= a) {
        mult += b;
        k++;
    }
    return k;
}


static void iterationStepTwo() {
int p = 2;
while (p < 10) {
    p += 2;
}

}

int sumEvenBetween(int min, int max) {
    int sum = 0;
    if (min >= max) {
        return 0;
    }
    if (min % 2 == 0) {
        if (max % 2 == 0) {
            sum += min;
            while (min < max) {
                min += 2;
                sum += min;
            }
        } else {
            sum += min;
            while (min < max -1) {
                min += 2;
                sum += min;
            }
        }
    } else {
        min += 1;
        if (max % 2 == 0) {
            sum += min;
            while (min < max) {
                min += 2;
                sum += min;
            } 
        } else {
            sum += min;
            while (min < max -1) {
                min += 2;
                sum += min;
            }
        }
    }
    return sum;
}




char nextLetter(char letter) {
    char output;
    if (letter != 'z') {
        output = (char)(letter + 1);
        return output;
    }
    else
    {
        return 'a';
    }
}


int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    else
    {
        return gcd (b, (a % b));
    }
}


int invertInt(int number) {
    int output = 0;
    while (number != 0) {
        output = output * 10 + (number % 10);
        number = number / 10;
    }
    return output;
}


int fib (int n) {
    int a = 0;
    int b = 1;
    int i = 1;
    int temp = 0;
    
    if (n == 0) {
        return a;
    } else if (n == 1) {
        return b;
    } else {
            while (i < n) {
                temp = a;
                a = b;
                b = a + temp;
                i++;
            }
    }
    return b;
}

 
}

class IrsUtil {
    static int irsGroup(int yearlyIncome) {
        if (yearlyIncome < 10000) {
            return 1;
        } else if (yearlyIncome <= 25500) {
            return 2;
        } else if (yearlyIncome <= 48500) {
            return 3;
        }
        return 4;
    }
    
    static double irsTax(int irsGroup) {
        if (irsGroup == 1) return 0.12;
        else if (irsGroup == 2) return 0.18;
        else if (irsGroup == 3) return 0.23;
        else if (irsGroup == 4) return 0.29;
        else return 0.0;
    }
}
