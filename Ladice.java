import java.util.*;

class Ladice {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);

		int n = io.getInt();	// num of items
		int l = io.getInt();	// num of drawers

		UnionFind ds = new UnionFind(l);
		int i;
		for(i=0; i<n; i++) {
			int a = io.getInt();
			int b = io.getInt();
			
			ds.unionSet(a,b);
			if(ds.getSize(ds.findSet(a)) >= ds.getItems(ds.findSet(a))+1) {
				io.println("LADICA");
				ds.addItems(ds.findSet(a));
			} else {
				io.println("SMECE");
			}
		}

		io.close();
	}
}