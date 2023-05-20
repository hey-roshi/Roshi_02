public class Edge {
int src;int dest; int weight;
public Edge(int s, int d, int w) {
	src = s;dest = d;weight = w;
}

@Override
	public String toString() {
		
		return "("+ src+","+ dest+","+weight+" )";
	}
}
