package pl.myapp.java.examples.datastructures.binarytree;

public class Node {
  int value;
  Node left;
  Node right;

  public Node(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public String toString() {
    return "Node{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
  }
}
