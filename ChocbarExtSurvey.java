public class ChocbarExtSurvey {
	private String[] chocBars;
	private String[] customers;
	private ChocbarComments [][] surveydata;
	final int NO_BARS;
	final int NO_PEOPLE;
	
	public ChocbarExtSurvey(int nobars, int nopeople, String[] cusname, String[] barname, ChocbarComments [][] extsurvey) {
		NO_BARS = nobars;
		NO_PEOPLE = nopeople;
		chocBars = new String[nobars];
		customers = new String[nopeople];
		surveydata = new ChocbarComments [nopeople][nobars];
		System.arraycopy(barname, 0, chocBars, 0, NO_BARS);
		System.arraycopy(cusname, 0, customers, 0, NO_PEOPLE);
		for (int j = 0; j < NO_PEOPLE; j++) 
			System.arraycopy(extsurvey [j], 0, surveydata [j], 0, NO_BARS);
	}
	
	public void printOutExtSurveyResults() {
		int start_cond, start_cond2;
		for (start_cond = 0; start_cond < NO_PEOPLE; start_cond++) {
			System.out.println("\n" + customers [start_cond] + ": ");
			for (start_cond2 = 0; start_cond2 < NO_BARS; start_cond2++) {
				System.out.print(chocBars [start_cond2] + ": ");
				System.out.print(surveydata [start_cond][start_cond2].toString() + "\n");
			}
		}
	}
}