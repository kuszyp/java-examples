package pl.myapp.java.examples.datastructures.binarytree;

public interface BinaryTree {
  void add(int value);

  boolean containsNode(int value);
}

class BaseBinaryTree implements BinaryTree {
  Node root;

  public BaseBinaryTree() {
    root = null;
  }

  @Override
  public void add(int value) {
    root = addRecursive(root, value);
  }

  @Override
  public boolean containsNode(int value) {
    return containsNodeRecursive(root, value);
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

  private boolean containsNodeRecursive(Node current, int value) {
    if (current == null) {
      return false;
    }

    if (current.value == value) {
      return true;
    }
    return value < current.value
        ? containsNodeRecursive(current.left, value)
        : containsNodeRecursive(current.right, value);
  }
}
