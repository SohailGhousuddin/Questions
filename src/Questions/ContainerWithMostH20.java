package Questions;

public class ContainerWithMostH20 {
    public static void main(String[] args)
    {
        // try to findout what are the two x which covers max area
        // if u take 1 and 7 the area covered is 1*8 as 1 is min(1,7) common and 1 and 7 are 8 steps away
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
     int maxHeight=0;
     for(int i=0;i<height.length;i++)
     {
         for(int j=1; j<height.length;j++)
         {
             if(j-i>0)
                 maxHeight = ((Math.min(height[i], height[j]))*(j - i)) > maxHeight ? ((Math.min(height[i], height[j]))*(j - i)) : maxHeight;

         }
     }
     return maxHeight;

    }
}
