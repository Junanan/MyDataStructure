package 图;

public class Graph {
	private Vertex[] vertex;
	private int currentSize;
	public int [][] adjMat;
	public Graph(int size) {
		vertex = new Vertex[size];
		adjMat=new int[size][size];
	}
	//像图中加入一个顶点
	public void addVertex(Vertex v) {
		vertex[currentSize++]=v;
	}
	public void addEdge(String v1,String v2) {
		//找出两个节点的下标
		int index1 = 0;
		for(int i=0;i<vertex.length;i++) {
			if(vertex[i].getValue().equals(v1)) {
				index1=i;
				break;
			}
		}
		int index2 = 0;
		for(int i=0;i<vertex.length;i++) {
			if(vertex[i].getValue().equals(v2)) {
				index2=i;
				break;
			}
		}
		adjMat[index1][index2]=1;
		adjMat[index2][index1]=1;
	}
	/**
	 * 深度优先算法
	 */
	public void dfs() {
		//把第0个顶点标记为已访问状态
		vertex[0].visited = true;
		
	}
}
