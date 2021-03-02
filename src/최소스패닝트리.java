import java.util.*;
import java.io.*;

public class 최소스패닝트리 {

	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        HashMap[] adj = new HashMap[V+1];
        
        for(int i=1;i<=V;i++)
            adj[i] = new HashMap<Integer,Integer>();
        
        for(int i=0;i<E;i++){
            String[] str = bf.readLine().split(" ");
            adj[Integer.parseInt(str[0])].put(Integer.parseInt(str[1]),Integer.parseInt(str[2]));
            adj[Integer.parseInt(str[1])].put(Integer.parseInt(str[0]),Integer.parseInt(str[2]));
        }
        
        //Prime 알고리즘
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        //set S
        boolean[] S = new boolean[V+1];
        S[1]=true;

        for(Object key:adj[1].keySet()){
            int weight = (Integer)adj[1].get((Integer)key);
            pq.offer(new int[] {(Integer)key,weight});
        }   
        
        
        int answer = 0;
        
        for(int c=1;c<V;c++){
            
            int[] next = pq.poll();
            while(S[next[0]] && !pq.isEmpty())
                next = pq.poll();
            
            S[next[0]]=true;
            answer+=next[1];
            	
            for(Object key:adj[next[0]].keySet()){
                int weight = (Integer)adj[next[0]].get((Integer)key);
                pq.offer(new int[] {(Integer)key,weight});
            }   
            
        }
        
        System.out.println(answer);
        
        
    
		
	}

}
