/**
 *Vanessa Zevania Zheng
 *A0184540H
 *
 *Train Passengers
 *Based on the input given on train and passengers,
 *determine whether such case is possible
 */

import java.util.*;

class Train {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int capacity = sc.nextInt();
		int stations = sc.nextInt();
		boolean pos = true;
		int onTrain = 0;		// num of passengers on train

		for(int i = 1; i <= stations; i++) {
			int left = sc.nextInt();
			int enter = sc.nextInt();
			int wait = sc.nextInt();
			if(left > onTrain) {
				pos = false;	break;
			}
			onTrain += enter;
			onTrain -= left;

			if(i==1 && left!=0) {		// first station
				pos = false;	break;
			} else if(i==stations) {	// last station
				if(enter!=0) {
					pos = false;	break;
				} else if(wait!=0) {
					pos = false;	break;
				} else if(onTrain!=0) {
					pos = false;	break;
				}
			} else if(i!=stations) {
				if(onTrain > capacity) {
					pos = false;	break;
				} else if(onTrain < 0) {
					pos = false;	break;
				} else if(wait!=0 && (capacity - onTrain) > 0) {
					pos = false;	break;
				}
			}

			 
		}
		if(pos) {
			System.out.println("possible");
		} else {
			System.out.println("impossible");
		}

	}
}