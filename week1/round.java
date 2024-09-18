int round(double n) {
    if (n >= (int) n + 0.5) {
        return (int) n+1;
    }
    return (int) n;
}