
package javalab;

// Write a Java program to find max and min from 1-D array having n elements.
public class Q2 {
    public static void main(String[] args){
        int[] num=new int[]{1,8,6,4,3};
        int min=num[0];
        int max=num[0];
        for(int i=2;i<num.length;i++){
            if(min>num[i])
                min=num[i];
            if(max<num[i])
                max=num[i];
        }
        System.out.println("Min :"+min+"\nMax :"+max);
    }
    
}
