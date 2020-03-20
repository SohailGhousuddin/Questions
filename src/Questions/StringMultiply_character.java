package Questions;

import java.net.Inet4Address;
import java.util.ArrayList;

public class StringMultiply_character {
    public static void main(String[] args)
    {
        System.out.println(multiply("987654321","123456789")); //""121932631112635269""
       // System.out.println(multiply("3","123456789"));
       // System.out.println(multiply("123","456"));
      //  System.out.println(addString("123456789","987654321"));
      //  System.out.println(multiply("0","9999"));
        //System.out.println(addString("0","9999"));
      //  System.out.println(addString("10488","45600"));
    }
    public static String multiply(String num1, String num2) {

        /*

        op1 -- 123
        op2 -- 456

        738
       6150
      49200
      56088

        stepValue - 8, 837 -- reverse after first iteration 738
        UnitsValue -- 8, 6*2+1 = 13 = 13%10 = 3, 6*1+1 = 7 =7%10 =7
        Carry -  1 , 13/10 = 1, 0
        dec   -- 8 , 13/10,7/10

"123456789"
"987654321"

"121932631112635269"


         */
        if(num1.equals("0")||num2.equals("0")) return "0";
        String res=new String("0");
        int str1len = num1.length()-1;
        int str2len = num2.length()-1;
        int carry=0;
        int unitValue=0;
        int dec=0;
        StringBuilder stpval = new StringBuilder("");
        ArrayList<String> tempResult = new ArrayList<>();
        while(str1len>-1)
        {
            while(str2len>-1)
            {

                unitValue = (Character.getNumericValue(num1.charAt(str1len)))*(Character.getNumericValue(num2.charAt(str2len)))+carry;

               if(unitValue>9) {
                   dec=unitValue%10;
                   carry=unitValue/10;

               }
               else{
                   dec=unitValue;
                   carry=0;
               }
               stpval=stpval.append(Integer.toString(dec));
               str2len--;

            }
            if(carry>0) stpval=stpval.append(Integer.toString(carry));
            carry=0;
            str2len=num2.length()-1;
            str1len--;
            stpval=stpval.reverse();
            int tr = tempResult.size();
            while(tr>0)
            {
                stpval.append(0);
                tr--;
            }
            tempResult.add(stpval.toString());
           // res = Long.toString( (Long.parseLong(stpval.toString())) + (Long.parseLong(res)));
            res=addString(res,stpval.toString());
            stpval.delete(0,stpval.length());

        }

    return res;
    }

    public static String addString(String s1, String s2)
    {
        StringBuilder res= new StringBuilder();


        char[] op1 = s1.toCharArray();
        char[] op2 = s2.toCharArray();
        int carry = 0;
        int sum =0;
        int i = op1.length-1;
        int j = op2.length-1;
        for(;i>-1&&j>-1;i--,j--) {
            sum = Character.getNumericValue(op1[i]) + Character.getNumericValue(op2[j]) + carry;
            if(sum>9)
            {
                carry = sum/10;
                sum=sum%10;
            }else{carry=0;}

         res.append(Integer.toString(sum));
        }
        if(i<0)
        {
            for(;j>-1;j--)
            {
                sum=Character.getNumericValue(op2[j])+carry;
                if(sum>9)
                {
                    carry = sum/10;
                    sum=sum%10;
                }
                else{ carry=0;}
                res.append(Integer.toString(sum));
            }
        }
        if(j<0)
        {
            for(;i>-1;i--)
            {
                sum=Character.getNumericValue(op1[i])+carry;
                if(sum>9)
                {
                    carry = sum/10;
                    sum=sum%10;
                }
                else{carry=0;}
                res.append(Integer.toString(sum));
            }
        }
        if(carry!=0) res.append(Integer.toString(carry));
        res=res.reverse();
        return res.toString();


    }
}
