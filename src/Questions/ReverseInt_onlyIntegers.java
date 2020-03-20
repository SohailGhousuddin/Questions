package Questions;

public class ReverseInt_onlyIntegers {
    public static void main(String[] args)
    {
        //System.out.println(reverse(1534236469));
        //System.out.println(reverse(120));
        System.out.println(reverse(-123));
        //-214748364 8
        //214748364 7

    }
    public static int reverse(int x) {

        boolean signed = x>0?false:true;
        int max_value = 214748364;

        int y=0,i=1;
        int mod =0;

        while(x!=0)
        {
              mod = x%10;
            if(!signed) {
                if(y==max_value&&mod>7)
                return 0;
                if(y>max_value) return 0;

            }
            if(signed)
            {
                if(y==-max_value&&mod<-8)
                    return 0;
                if(y<-max_value) return 0;

            }
              y=y*i+mod;

              i=10;
              x=x/10;

        }
         return y;

    }
}
