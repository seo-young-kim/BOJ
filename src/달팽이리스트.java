import java.io.*;

public class 달팽이리스트 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = bf.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		int K = Integer.parseInt(arr[2]);
		int[] list = new int[N];
		
		arr = bf.readLine().split(" ");
		
		for(int i=0;i<N;i++)
			list[i]=Integer.parseInt(arr[i]);
		
		for(int i=0;i<M;i++) {
			
			int q = Integer.parseInt(bf.readLine());
			int len = N-K+1;
			if(q<N)
				bw.write(list[q]+"\n");
			else {
				q-=K-1;
				q%=len;
				q+=K-1;
				bw.write(list[q]+"\n");
			}
			
			
			bw.flush();
		}
		
		bw.close();
		
	}

}
