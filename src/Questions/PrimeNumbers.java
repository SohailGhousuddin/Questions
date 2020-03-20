package Questions;

import java.util.ArrayList;

public class PrimeNumbers {

    public static void main(String[] args)
    {
        System.out.println(prime(1,30));
    }

    public static ArrayList<Integer> prime(int start, int end)
    {
        ArrayList<Integer> aInt = new ArrayList<>();
        for(int i=1;i<=end;i++)
        {
            aInt.add(i);
        }

        for(int j=2;j*j<end;j++)
        {
            for(int k=j+j;k<=aInt.size();k=k+j)
            {
                aInt.set(k-1, 0);
            }
        }

        return aInt;
    }
}
