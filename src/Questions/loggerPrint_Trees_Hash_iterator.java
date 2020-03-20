package Questions;

import java.util.*;
import java.util.function.Consumer;

public class loggerPrint_Trees_Hash_iterator {


    public static HashMap<String,logTimes> reqHash = new HashMap<>();
    public static TreeSet<String> reqTree = new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String s, String t1) {
            return s.compareTo(t1);
        }
    });
    public static PriorityQueue<String> req=new PriorityQueue<>(new Comparator<String>() {
        @Override
        public int compare(String s, String t1) {
            return s.compareTo(t1);
        }
    });

    public static class logTimes{
        public Long startTime;
        public Long endTime;

        public logTimes(Long t1,Long t2)
        {
            this.startTime=t1;
            this.endTime=t2;
        }
    };

    public static void main(String[] args)
    {

        started(1L,"a");
        started(3L,"c");
        started(4L,"d");

        started(2L,"b");

        finished(8L,"b");
        finished(7L,"c");
        finished(10L,"a");

        finished(15L,"d");


    }

    public static void started(Long time, String reqID)
    {
        logTimes t = new logTimes(time,0L);
        reqHash.put(reqID,t);
        req.offer(reqID);
        reqTree.add(reqID);
       // System.out.println(req);

    }

    public static void finished(Long time, String reqID)
    {

        Iterator j = reqTree.iterator();
        logTimes t=reqHash.get(reqID);
        t.endTime=time;
        String s=null;

      //  System.out.println(reqTree);
       while(j.hasNext()) {
           // System.out.println("Tree representation");
            s = j.next().toString();
           // System.out.print(s+"->");
            t =reqHash.get(s);
            if(t.endTime!=0L)
            {
                System.out.println("request id: " +s+"  " +t.startTime+".....->"+t.endTime);
                reqTree.remove(s);
                j=reqTree.iterator();
                reqHash.remove(s);
            }
            if(s.equals(reqID)||t.endTime==0L) break;
        }

        //j.forEachRemaining();
     //   System.out.println("");

    }

}
