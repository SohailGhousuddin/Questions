package Graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
    Vertex[] adjList;

    public Graph(String file) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(file));
        int listSize=sc.nextInt();
        adjList = new Vertex[listSize];

        boolean directionalGraph = sc.next().equals("directed")?true:false;

        for(int i=0;i<adjList.length;i++)
        {
            adjList[i]=new Vertex(sc.next(),null);

        }

        while(sc.hasNext())
        {
            int v1= indexForName(sc.next());
            int v2 = indexForName(sc.next());

            adjList[v1].adjList=new Neighbor(v2,adjList[v1].adjList);
            if(!directionalGraph)adjList[v2].adjList=new Neighbor(v1,adjList[v2].adjList);
        }
    }
    public int indexForName(String vName) {
        int res=-1;
        for (int i = 0; i < adjList.length; i++)
        {
            if(adjList[i].name.equals(vName)) {
                res=i;
            }
        }
        return res;
    }

    public void printList()
    {

        System.out.println();
        for (int i = 0; i < adjList.length; i++)
        {
            System.out.print(adjList[i].name);
            for (Neighbor nbr = adjList[i].adjList;nbr!=null;nbr=nbr.next)
            {
                System.out.print("--> " + adjList[nbr.vertexNumber].name);

            }
            System.out.println();
        }
    }

    public void dfsTraversal()
    {
        // adjList this is list of vertices , each vertices is pointing to adjacent vertex index
           boolean[] visited = new boolean[adjList.length];
           for(int i=0;i<adjList.length;i++)
           {
               if(!visited[i]) {
                   System.out.println("Starting at vertix: "+ adjList[i].name);
                   DFS(i, visited);
               }
           }

    }
    public void DFS(int v, boolean[] visited)
    {

        visited[v]=true;
        System.out.println("Visiting: " + adjList[v].name);


        for (Neighbor nbr = adjList[v].adjList; nbr != null; nbr = nbr.next) {
         if(!visited[nbr.vertexNumber]) {
             System.out.println("\n"+ adjList[v].name+ "--"+ adjList[nbr.vertexNumber].name);
             DFS(nbr.vertexNumber,visited);
        }
        }


    }

    public void bfs() {
        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> queue = new Queue<Integer>();
        for (int v=0; v < visited.length; v++) {
            if (!visited[v]) {
                System.out.println("\nSTARTING AT " + adjList[v].name);
                queue.clear();
                bfs(v, visited, queue);
            }
        }
    }

    // BFS starting at some vertex v
    private void bfs(int start, boolean[] visited, Queue<Integer> queue) {
        visited[start] = true;
        System.out.println("visiting " + adjList[start].name);
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (Neighbor nbr=adjList[v].adjList; nbr != null; nbr=nbr.next) {
                int vnum = nbr.vertexNumber;
                if (!visited[vnum]) {
                    System.out.println("\n" + adjList[v].name + "--" + adjList[vnum].name);
                    visited[vnum] = true;
                    queue.enqueue(vnum);
                }
            }
        }
    }
        public static void main(String[] args) throws FileNotFoundException {
            String fileName = "E:\\Workspace\\src\\Resource\\Input.txt";
            Graph g = new Graph(fileName);
            g.printList();
            g.dfsTraversal();
            g.bfs();
        }

    }
