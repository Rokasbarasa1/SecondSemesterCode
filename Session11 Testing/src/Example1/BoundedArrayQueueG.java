

public class BoundedArrayQueueG<T> implements QueueADT<T> {

	private T[] q;
	private int front, count;
	private int cap;

	public BoundedArrayQueueG(int cap) {
		q = (T[])(new Object[cap]);
		this.cap = cap;
	}
	
	@Override
	public void enqueue(T element) throws IllegalArgumentException, IllegalStateException{
		if(element == null) {
			throw new IllegalArgumentException("Null is not allowed");
		} else if(count == cap) {
			throw new IllegalStateException("Queue is full");
		}

		q[(front + count) % cap] = element;
		count++;
	}

	@Override
	public T dequeue() throws IllegalStateException {
		if(count == 0) {
			throw new IllegalStateException("Queue is empty");
		}
		T tmp = q[front];
		q[front] = null;
		front = (++front) % cap;
		count--;
		return tmp;
	}

	@Override
	public T first() {
		if(count == 0) throw new IllegalStateException("Queue is empty");
		return dequeue();
	}

	@Override
	public int size() {
		return q.length;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int indexOf(T element) {
		if(element == null) {
			return -1;
		}
		for(int i = 0; i < count; i++) {
			if(element.equals(q[i])) {
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public boolean contains(T element) {
		if(element == null) return false;
		for (T t : q) {
			if(element.equals(t)) return true;
		}
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i = 0; i < count; i++) {
			int idx = (front + i) % cap; 
			sb.append(q[idx]);
			if(i < count -1) {
				sb.append(", ");
			}
		}
		return sb.toString() + "}";
	}

}
