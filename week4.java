class week4 {
 static void arrayRead() {
int[] numbers = {4, 3, 2, 1}; 
int sum = numbers[0];
sum += numbers[1];
sum += numbers[2];
sum += numbers[3];
}

int sum(int[] array) {
    int sum = 0;
    int i = 0;
    while (i < array.length)
    {
        sum += array[i];
        i++;
    }
    return sum;
}

static void arrayOfDigits() {
int[] digits = new int[10];
int i = 0;
while (i <= 9)
{
    digits[i] = i;
    i++;
}
}

int[] naturals(int n) {
    assert n >= 0 : "argumento não pode ser negativo";
    int[] nats = new int[n];
    int i = 1;
    while (i <= n)
    {
        nats[i - 1] = i;
        i++;
    }
    return nats;
}

boolean isOrdered(int[] array)
{
    int i = 1;
    while (i < array.length)
    {
        if (array[i - 1] > array[i])
            return false;
        i++;
    }
    return true;
}

int[] inverted(int[] array)
{
    int[] inverted = new int[array.length];
    int i = 0;
    
    while (i < array.length)
    {
        inverted[i] = array[array.length - 1 - i];
        i++;
    }
    return inverted;
}

static boolean contains(int[] array, int nbr)
{
    int i = 0;
    while (i < array.length)
    {
        if (array[i] == nbr)
            return true;
        i++;
    }
    return false;
}

static int count(int[] array, int nbr)
{
    int i = 0;
    int ct = 0;
    while (i < array.length)
    {
        if (array[i] == nbr)
            ct++;
        i++;
    }
    return ct;
}

static boolean isPalindrome(char[] array)
{
    int i = 0;
    while (i < array.length - i)
    {
        if (array[i] != array[array.length - 1 - i])
            return false;
        i++;
    }
    return true;
}

boolean areEqual(int[] a, int[] b) {
    if (a.length != b.length)
        return false;
    int i = 0;
    while (i < a.length)
    {
        if (a[i] != b[i])
            return false;
        i++;
    }
    return true;
}

int[] merge(int[] left, int[] right) {
    int[] merge = new int[left.length + right.length];
    int i = 0;
    while (i < left.length)
    {
        merge[i] = left[i];
        i++;
    }
    int j = 0;
    while (j < right.length)
    {
        merge[i + j] = right[j];
        j++;
    }
    return merge;
}

static boolean alternatedBooleans(boolean[] array)
{
    int i = 0;
    while (i < array.length - 1)
    {
        if (array[i] == array[i + 1])
            return false;
        i++;
    }
    return true;
}

static boolean[] invertedBooleans(boolean[] array)
{
    int i = 0;
    boolean[] invertedBooleans = new boolean[array.length];
    while (i < array.length)
    {
        invertedBooleans[i] = !array[i];
        i++;
    }
    return invertedBooleans;
} 
}

class ArrayUtil
{
    static boolean isEmpty(int[] array)
    {
        if (array.length == 0)
            return true;
        else
            return false;
    }
    
    static int first(int[] array)
    {
        assert (!isEmpty(array));
        return array[0];
    }
    
    static int last(int[] array)
    {
        assert (!isEmpty(array));
        return array[array.length - 1];
    }
    
    static int nextIndex(int[] array, int index)
    {
        assert index >= 0 && index < array.length;
        if (index == array.length - 1)
            return 0;
        else
            return index + 1;
    }
    
    static int prevIndex(int[] array, int index)
    {
        assert index >= 0 && index < array.length;
        if (index == 0)
            return array.length - 1;
        else
            return index - 1;
    }
    
    static int element(int[] array, int index)
    {
        assert index >= -array.length && index < array.length;
        if (index >= 0)
            return array[index];
        else
            return array[array.length + index];
    }
}

class ArrayCopy {
    static int[] copyNewSize(int[] array, int n)
    {
        int[] newarray = new int[n];
        int i = 0;
        while (i < n && i < array.length)
        {
            newarray[i] = array[i];
            i++;
        }
        while (i < n)
        {
            newarray[i] = 0;
            i++;
        }
        return newarray;
    }

    static int[] copy(int[] array)
    {
        return copyNewSize(array, array.length);
    }
}

class Random
{
    static int[] randomArray(int n)
    {
        int[] array = new int[n];
        int i = 0;
        while (i < n)
        {
            array[i] = (int)(Math.random() * 10);
            i++;
        }
        return array;
    }
    
    static int randomIndex(int[] array)
    {
        return (int)(Math.random() * array.length);
    }
    
    static int randomElement(int[] array)
    {
        return array[randomIndex(array)];
    }
}

class DoubleStats
{
    static double min(double[] array)
    {
        int i = 1;
        double min = array[0];
        while (i < array.length)
        {
            if (array[i] < min)
                min = array[i];
            i++;
        }
        return min;
    }
    
    static double max(double[] array)
    {
        int i = 1;
        double max = array[0];
        while (i < array.length)
        {
            if (array[i] > max)
                max = array[i];
            i++;
        }
        return max;
    }
    
    static double sum(double[] array)
    {
        int i = 0;
        double sum = 0;
        while (i < array.length)
        {
            sum += array[i];
            i++;
        }
        return sum;
    }
    
    static double average(double[] array)
    {
        return sum(array) / array.length;
    }
}

class SubArray
{
    static int[] subArray(int[] array, int start, int finish)
    {
        int[] newarray = new int[finish - start + 1];
        int i = 0;
        int j = start;
        while (i < newarray.length)
        {
            newarray[i] = array[j];
            i++;
            j++;
        }
        return newarray;
    }
    
    static int[] leftSide(int[] array, boolean middle)
    {
        int size;
        if (middle && array.length % 2 == 1)
            size = array.length / 2 + 1;
        else
            size = array.length / 2;
        int[] newarray = new int[size];
        int i = 0;
        while (i < newarray.length)
        {
            newarray[i] = array[i];
            i++;
        }
        return newarray;
    }
    
    static int[] rightSide(int[] array, boolean middle)
    {
        int size;
        if (middle && array.length % 2 == 1)
            size = array.length / 2 + 1;
        else
            size = array.length / 2;
        int[] newarray = new int[size];
        int i = 0;
        while (i < newarray.length)
        {
            newarray[i] = array[array.length / 2 + i];
            i++;
        }
        return newarray;
    }
}