
public class Person {
  private String name;
	private String giftee;
	private String passWord;
	
	Person(String name, String giftee, String inPW){
		this.name = name;
		this.giftee = giftee;
		this.passWord = inPW;
	}
	
	public String getPW() {
		return this.passWord;
	}
	
	public void changePW(String newPW){
		this.passWord = newPW;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getGiftee() {
		return this.giftee;
	}
	
	public void changeGiftee(String newGiftee){
		this.giftee = newGiftee;
	}
	
	public String toString() {
		return ("You, " + this.getName()/*.toUpperCase()*/ + " must give " + this.getGiftee()/*.toUpperCase()*/ + " a fucking awesome gift that is <= $10.");
		//return (this.getGiftee());
	}
	
}
