// package test;

public class code19_5 {
	public static <E extends Comparable<E>> E max(E[] list) {
		E max = list[0];
		for(E i:list) {
			if(i.compareTo(max) > 0)
				max = i;
		}
		return max;
	}
	public static void main(String args[]) {
		Integer[] list = {1, 2, 4, 3, 6, 1, 5};
		System.out.println(max(list));
	}
}
