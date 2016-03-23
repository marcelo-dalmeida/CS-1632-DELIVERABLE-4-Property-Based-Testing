package propertybasedtesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Util {
	
	public static final int QTY_OF_ARRAYS = 100;
	public static final int MAX_LENGTH = 100;
	public static final int MAX_VALUE = 100;
	
	public static List<int[]> createArrays()
	{
		Random rand = new Random();
		List<int[]> arrays = new ArrayList<>();
		
		int length;
		int value;
		int[] a;
		
		for(int i = 0; i < QTY_OF_ARRAYS; i++)
		{
			length = rand.nextInt(MAX_LENGTH + 1);
			a = new int[length];
			for (int j = 0; j < a.length; j++) {
				value = rand.nextInt(MAX_VALUE + 1);
				a[j] = value;
			}
			arrays.add(a);
		}
		return arrays;
	}
	public static List<int[]> copyArrays(List<int[]> arrays)
	{
		List<int[]> copy = new ArrayList<>();
		for (int[] a : arrays) {
			copy.add(a.clone());
		}
		return copy;
	}
	public static void sortArrays(List<int[]> arrays)
	{
		for (int[] a : arrays) {
			Arrays.sort(a);
		}
	}
	
	public static void print(List<int[]> arrays)
	{
		for (int[] a : arrays) {
			for (int i : a) {
				System.out.print(" " + i + " ");
			}
			System.out.println();
		}
	}
}
