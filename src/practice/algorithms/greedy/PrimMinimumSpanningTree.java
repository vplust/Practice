package practice.algorithms.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class PrimMinimumSpanningTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create grtaph
		int graph[][]= {
				{0,2,0,6,0},
				{2,0,3,8,5},
				{0,3,0,0,7},
				{6,8,0,0,9},
				{0,5,7,9,0}
		};
		boolean[] visited = new boolean[graph.length];
		int intMax = Integer.MAX_VALUE	;
		int mstResult[][]={
				{0,0,-1},
				{1,intMax,-1},
				{2,intMax,-1},
				{3,intMax,-1},
				{4,intMax,-1},
		};
		
		//Traverse each node and update weight on each connected node to the traversing node
		for(int i =0; i< graph.length;++i){
			int minWeightNode = minWeightNode(mstResult,visited);
			visited[minWeightNode] = true;
			int connectedNodes[] = graph[minWeightNode];
			for(int j =0;j<connectedNodes.length;++j){
				if(connectedNodes[j]!=0 && mstResult[j][1] > connectedNodes[j]){
					mstResult[j][1]=connectedNodes[j];
					mstResult[j][2]=minWeightNode;
				}	
			}
			
		}
		
		for(int mstNode[] : mstResult)
		{
			System.out.println(mstNode[0]+","+mstNode[1]+","+mstNode[2]);
		}
	}

	public static int minWeightNode(int mstResult[][], boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int mstNode[] : mstResult)
			if(mstNode[1]<=min && visited[mstNode[0]]==false)
			{
				min = mstNode[1];
				index = mstNode[0];
			}
		return index;
	}

}
