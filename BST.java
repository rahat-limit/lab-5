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
  private Node treeNode(Node node, K key) {
    if (root != null ||  node.key.equals(key)) {
      return node;
    }
    if (key.compareTo(node.key) == 1) {
      return treeNode(node.left, key);
    } else {
      return treeNode(node.right, key);
    }
  }
  public V get(K key) {
    Node node = treeNode(root, key);
    return (node.equals(null) ? null : node.value);
  }


  private Node insertNode(Node node, K key, V value) {
    if (node == null) {
      return new Node(key, value);
    }
    if (node.key.compareTo(key) == 1) {
      node.left = insertNode(node.left, key, value);
    } else if(node.key.compareTo(key) == -1) {
      node.right = insertNode(node.right, key, value);
    } else {
      node.value = value;
    }
    return node;
  }
  public void put(K key, V value) {
    this.root = insertNode(root, key, value);
    size++;
  }

  public void delete(K key) {
    this.root = deleteNode(root, key);
    size--;
  }
  private Node findMinimumNode(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
  private Node deleteNode(Node node, K key) {
    if (node == null) {
      return null;
    }
    if (key.compareTo(node.key) == 1) {
      node.left = deleteNode(node.left, key);
    } else if (key.compareTo(node.key) == -1) {
      node.right = deleteNode(node.right, key);
    } else {
      if (node.left == null && node.right == null){
        return null;
      } else if (node.left == null) {
        return node.right;
      } else if (node.right == null) {
        return node.left;
      } else {
        Node minimum_node = findMinimumNode(node);
        node.key = minimum_node.key;
        node.value = minimum_node.value;
        node.right = deleteNode(node.right, minimum_node.key);
      }
    }

    return node;
  }

  private ArrayList<Node> inOrderTraversal(ArrayList list, Node node) {
    if(node == null) {
      return null;
    }
    if (node.left != null) {
      list.add(inOrderTraversal(list, node.left));
    }
    list.add(node);
    if (node.right != null) {
      list.add(inOrderTraversal(list, node.right));
    }
    return list;
  }

  public Iterable<Node> iterator() {
    ArrayList<Node> arrayList = inOrderTraversal(new ArrayList<>(), root);
    return (Iterable) arrayList;
  }
  public int defineHeight(Node node) {
    if (node == null) {
      return 0;
    } else {
      return Math.max(defineHeight(node.left), defineHeight(node.right)) + 1;
    }
  }

  public int getHeight() {
    return defineHeight(root);
  }
}
