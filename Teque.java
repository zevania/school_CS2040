import java.util.*;

class Teque {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);

		int n = io.getInt();	// num of operations
		int[] front = new int[2000000];	int fhead = 1999999/2; int ftail = 1999999/2;
		int[] back = new int[2000000];	int bhead = 1999999/2; int btail = 1999999/2;
		int frontSize = ftail-fhead;	int backSize = btail-bhead;

		for(int i=0; i<n; i++) {
			frontSize = ftail-fhead;
			backSize = btail-bhead;
			String temp = io.getWord();
			int a = io.getInt();
			if (temp.equals("push_back")) {
				btail++;
				back[btail] = a;
			} else if (temp.equals("push_front")) {
				front[fhead] = a;
				fhead--;
			} else if (temp.equals("push_middle")) {
				int mid = (frontSize+backSize+1)/2;
				if(mid > frontSize) {
					while(mid != frontSize) {
						ftail++;
						front[ftail] = back[bhead+1];
						back[bhead+1] = 0;
						bhead++;
						frontSize++;
						backSize--;
					}
				} else if(mid < frontSize) {
					while(mid != frontSize) {
						back[bhead] = front[ftail];
						bhead--;
						front[ftail] = 0;
						ftail--;
						frontSize--;
						backSize++;
					}
				}
				
				back[bhead] = a;
				bhead--;
			} if (temp.equals("get")) {
				if(a > frontSize-1) {
					int pos = a-frontSize;
					io.println(back[bhead+pos+1]);
				} else {
					io.println(front[fhead+a+1]);
				}
			}
		}
		io.close();
	}
}