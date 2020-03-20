import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8 {
    public static void main(String[] args) {
        String s = "Hello";
        Stream st = Stream.of(s);
        List<Character> cList = new ArrayList<Character>();
       // st.forEach(p-> System.out.println(p));



        s.chars()
                .mapToObj(i -> {
                    cList.add((char) i);
                    return Character.valueOf((char) i);
                })
                .forEach(p->System.out.println("Index :"+cList.size() +" | Char at:"+((char)p)));
        char[] ctemp = {'a','b','c'};
        List<Character> clst;
        clst = IntStream.range(0,ctemp.length)
                               .filter(i->{
                                    if(i==2)
                                        return true;
                                    return false;

                               })
                               .mapToObj(i->ctemp[i])
                               .collect( Collectors.toList());

        System.out.println(clst);
        palin("HELLO");






    }

    public static void palin(String seq)
    {
      /*  char[] input = seq.toCharArray();
        Boolean ret = IntStream
                     .range(0,seq.length())
                     .forEach(i->).
                        allMatch(i->input[i]==input[seq.length()-i]);
        System.out.println(ret);*/

    }

}
