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