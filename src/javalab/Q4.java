/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab;

public class Q4 {
 public static void main(String[] args){
     int[][] jarArr=new int[3][];
     jarArr[0]=new int[]{1,2,3};
     jarArr[1]=new int[]{4,5};
     jarArr[2]=new int[]{6,7,8,9};
     
     System.out.println("Jagged Array:");
    for(int i=0;i<3;i++){
        for(int j=0;j<jarArr[i].length;j++){
            System.out.print(jarArr[i][j]+" ");
        }
        System.out.println(" ");
    }
 }    
}
