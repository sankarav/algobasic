/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.san.QuickFind;

/**
 * The contents in this is as presented in Coursera Algorithms Part-1 Course
 * @author san
 */
public class QuickFind {
    
    private int[] id;
    
    public QuickFind(int size){
        id = new int[size];
        for(int i = 0; i < id.length; i++){
            id[i] = i;
        }
    }
    
    public void union(int p, int q){
        int p_id = id[p];
        int q_id = id[q];
        id[p] = q_id;
        for(int i =0; i < id.length; i++){
            if(id[i] == p_id){
                id[i] = q_id;
            }
        }
    }
    
    public boolean isConnected(int p, int q){
        return id[p] == id[q];
    }
    
    
    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        
        qf.union(4, 3);
        qf.union(3, 8);
        qf.union(6, 5);
        qf.union(9, 4);
        qf.union(2, 1);
        
        System.out.println("8 - 9 : " + qf.isConnected(8, 9));
        System.out.println("5 - 0 : " + qf.isConnected(5, 0));
        
        qf.union(5, 0);
        qf.union(7, 2);
        qf.union(6, 1);
        
        System.out.println("7 - 8 : " + qf.isConnected(7, 8));
    }
}
