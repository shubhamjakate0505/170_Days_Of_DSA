import java.util.*;
public class LL{
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int count=0; //for the counting Linked list size
    public void addFrist(int data){

        Node newnode=new Node(data);//create new node
        count++;
        if(head==null){//if the LL is null
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }

    public void addLast(int data){
        Node newnode=new Node(data);
        count++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }

    public void Printll(){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }

        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("Null");
    }

    public void Addmiddle(int idx,int data){
        if(idx==0){
            addFrist(data);
            return;
        }
        Node newnode=new Node(data);
        count++;
        Node temp=head;
        int i=0;//track that my temp in which idx
        while(i<idx-1){//previous node
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public int removeFrist(){
        if(count==0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(count==1){
            int val=head.data;//remove karna hai
            head=tail=null;
            count=0;
            return val;

        }

        
        
        int val=head.data;
        head=head.next;
        count--;
        return val;// remove kiya hua return kiya hai
    }
    public int removelast(){
        if(count==0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(count==1){
            int val=head.data;
            head=tail=null;
            count=0;
            return val;
        }

        Node prev=head;
        for(int i=0;i<count-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;//remove karna hai isko
        prev.next=null;
        tail=prev;
        count--;
        return val;
    }

    public static void main(String args[]){
        LL ll=new LL();
        
        ll.addFrist(10);
        
        ll.addFrist(20);
       
        ll.addLast(3);
        
        ll.addLast(4);
        ll.Addmiddle(2,7);
        ll.removeFrist();
        ll.Printll();
        
        System.out.println(ll.removelast());
        ll.Printll();
        System.out.println("Total count is : - "+ll.count);
        
    }

}