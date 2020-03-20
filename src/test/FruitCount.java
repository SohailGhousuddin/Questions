package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class FruitCount {
    public static void main(String[] args) {
        // int[] trees={1,0,1,4,1,4,1,2,3};
        // int[] trees={1,2,3};
        //    int[] trees = {1,1,2,2};
        // int[] trees={1,1,2,2,2,3,3,3,1};
        int[] trees = {1, 0, 1, 4, 4, 4, 1, 4, 4, 2, 3};

        ArrayList<Integer> iList = new ArrayList<>();
        iList.add(10);
        iList.add(20);
        iList.add(15);
        iList.add(30);
        iList.add(25);


        int[] res = new int[trees.length];
/*
        List<Integer> sortedDesc = iList.stream().sorted((i1,i2)->(i1>i2)?-1:(i1<i2)?1:0).collect(Collectors.toList());
        List<Integer> sumThree = iList.stream().filter((i1)->i1>10).collect(Collectors.toList());
        System.out.println(sortedDesc);
        exit(0);
  */
        if (trees.length == 0) {
            System.out.println("Array should not be empty ");
        } else {
            // System.out.println(count(trees));
            int final_res = 0;
            int cur_res = 0;
            int pos = 0;
            System.out.println(count(trees));
            /*
            for (int i : trees)
            {
                cur_res=countFruits(pos,trees);
                pos++;
               final_res = cur_res > final_res  ? cur_res : final_res;

            }
            System.out.println(final_res);*/
        }
    }

    public static int countFruits(int pos, int[] tree) {
        int count = 0;
        int first_val = -1;
        int second_val = -1;
        for (int i = pos; i < tree.length; i++) {

            if ((second_val == -1) && ((first_val != -1) && (first_val != tree[i]))) {
                second_val = tree[i];
            }
            if (first_val == -1) {
                first_val = tree[i];
            }
            if ((second_val != -1) && (second_val != tree[i]) && (first_val != tree[i])) {
                return count;
            }
            count++;


        }

        return count;
    }

    public static int count(int[] tree) {


        if (tree.length < 3) return tree.length;
        int[] items = {-1, -1};
        items[0] = tree[0];
        for (int j = 1; j < tree.length; j++) {
            if (tree[j] != items[0]) {
                items[1] = tree[j];
                break;
            }

            if (j == tree.length) return j;

        }

        int[] mcount = {0, 0};
        int value_to_change = 0;
        int preSameCharCnt = 1;
        for (int i = 0; i < tree.length; i++) {


            if ((tree[i] != items[0]) && ((tree[i] != items[1]))) {

                // read next value and see if it is same as one of the value in items then change the other one
                //value_to_change = (value_to_change==1)? 0:1;
                if ((i) != tree.length - 1) {
                    if (tree[i + 1] == items[0]) {
                        value_to_change = 1;
                    } else {
                        value_to_change = 0;
                    }
                    items[value_to_change] = tree[i];

                }

                //  mcount[1]=preSameCharCnt>2?preSameCharCnt:2;
                mcount[1] = 2;

            } else {
                mcount[1] = mcount[1] + 1;
                mcount[0] = mcount[1] > mcount[0] ? mcount[1] : mcount[0];
                if ((i > 0) && (items[1] == tree[i])) {
                    items[0] = items[1];
                    items[1] = tree[i];
                }


            }

            if ((i != 0) && (tree[i] == tree[i - 1])) {
                preSameCharCnt = preSameCharCnt + 1;
            } else {
                if (i > 0) preSameCharCnt = 2;
            }
        }
        return mcount[0];
    }

}
