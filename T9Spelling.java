import java.util.*;

class T9Spelling {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		String[] arr = new String[123];
		arr['a'] = "2";
		arr['b'] = "22";
		arr['c'] = "222";

		arr['d'] = "3";
		arr['e'] = "33";
		arr['f'] = "333";

		arr['g'] = "4";
		arr['h'] = "44";
		arr['i'] = "444";

		arr['j'] = "5";
		arr['k'] = "55";
		arr['l'] = "555";

		arr['m'] = "6";
		arr['n'] = "66";
		arr['o'] = "666";

		arr['p'] = "7";
		arr['q'] = "77";
		arr['r'] = "777";
		arr['s'] = "7777";

		arr['t'] = "8";
		arr['u'] = "88";
		arr['v'] = "888";

		arr['w'] = "9";
		arr['x'] = "99";
		arr['y'] = "999";
		arr['z'] = "9999";

		arr[' '] = "0";

		for(int i=1; i<=n; i++) {
			StringBuilder line = new StringBuilder(sc.nextLine());
			StringBuilder ans = new StringBuilder();
			for(int j=0; j<line.length(); j++) {
				StringBuilder m = new StringBuilder(arr[line.charAt(j)]);
				int len = ans.length();
				if(len>0 && ans.charAt(len-1) == m.charAt(0)) {
					ans.append(" ");
				}
				ans.append(m);
			}
			System.out.println("Case #"+i+": "+ans);
		}
	}
}