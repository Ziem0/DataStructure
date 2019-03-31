import com.ziemo.algo.divideAndConquer.efficient.QuickSort;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.*;

class QuickSortTest {


	QuickSort quickSort;

	@BeforeEach
	void setUp() {
		quickSort = new QuickSort();
	}

	@RepeatedTest(50)
	void mainTest() {
		int[] ints = new Random().ints(50, 1, 100).toArray();
		List<Integer> data = new LinkedList<>();
		Arrays.stream(ints).forEach(data::add);
		List<Integer> expecting = data;

//		quickSort.sortFinal(data);
		quickSort.sort(data);

		StringBuilder result = new StringBuilder();
		data.forEach(e -> result.append(e).append(" "));

		Collections.sort(expecting);
		StringBuilder expectResult = new StringBuilder();
		expecting.forEach(e -> expectResult.append(e).append(" "));

		Assert.assertEquals(expectResult.toString(), result.toString());
	}
}