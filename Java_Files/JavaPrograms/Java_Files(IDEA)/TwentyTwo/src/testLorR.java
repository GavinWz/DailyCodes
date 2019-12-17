import java.util.ArrayList;

public class testLorR {

    public static void main(String[] args){
        MyPoint p1= new MyPoint(1, 0);
        MyPoint p2= new MyPoint(2, 1);
        MyPoint p0= new MyPoint(0, -1);
        System.out.println(judgeLorR(p1, p2, p0));
    }

    private static class MyPoint implements Comparable<MyPoint>{
        double x, y;
        MyPoint rightMostLowestPoint;

        MyPoint(double x, double y){
            this.x = x;
            this.y = y;
        }

        public void setRightMostLowestPoint(MyPoint p){
            rightMostLowestPoint = p;
        }

        @Override
        public int compareTo(MyPoint o) {
            if((this.x * this.x + this.y * this.y) > (o.x * o.x +o.y + o.y))
                return 1;
            else if((this.x * this.x + this.y * this.y) == (o.x * o.x +o.y + o.y))
                return 0;
            else
                return -1;
        }
    }

    public static double judgeLorR(MyPoint s1, MyPoint s2, MyPoint s0){  //smaller, false; biger, true
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(0, 0);
        p1.x = s1.x - s2.x;
        p1.y = s1.y - s2.y;
        p2.x = s0.x - s1.x;
        p2.y = s0.y - s1.y;
        return p1.x * p2.y - p2.x * p1.y;
    }
}
