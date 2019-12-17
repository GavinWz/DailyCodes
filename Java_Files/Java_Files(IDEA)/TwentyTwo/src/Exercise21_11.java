import java.util.ArrayList;
import java.util.Stack;

public class Exercise21_11 {


    public static void main(String[] args){
        double[][] list = {{2, 3}, {8, 5}, {0, 4}, {2, 6}, {7, 2}, {9, 4}, {5, 7}};
        System.out.println("The original points list is: ");
        for(double[] temp : list)
            System.out.print("["  + temp[0] + ", " + temp[1] + "] , ");
        System.out.println();
        System.out.println("After sorted by Graham algorithm, they are: ");
        Stack<MyPoint> getIt = getConvexHull(list);
        for(MyPoint temp : getIt)
            System.out.println("["  + temp.x + ", " + temp.y + "]");
    }

    private static class MyPoint implements Comparable<MyPoint>{
        double x, y;

        MyPoint(double x, double y){
            this.x = x;
            this.y = y;
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

    public static Stack<MyPoint> getConvexHull(double[][] s){
        ArrayList<MyPoint> points = new ArrayList<>();
        ArrayList<MyPoint> getIt = new ArrayList<>();
        for(double[] temp : s){   //Insert the ArrayList
            points.add(new MyPoint(temp[0], temp[1]));
        }
        MyPoint rightDown = points.get(0);
        for(MyPoint temp : points){  //Find the rightDown point
            if(temp.compareTo(rightDown) > 0)
                rightDown = temp;
        }
        sort(points); //Sort the points ArrayList
        Stack<MyPoint> H = new Stack<>();
        H.push(rightDown);
        H.push(points.get(0));
        H.push(points.get(1));
        H.push(points.get(2));

        for(int i = 3; i < points.size()-1; ) {
            MyPoint t1 = H.pop();
            MyPoint t2 = H.peek();
            H.push(t1);
            if (judgeLorR(t1, t2, points.get(i)) < 0) {
                H.push(points.get(i));
                i++;
            } else {
                getIt.add(H.pop());
            }
        }

        return H;
    }

    public static void sort(ArrayList<MyPoint> list){
        MyPoint temp;
        MyPoint p0 = list.get(0);
        for(int i = 0; i < list.size(); i++){
            for(int j = 1; j < list.size() - i; j++){
                if(judgeBorS(list.get(j-1), list.get(j), p0) > 0){
                    temp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                }
                else if(judgeBorS(list.get(j-1), list.get(j), p0) == 0){
                    double distance1 = Math.sqrt(Math.pow(list.get(j).x - p0.x, 2) +
                            Math.pow(list.get(j).y - p0.y, 2));
                    double distance2 = Math.sqrt(Math.pow(list.get(j-1).x - p0.x, 2) +
                            Math.pow(list.get(j-1).y - p0.y, 2));
                    if(distance1 > distance2)
                        list.remove(j-1);
                    else
                        list.remove(j);
                }
            }
        }
    }

    public static int judgeBorS(MyPoint s1, MyPoint s2, MyPoint s0){  //smaller, false; biger, true

        double angle1 = (s1.x - s0.x) / (Math.sqrt(Math.pow(s1.x - s0.x, 2) + Math.pow(s1.y - s0.y, 2)));
        double angle2 = (s2.x - s0.x) / (Math.sqrt(Math.pow(s2.x - s0.x, 2) + Math.pow(s2.y - s0.y, 2)));
        if(s2.y - s0.y < 0 && s1.y - s0.y > 0)
            return 1;
        else if (s2.y - s0.y > 0 && s1.y - s0.y < 0)
            return -1;
        else if(s2.y - s0.y >= 0 && s1.y - s0.y >= 0) {
            if (angle1 > angle2)
                return 1;
            else if (angle1 == angle2)
                return 0;
            else
                return -1;
        }
        else{
            if (angle1 > angle2)
                return -1;
            else if (angle1 == angle2)
                return 0;
            else
                return 1;
        }
    }
    public static double judgeLorR(MyPoint s1, MyPoint s2, MyPoint s0){
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(0, 0);
        p1.x = s1.x - s2.x;
        p1.y = s1.y - s2.y;
        p2.x = s0.x - s1.x;
        p2.y = s0.y - s1.y;
        return p1.x * p2.y - p2.x * p1.y;
    }


}
