package Graphs;

import java.util.ArrayList;

public class validTree {
    public static void main(String[] args) {
        int n =5;
        int[][] nums = {{1,2},{1,3},{0,1},{0,4}};
        ArrayList<Vertex20> graph = createTree(n,nums);
    }

    public static ArrayList<Vertex20> createTree(int n, int[][] edges) {
        ArrayList<Vertex20> vertices = new ArrayList<>();
        Neighbor next = null;
        ArrayList<Integer> vertadded = new ArrayList<>();
        Vertex20 v;
        int vert=-1;
        for(int i=0;i<edges.length;i++)  {

            vert =edges[i][1];
            if(!vertadded.contains(vert))
            {
                v=new Vertex20(vert,null);
                vertices.add(v);
                vertadded.add(vert);

            }
            vert = edges[i][0];
            if(!vertadded.contains(vert))
            {
                v=new Vertex20(vert,null);
                vertices.add(v);
                vertadded.add(vert);
                Neighbor n1 = new Neighbor(edges[i][1],null);
                v.adjList=n1;

            }
            else{
                int verindex = getIndex(vert,vertices);
                Neighbor n2 = new Neighbor(vert,vertices.get(verindex).adjList);
                vertices.get(verindex).adjList = n2;

            }




        }
        System.out.println("testing");
        return vertices;
    }
    public static int getIndex(int val, ArrayList<Vertex20> tree)
    {
        for(int i=0;i<tree.size()-1;i++)
            if(tree.get(i).vertexid==val) return i;
        return -1;
    }
}
