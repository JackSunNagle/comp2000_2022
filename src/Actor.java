import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class Actor extends Thread {
  static int size = Cell.size;
  private Cell loc;

  enum Player {
    Human, Bot
  };

  private Player player;
  int speed;
  int turns;
  int damage;
  int score;
  protected MoveStrategy strat;
  protected String desc;
  protected BufferedImage img;
  Thread t;

  public Actor(Cell l, BufferedImage i, String d, Player p, int s, int harm) {
    loc = l;
    img = i;
    player = p;
    speed = s;
    desc = d;
    strat = new RandomMove();
    turns = speed;
    damage = harm;
  }

  public synchronized void paint(Graphics g) {
    g.drawImage(img, loc.x, loc.y, size, size, null);
  }

  public synchronized boolean isHuman() {
    return player == Player.Human;
  }

  public synchronized boolean isBot() {
    return player == Player.Bot;
  }

  public synchronized void setLocation(Cell inLoc) {
    loc = inLoc;
  }

  public synchronized Cell getLocation() {
    return loc;
  }

  @Override
  public void run() {
    System.out.println("New thread - "+desc+": " + Thread.currentThread().getName());
    try {
      while(true){
        System.out.println(desc + ": " + Thread.currentThread().getName() + ", " + Thread.currentThread().isAlive() + ", " + Thread.currentThread().getState());
        Thread.sleep(1000);
      }

    } catch (Exception e) {
      System.out.println(desc + "Exception Caught");
    }

  }

}
