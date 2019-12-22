import java.util.*;

class JoinStrings2 {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);

		int n = io.getInt();	// num of strings
		List<TailLinkedList> list = new ArrayList<>();
		list.add(new TailLinkedList());
		for(int i=1; i<=n; i++) {
			TailLinkedList temp = new TailLinkedList();
			temp.addBack(io.getWord());
			list.add(temp);
		}

		int a = 0;
		for(int j=1; j<n; j++) {
			a = io.getInt();
			int b = io.getInt();
			TailLinkedList first = list.get(a);
			TailLinkedList second = list.get(b);
			first.getTail().setNext(second.getHead());
			first.num_nodes = first.num_nodes + second.num_nodes;
			first.tail = second.getTail();
		}

		if(list.size()>2) {
			TailLinkedList ll = list.get(a);
			ll.print();
		} else {
			list.get(1).print();
		}


		io.close();
	}
}