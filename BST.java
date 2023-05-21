import java.util.ArrayList;

public class BST<K extends Comparable<K>, V>  {
  private Node root;
  private int size = 0;
  public class Node{
    private K key;
    private V value;
    private Node left, right;
    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      return "{key: " + this.key + " value: " + this.value + "}";
    }
  }
  public int getSize() {
    return size;
  }


}
