package Questions;

public class pascalTriangle {
    /*
    class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pt = new ArrayList<>();

        System.out.println(pt);
        PTriangle(pt,numRows);

        return pt;
    }
    public void PTriangle(List<List<Integer>> input, int numRows)
    {
         if(numRows>1)PTriangle(input,numRows-1);
         if(numRows==1){
            List<Integer> i = new ArrayList<>();
            i.add(1);
             input.add(i);
         }
        if(numRows==2){
            List<Integer> i = new ArrayList<>();
            i.add(1);
            i.add(1);
             input.add(i);
        }
        if(numRows>2)
        {

                List<Integer> ii = new ArrayList<>();
            List<Integer> temp;
            int res = 0;
                    for(int j=0;j<numRows;j++)
                    {
                        //ii.add(1);
                        if(j==0 || j==numRows-1) {
                            res=1;

                        }


                        else
                        {
                            temp = input.get(numRows-2);
                            res = temp.get(j-1)+temp.get(j);
                        }

                       ii.add(res);

                    }
                   input.add(ii);


        }


    }
}
     */
}
