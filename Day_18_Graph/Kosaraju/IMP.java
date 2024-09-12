import java.util.*;
public class IMP{
    static class Edge {
        int src;
        int dest;
       
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
           }
       
 }
    public static void creategraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
            
        graph[0].add(new Edge(0,2));       
        graph[0].add(new Edge(0,3));
              
        graph[1].add(new Edge(1,0));
              
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
     
       } 

}
    public static void topsort(ArrayList<Edge>[] graph,int curr,boolean vis[],stack<Integer> s){
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topsort(graph,e.dest,vis,s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[]){
        vis[curr]=true;
        System.out.println(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge> graph[],int v){
        stack<Integer> s=new stack<>();
        boolean vis[]=new boolean[v];

        for(int i=0;i<v;i++){
            if(!vis[i]){
                topsort(graph,i,vis,s)
            }
        }
        //step2
        ArrayList<Edge> transport[]=new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            vis[i]=false;
            transport[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                transport[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        //step3
        while(!s.isEmpty()){
            int curr=s.pop();
            if(!vis[curr]){
                System.out.println("SCC -> ");
                dfs(transport,curr,vis);
                System.out.println();
            }
        }
    
    public static void main(String args[]){
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creategraph(graph);
        kosaraju(graph,v);

     
    }
    }
