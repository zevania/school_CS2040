import java.util.*;

class CardTrick {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();		// num of test cases

		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			if(n>1) {
				arr[1] = 1;
				int value = 2;
				for(int j=0; j<n; j++) {
					if(arr[j]==0) {
						arr[j] = value;
						value++;
					}
				}
				order(arr);
			} else {
				arr[0] = 1;
			}
			
			String result = "";
			for(int k=0; k<n; k++) {
				result += arr[k];
				result += " ";
			}
			System.out.println(result);

		}
	}

	public static void order(int[] arr) {
		int len = arr.length;
		
		Queue<Integer> cards = new LinkedList<>();
		for(int i=0; i<len; i++) {
			cards.offer(arr[i]);
		}
		
		int counter = 1;
		while(!cards.isEmpty()) {
			for(int i=1; i<=counter; i++) {
				int a = cards.poll();
				cards.offer(a);
			}
			int b = cards.peek();
			if(b==counter) {
				cards.poll();
			} else {
				int index = 0;
				for(int p=0; p<len; p++) {
					if(arr[p]==b) {
						index = p;	break;
					}
				}
				for(int i=0; i<len; i++) {	//swap element in arr
					if(arr[i]==counter) {
						int temp = arr[i];
						arr[i] = b;
						arr[index] = temp;	break;					
					}
				}

				int swapi = 0;
				Integer[] larr = cards.toArray(new Integer[0]);
				for(int l=0; l<larr.length; l++) {
					if(larr[l]==b) {
						swapi = l; break;
					}
				}

				for(int t=0; t<larr.length; t++) {
					if(larr[t]==counter) {
						int temp = larr[t];
						larr[t] = larr[swapi];
						larr[swapi] = temp;	break;
					}
				}

				//LinkedList<Integer> ll = new LinkedList(Arrays.asList(larr));
				cards = new LinkedList(Arrays.asList(larr));
				cards.poll();
			}
			counter++;
		}
	}

}