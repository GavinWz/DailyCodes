import javafx.geometry.Point2D;

import java.awt.*;
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

    }
    public static ArrayList<Point2D> find(ArrayList<Point2D> list) {
        ArrayList<Point2D> wrapping = new ArrayList<>();
        Point2D h0 = list.get(0);
        Point2D t0;
        Point2D t1;

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            Point2D temp = list.get(i);
            if (temp.getX() * temp.getX() + temp.getY() * temp.getY() >
                    h0.getX() * h0.getX() + h0.getY() * h0.getY()) {
                h0 = temp;
                index = i;
            }
        }
        wrapping.add(h0);
        t0 = h0;
        list.remove(h0);
        for (int i = 0; i < list.size(); i++) {
            t1 = list.get(0);
            for (Point2D temp : list) {
                if (judgeRorL(t0, t1, temp) > 0) {
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

    public static int judgeRorL(Point2D s1, Point2D s2, Point2D test){  //L,return 0; R,return 1.
        double k = (s2.getY() - s1.getY()) / (s2.getX() - s1.getX());
        return 0;
    }

}
