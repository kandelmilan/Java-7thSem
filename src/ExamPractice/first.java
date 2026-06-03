package ExamPractice;

import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6}};
     int dsum=0;
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[i].length;j++){
            if(i==j){
                dsum+=arr[i][j];
            }
            }
        }
        System.out.print(dsum);
         
    }
}




// to add 2 numbers

//  System.out.println("Enter two numbers");;
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int cum = a + b;
//        System.out.println("sum =" + cum);

//int[][] num=new int[][]{{1,2,3,4,5},{6,7,8,9,10}};
//      int i,j;
//      for(i=0;i<5;i++){
//      for(j=0;j<5;j++){
//          System.out.println(num[i][j]);
//      }
//      System.out.println("");
//      }


//if(min>arr[i][j])
//            {
//                min=arr[i][j];
//            }
//            else if(max<arr[i][j]){
//                max=arr[i][j];
//            }else{
//                System.out.print("finished");
//            }