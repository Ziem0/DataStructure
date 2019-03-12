import com.ziemo.algo.stack.StackOverFlow;
import com.ziemo.algo.stack.StackUnderFlow;
import com.ziemo.algo.stack.Stackk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackkTest {

	Stackk<String> stackk;

	@BeforeEach
	void setUp() {
		stackk = new Stackk<>(10);
	}

	@Test
	void testSize() {
		assertEquals(10, stackk.getSize());
	}

	@Test
	void testRemainSpace() throws StackOverFlow {
		stackk.push("demo");
		assertEquals(9, stackk.leftSize());
	}

	@Test
	void testPush() throws StackOverFlow {
		stackk.push("demo1");
		stackk.push("demo2");
		stackk.push("demo3");
		String result = "demo1 demo2 demo3 null null null null null null null";
		assertEquals(result, stackk.toString());
	}

	@Test
	void testPop() throws StackOverFlow, StackUnderFlow {
		stackk.push("demo1");
		stackk.push("demo2");
		assertEquals("demo2", stackk.pop());
	}

	@Test
	void testRemoveAfterPop() throws StackOverFlow, StackUnderFlow {
		stackk.push("demo1");
		stackk.push("demo2");
		stackk.pop();
		assertEquals(9,stackk.leftSize());
	}

	@Test
	void testPeek() throws StackOverFlow, StackUnderFlow {
		stackk.push("demo1");
		stackk.push("demo2");
		assertEquals("demo2", stackk.peek());
	}

	@Test
	void testStackOverFlow() throws StackOverFlow {
		for (int i = 0; i < 10; i++) {
			stackk.push(1 + " num");
		}
		assertThrows(StackOverFlow.class, () -> stackk.push("too much"));
	}

	@Test
	void testStackUnderFlow() {
		assertAll(() -> {
			assertThrows(StackUnderFlow.class, () -> stackk.pop());
			assertThrows(StackUnderFlow.class, () -> stackk.peek());
		});

	}

}