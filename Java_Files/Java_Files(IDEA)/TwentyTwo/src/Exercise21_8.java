import javafx.geometry.Point2D;
import java.util.ArrayList;

public class Exercise21_8 {
    public static void main(String[] args) {
        ArrayList<Point2D> list = new ArrayList<>();
        list.add(new Point2D(2, 3));
        list.add(new Point2D(8, 5));
        list.add(new Point2D(0, 4));
        list.add(new Point2D(2, 6));
        list.add(new Point2D(7, 2));
        list.add(new Point2D(9, 4));
        list.add(new Point2D(5, 7));
        System.out.println("The original points list is: ");
        for(Point2D temp : list)
            System.out.print("["  + temp.getX() + ", " + temp.getY() + "] ");
        System.out.println();
        System.out.println("After sorted by gift-wrapping algorithm, they are: ");
        ArrayList<Point2D> getIt = find(list);
        for(Point2D temp : getIt)
            System.out.print("["  + temp.getX() + ", " + temp.getY() + "] ");
    }
    public static ArrayList<Point2D> find(ArrayList<Point2D> list) {
        ArrayList<Point2D> wrapping = new ArrayList<>();
        Point2D h0 = list.get(0);
        Point2D t0;
        Point2D t1;

        for (int i = 0; i < list.size(); i++) {
            Point2D temp = list.get(i);
            if (temp.getX() * temp.getX() + temp.getY() * temp.getY() >
                    h0.getX() * h0.getX() + h0.getY() * h0.getY()) {
                h0 = temp;
            }
        }

        wrapping.add(h0);
        t0 = h0;
        list.remove(h0);

        while(true){
            if(list.size() == 0)
                break;
            t1 = list.get(0);
            for (Point2D temp : list) {
                if (judgeLorR(t0, t1, temp) > 0) {
                    t1 = temp;
                }
            }
            if(t1 != h0) {
                wrapping.add(t1);
                list.remove(t1);
                t0 = t1;
            }
            else
                break;
        }
        return wrapping;
    }

    public static double judgeLorR(Point2D s1, Point2D s2, Point2D s0){
        Point2D p1 = new Point2D(s1.getX() - s2.getX(), s1.getY() - s2.getY());
        Point2D p2 = new Point2D(s0.getX() - s1.getX(), s0.getY() - s1.getY());
        return p1.getX() * p2.getY() - p2.getX() * p1.getY();
    }

}
