import java.util.*;

class PeaSoupPancakes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numRes = sc.nextInt();
		List<List<String>> resList = new ArrayList<>();

		for(int i = 0; i < numRes; i++) {
			int numMenu = sc.nextInt();
			sc.nextLine();
			List<String> res = new ArrayList<>();
			String resName = sc.nextLine();
			res.add(resName);
			for(int j = 0; j < numMenu; j++) {
				String menuName = sc.nextLine();
				res.add(menuName);
			}
			resList.add(res);
		}

		boolean isPancake = false;
		boolean isPeaSoup = false;
		String resHave = "";
		//List<String> resHave = new ArrayList<>();
		for(int i=0; i<resList.size(); i++) {
			List<String> temp = resList.get(i); 
			for(int j=1; j<temp.size(); j++) {
				if(temp.get(j).equals("pancakes")) {
					isPancake = true;
				} else if(temp.get(j).equals("pea soup")) {
					isPeaSoup = true;
				}
			}
			if(isPancake && isPeaSoup) {
				resHave = temp.get(0);
				break;
				//resHave.add(temp.get(0));
			}
			isPancake = false;
			isPeaSoup = false;
		}

		if(!resHave.equals("")) {
			System.out.println(resHave);
		} else {
			System.out.println("Anywhere is fine I guess");
		}
		
	}
}