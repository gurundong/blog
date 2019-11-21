package com.github.wheatphp.blog.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic01 {

    public static int[] answer(){
        Integer[] inputArr = {2, 7, 11, 15};
        Integer need = 9;
        List<Integer> result = new ArrayList<>();
//        Arrays.stream(inputArr).forEach(System.out::println);
//        Arrays.stream(inputArr).forEach(k-> System.out.println(k));
        for (int i = 0;i<inputArr.length;i++){
            for (int j=0;j<inputArr.length - i - 1;j++){
                if((inputArr[i] + inputArr[j+i+1]) == need){
                    result.add(i);
                    result.add(j + i + 1);
                }
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] res = Topic01.answer();
        Arrays.stream(res).forEach(v-> System.out.println(v));
    }
}
