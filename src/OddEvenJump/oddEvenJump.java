package OddEvenJump;

/*
From starting index i = 0, we make jumps to i = 1, i = 2, i = 3:

During our 1st jump (odd numbered), we first jump to i = 1
   because A[1] is the smallest value in
   (A[1], A[2], A[3], A[4]) that is greater than or equal to A[0].

During our 2nd jump (even numbered), we jump from i = 1 to i = 2
   because A[2] is the largest value in
   (A[2], A[3], A[4]) that is less than or equal to A[1].

   A[3] is also the largest value, but 2 is a smaller index, so we can only jump to i = 2 and not i = 3.

During our 3rd jump (odd numbered), we jump from i = 2 to i = 3 because A[3] is the smallest value in (A[3], A[4]) that is greater than or equal to A[2].

 */

public class oddEvenJump {
    public static void main(String[] args)
    {
        int[] input = {2,3,1,1,4};
        System.out.println(oddEvenJumps(input));
    }
    public static int oddEvenJumps(int[] A) {
        int result = -1;

        for(int i=0;i<A.length;i++)
        {
            result=findStartingIteration(i+1,A);
        }
    return result;
    }

public static int findStartingIteration(int startPos,int[] A)
{
    boolean nextJump=true;
    int jumpCnt=0;
    for(int i=startPos;i<A.length&&nextJump;i++)
    {
        nextJump=false;
        if(i%2==0) { // even jump, consider max
            int maxValue=MaxC(A,i);
            if((A[i]>=MaxC(A,i))&&(A[i]<=A[i-1])) {
                nextJump=true;
                jumpCnt++;
            }

        }
        else { /* odd jump, consider min
            During our 1st jump (odd numbered), we first jump to i = 1
            because A[1] is the smallest value in
                    (A[1], A[2], A[3], A[4]) that is greater than or equal to A[0].*/
        int minval = MinC(A,i);
            if((A[i]<=MinC(A,i))&&A[i]>=A[i-1]) {
                nextJump = true;
                jumpCnt++;
            }
        }

    }
    return jumpCnt;
}
    public static int MaxC(int[] A, int index)
    {
       int max = A[index];
       for(int i=index;i<A.length;i++)
       {
         max=max>A[i]?max:A[i];
       }
       return max;
    }
    public static int MinC(int[] A, int index)
    {
        int min = A[index];
        for(int i=index;i<A.length;i++)
        {
            min=min<A[i]?min:A[i];
        }
        return min;

    }
}
