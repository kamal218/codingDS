import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class myGraph {

    public static class Edge {
        int nbr = 0;
        int wt = 0;

        public Edge(int nbr, int wt) {
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static ArrayList<Edge>[] graph = new ArrayList[7];

    public static void main(String[] args) {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();
        addEdge(0, 1, 30);
        addEdge(0, 3, 30);
        addEdge(2, 1, 30);
        addEdge(2, 3, 30);
        addEdge(4, 3, 30);
        addEdge(4, 5, 30);
        addEdge(4, 6, 30);
        addEdge(5, 6, 30);
        // displayGraph();
        // removeEdge(3, 4);
        // displayGraph();
        // removeVertex(1);
        // removeVertex(3);
        removeEdge(0, 3);
        // removeEdge(4, 5);
        displayGraph();
        solve();
    }

    public static void addEdge(int src, int nbr, int wt) {
        graph[src].add(new Edge(nbr, wt));
        graph[nbr].add(new Edge(src, wt));
    }

    public static void removeEdge(int src, int dest) {
        int i = 0, j = 0;
        while (i < graph.length) {
            Edge e = graph[src].get(i);
            if (e.nbr == dest)
                break;
            i++;
        }
        while (j < graph.length) {
            Edge e = graph[dest].get(j);
            if (e.nbr == src)
                break;
            j++;
        }
        graph[src].remove(i);
        graph[dest].remove(j);
    }

    public static void removeVertex(int vtx) {
        while (graph[vtx].size() != 0) {
            Edge e = graph[vtx].get(0);
            removeEdge(vtx, e.nbr);
        }
    }

    public static ArrayList<Edge>[] getGraph() {
        return graph;
    }

    /*****************************************/

    public static void solve() {
        boolean[] isVisited = new boolean[7];
        // dfsTraversal(0, isVisited);
        // System.out.println(hasPath(2, 6, isVisited, 2 + ""));
        // allPaths(0, 6, isVisited, 0+" ");
        // System.out.println(GCC(isVisited));
        // System.out.print(GCC(isVisited)==1);
        // allSolution(0, 6, 0, 40, isVisited, 0 + " ");
        // System.out.println(spsf);
        // System.out.println(mpsf);
        // System.out.println(cpsf);
        // System.out.println(fpsf);
        // System.out.println(swsf + " " + mwsf + " " + ceilValue + " " + floorValue);
        // System.out.println(pq.peek());
        // boolean[] isHit = new boolean[7];
        // System.out.println(isCyclePresent(0, isVisited, isHit));
        // System.out.println(isCyclePresent_02(0, 0, isVisited));
        System.out.println(countCycle(0, 0, isVisited));
        // int[][] island = { { 0, 0, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1, 1, 1 }, {
        // 1, 1, 1, 1, 0, 1, 1, 0 },
        // { 1, 1, 0, 0, 0, 1, 1, 0 }, { 1, 1, 1, 1, 0, 1, 1, 0 }, { 1, 1, 1, 1, 0, 1,
        // 1, 0 },
        // { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };
        // int count = 0;
        // boolean[][] isVisited = new boolean[island.length][island[0].length];
        // for (int i = 0; i < island.length; i++) {
        // for (int j = 0; j < island.length; j++) {
        // if (!isVisited[i][j] && island[i][j] != 1) {
        // numberOfIslands(island, i, j, island.length, island[0].length, isVisited);
        // count++;
        // }
        // }
        // }
        // System.out.println(count);
    }

    public static void dfsTraversal(int src, boolean[] isVisited) {
        isVisited[src] = true;
        // System.out.println(src + " ");
        for (Edge e : graph[src]) {
            if (!isVisited[e.nbr])
                dfsTraversal(e.nbr, isVisited);
        }
    }

    public static boolean hasPath(int src, int dest, boolean[] isVisited, String path) {
        if (src == dest) {
            System.out.println(path);
            return true;
        }
        isVisited[src] = true;
        boolean res = false;
        for (Edge e : graph[src]) {
            if (!isVisited[e.nbr])
                res = res || hasPath(e.nbr, dest, isVisited, path + e.nbr + " ");
        }
        return res;
    }

    public static void allPaths(int src, int dest, boolean[] isVisited, String path) {
        if (src == dest) {
            System.out.println(path);
            return;
        }
        isVisited[src] = true;
        for (Edge e : graph[src]) {
            if (!isVisited[e.nbr])
                allPaths(e.nbr, dest, isVisited, path + e.nbr + " ");
        }
        isVisited[src] = false;
    }

    public static class pair {
        String path = "";
        int wt = 0;

        public pair(String path, int wt) {
            this.path = path;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return path + " ";
        }
    }

    // smallest/largest/ceil/floor/kh largest path
    static String spsf = "";
    static String mpsf = "";
    static String cpsf = "";
    static String fpsf = "";
    static int swsf = Integer.MAX_VALUE;
    static int mwsf = Integer.MIN_VALUE;
    static int ceilValue = Integer.MAX_VALUE;
    static int floorValue = Integer.MIN_VALUE;
    static PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
        return a.wt - b.wt;
    });

    public static void allSolution(int src, int dest, int wsf, int compare, boolean[] isVisited, String psf) {
        if (src == dest) {
            if (wsf < swsf) {
                spsf = psf;
                swsf = wsf;
            }
            if (wsf > mwsf) {
                mpsf = psf;
                mwsf = wsf;
            }
            if (wsf > compare && wsf < ceilValue) {
                cpsf = psf;
                ceilValue = wsf;
            }
            if (wsf > floorValue && wsf < compare) {
                fpsf = psf;
                floorValue = wsf;
            }
            pq.add(new pair(psf, wsf));
            if (pq.size() > 2) {
                pq.remove();
            }
        }
        isVisited[src] = true;
        for (Edge e : graph[src]) {
            if (!isVisited[e.nbr])
                allSolution(e.nbr, dest, wsf + e.wt, compare, isVisited, psf + e.nbr + " ");
        }
        isVisited[src] = false;
    }

    public static int GCC(boolean[] isVisited) {
        int gcc_count = 0;
        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i]) {
                dfsTraversal(i, isVisited);
                gcc_count++;
            }
        }
        return gcc_count;
    }

    public static boolean isCyclePresent(int src, boolean[] isVisited, boolean[] isHit) {
        isVisited[src] = true;

        if (isHit[src] == true)
            return true;

        boolean res = false;
        isHit[src] = true;
        for (Edge e : graph[src]) {
            if (!isVisited[e.nbr]) {
                res = res || isCyclePresent(e.nbr, isVisited, isHit);
            }
        }
        isVisited[src] = false;
        return res;
    }

    public static boolean isCyclePresent_02(int src, int par, boolean[] isVisited) {
        isVisited[src] = true;
        boolean res = false;
        for (Edge e : graph[src]) {
            if (!isVisited[e.nbr]) {
                res = res || isCyclePresent_02(e.nbr, src, isVisited);
            } else if (e.nbr != par)
                return true;
        }
        isVisited[src] = false;
        return res;
    }

    public static int countCycle(int src, int par, boolean[] isVisited) {
        isVisited[src] = true;
        int count = 0;
        for (Edge e : graph[src]) {
            if (!isVisited[e.nbr]) {
                count += countCycle(e.nbr, src, isVisited);
            } else if (e.nbr != par)
                count+=1;
        }
        isVisited[src] = false;
        return count;
    }

    public static void numberOfIslands(int[][] island, int sr, int sc, int er, int ec, boolean[][] isVisited) {
        if (sr < 0 || sc < 0 || sr >= island.length || sc >= island[0].length || island[sr][sc] == 1
                || isVisited[sr][sc])
            return;
        isVisited[sr][sc] = true;
        numberOfIslands(island, sr + 1, sc, er, ec, isVisited);
        numberOfIslands(island, sr, sc + 1, er, ec, isVisited);
        numberOfIslands(island, sr - 1, sc, er, ec, isVisited);
        numberOfIslands(island, sr, sc - 1, er, ec, isVisited);
    }

    public static void displayGraph() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e.nbr + "@" + e.wt + ", ");
            }
            System.out.println();
        }
    }
}