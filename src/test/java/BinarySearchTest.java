import com.ziemo.algo.divideAndConquer.BinarySearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

		BinarySearch bs;

		@BeforeEach
		void setUp() {
			bs = new BinarySearch(1, 2, 3, 4, 5, 6);
		}

		@TestFactory
		Stream<DynamicTest> testSearchFound() {
			return Arrays.stream(bs.in).map(e -> DynamicTest.dynamicTest("ckecker", () -> {
				assertAll(() ->{
					assertTrue(bs.search(bs.in, e));
					assertFalse(bs.search(bs.in, e+bs.in.length));
				});
			}));
		}

}