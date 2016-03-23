package propertybasedtesting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PropertyBasedTest {

	List<int[]> arrays;
	List<int[]> sortedArrays;
	
	@Before
	public void setUp()
	{
		arrays = Util.createArrays();
		sortedArrays = Util.copyArrays(arrays);
		Util.sortArrays(sortedArrays);
	}
	
	@Test
	public void testAlwaysIncreasingOrderProperty(){
		for (int[] a : sortedArrays) {
			for(int i = 1; i < a.length; i++)
			{
				if (a[i] < a[i-1])
				{
					Assert.fail("a[i-1] " + a[i-1] + " > " + a[i] + " a[i] " + "Increasing Order" );
				}
			}
		}
	}
	
	@Test
	public void testSameElementsProperty(){
		Map<Integer, Integer> elementCount;
		int[] a;
		int[] sa;
		int key;
		
		for (int i = 0; i < Util.QTY_OF_ARRAYS; i++)
		{
			a = arrays.get(i);
			sa = sortedArrays.get(i);
			elementCount = new HashMap<>();
			
			for (int m = 0; m < a.length; m++) 
			{
				key = a[m];
				if(elementCount.containsKey(key))
				{
					elementCount.put(key, elementCount.get(key) + 1);
				}
				else
				{
					elementCount.put(key, 1);
				}
			}
			
			for (int n = 0; n < sa.length; n++) 
			{
				key = sa[n];
				if(elementCount.containsKey(key))
				{
					if(elementCount.get(key) == 1)
					{
						elementCount.remove(key);
					}
					else
					{
						elementCount.put(key, elementCount.get(key) - 1);
					}
				}
				else
				{
					Assert.fail();
				}
			}
			if (!elementCount.isEmpty())
			{
				Assert.fail();
			}
		}
	}
	
	@Test
	public void testSameOutputConsistencyProperty()
	{
		
		List<int[]> otherSortedArrays = Util.copyArrays(arrays);
		Util.sortArrays(otherSortedArrays);
		int[] sa;
		int[] osa;
		
		for (int i = 0; i < Util.QTY_OF_ARRAYS; i++)
		{
			sa = sortedArrays.get(i);
			osa = otherSortedArrays.get(i);
			for (int j = 0; j < sa.length; j++) 
			{
				Assert.assertArrayEquals(sa, osa);	
			}
		}
	}
}
