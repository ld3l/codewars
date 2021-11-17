import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//Given a number of points on a plane, your task is to find two points with the smallest distance between them in linearithmic O(n log n) time.
public class ClosestPair {

public static List<Point> closestPair(List<Point> points) {
      List<Point> pair = new ArrayList<>();
      List<Point> arr = new ArrayList<>(points);
      arr.sort(Comparator.comparing(a -> a.x));
      final int n = points.size();
      double l = Integer.MAX_VALUE;
      double tolerance = Math.sqrt(l);
      int a = 0, b = 0;
      for (int i = 0; i + 1 < n; i++) {
          for (int j = i + 1; j < n; j++) {
              if (arr.get(j).x >= arr.get(i).x + tolerance) {
                  break;
              }
              double ls = Math.pow(arr.get(i).x - arr.get(j).x, 2) + Math.pow(arr.get(i).y - arr.get(j).y, 2);
              if (ls < l) {
                  l = ls;
                  tolerance = Math.sqrt(l);
                  a = i;
                  b = j;
              }
          }
      }
      pair.add(arr.get(a));
      pair.add(arr.get(b));
      return pair;
  }
}

class Point {
    public double x, y;

    public Point() {
        x = y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", x, y);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(x) ^ Double.hashCode(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point other) {
            return x == other.x && y == other.y;
        } else {
            return false;
        }
    }
}