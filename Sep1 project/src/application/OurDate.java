package application;

import java.util.GregorianCalendar;

public class OurDate {
	// DONE
	private int year;
	private int month;
	private int day;

	/**
	 * Constructor methode to set a date
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public OurDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * methode to get year parameter individually
	 * 
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * methode to get month parameter individually
	 * 
	 * @return
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * methode to get day parameter individually
	 * 
	 * @return
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Emty constructor methode to instantialate OurDate without parameters
	 * 
	 */
	public OurDate() {
	}

	/**
	 * methode to set year parameter individually
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * methode to set month parameter individually
	 * 
	 * @param month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * methode to set day parameter individually
	 * 
	 * @param day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * toString methode to get date as a string
	 * 
	 */
	public String toString() {
		return year + "/" + month + "/" + day;
	}

	/**
	 * set OurDate as a new object with current date as parameter recived from the GregorianCalender class
	 * 
	 * @return
	 */
	public static OurDate today() {
		GregorianCalendar currentDate = new GregorianCalendar();

		return new OurDate(currentDate.get(GregorianCalendar.YEAR), currentDate.get(GregorianCalendar.MONTH) + 1,
				currentDate.get(GregorianCalendar.DATE));
	}

	/**
	 * methode for comparing date with current date
	 * 
	 * @return
	 */
 
	public boolean isAfterMatch() {				
		if (today().year >= year) {
			if (today().year == year) {
				if (today().month >= month) {
					if (today().month == month) {
						if (today().day >= day) {
							if (today().day == day) {
								return false;
							} else
								return true;
						} else
							return false;
					} else
						return true;
				} else
					return false;
			} else
				return true;
		} else
			return false;
	}
 
	public boolean after(OurDate match) {
		if (match.year >= year) {
			if (match.year == year) {
				if (match.month >= month) {
					if (match.month == month) {
						if (match.day >= day) {
							if (match.day == day) {
								return false;
							} else
								return true;
						} else
							return false;
					} else
						return true;
				} else
					return false;
			} else
				return true;
		} else
			return false;
	}
}
