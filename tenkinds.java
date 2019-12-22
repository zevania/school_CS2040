import java.util.*;
import java.io.*;

public class tenkinds {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int r = io.getInt();    // row
		int c = io.getInt();    // column
		
		int[][] ori = new int[r][c];
		PeopleArray[][] arr = new PeopleArray[r][c];
		
		for(int i=0; i<r; i++) {
			String text = io.getWord();
			for(int j=0; j<c; j++) {
				int a = Integer.parseInt(""+text.charAt(j));
				ori[i][j] = a;
				arr[i][j] = new PeopleArray(a,0);
			}
		}

		// pre-process
		int counter = 0;    int[] count = new int[1];
		outerloop:
		for(int m=0; m<r; m++) {
			for(int n=0; n<c; n++) {
				if(count[0]==r*c) {
					break outerloop;
				}
				if(arr[m][n].visited==0) {
					counter++;
					int temp = arr[m][n].value;
					arr[m][n].value = counter;
					bfs(arr, m, n, temp, count);
				}
			}
		}

		int query = io.getInt();
		for(int q=0; q<query; q++) {
			int r1 = io.getInt()-1; int c1 = io.getInt()-1;
			int r2 = io.getInt()-1; int c2 = io.getInt()-1;
			if(arr[r1][c1].value==arr[r2][c2].value) {
				if(ori[r1][c1]==1)  io.println("decimal");
				else                io.println("binary");
			} else {
				io.println("neither");
			}
		}
		io.close();
	}

	public static void dfs(PeopleArray[][] arr, int m, int n, int temp, int[] count) {
		arr[m][n].visited = 1;  count[0] += 1;

		if((m-1)>=0 && arr[m-1][n].visited==0 && arr[m-1][n].value==temp) {
				arr[m-1][n].value = arr[m][n].value;
				dfs(arr, m-1, n, temp, count);
		}
		if((m+1)<arr.length && arr[m+1][n].visited==0 && arr[m+1][n].value==temp) {
				arr[m+1][n].value = arr[m][n].value;
				dfs(arr, m+1, n, temp, count);
		}
		if((n-1)>=0 && arr[m][n-1].visited==0 && arr[m][n-1].value==temp) {
				arr[m][n-1].value = arr[m][n].value;
				dfs(arr, m, n-1, temp, count);
		}
		if((n+1)<arr[0].length && arr[m][n+1].visited==0 && arr[m][n+1].value==temp) {
				arr[m][n+1].value = arr[m][n].value;
				dfs(arr, m, n+1, temp, count);
		}
	}

	public static void bfs(PeopleArray[][] arr, int m, int n, int temp, int[] count) {
		arr[m][n].visited = 1;  count[0] += 1;
		int stamp = arr[m][n].value;
		Queue<Integer> x = new LinkedList<>();
		Queue<Integer> y = new LinkedList<>();
		x.add(m);
		y.add(n);
		while (!x.isEmpty()) {
			m = x.remove();
			n = y.remove();
			if((m-1)>=0 && arr[m-1][n].visited==0 && arr[m-1][n].value==temp) {
				arr[m-1][n].visited = 1;
				arr[m-1][n].value = stamp;
				x.add(m-1);
				y.add(n);
			}
			if((m+1)<arr.length && arr[m+1][n].visited==0 && arr[m+1][n].value==temp) {
				arr[m+1][n].visited = 1;
				arr[m+1][n].value = stamp;
				x.add(m+1);
				y.add(n);
			}
			if((n-1)>=0 && arr[m][n-1].visited==0 && arr[m][n-1].value==temp) {
				arr[m][n-1].visited = 1;
				arr[m][n-1].value = stamp;
				x.add(m);
				y.add(n-1);
			}
			if((n+1)<arr[0].length && arr[m][n+1].visited==0 && arr[m][n+1].value==temp) {
				arr[m][n+1].visited = 1;
				arr[m][n+1].value = stamp;
				x.add(m);
				y.add(n+1);
			}		
		}
	}
}

class PeopleArray {
	int value;
	int visited;

	public PeopleArray(int value, int visited) {
		this.value = value;
		this.visited = visited;
	}
}

class Kattio extends PrintWriter {
	public Kattio(InputStream i) {
		super(new BufferedOutputStream(System.out));
		r = new BufferedReader(new InputStreamReader(i));
	}
	public Kattio(InputStream i, OutputStream o) {
		super(new BufferedOutputStream(o));
		r = new BufferedReader(new InputStreamReader(i));
	}

	public boolean hasMoreTokens() {
		return peekToken() != null;
	}

	public int getInt() {
		return Integer.parseInt(nextToken());
	}

	public double getDouble() {
		return Double.parseDouble(nextToken());
	}

	public long getLong() {
		return Long.parseLong(nextToken());
	}

	public String getWord() {
		return nextToken();
	}



	private BufferedReader r;
	private String line;
	private StringTokenizer st;
	private String token;

	private String peekToken() {
		if (token == null)
			try {
				while (st == null || !st.hasMoreTokens()) {
					line = r.readLine();
					if (line == null) return null;
					st = new StringTokenizer(line);
				}
				token = st.nextToken();
			} catch (IOException e) { }
		return token;
	}

	private String nextToken() {
		String ans = peekToken();
		token = null;
		return ans;
	}
}
