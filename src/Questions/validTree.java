package Questions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class validTree {

    public static void main(String[] args) {

        int[][] edges={{0,1},{0,2},{0,3},{1,4}};
         int n = 4;
        System.out.println(validTree(n,edges));
        System.out.println("Testing");
    }
        public static boolean validTree(int n, int[][] edges) {
            ArrayList<Integer> edge1 = new ArrayList<Integer>();
            for (int i = 0; i < edges.length; i++) {
                edge1.add(edges[i][1]);
            }
            if(n-edge1.size()!=1) return false;
            edge1.sort(new Comparator<Integer>() {
                public int compare(Integer i1, Integer i2) {
                    return i1 > i2 ? 1 : i1 == i2 ? 0 : -1;
                }
            });

                for (int j = 1; j < edge1.size(); j++) {
                if (edge1.get(j - 1) == edge1.get(j)) return false;
            }
            return true;
        }
    }

