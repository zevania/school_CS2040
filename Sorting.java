import java.util.*;

class Sorting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		while(n!=0) {
			String[] names = new String[n];
			for(int i=0; i<n; i++) {
				names[i] = sc.nextLine();
			}
			//bubbleSort2(names);
			Arrays.sort(names, new NameComparator());
			for(int i=0; i<n; i++) {
				System.out.println(names[i]);
			}
			n = Integer.parseInt(sc.nextLine());
		}
	}
}

class NameComparator implements Comparator<String> {
	@Override
	public int compare(String name1, String name2) {
		if(name1.charAt(0) == name2.charAt(0))
	    	return name1.charAt(1) - name2.charAt(1);
	    else
	    	return name1.charAt(0) - name2.charAt(0);
	}
}