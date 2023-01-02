import java.util.ArrayList;
public class Assignment2{
	public static void main(String[] args) {
	System.out.println("Christian Lopez - Git Assignment");
	PlayerData playerData = new PlayerData();
	PlayerData[] myData = playerData.getMyData();
    Player play = new Player(47,myData);
	play.initializeList();
	for(int i = 0; i < 3; i++){
		ArrayList<seLinkList> minMax = play.findMinMaxWeight();
		int min = minMax.get(0).a + minMax.get(0).b + minMax.get(0).c;
	    int max = minMax.get(1).a + minMax.get(1).b + minMax.get(1).c;
		System.out.println("Min node A: " + minMax.get(0).a + " B: " + minMax.get(0).b + " C: " + minMax.get(0).c + " Weight: " + min + " Index: " + minMax.get(0).index );
	    System.out.println("Max node A: " + minMax.get(1).a + " B: " + minMax.get(1).b + " C: " + minMax.get(1).c + " Weight: " + max + " Index: " + minMax.get(1).index );
		System.out.println("");
		play.removeNode(minMax.get(0));
		play.removeNode(minMax.get(1));
	}
	/* To see how my link list looks after deleting
	for(seLinkList test = play.head; test != null; test = test.next){
		System.out.println("Test node A: " + test.a + " B: " + test.b + " C: " + test.c + " Index: " + test.index );
	}*/
	System.out.println("Done!");
	}
}