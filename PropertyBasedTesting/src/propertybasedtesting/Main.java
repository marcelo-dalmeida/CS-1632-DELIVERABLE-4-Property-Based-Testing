package propertybasedtesting;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<int[]> arrays = Util.createArrays();
		List<int[]> sortedArrays = Util.copyArrays(arrays);
		Util.sortArrays(sortedArrays);
	}
}