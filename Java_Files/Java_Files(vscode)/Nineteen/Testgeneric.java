import java.util.Scanner;

public class Testgeneric {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Integer[] integer= {1, 2, 3};
		System.out.println(" "+ integer);
		Integer Max;
		Max=max(integer);
		System.out.println(" "+Max);
		// TODO Auto-generated method stub

	}

	public static <E extends Comparable<E>> E max(E[] list)
	{
		E max;
		max=list[0]; 
		for(int i=1;i<list.length-1;i++)
		{
			if(max.compareTo(list[i])<0)
				max=list[i];
		}
		return max;
		
	}
}