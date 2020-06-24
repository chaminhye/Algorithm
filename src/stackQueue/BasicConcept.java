package stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BasicConcept {

	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList();
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("-====== Stack ========");
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
		
		System.out.println("-====== Queue ========");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		Queue pq = new PriorityQueue();
		
		pq.offer(3);
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		
		System.out.println(pq);
		
		Object obj = null;
		
		
		while((obj = pq.poll()) != null) {
			System.out.println(obj);
		}
		
		
		Deque<String> stack = new ArrayDeque<>();
		stack.addFirst("Element1");
		stack.addFirst("Element2");
		stack.addFirst("Element3");
		System.out.println(stack.removeFirst());
		System.out.println(stack.removeFirst());
		System.out.println(stack.removeFirst());
		
		System.out.println("=======================");
		
		Deque<String> queue = new ArrayDeque<>();
		queue.addFirst("Element1");
		queue.addFirst("Element2");
		queue.addFirst("Element3");
		System.out.println(queue.removeLast());
		System.out.println(queue.removeLast());
		System.out.println(queue.removeLast());
	}
}
