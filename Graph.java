import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
ArrayList<Edge>[] list;
int vt;
@SuppressWarnings("unchecked")
public Graph(int v) {
	vt = v;
	list = new ArrayList[v];
	for (int i = 0; i < list.length; i++) {
		list[i] = new ArrayList<Edge>();
		
	}
}


public void createDGrapgh(int s,int d, int w) {
	list[s].add(new Edge(s, d, w));
//	list[d].add(new Edge(d, s, w));
}

public void createUDGrapgh(int s,int d, int w) {
	list[s].add(new Edge(s, d, w));
	list[d].add(new Edge(d, s, w));
}

public  void  createGraph(){
	createDGrapgh(0,1,5);
	createDGrapgh(0,2,4);
	createDGrapgh(1,3,3);
	createDGrapgh(2,1,6);
	createDGrapgh(3,2,2);
}


public void BellmanFord() {
	int[] dist = new int[list.length];
	for (int i = 0; i < vt; i++) {
		 dist[i] = Integer.MAX_VALUE;
		
	}
	
	
	ArrayList<Edge> al = new ArrayList<>();
	for (ArrayList<Edge> edges : list) {
		for (Edge edge : edges) {
			al.add(edge);
		}
	}
	
	dist[0] = 0;
	for (int i = 1; i < vt; i++) {
		for (Edge edge : al) {
			int u = edge.src;
			int v = edge.dest;
			int w = edge.weight;
			if (dist[u]+w < dist[v]) {
				dist[v] = dist[u]+w ;
			}
		}
		
		
	}
	
	
	for (Edge edge : al) {
		int u = edge.src;
		int v = edge.dest;
		int w = edge.weight;
		if (dist[u]+w < dist[v]) {
			  System.out.println("CreateGraph contains negative w cycle");
			  return ;
		}
	
	}
	
	System.out.println(Arrays.toString(dist));
}


public void print() {
	for (ArrayList<Edge> arrayList : list) {
		System.out.println(arrayList);
	}
}
public static void main(String[] args) {
	Graph g = new Graph(4);
	g.createGraph();
//	g.print();
	
	g.BellmanFord();
	
}
}
