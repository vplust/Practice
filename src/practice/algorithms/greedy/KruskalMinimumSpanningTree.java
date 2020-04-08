package practice.algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import practice.algorithms.greedy.KruskalMinimumSpanningTree.Graph.Edge;

public class KruskalMinimumSpanningTree {
	
	//Graph
	public static class Graph{
		int vertices;
		Edge edge[];
		
		Graph(int vertices){
			this.vertices = vertices;
			this.edge = new Edge[vertices];
			IntStream.range(0, vertices).forEach(i->edge[i]=new Edge());
		}
		
		public static class Edge implements Comparable<Edge>{
			int src;
			int des;
			int weight;
			
			Edge(){}
			Edge(int src, int des, int weight){
				this.src = src;
				this.des = des;
				this.weight = weight;
			}
			@Override
			public int compareTo(Edge e) {
				// TODO Auto-generated method stub
				return this.weight-e.weight;
			}
			
			@Override
			public String toString(){
				return this.src+" "+this.des+" "+this.weight;
			}
		}
		
		
	}
	
	public static class Set{
		Integer parent;
		Integer rank;
		Set(int parent){
			this.parent = parent;  //Initially each vertices represent their set
			this.rank = 0;
		}
	}
	
	//Helper class to create recursive
	public static class DisjointFunction<I>{
		public I fuction;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vertices = 6;
		Graph graph = new Graph(vertices);
		graph.edge[0] = new Graph.Edge(0, 1, 4);
		graph.edge[1] = new Graph.Edge(0, 2, 2);
		graph.edge[2] = new Graph.Edge(0, 3, 2);
		graph.edge[3] = new Graph.Edge(0, 5, 3);
		graph.edge[4] = new Graph.Edge(4, 5, 1);
		graph.edge[5] = new Graph.Edge(3, 4, 5);
		
		Graph.Edge result[] = new Graph.Edge[vertices];
		//Sort all the edges in decreasing weight
		Arrays.sort(graph.edge);
		//Create separate set for each vertices
		Set[] sets = new Set[vertices];
		IntStream.range(0, vertices).forEach(i->sets[i]=new Set(i));
		//Create disjoint set methods
		DisjointFunction<BiFunction<Set[], Integer, Integer>> find = new DisjointFunction<>();
		find.fuction = (set,parent)->{
			if(sets[parent].parent != parent)
				find.fuction.apply(sets,sets[parent].parent);
			return sets[parent].parent;
		};
		
		BiConsumer<Set[], Integer[]> union = (set,xy)->{
			int xParent = find.fuction.apply(set, xy[0]);
			int yParent = find.fuction.apply(set, xy[1]);

			if(sets[xParent].rank<set[yParent].rank)
				set[xParent].parent = yParent;
			else if(sets[xParent].rank>set[yParent].rank)
				set[yParent].parent = xParent;
			else{
				set[yParent].parent = xParent;
				++set[xParent].rank;
			}
		};
		
		//Call each edge and add to spanning tree
		for(int i=0,e=0;e<vertices-1 && i<graph.edge.length;++i){			
			//Disjont set find subsets
			int x = find.fuction.apply(sets, graph.edge[i].src); //vertex representing set src is included
			int y = find.fuction.apply(sets, graph.edge[i].des); //vertex representing set des is included
			
			if(x!=y){
				result[e++]=graph.edge[i];
				union.accept(sets, new Integer[]{x,y});
			}
		}
		
		System.out.println(Arrays.asList(result).stream().filter(a->a!=null).collect(Collectors.toList()));
		
	}

}
