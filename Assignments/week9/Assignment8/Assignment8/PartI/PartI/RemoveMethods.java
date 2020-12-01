package PartI;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RemoveMethods {

	public static void remAllStack(Stack<Object> stack, Object item) {
		Stack<Object> stkTemp = new Stack<Object>();
		Object tmp;
		while(stack.size() > 0) {
//			System.out.println(stack.pop());
			tmp = stack.pop();
			if (!tmp.equals(item)){
				stkTemp.push(tmp);
			}
		}
		while (stkTemp.size() > 0) stack.push(stkTemp.pop());
	}
		
		


	
	public static void remAllQueue(Queue<Object> queue, Object item) {
		Queue<Object> queTemp = new LinkedList<Object>();
		Object tmp;
		while(queue.size() > 0) {
//			System.out.println(stack.pop());
			tmp = queue.remove();
			if (!tmp.equals(item)){
				queTemp.add(tmp);
			}
		}
		while (queTemp.size() > 0) queue.add(queTemp.remove());
		

	}
	
	public static void main(String[] args) {
//		System.out.print(30);
		Stack<Object> stk = new Stack<Object>();
		stk.push(new Integer(24));
		stk.push(new Integer(2));
		stk.push(new Integer(9));
		stk.push(new Integer(2));
		stk.push(new Integer(7));
		stk.push(new Integer(10));
		stk.push(new Integer(16));
		System.out.println("begin: stk is " + stk);
		RemoveMethods.remAllStack(stk, new Integer(2));
		System.out.println("end: stk is " + stk);
		RemoveMethods.remAllStack(stk, new Integer(24));
		System.out.println("end: stk is " + stk);
		
		Queue<Object> q = new LinkedList<Object>(); // you should probably find a concrete class for this
		q.offer(new Integer(24));
		q.offer(new Integer(2));
		q.offer(new Integer(9));
		q.offer(new Integer(2));
		q.offer(new Integer(7));
		q.offer(new Integer(10));
		q.offer(new Integer(16));
		System.out.println("begin: q is " + q);
		RemoveMethods.remAllQueue(q, new Integer(2));
		System.out.println("end: q is " + q);
		RemoveMethods.remAllQueue(q, new Integer(24));
		System.out.println("end: q is " + q);
//		
	}
}
