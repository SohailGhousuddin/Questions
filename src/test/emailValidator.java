package test;

import java.util.*;

public class emailValidator {

    public static void main(String[] args)
    {
        String[] inpStr = {"+test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

        System.out.println(numUniqueEmails(inpStr));
    }

    public static int numUniqueEmails(String[] emails) {
        String domain;
        String local;
        int plsPos;



        HashMap<String,Integer> emailcount = new HashMap<String, Integer>();
        Map m1 = Collections.synchronizedMap(emailcount);
        Vector vec = new Vector();
        vec.add(new Integer(35));
        vec.add(new String("test"));

        for (int i = 0; i < emails.length; i++) {
            local = "";
             domain = emails[i].substring(emails[i].indexOf('@'));
           for(char c : emails[i].substring(0,emails[i].indexOf('@')).toCharArray())
            {
                if(c=='+')break;
                if(c!='.')
                    local=local+c;
            }
          assert !local.isEmpty() : "AssertionError: Local and domain names must be non-empty.";
             emailcount.put(local+domain,i);
            System.out.println(local+domain);
        }
        return emailcount.size();
    }
}
