class week7 {
 int count(char c, String text) {
    int count = 0;
    for (int i = 0; i < text.length(); i++)
    {
        if (text.charAt(i) == c)
            count++;
    }
    return count;
}

boolean allUpperCase(String s)
{
    for (int i = 0; i < s.length(); i++)
    {
        if (s.charAt(i) < 'A' || s.charAt(i) > 'Z')
            return false;
    }
    return true;
}

boolean isWord(String s)
{
    if (s.isEmpty())
        return false;
    for (int i = 0; i < s.length(); i++)
    {
        if (!((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')))
            return false;
    }
    return true;
}

boolean isPalindrome(String s)
{
    for(int i = 0; i < s.length() / 2; i++)
    {
        if (s.charAt(i) != s.charAt(s.length() - 1 - i))
            return false;
    }
    return true;
}

int countWords(String s)
{
    int count = 0;
    int i = 0;
    if (s.isEmpty())
        return count;
    if (s.charAt(0) != ' ')
    {
        count ++;
        i++;
    }
    while (i < s.length() - 1)
    {
        if (s.charAt(i) != ' ' && s.charAt(i - 1) == ' ')
            count++;
        i++;
    }
    return count;
}

String wrap(String s, char c)
{
    if (c == '(')
        return c + s + ')';
    else if (c == '[')
        return c + s + ']';
    else if (c == '{')
        return c + s + '}';
    else
        return c + s + c;
}

int count(String s, String[] array) {
    int count = 0;
    for (int i = 0; i < array.length; i++)
    {
        if (array[i].equals(s))
            count++;
    }
    return count;
}

String largest(String[] array) {
    int max = 0;
    for (int i = 0; i < array.length; i++) {
        if (array[i].length() > max)
            max = i;
    }
    return array[max];
}

String join(String[] array, String sep)
{
    String ret = "";
    int i = 0;
    while (i < array.length - 1) {
        ret += array[i];
        ret += sep;
        i++;
    }
    ret += array[i];
    return ret;
} 
}

