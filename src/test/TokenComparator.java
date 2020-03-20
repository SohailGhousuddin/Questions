package test;

import java.util.Comparator;

public class TokenComparator implements Comparator<Token> {
    @Override
    public int compare(Token t1, Token t2) {
        if(t1.getTokenLength()<t2.getTokenLength())return 1;
        if(t1.getTokenLength()>t2.getTokenLength())return -1;
        return 0;
    }
}
