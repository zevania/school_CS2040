import java.util.*;

class Islands {
	public static void main(String[] args) {
		//Kattio io = new Kattio(System.in, System.out);
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt(); 	// row
		int c = sc.nextInt();	// column

		sc.nextLine();

		ArrIsland[][] arr = new ArrIsland[r][c];

		for(int i=0; i<r; i++) {
			String temp = sc.nextLine();
			for(int j=0; j<c; j++) {
				arr[i][j] = new ArrIsland(temp.charAt(j), false);
			}
		}

		int ans = 0;

		for(int p=0; p<r; p++) {
			for(int q=0; q<c; q++) {
				if(arr[p][q].value == 'L' && arr[p][q].visited == false) {
					dfs(arr, p, q);
					ans++;
				}
			}
		}

		System.out.println(ans);
	}

	public static void dfs(ArrIsland[][] arr, int p, int q) {
		arr[p][q].visited = true;
		List<IntegerPair> neighbors = new ArrayList<>();
		if((p-1)>=0)	neighbors.add(new IntegerPair(p-1,q));
		if((p+1)<arr.length)	neighbors.add(new IntegerPair(p+1,q));
		if((q-1)>=0)	neighbors.add(new IntegerPair(p,q-1));
		if((q+1)<arr[0].length)	neighbors.add(new IntegerPair(p,q+1));

		for(int i=0; i<neighbors.size(); i++) {
			int a = neighbors.get(i).x;
			int b = neighbors.get(i).y;
			if(arr[a][b].value == 'C' || arr[a][b].value == 'L') {
				if(arr[a][b].visited == false) {
					dfs(arr, a, b);
				}
			}
		}
	}
}

class IntegerPair {
	int x;
	int y;

	public IntegerPair (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ArrIsland {
	char value;
	boolean visited;

	public ArrIsland (char value, boolean visited) {
		this.value = value;
		this.visited = visited;
	}
}