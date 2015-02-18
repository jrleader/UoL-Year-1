import java.util.*;
public class ChocolateExtTestHarness {
	public static void main(String[] args) {
	final int NOBARS = 3;
	final int NOCUS = 3;
	String cmt1 = "N/A";
	String cmt2 = "Tastes good";
	String cmt3 = "No comments";
	String cmt4 = "Poor packaging";
	String cmt5 = "Tastes sweet";
	int taste = getNum((int)(Math.random() * 10));
	int appearance = getNum((int)(Math.random() * 10));
	String customers[] = {"C110", "C120", "C130"};
	String bars[] = {"BAR1", "BAR2", "BAR3"};
	ChocbarComments item1 = new ChocbarComments(taste, appearance, cmt1);
	ChocbarComments item2 = new ChocbarComments(taste, appearance, cmt5);
	ChocbarComments item3 = new ChocbarComments(taste, appearance, cmt4);
	ChocbarComments item4 = new ChocbarComments(taste, appearance, cmt3);
	ChocbarComments item5 = new ChocbarComments(taste, appearance, cmt2);
	ChocbarComments item6 = new ChocbarComments(taste, appearance, cmt1);
	ChocbarComments item7 = new ChocbarComments(taste, appearance, cmt5);
	ChocbarComments item8 = new ChocbarComments(taste, appearance, cmt3);
	ChocbarComments item9 = new ChocbarComments(taste, appearance, cmt2);
	ChocbarComments [][] survey1 = {{item1, item2, item3}, {item4, item5, item6}, {item7, item8, item9}};
	ChocbarExtSurvey survey = new ChocbarExtSurvey(NOBARS, NOCUS, customers, bars, survey1);
	survey.printOutExtSurveyResults();
	}
	
	public static void ShuffleArray(int [] sampleArray) {
		Random rand = new Random();
		for(int i = 0; i < sampleArray.length; i++) {
			int index = rand.nextInt(sampleArray.length);
			int a = sampleArray[index];
			sampleArray[index] = sampleArray[i];
			sampleArray[i] = a;
		}
	}
	
	public static int getNum(int loc) {
		int [] randNum = {1,2,3,4,5,6,7,8,9,10};
		int i = 0;
		while(i < loc) {
			ShuffleArray(randNum);
			i++;
		}
		return randNum[loc];
	}
}


