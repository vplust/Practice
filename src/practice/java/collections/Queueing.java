package practice.java.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Queueing {
	
	public static void main(String[] args) {
		priorityQueueing();
	}
	
	public static void priorityQueueing(){
		PriorityBlockingQueue<Integer> pq = new PriorityBlockingQueue<>(50,(a,b)->a<b?-1:1);
		List<Integer> random = IntStream.range(0, 100).boxed().collect(Collectors.toList());
		Collections.shuffle(random);
		System.out.println(random);
		for(int i =0; i<random.size();++i)
		{
			pq.offer(random.get(i));
		}
		System.out.println(pq.size());
		while(!pq.isEmpty())
		{
			System.out.print(pq.peek()+",");
			pq.poll();
		}
	}

}
