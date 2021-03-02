package ���͵�2021_2;
import java.io.*;

public class ƽ���� {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			
			String str = bf.readLine();
			if(str.equals("end"))break;
			
			char[][] map = new char[3][3];
			int index=0;
			for(int i=0;i<9;i++)
					map[i/3][i%3]=str.charAt(index++);
			
			if(test(map))
				bw.write("valid\n");
			else
				bw.write("invalid\n");
			
			bw.flush();
		}
		bw.close();
	}
	
	public static boolean test(char[][] map) {
		
		int nX=0;
		int nO=0;
		
		//���� ��
		for(int i=0;i<9;i++)
			if(map[i/3][i%3]=='X')
				nX++;
			else if(map[i/3][i%3]=='O')
				nO++;
		
		boolean answer=false;
		
		//��ĭ ���� 
		if((nX+nO)==9) { //nX=5, nO=4������. �׸��� O�� ����� �ȵ�
			if(nX-1!=nO || check(map,'O'))
				return false;
			return true;
		}else {
		//��ĭ ����
			// o���� ��������
			if(nX==nO) {
				boolean isO = check(map,'O');
				boolean isX = check(map,'X');
				if(isO && !isX)
					answer = true;
				else answer = false;
			
			//x���� ��������
			}else if(nX-1==nO) {
				boolean isO = check(map,'O');
				boolean isX = check(map,'X');
				
				if(!isO && isX)
					answer = true;
				else answer = false;
			}
		}
		return answer;
	}
							//W�� ���� �ִ��� Ȯ��
	public static boolean check(char[][] map,char W) {
		//����
		for(int r=0;r<3;r++)
			if(map[r][0]==W && map[r][1]==W && map[r][2]==W )
				return true;
		//����
		for(int r=0;r<3;r++)
			if(map[0][r]==W && map[1][r]==W && map[2][r]==W )
				return true;
		//�밢��
		if(map[0][0]==W && map[1][1]==W && map[2][2]==W )
			return true;
		if(map[0][2]==W && map[1][1]==W && map[2][0]==W )
			return true;
		return false;
	}
}