/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab;

/**
 *
 * @author kandelmilan
 */
public class Q13 {
    public static void main(String[] args){
        int[][] max1=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] max2=new int[][]{{2,2,2},{2,2,2},{2,2,2}};
        int[][] max3=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                max3[i][j]=0;
                for(int k=0;k<3;k++){
                    max3[i][j]+=max1[i][k]*max2[k][j];
                }
            }
        }
        System.out.println("Multiplication result:");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(max3[i][j]+" ");
            }
            System.out.println();
        }
    }
}
