import java.util.ArrayList;

public class Player {
    public int numPlayers;
    PlayerData data = new PlayerData();
    PlayerData[] dataArray = data.getMyData();
    PlayerData initial = dataArray[0];
    seLinkList head = new seLinkList(null, initial.a, initial.b, initial.c, dataArray.length - 1, null); //I initialize the head to the first player in dataArray
    public Player(int num, PlayerData[] array){
        this.numPlayers = num;
        this.dataArray = array; 
    }
    public void addPlayer(seLinkList node){//Inserts to the beginning
        node.next =head;
        head.prev = node;
        head = node;
        head.prev = null; //At front
    }
    public void initializeList(){
       int i = 1; //Start from 1 as I already initialized 0 as the head.
       int backIndex = dataArray.length - 2; 
        while(i < this.numPlayers){
            PlayerData person = this.dataArray[i];
            seLinkList player = new seLinkList(head, person.a, person.b, person.c, backIndex, null); //maybe not null
            addPlayer(player);
            i++;
            backIndex--;
        }
    }
    public seLinkList findMaxWeight(){
        int weight = 0;
        seLinkList max = head;
        for(seLinkList test = this.head; test.next != null; test = test.next ){
            int sum = test.a + test.b + test.c;
            if(sum > weight){ //update max
            weight = sum;
            max = test;
            }
        }
        //System.out.println("Max weight is " + weight);
       // System.out.println("Max weight at index " + max.index);
        //System.out.println("Max weight a is " + max.a + " b is " + max.b +" c is " + max.c );
        return max;
    }
    public seLinkList findMinWeight(){
        int weight = head.a + head.b + head.c;
        seLinkList min = head;
        for(seLinkList temp = this.head; temp.next != null; temp = temp.next){
            int sum = temp.a + temp.b + temp.c;
            if(sum < weight){
                weight = sum;
                min = temp;
            }
        }
        return min;
    }
    public ArrayList<seLinkList> findMinMaxWeight(){
        int minTracker = head.a + head.b + head.c;
        int maxTracker = head.a + head.b + head.c;
        seLinkList min = head;
        seLinkList max = head;
        for(seLinkList temp = this.head; temp.next != null; temp = temp.next){
            int sum = temp.a + temp.b + temp.c;
            if(sum < minTracker){
                minTracker = sum;
                min = temp;
            }
            if(sum > maxTracker){
                maxTracker = sum;
                max = temp;
            }
        }
        ArrayList<seLinkList> minMax = new ArrayList<seLinkList>();
        minMax.add(min);
        minMax.add(max);
        return minMax;
    }
    public void removeNode(seLinkList remove){
        if(head.next == null && remove == head){ //Only 1 Node
            head = null;
            return;
        }
        head = removeNode(head, remove);
        seLinkList temp = head;
        int counter = 0;
        while(head != null){ //fix the indexes
            if(counter != head.index){
            head.index = counter;
            }
            counter++;
            head = head.next;
        }
       head = temp;
        return;
       }
       public seLinkList removeNode(seLinkList head, seLinkList remove){
        if(head == null){ //Doesn't exist;
            return null;
        }
        if(head == remove && head.prev == null){ //First node
            head.next.prev = null;
            return head.next;
        }
        if(head == remove && head.next != null && head.prev != null){ //In middle
            head.prev.next = head.next; //update prev's next.
            head.next.prev = head.prev;//update the next's prev.
            return head.next;
        }
        if(head == remove && head.next == null){ //In end
            head.prev.next = null;
            return head;
        }
        head.next = removeNode(head.next, remove);
        return head;
       }
}