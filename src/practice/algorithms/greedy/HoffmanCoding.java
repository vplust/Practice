package practice.algorithms.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HoffmanCoding {
	
	public static class Node{
		char c;
		int frequency;
		Node left;
		Node right;
		public Node(char ch, int frequency) {
			this.c = ch;
			this.frequency = frequency;
		}
		
		@Override
		public String toString(){
			return c+" "+frequency;
		}
	}
	
	public static void printHoffmanCode(Node node,String code){
		if(node.left==null && node.right==null)
		{
			System.out.println(node.c+" : "+code);
			return;
		}
		printHoffmanCode(node.left, code+"0");
		printHoffmanCode(node.right, code+"1");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create Test string
		String inputString = "zzzzzzzabppppppbcccddddeeeee";
		Map<Character,Integer> count = new HashMap<>();
		for(Character c : inputString.toCharArray())
			count.compute(c, (k,v)->null!=v?v+1:1);
		System.out.println(count);
		
		//Create separate nodes
		PriorityQueue<Node> hoffmanHeap = new PriorityQueue<>((a,b)->a.frequency-b.frequency);
		for(Map.Entry<Character, Integer> entry : count.entrySet())
			hoffmanHeap.offer(new Node(entry.getKey(), entry.getValue()));
		
		//Create hoffman heap
		while(hoffmanHeap.size()>1){
			Node left = hoffmanHeap.poll();
			Node right = hoffmanHeap.poll();
			Node root = new Node('-',left.frequency+right.frequency);
			root.left = left;
			root.right = right;
			
			hoffmanHeap.offer(root);
		}
		printHoffmanCode(hoffmanHeap.poll(), "");
		
	}

}
