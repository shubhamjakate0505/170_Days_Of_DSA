//o(n)

import java.util.*;
public class KLevel{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }
    }
    public static void level(Node root,int lval,int k){
        
        //base case
        if(root==null){
            return;
        }
        if(lval==k){
            System.out.print(root.data+" ");
            return;
        }
        level(root.left,lval+1,k);
        level(root.right,lval+1,k);


    }
   
    
    public static void main(String args[]){

      /*    1
          /   \
         2     3
        / \   / \
       4  5  6   7   */


        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        root.right.left=new Node(7);
        int k=3;
        level(root,1,k);
       

    }
}