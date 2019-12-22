import java.util.*;

class LostMap {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int V = io.getInt();

		ArrayList<IntegerTriple> edgeList = new ArrayList<IntegerTriple>();

		for(int k=0; k<V; k++) {
			for(int l=0; l<V; l++) {
				int dis = io.getInt();
				if(l >= k+1)
					edgeList.add(new IntegerTriple(dis, k, l));
			}
		}

		Collections.sort(edgeList);

		UnionFind UF = new UnionFind(V);
	    int i;
	    for (i = 0; i < edgeList.size(); i++) {
	    	if(UF.numDisjointSets() == 0)	break;
	    	IntegerTriple e = edgeList.get(i);
	      	int u = e.second, v = e.third, w = e.first; 
	      	if (!UF.isSameSet(u, v)) { 
	        	UF.unionSet(u, v);
	        	io.println((u+1) + " " + (v+1));
	      	}
	    }


		io.close();
	}
}

class IntegerTriple implements Comparable<IntegerTriple> {
  public Integer first, second, third;

  public IntegerTriple(Integer f, Integer s, Integer t) {
    first = f;
    second = s;
    third = t;
  }

  public int compareTo(IntegerTriple o) {
    if (!this.first.equals(o.first))
      return this.first - o.first;
    else if (!this.second.equals(o.second))
      return this.second - o.second;
    else
      return this.third - o.third;
  }
}

class UnionFind {
  public ArrayList<Integer> p, rank, setSize;
  public int numSets;

  public UnionFind(int N) {
    p = new ArrayList<Integer>(N);
    rank = new ArrayList<Integer>(N);
    setSize = new ArrayList<Integer>(N);
    numSets = N;
    for (int i = 0; i < N; i++) {
      p.add(i);
      rank.add(0);
      setSize.add(1);
    }
  }

  public int findSet(int i) { 
    if (p.get(i) == i) return i;
    else {
      int ret = findSet(p.get(i)); p.set(i, ret);
      return ret; 
    } 
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { 
      numSets--; 
      int x = findSet(i), y = findSet(j);
      // rank is used to keep the tree short
      if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
      else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                                     if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y)+1); } 
    } 
  }

  public int numDisjointSets() { return numSets; }
}