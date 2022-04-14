import java.util.ArrayList;

public class Graph {

	public ArrayList<String> vertices;
	public ArrayList<Edge> edges;
	public static final int INFINITY = 999999;

	public Graph() {
		vertices = new ArrayList<String>();
		edges = new ArrayList<Edge>();
	}

	public void addVertex(String v) {
		if (!vertices.contains(v)) vertices.add(v);
	}

	public void addEdge(Edge e) {
		edges.add(e);
		if (!vertices.contains(e.src)) {
			vertices.add(e.src);
		}
		if (!vertices.contains(e.dst)) {
			vertices.add(e.dst);
		}
	}

	public void removeVertex(String v) {
		vertices.remove(v);
	}

	public void removeEdge(Edge e) {
		edges.remove(e);
	}

	public void removeVertex(int v_index) {
		vertices.remove(v_index);
	}

	public void removeEdge(int e_index) {
		edges.remove(e_index);
	}

	public int numEdges() {
		return edges.size();
	}

	// This method will give you an adjacency matrix form
	// give the boolean parameter false to get the costs
	// if it is true you will get latencies instead (this will not be needed in part I)

	public int[][] asArray(boolean latency) {
		int size = vertices.size();
		int[][] result = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					result[i][j] = 0;
				} else {
					result[i][j] = INFINITY;
				}
			}
		}


		for (Edge e : edges) {
			int value = e.cost;
			if (latency) value = e.latency;
			int src_index = vertices.indexOf(e.src);
			int dst_index = vertices.indexOf(e.dst);
			result[src_index][dst_index] = result[dst_index][src_index] = value;
		}

		return result;
	}
}

