class week6 {
  
}

record Range(int min, int max) {

}

class RangeUtil {
    static int length(Range r) {
        if (r.min() > r.max())
            return 0;
        else
            return r.max() - r.min() + 1;
    }
    
    static int sum(Range r) {
        int i = r.min();
        int res = 0;
        while (i < r.max() + 1) {
            res += i;
            i++;
        }
        return res;
    }
    
    static Range indexes(int[] array) {
        if (array.length == 0) {
            return new Range(0, -1);
        }
        else
            return new Range(0, array.length - 1);
    }
    
    static Range expand(Range r,int i) {
        if (i < 0)
            return new Range(r.min() + i, r.max());
        else
            return new Range(r.min(), r.max() + i);
    }
    
}

record Range(int min, int max) {
    boolean isEmpty() {
        return this.min > this.max;
    }
    
    int length() {
        if (this.min > this.max)
            return 0;
        return this.max - this.min + 1;
    }
    
    boolean includes(int i) {
        return i >= this.min && i <= this.max;
    }
    
    boolean excludes(int i) {
        return i < this.min || i > this.max;
    }
    
    boolean isValidFor(int[] array) {
        if (array.length > 0)
            return this.min >= array[0] && this.max <= array[0] + this.length();
        return false;
    }
    
    boolean contains(Range r) {
        return this.min <= r.min && this.max >= r.max;
    }
    
    Range expand(int i) {
        if (i < 0)
            return new Range(this.min + i, this.max);
        else
            return new Range(this.min, this.max + i);
    }
}

class ArrayFunctions {
    static int sum(int[] array, Range r) {
        int sum = 0;
        for (int i = r.min(); i < r.max() + 1; i++) {
            sum += array[i];
        }
        return sum;
    }
    
    static int[] subArray(int[] array, Range r) {
        int[] ret = new int[r.max() - r.min() + 1];
        int i = 0;
        for (int j = r.min(); j < r.max() + 1; j++) {
            ret[i] = array[j];
            i++;
        }
        return ret;
    }
    
    static Range valueRange(int[] array) {
        int[] newarr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newarr[i] = array[i];
        }
        for (int i = 0; i < newarr.length; i++) {
            for (int j = 0; j < newarr.length - i - 1; j++) {
                if (newarr[j] > newarr[j + 1]) {
                    ArrayOrder.swap(newarr, j, j + 1);
                }
            }
        }
        return new Range(newarr[0], newarr[array.length - 1]);
    }
}

record Dimension(int length, int height) {
    int area() {
        return this.length * this.height;
    }
    
    int perimeter() {
        return 2 * this.length + 2 * this.height;
    }
    
    boolean isSquare() {
        return this.length == this.height;
    }
    
    boolean isVertical() {
        return this.height > this.length;
    }
    
    boolean isHorizontal() {
        return this.length > this.height;
    }
    
    boolean largerThan(Dimension n) {
        return this.area() > n.area();
    }
    
    Dimension scale(int size) {
        assert size > 0;
        return new Dimension(size * this.length, size * this.height);
    }
}

record Position(int line, int column) {
   Position top() {
       return new Position(this.line -1, this.column);
   }
   
   Position right() {
       return new Position(this.line, this.column + 1);
   }
   
   Position bottom() {
       return new Position(this.line + 1, this.column);
   }
   
   Position left() {
       return new Position(this.line, this.column - 1);
   }
   
   Position[] adjacent() {
       Position[] array = new Position[4];
       array[0] = this.top();
       array[1] = this.right();
       array[2] = this.bottom();
       array[3] = this.left();
       return array;
   }
   
   Position[] adjacentNonNegative() {
       Position[] array = this.adjacent();
       int n = 0;
       for (int i = 0; i < array.length; i++) {
           if (array[i].line >= 0 && array[i].column >= 0) {
               n++;
           }
       }
       Position[] nonNegative = new Position[n];
       int j = 0;
       for (int i = 0; i < array.length; i++) {
           if (array[i].line >= 0 && array[i].column >= 0) {
               nonNegative[j] = array[i];
               j++;
           }
       }
       return nonNegative;
   }
}

class PositionUtil {
    static Position[] diagonal(int i) {
        Position[] array = new Position[i];
        for (int j = 0; j < i; j++) {
            array[j] = new Position(j, j);
        }
        return array;
    }
    
    static Position[] positions(Dimension dim) {
        int n = 0;
        Position[] array = new Position[dim.area()];
        for (int i = 0; i < dim.height(); i++) {
            for (int j = 0; j < dim.length(); j++) {
                array[n] = new Position(i, j);
                n++;
            }
        }
        return array;
    }
    
    static boolean contains(Position[] array, Position pos) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(pos))
                return true;
        }
        return false;
    }
}

record Point(double x, double y) {
    boolean isOrigin() {
        return (this.x == 0 && this.y == 0);
    }
    
    Point scale(double factor) {
        return new Point(this.x * factor, this.y * factor);
    }
    
    Point sum(Point p) {
        return new Point(this.x + p.x(), this.y + p.y());
    }
    
    Point sum(double x, double y) {
        return new Point(this.x + x, this.y + y);
    }
    
    double distance(Point p) {
        return (Math.sqrt(Math.pow(p.x() - this.x, 2) + Math.pow(p.y() - this.y, 2)));
    }
}