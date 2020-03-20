package Questions;

public class GCD {
    public static void main(String[] args)
    {
        System.out.println(GCD_func(2,3));
    }

    public static int GCD_func(int a, int b)
    {
        if(a==0)
            return b;
        else
            return GCD_func(b%a,a);

    }
}
