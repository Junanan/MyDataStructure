import java.awt.Color;
import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		Map<Vertex,List<Vertex>> adjacencyL = new TreeMap<>();
		List<Vertex> aTartgetA = new LinkedList<>();
		List<Vertex> aTartgetB = new LinkedList<>();
		List<Vertex> aTartgetC = new LinkedList<>();
		List<Vertex> aTartgetD = new LinkedList<>();
		List<Vertex> aTartgetE = new LinkedList<>();
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		aTartgetA.add(B);
		aTartgetA.add(C);
		aTartgetB.add(C);
		aTartgetC.add(D);
		aTartgetC.add(E);
		aTartgetD.add(C);
		aTartgetD.add(E);
		adjacencyL.put(A,aTartgetA );
		adjacencyL.put(B,aTartgetB );
		adjacencyL.put(C,aTartgetC );
		adjacencyL.put(D,aTartgetD );
		adjacencyL.put(E,aTartgetE );
	}
	public static void dfs(Vertex x ) {
		for(int i = 0 ;i<5;i++) {
			if(x.color==Color.WHITE) {
				x.color=Color.BLACK;
				
			}
		}
	}
	

}
class Vertex implements Comparable<Vertex>{
	String key;
	Color color;
	int d;
	Vertex p;
	
	public Vertex(String key) {
		this.key = key;
		color = Color.white;
		d = Integer.MAX_VALUE;
		p = null;	
	}
	public int compareTo(Vertex v) {
		return key.compareTo(v.key);
	}
	public String toString() {
		return key;
	}
}