import com.ziemo.algo.queue.CustomQueue;
import com.ziemo.algo.stack.StackUnderFlow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

	private CustomQueue q;

	@BeforeEach
	void setUp() {
		q = new CustomQueue();
	}

	@Test
	void testSize() {
		q.enqueue("demo", null);
		assertEquals(1, q.queueSize());
	}

	@Test
	void testIsEmpty() {
		assertAll(() -> {
			assertTrue(q.isEmpty());
			q.enqueue("demo", null);
			assertFalse(q.isEmpty());
		});
	}

	@Test
	void testEnqueue() {
		assertAll(() -> {
			q.enqueue("demo1", null);
			assertEquals("demo1", q.peek());
			q.enqueue("demo2", 1);
			assertEquals("demo2", q.peek());
			q.enqueue("demo3", 3);
			q.enqueue("demo4", 2);
			q.dequeue();
			assertEquals("demo4", q.peek());
		});
	}

	@Test
	void testPeek() throws StackUnderFlow {
		q.enqueue("demo1", null);
		q.enqueue("demo2", null);
		assertEquals("demo1", q.peek());
	}

	@Test
	void testDequeue() throws StackUnderFlow {
		q.enqueue("demo1", null);
		q.enqueue("demo2", 1);
		assertAll(() -> {
			assertEquals("demo2", q.dequeue());
			assertEquals(1, q.queueSize());
		});

	}


}