package queue_using_array;

public class QueueUse {
	public static void main(String[] args) throws QueueFullException, QueueEmptyException {
		QueueUsingArray queue = new QueueUsingArray();
		int curr[] = {10, 20, 30, 40, 50};

		for(int elem : curr)
		{
			queue.enqueue(elem);
			System.out.println(elem);   // 10 20 30 40 50
		}

		System.out.println("Size :" + queue.size());   // Size :5
		System.out.println("Is Empty ? " + queue.isEmpty());   // Is Empty ? false
		System.out.println("First element in Queue : " + queue.front());   // First element in Queue : 10

		// delete two elements (10, 20)
		queue.dequeue();
		queue.dequeue();

		System.out.println("Size :" + queue.size());   // Size :3

		queue.enqueue(60);   // will throw QueueFullException
		queue.enqueue(70);   // not executed

		System.out.println(queue.front());   // not reached
	}
}