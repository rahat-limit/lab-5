# Assignment 6
## BFS
Performs Breadth-First Search (BFS) starting from a given vertex.
```java
public void BFS(Vertex start){
    Set<Vertex> visited = new HashSet<>();
    Queue<Vertex> queue = new LinkedList<>();

    visited.add(start);
    queue.add(start);

    while (!queue.isEmpty()) {
        Vertex currentVertex = queue.poll();
        System.out.print(currentVertex + " ");
        Set<Vertex<V>> neighbors = currentVertex.getAdjVertices().keySet();
        for (Vertex<V> neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
    }
}
```
## Method: dijkstra
A map containing the shortest distances from the starting vertex to all other vertices. The keys represent the vertices, and the values represent the corresponding shortest distances.
```java
public Map<Vertex, Double> dijkstra(Vertex start) {
    Map<Vertex, Double> distances = new HashMap<>();
    for (Vertex node : graph.keySet()) {
        distances.put(node, Double.MAX_VALUE);
    }
    distances.put(start, 0d);

    PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
    queue.add(start);

    while (!queue.isEmpty()) {
        Vertex currentVertex = queue.poll();

        for (Edge neighbor : graph.get(currentVertex)) {
            double distance = distances.get(currentVertex) + neighbor.getWeight();

            if (distance < distances.get(currentVertex)) {
                distances.put(currentVertex, distance);
                queue.add((Vertex) neighbor.getDest());
            }
        }
    }

    return distances;
}
```
## Add Edge
Adds a weighted edge between two vertices in the graph.
```java
public void addEdge(Vertex source, Vertex destination, double weight){
    Edge edge = new Edge(source, destination, weight);
    source.addAdjVertex(destination, weight);
    if (!graph.containsKey(source)) graph.put(source, new ArrayList<>());
    graph.get(source).add(edge);
}
```



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
