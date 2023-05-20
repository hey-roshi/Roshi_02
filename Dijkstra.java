import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
 ArrayList<Edge>[] list;
 int vt;
 @SuppressWarnings("unchecked")
public Dijkstra(int v) {
	 list = new ArrayList[v];
	 vt = v;
	 for (int i = 0; i < list.length; i++) {
		list[i] =  new ArrayList<Edge>();		
	}
} 
	
 public void insert(int s, int d, int w) {
	list[s].add(new Edge(s, d, w));
}
 
 public void createGraph() {
//	insert(0, 1, 2);
//	insert(0, 2, 4);
//	
//	insert(1, 3, 7);
//	insert(1, 2, 1);
//	
//	insert(2, 4, 3);
//	
//	insert(3, 5, 1);
//	insert(4, 3, 2);
//	insert(4, 5, 5);
	 
	 
	 insert(0, 1, 2);
	 insert(0, 2, 8);
	 insert(1, 2, 5);
	 insert(1, 3, 6);
	 insert(2, 3, 3);
	 insert(2, 4, 2);
	 insert(4, 3, 1);
	 insert(4, 5, 3);
	 insert(3, 5, 9);
	 
}
 
 public void display() {
	for (ArrayList<Edge> arrayList : list) {
		System.out.println(arrayList);
	}
}
 

 
 
 public void dijk2(int start) {
	PriorityQueue<Edge> q = new PriorityQueue<>();
	int[] dist = new int[vt];
	int previous[] = new int[vt];
	boolean[] isVisited = new boolean[vt];
	for (int i = 0; i < isVisited.length; i++) {
		dist[i] = Integer.MAX_VALUE;
		previous[i] = -1;
	}
	int prev = start;
	dist[start] = 0;
	q.offer(new Edge(start, start, 0));
	while (!q.isEmpty()) {
		Edge t = q.poll();
		if (isVisited[t.dest] == false) {
			isVisited[t.dest] = true;
			prev = t.dest;
			
					
			for (Edge e : list[t.dest]) {
				int u = e.src;
				int v = e.dest;
				int w = e.weight;
				if ( (dist[u] + w) < dist[v] ) {
					dist[v] = dist[u] + w;
					previous[v] = prev;
					e.weight = dist[v];
					q.offer(e);
				}
			}
		}
	}
	
	for (int i = 0; i < vt; i++) {
			System.out.println(i+"  "+dist[i] +"  "+ previous[i]);
		
	}
}
 
 
 
public static void main(String[] args) {
   Dijkstra g = new Dijkstra(6);
   g.createGraph();
//   g.display();
   g.dijk2(0);
}

}
