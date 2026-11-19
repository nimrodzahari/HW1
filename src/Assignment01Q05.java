public class Assignment01Q05 {
    public static int findShortestPath(int[][] matrix, int i, int j) {
    int n = matrix.length;
    int[] distance = new int[n];
    int[] queue = new int[n];

    for (int k = 0; k < n; k++) {
        distance[k] = -1;
    }

    int head = 0;
    int tail = 0;

    distance[i] = 0;
    queue[tail] = i;
    tail++;

    while (head < tail) {
        int v = queue[head];
        head++;

        for (int k = 0; k < n; k++) {
            if (matrix[v][k] == 1 && distance[k] == -1) {
                distance[k] = distance[v] + 1;
                queue[tail] = k;
                tail++;
            }
        }
    }

    return distance[j];
}

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}