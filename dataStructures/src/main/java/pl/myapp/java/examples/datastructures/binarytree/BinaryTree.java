package pl.myapp.java.examples.datastructures.binarytree;

public interface BinaryTree {
  void add(int data);
}

class BaseBinaryTree implements BinaryTree {
  Node root;

  public BaseBinaryTree() {
    root = null;
  }

  @Override
  public void add(int data) {
    root = addRecursive(root, data);
  }

  private Node addRecursive(Node current, int value) {
    if (current == null) {
      return new Node(value);
    }

    if (value < current.value) {
      current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
      current.right = addRecursive(current.right, value);
    }

    return current;
  }
}
