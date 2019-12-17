import java.lang.Math;
import java.util.ArrayList;
public class code19_8 {
	public static <E> void shuffle(ArrayList<E> list) {
		for(int i = 0; i < list.size(); i++) {
			int index = (int)(Math.random() * list.size());
			E temp = list.get(index);
			list.set(index, list.get(i));
			list.set(i, temp);
			System.out.println(index);
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] numbers = {1,2,3,4,5,6,7};
		for(int i : numbers) {
			list.add(i);
		}
		System.out.println("Begins:");
		System.out.println(list);
		shuffle(list);
		System.out.println("End:");
		System.out.println(list);
	}

}
