import com.ziemo.algo.DynamicArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

	private DynamicArray array;

	@BeforeEach
	void setUp() {
		array = new DynamicArray(10);
		IntStream.rangeClosed(0,9).forEach(i -> array.getStaticArray()[i]=i+1);
	}

	@Test
	void addTest() {
		array.add(100);
		String result = "1 2 3 4 5 6 7 8 9 10 100";
		assertEquals(result, array.toString());
	}

	@Test
	void removeTest() {
		array.remove(0);
		String result = "2 3 4 5 6 7 8 9 10";
		assertEquals(result,array.toString());
	}

	@Test
	void removeTest_LastItem() {
		array.remove(9);
		String result = "1 2 3 4 5 6 7 8 9";
		assertEquals(result, array.toString());
	}

	@Test
	void removeTest_InvalidItem() {
		assertThrows(IndexOutOfBoundsException.class, () -> array.remove(10));
	}

	@Test
	void insertTest() {
		array.insert(0, 200);
		assertEquals(200, array.getStaticArray()[0]);
	}

}