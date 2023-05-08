package queues;

import stacks.StackSLL;

public class QueueSt<E> {
	
		// data fields
		private StackSLL<E> left;
		private StackSLL<E> right;
		private int size;
		
		// Constructor
	
		
		public void add (E item) {


		}
		
		public E remove() {
			return null;
			
		}
		
		public E element() {
			return null;

		}
		
		public Boolean isEmpty() {
			return null;

		}
		
		public String toString() {
			return null;

				
		}
		
		public static void main(String[] args) {
			QueueSt<String> q = new QueueSt<>();
			
			q.add("one");
			q.add("two");
			q.add("three");
			
			System.out.println(q);
			q.remove();
			System.out.println(q);
			
			
		}
		

	}

