import java.util.Random;
public class Main {
  public static void main(String[] args) {
    BST<Integer, String> bst = new BST();
    Random rand = new Random();
    for (int i = 0; i < 15; i++) {
      bst.put(rand.nextInt(100), "Val " + i);
    }
    System.out.println(bst.getHeight());;
  }
}
