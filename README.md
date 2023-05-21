# Assignment 5
## Get Size
Return size of tree.
```java
public int getSize() {
    return size;
}
```
## Get
Get Node by given key
```java
public V get(K key) {
    Node node = getTreeNode(root, key);
    return (node.equals(null) ? null : node.value);
}

private Node getTreeNode(Node node, K key) {
    if (root != null || node.key.equals(key)) {
        return node;
    }
    if (key.compareTo(node.key) == 1) {
        return getTreeNode(node.left, key);
    } else {
        return getTreeNode(node.right, key);
    }
}
```
## Put
Put Node in a tree.
```java
public void put(K key, V value) {
    this.root = insertNode(root, key, value);
    size++;
}

private Node insertNode(Node node, K key, V value) {
    if (node == null) {
        return new Node(key, value);
    }
    if (node.key.compareTo(key) == 1) {
        node.left = insertNode(node.left, key, value);
    } else if (node.key.compareTo(key) == -1) {
        node.right = insertNode(node.right, key, value);
    } else {
        node.value = value;
    }
    return node;
}
```
## Iterator
Go through whole binary search, return iterator
```java
public Iterable<Node> iterator() {
    ArrayList<Node> arrayList = inorderTraversal(new ArrayList<>(), root);
    return (Iterable) arrayList;
}

private ArrayList<Node> inorderTraversal(ArrayList list, Node node) {
    if (node == null) {
        return null;
    }
    if (node.left != null) {
        list.add(inorderTraversal(list, node.left));
    }
    list.add(node);
    if (node.right != null) {
        list.add(inorderTraversal(list, node.right));
    }
    return list;
}
```
