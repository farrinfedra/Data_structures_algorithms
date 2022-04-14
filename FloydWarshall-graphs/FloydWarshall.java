public class FloydWarshall {
    public int[][] array;

    public FloydWarshall(Graph graph) {
        int size = graph.vertices.size();
        array = new int[size][size];
        array = graph.asArray(true);
        for (int k = 0; k <size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (array[i][j] > array[i][k] + array[k][j] && array[i][k] != Graph.INFINITY && array[k][j] != Graph.INFINITY ) {
                        array[i][j] = array[i][k] + array[k][j];
                    }
                }
            }
        }
    }

    public int[][] getFloydWarshal() {
        return array;
    }
}
