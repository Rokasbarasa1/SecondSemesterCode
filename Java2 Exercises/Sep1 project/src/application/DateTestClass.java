package application;

public class DateTestClass {
	public static void main(String[] args) {
	   
	   OurDate date1 = new OurDate(2018, 5, 29);
	   OurDate date2 = new OurDate(2018, 5, 27);
	   OurDate date3 = new OurDate(2018, 6, 31);
      OurDate date4 = new OurDate(2018, 1, 5);

		System.out.println(date1.toString());
		System.out.println(date1.isAfterMatch());

		System.out.println(date2.toString());
		System.out.println(date2.isAfterMatch());

		System.out.println(date3.toString());
		System.out.println(date3.isAfterMatch());

		System.out.println(date4.toString());
		System.out.println(date4.isAfterMatch());

		Player p1 = new Player("Rokas", "Barasa", "1", "Striker", "Available");
		Player p2 = new Player("Ryan", "Rimkus", "8", "Middle", "Available");
		Player p3 = new Player("Roma", "Juodis", "4", "Goal Keeper", "Available");
		Player p4 = new Player("Jamie", "Rekasius", "9", "Striker", "Available");
		Player p5 = new Player("Lukas", "Drasutis", "3", "Middle", "Available");
		Player p6 = new Player("Rokas", "Anuzis", "10", "Striker", "Available");
		Player p7 = new Player("Mahmund", "Domarkas", "11", "Striker", "Available");
		Player p8 = new Player("Emmanuel", "Tekorius", "7", "Defender", "Available");
		Player p9 = new Player("Rokas", "Adomaitis", "2", "Middle", "Available");
		Player p10 = new Player("Francesko", "Kuprelis", "5", "Middle", "Available");
		Player p11 = new Player("Bartek", "Eglynas", "6", "Defender", "Available");

		Formation greenBastards = new Formation("Debilai");

		greenBastards.addPlayer(p1);
		greenBastards.addPlayer(p2);
		greenBastards.addPlayer(p3);
		greenBastards.addPlayer(p4);
		greenBastards.addPlayer(p5);
		greenBastards.addPlayer(p6);
		greenBastards.addPlayer(p7);
		greenBastards.addPlayer(p8);
		greenBastards.addPlayer(p9);
		greenBastards.addPlayer(p10);
		greenBastards.addPlayer(p11);

		Match match1 = new Match("Red Indians", date1, "Friendly", greenBastards, "Fenstad");
		Match match2 = new Match("Bundle sticks", date2, "Cup", greenBastards, "Bergen");
		Match match3 = new Match("Dumb Turtles", date3, "League", greenBastards, "Oslo");
		Match match4 = new Match("Chavs", date4, "Cup", greenBastards, "Jassheim");

		MatchList mlist = new MatchList();

		mlist.addMatch(match1);
		mlist.checkDates();
		p4.setPostion("Middle");
		mlist.addMatch(match2);
		mlist.checkDates();
		p4.setPostion("Defender");
		mlist.addMatch(match3);
		mlist.checkDates();
		p4.setPostion("Middle");
		mlist.addMatch(match4);
		mlist.checkDates();

		mlist.sortMatchesByDate();

		System.out.println(mlist.toString());
		mlist.checkDates();

		System.out.println(p4.getMostPlayedPosition());
		mlist.getMatch(1).hasMatchPassed();
		System.out.println(mlist.getMatch(1).getPastMatch());
		
		
		//System.out.println(Integer.toString(p1.getDateAvailable().getDay()));
		
	}
}
