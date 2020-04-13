package practice.algorithms.greedy;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		for(int i=0;i< graph.length;++i){
			int minimumNode = PrimMinimumSpanningTree.minWeightNode(mstResult, visited);
			//update visited
			visited[minimumNode]=true;
			//Update all connected nodes
			for(int j =0;j<graph[minimumNode].length;++j){
				if(graph[minimumNode][j]!=0)
				{
					int distance = mstResult[minimumNode][1]+graph[minimumNode][j];
					if(mstResult[j][1]>distance){
						mstResult[j][1] = distance;
						mstResult[j][2] = minimumNode;
					}
				}
			}
		}
		
		for(int mstNode[] : mstResult)
		{
			System.out.println(mstNode[0]+","+mstNode[1]+","+mstNode[2]);
		}
		
	}

}
