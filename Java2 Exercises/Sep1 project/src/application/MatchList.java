package application;

import java.util.ArrayList;

public class MatchList {
	// DONE

	private ArrayList<Match> matches;

	/**
	 * Setting Arraylist of matches, defult size are 10
	 */
	public MatchList() {
		matches = new ArrayList<Match>(10);
	}

	/**
	 * methode for adding match to matchlist
	 * 
	 * @param obj
	 */
	public void addMatch(Match obj) {
		matches.add(obj);
	}

	/**
	 * methode for removing match from matchlist
	 * 
	 * @param obj
	 */
	public void deleteMatch(Match obj) {
		matches.remove(obj);
	}

	/**
	 * methode for getting a match in the match arraylist
	 * 
	 * @param index
	 * @return
	 */
	public Match getMatch(int index) {
		return matches.get(index);
	}

	/**
	 * methode for getting size of matchlist arraylist
	 * 
	 * @return
	 */
	public int listSize() {
		return matches.size();
	}

	public void sortMatchesByDate() {
		int n = matches.size();
		Match temp = null;
		for (int i = 0; i < n; i++) {
			for (int k = 1; k < (n - 1); k++) {
				if (matches.get(k - 1).getDate().after(matches.get(k).getDate())) {
					temp = matches.get(k - 1);
					matches.set((k - 1), matches.get(k));
					matches.set(k, temp);
				}
			}
		}
	}

	/**
	 * toString methode, to return a all matches in an table
	 * 
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < matches.size(); i++) {
			output += matches.get(i).toString() + "\n";
		}
		return output;
	}

	/**
	 * methode for checking if a date is passed
	 * 
	 */
	public void checkDates() {
		for (int i = 0; i < matches.size(); i++) {
			matches.get(i).hasMatchPassed();
		}
	}

}