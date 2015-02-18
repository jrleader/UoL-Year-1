public class ChocbarComments {
	private int taste;
	private int appearance;
	private String comments;
	
	public ChocbarComments(int taste, int appearance, String comments) {
		this.taste = taste;
		this.appearance = appearance;
		this.comments = comments;
	}
	
	public String toString() {
		return "Taste: " + taste + "  " + "Appearance: " + appearance + "  " + "Comments: " + comments;
	}
}