/**
 *Vanessa Zevania Zheng
 *A0184540H
 *
 *Best Relay Team
 *Based on the time given for each runner in the first leg and other legs,
 *determine the runners for the best team with shortest time
 */

import java.util.*;

class BestRelayTeam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Runner[] runners = new Runner[n];
		sc.nextLine();
		for(int i=0; i<n; i++) {
			String name = sc.next();
			double first = sc.nextDouble();
			double other = sc.nextDouble();
			runners[i] = new Runner(name, first, other);
		}
		Runner[] sortedRunners = Arrays.copyOf(runners, n);
		Arrays.sort(sortedRunners, new SortSpeed());

		String[] bestTeam = new String[4];		// Runners names for the best team
		double totalTime = 100;
		for(int i = 0; i < n; i++) {
			double temp = 0;
			temp += runners[i].first;
			int counter1 = 0;
			for(int j = 0; j < 4; j++) {
				if(counter1<3 && !runners[i].name.equals(sortedRunners[j].name)) {
					counter1++;
					temp += sortedRunners[j].other;
				}
			}
			if(temp < totalTime) {
				totalTime = temp;
				bestTeam[0] = runners[i].name;
				int k = 1;
				for(int j = 0; j < 4; j++) {
					if(k < 4 && !runners[i].name.equals(sortedRunners[j].name)) {
						bestTeam[k] = sortedRunners[j].name;
						k++;						
					}
				}
			}
		}

		System.out.println(totalTime);
		for(int i = 0; i < 4; i++) {
			System.out.println(bestTeam[i]);
		}
	}
}

class SortSpeed implements Comparator<Runner> {
	public int compare(Runner a, Runner b) {
		if(a.other > b.other) {
			return 1;
		} else if(a.other == b.other) {
			return 0;
		} else {
			return -1;
		}
	}
}

class Runner {
	public String name;
	public double first;
	public double other;

	public Runner(String name, double first, double other) {
		this.name = name;
		this.first = first;
		this.other = other;
	}
}