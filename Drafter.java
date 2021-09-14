import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Drafter
{
  // creates a drafter and utilizes queues to determine who gets chosen on this team.
  private Queue<String> qbQueue = new LinkedList<>();
  private Queue<String> rbQueue = new LinkedList<>();
  private Queue<String> wrQueue = new LinkedList<>();
  private Queue<String> teQueue = new LinkedList<>();
  private int numQB = 1, numRB = 2, numWR = 2, numTE = 1;
  String[] qb = new String[numQB], rbs = new String[numRB], wrs = new String[numWR], tes = new String[numTE];

  public Drafter()
  {
    numQB = 1;
    numRB = 2;
    numWR = 2;
    numTE = 1;
  }

  // Using a list of players from a specified position and corresponding position queue,
  // fill the queue with players from the list in random selections.
  public void setPositionQueue(LinkedList<String> players, Queue<String> pQueue)
  {
    Random rand = new Random();
    String usedNum = "";

    for(int x = 0; x < players.size(); x++)
    {
      int randNum = rand.nextInt(players.size());
      while(usedNum.contains(String.valueOf(randNum))) { randNum = rand.nextInt(players.size()); }
      pQueue.add(players.get(randNum));
      usedNum += String.valueOf(randNum);
    }
  }

  // return t/f is position can be inserted
  public static boolean canAddToTeam(String[] posArr)
  {
    return posArr[posArr.length-1] == null;
  }

  // set the position array with the incoming player.
  public void setPos(String[] posArr, String player)
  {
    for(int x = 0; x < posArr.length; x++)
    {
      if(posArr[x] == null)
      {
        posArr[x] = player;
        break;
      }
    }
  }

  // getters
  public Queue<String> getQBQueue() { return qbQueue; }
  public Queue<String> getRBQueue() { return rbQueue; }
  public Queue<String> getWRQueue() { return wrQueue; }
  public Queue<String> getTEQueue() { return teQueue; }

  public String[] getQBArr() { return qb; }
  public String[] getRBArr() { return rbs; }
  public String[] getWRArr() { return wrs; }
  public String[] getTEArr() { return tes; }

  @Override
  public String toString()
  {
    String result = "Quarterback: " + getQBArr()[0] + "\nRunning Back: " + getRBArr()[0] + ", " + getRBArr()[1];
    result += "\nWide Recievers: " + getWRArr()[0] + ", " + getWRArr()[1];
    result += "\nTight End: " + getTEArr()[0];
    return result;
  }
}
