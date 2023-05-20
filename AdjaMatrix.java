public class AdjaMatrix {
	boolean[][]adj;
	int v;
	public AdjaMatrix(int v) {
	this.v=v;
	adj=new boolean[v][v];
}
public void insert(int s,int d) {
	adj[s][d]=true;
	adj[d][s]=true;
}

public static void main(String[] args) {
	AdjaMatrix g=new AdjaMatrix(4);
	g.insert(0,1);
	g.insert(1,2);
	g.insert(2,3);
	g.insert(3,0);
	
	for(int i=0;i<4;i++) {
		
	for(int j=0;j<4;j++){
		System.out.print(g.adj[i][j]+" ");
	}
	System.out.println();
	}
}
}
