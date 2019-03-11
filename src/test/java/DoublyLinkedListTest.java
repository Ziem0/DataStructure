import com.ziemo.algo.doublyLinkedLista.DoublyLinkedList;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

	DoublyLinkedList<String> list;

	@BeforeEach
	void setUp() {
		list = new DoublyLinkedList<>();
	}

	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
	}

	@TestFactory
	Stream<DynamicTest> testAddAndGet() {
		String[] input = {"ziemo", "ania", "nina", "gabi"};
		return Arrays.stream(input).map(i -> DynamicTest.dynamicTest("addManyInput", () -> {
			list.add(0, i);
			assertEquals(i, list.getElement(0));
		}));
	}

	@Test
	void testSize() {
		list.add(0, "ziemo");
		list.add(1, "ziemo");
		assertEquals(2, list.getSize());
	}

	@TestFactory
	Stream<DynamicTest> testAdd() {
		List<Integer> integers = Arrays.asList(0, 1, 2, 0, 1);
		return integers.stream().map(i -> DynamicTest.dynamicTest("random adding", () -> {
			list.add(i, i + " number");
			assertEquals(i+" number", list.getElement(i));
		}));
	}

	@RepeatedTest(20)
	void testRemove() {
		for (int i = 0; i < 100; i++) {
			list.add(i,i + "");
		}

		int randomInt = new Random().nextInt(100);
		List<Integer> expected = IntStream.rangeClosed(0, 99).filter(i -> i != randomInt).boxed().collect(Collectors.toList());
		list.remove(randomInt);
		assertEquals(expected.toString(), list.iterate());
	}
}