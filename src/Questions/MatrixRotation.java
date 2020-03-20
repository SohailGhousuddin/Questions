package Questions;

public class MatrixRotation {
    public static void main(String[] args)
    {
        int[][] mat3 = { { 1,2,3 },
                        { 4,5,6 },
                        { 7,8,9 }
                       };
        int[][] mat2 = { { 1,2 },
                         { 3,4 }
                       };

        int[][] mat4 = { { 1,2,3,4 },
                         { 5,6,7,8 },
                         { 9,10,11,12 },
                         { 13,14,15,16 }
                        };

        int[][] matrix5 = {  { 1,2,3,4, 5 },
                            { 6,7,8,9,10 },
                            { 11,12,13,14,15 },
                            { 16,17,18,19,20 },
                            { 21,22,23,24,25 }
                          };

       // display(mat4);
       // display(mat3);
        //MatrixRotateCorners(mat4,4);
        //MatrixRotateMiddleElements(mat4,4);
       // swap(mat2,0,1,1,1);
        //display(mat4);
        /*
        display(mat3);
        MatrixRotateCorners(mat3,0,3);
        MatrixRotateMiddleElements(mat3,0,3);
         display(mat3);
         */
        //display(matrix);
       // rotate(matrix);
       /*
        display(mat4);
        rotate(mat4);
       display(mat4);
       */

        display(matrix5);
       // MatrixRotateCorners(matrix5,0,5);
        //MatrixRotateMiddleElements(matrix5,0,5);
        rotate(matrix5);
        display(matrix5);

    }
    public static void rotate(int[][] matrix) {

    performRotation(matrix,0,matrix.length);
    }
    public static void performRotation(int[][] matrix, int startPos,int size)
    {
        int len = size;
       // while(len>=2)
        {
            if(len==3)
            {
                MatrixRotateMiddleElements(matrix,startPos,len);
                MatrixRotateCorners(matrix,startPos,len);

                len-=2;
            }
            if (len==2)
            {
                MatrixRotateCorners(matrix,startPos,len);

                len-=2;
            }
            if(len>3)
            {
                MatrixRotateMiddleElements(matrix,startPos,len);

                MatrixRotateCorners(matrix,startPos,len);

                len-=2;
                startPos+=1;
               performRotation(matrix,startPos,len);
            }

        }

    }
    public static void display(int[][] res)
    {

        System.out.println();
        for(int[] row:res) {
            for(int c:row)
            {
                System.out.print(c+" ");
            }
            System.out.println();

        }
        System.out.println();

    }
    public static void MatrixRotateCorners(int[][] mat, int startPos, int size)
    {
        int len = size-1;




            int temp = mat[startPos][startPos];
            mat[startPos][startPos] = mat[len+startPos][startPos];
            mat[len+startPos][startPos] = mat[len+startPos][len+startPos];
            mat[len+startPos][len+startPos] = mat[startPos][len+startPos];
            mat[startPos][len+startPos] = temp;



    }
    public static void MatrixRotateMiddleElements(int[][] mat, int startPos, int size)
    {
        int len = size-1;
        int temp = 0;
        for(int i=1;i<len;i++)
        {

            temp = mat[startPos][i+startPos];
            mat[startPos][i+startPos] = mat[i+startPos][startPos];
            mat[i+startPos][startPos] = mat[len+startPos][i+startPos];
            mat[len+startPos][i+startPos] = mat[i+startPos][len+startPos];
            mat[i+startPos][len+startPos] = temp;

        }
        /*
        int len = size-1;
        int temp = 0;
        for(int i=1;i<len;i++)
        {

            temp = mat[startPos][i]; //mat[0][1];
            mat[startPos][i] = mat[i][startPos]; //mat[0][1] = mat[1][0]
            mat[i][startPos] = mat[len][i];
            mat[len][i] = mat[i][len];
            mat[i][len] = temp;

        } */
    }


}
