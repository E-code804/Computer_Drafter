import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Drafting
{
  private static LinkedList<String> qbs = new LinkedList<>();
  private static LinkedList<String> rbs = new LinkedList<>();
  private static LinkedList<String> wrs = new LinkedList<>();
  private static LinkedList<String> tes = new LinkedList<>();
  private static LinkedList<String> allPlayers = new LinkedList<>();

  // have methods for setting order of players, actual drafting and setting of teams.
  public static void main(String[] args)
  {
    // Fills the position linkedlits with their respective players.
    fillLists();

    // Initialize the drafters and fill in their queues based on positions.
    Drafter d1 = new Drafter();
    d1.setPositionQueue(qbs, d1.getQBQueue());
    d1.setPositionQueue(rbs, d1.getRBQueue());
    d1.setPositionQueue(wrs, d1.getWRQueue());
    d1.setPositionQueue(tes, d1.getTEQueue());

    Drafter d2 = new Drafter();
    d2.setPositionQueue(qbs, d2.getQBQueue());
    d2.setPositionQueue(rbs, d2.getRBQueue());
    d2.setPositionQueue(wrs, d2.getWRQueue());
    d2.setPositionQueue(tes, d2.getTEQueue());

    Drafter d3 = new Drafter();
    d3.setPositionQueue(qbs, d3.getQBQueue());
    d3.setPositionQueue(rbs, d3.getRBQueue());
    d3.setPositionQueue(wrs, d3.getWRQueue());
    d3.setPositionQueue(tes, d3.getTEQueue());

    Drafter d4 = new Drafter();
    d4.setPositionQueue(qbs, d4.getQBQueue());
    d4.setPositionQueue(rbs, d4.getRBQueue());
    d4.setPositionQueue(wrs, d4.getWRQueue());
    d4.setPositionQueue(tes, d4.getTEQueue());

    Drafter d5 = new Drafter();
    d5.setPositionQueue(qbs, d5.getQBQueue());
    d5.setPositionQueue(rbs, d5.getRBQueue());
    d5.setPositionQueue(wrs, d5.getWRQueue());
    d5.setPositionQueue(tes, d5.getTEQueue());

    Drafter[] drafters = {d1, d2, d3, d4, d5}; // DO NOT DELETE
    draftLogic(drafters);
    System.out.println(d1.toString() + "\n");
    System.out.println(d2.toString() + "\n");
    System.out.println(d3.toString() + "\n");
    System.out.println(d4.toString() + "\n");
    System.out.println(d5.toString());
  }

  // make the draft logic
  private static void draftLogic(Drafter[] drafters)
  {
    // make the random in between 0 and size of all players list
    Random rand = new Random();
    // make to position to be filled randomly generated.
    int amountOfPicks = allPlayers.size();
    for(int x = 0; x < amountOfPicks; x++)
    {
      // selects the current drafter
      Drafter d = drafters[x%drafters.length];
      // generate a random number to determine what position will be drafted
      int randPos = rand.nextInt(4);
      // store the position array that will be filled
      String[] currentArr = getPosArr(d, randPos); // in drafter, make sure player in queue is available.
      // storing the corresponding position list
      LinkedList<String> playerInPosition = getPosList(randPos);
      // storing the corresponding player queue.
      Queue<String> posQueue = getPosQueue(d, randPos);
      while(!d.canAddToTeam(currentArr)) // ensures an open array and valid pos list are chosen.
      {
        randPos = rand.nextInt(4);
        currentArr = getPosArr(d, randPos);
        playerInPosition = getPosList(randPos);
        posQueue = getPosQueue(d, randPos);
      }

      // with #1 choice, check if it is in the allPlayers list
      String desiredPlayer = posQueue.peek();
      while(allPlayers.indexOf(desiredPlayer) == -1) // ensures a valid player from queue is selected
      {
        posQueue.remove(desiredPlayer);
        desiredPlayer = posQueue.peek();
      }
      // at the drafter's current position array, insert the desiredPlayer and remove from allPlayers
      d.setPos(currentArr, allPlayers.remove(allPlayers.indexOf(desiredPlayer)));
    }
  }


  // getter methods to return the current drafter's drafting position, queue, and list
  private static String[] getPosArr(Drafter d, int pos)
  {
    if(pos == 0) {return d.getQBArr();}
    else if(pos == 1) {return d.getRBArr();}
    else if(pos == 2) {return d.getWRArr();}
    return d.getTEArr();
  }

  private static Queue<String> getPosQueue(Drafter d, int pos)
  {
    if(pos == 0) {return d.getQBQueue();}
    else if(pos == 1) {return d.getRBQueue();}
    else if(pos == 2) {return d.getWRQueue();}
    return d.getTEQueue();
  }

  private static LinkedList<String> getPosList(int pos)
  {
    if(pos == 0) {return qbs;}
    else if(pos == 1) {return rbs;}
    else if(pos == 2) {return wrs;}
    return tes;
  }

  // Filling all pos lists and the all players list.
  public static void fillLists()
  {
    qbs.add("Patrick Mahomes");
    qbs.add("Kyler Murray");
    qbs.add("Dak Prescott");
    qbs.add("Josh Allen");
    qbs.add("Aaron Rodgers");

    rbs.add("Christian McCafferey");
    rbs.add("Dalvin Cook");
    rbs.add("Saquon Barkley");
    rbs.add("Derrick Henry");
    rbs.add("Alvin Kamara");
    rbs.add("Jonathan Taylor");
    rbs.add("Nick Chubb");
    rbs.add("Aaron Jones");
    rbs.add("Ezekiel Elliot");
    rbs.add("Cam Akers");

    wrs.add("Davante Adams");
    wrs.add("Tyreek Hill");
    wrs.add("D.K Metcalf");
    wrs.add("Stefon Diggs");
    wrs.add("DeAndre Hopkins");
    wrs.add("Julio Jones");
    wrs.add("A.J Brown");
    wrs.add("Justin Jefferson");
    wrs.add("Calvin Ridley");
    wrs.add("Keenan Allen");

    tes.add("Travis Kelce");
    tes.add("George Kittle");
    tes.add("Darren Waller");
    tes.add("Mark Andrews");
    tes.add("T.J Hockenson");

    for(String player : qbs) { allPlayers.add(player); }
    for(String player : rbs) { allPlayers.add(player); }
    for(String player : wrs) { allPlayers.add(player); }
    for(String player : tes) { allPlayers.add(player); }
  }
}
