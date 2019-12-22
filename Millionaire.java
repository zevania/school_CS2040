import java.util.*;

class Millionaire {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);

		int r = io.getInt();
		int c = io.getInt();

		int[][] arr = new int[r][c];

		TreeMap<IntegerPair, Boolean> tm = new TreeMap<>();
		PriorityQueue<IntegerTriple> pq = new PriorityQueue<IntegerTriple>();
		final int INF = 1000000000;
		pq.offer(new IntegerTriple(0, 0, 0));

		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				arr[i][j] = io.getInt();
				pq.offer(new IntegerTriple(INF, i, j));
			}
		}

		int finalH = 0;

		while(!pq.isEmpty()) {
			if(tm.containsKey(new IntegerPair(r-1,c-1)))
				break;
			IntegerTriple it = pq.poll();
			int H = it.first;
			int x = it.second;
			int y = it.third;

			if(!tm.containsKey(new IntegerPair(x,y))) {
				finalH = Math.max(finalH, H);
				tm.put(new IntegerPair(x,y), true);

				int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
				for(int i=0; i<4; i++) {
					int nextRow = x + move[i][0];
					int nextCol = y + move[i][1];
					if((nextRow >= 0 && nextRow < arr.length) && 
						(nextCol >= 0 && nextCol < arr[0].length) && !tm.containsKey(new IntegerPair(nextRow, nextCol))) {

						int temp = arr[nextRow][nextCol]-arr[x][y];
						if(temp > 0) {
							IntegerTriple test = new IntegerTriple(temp, nextRow, nextCol);
							pq.offer(test);
						} else {
							IntegerTriple test = new IntegerTriple(0, nextRow, nextCol);
							pq.offer(test);
						}
						
					}
				}
			}
		}

		io.println(finalH);
		io.close();
	}
}

class IntegerTriple implements Comparable<IntegerTriple> {
  Integer first, second, third;

  public IntegerTriple(Integer f, Integer s, Integer t) {
    first = f;
    second = s;
    third = t;
  }

  public int compareTo(IntegerTriple o) {
    if (!this.first.equals(o.first))
      	return this.first - o.first;
    else if(!this.second.equals(o.second))
      	return this.second - o.second;
  	else
  		return this.third - o.third;
  }
}

class IntegerPair implements Comparable<IntegerPair> {
  Integer first, second;

  public IntegerPair(Integer f, Integer s) {
    first = f;
    second = s;
  }

  public int compareTo(IntegerPair o) {
    if (!this.first.equals(o.first))
      return this.first - o.first;
    else
      return this.second - o.second;
  }
}
