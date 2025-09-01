package pl.myapp.java.examples.datastructures.binarytree;

public interface BinaryTree {
  void add(int value);

  boolean containsNode(int value);

  void delete(int value);
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

  @Override
  public void delete(int value) {
    root = deleteRecursive(root, value);
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

  private Node deleteRecursive(Node current, int value) {
    if (current == null) {
      return null;
    }

    if (current.value == value) {
      // a node has no children
      if (current.left == null && current.right == null) {
        return null;
      }
      // a node has one child
      if (current.right == null) {
        return current.left;
      }
      if (current.left == null) {
        return current.right;
      }
      // a node has hwo children
      int smallestValue = findSmallestValue(current.right);
      current.value = smallestValue;
      current.right = deleteRecursive(current.right, smallestValue);
      return current;
    }

    if (value < current.value) {
      current.left = deleteRecursive(current.left, value);
    } else if (value > current.value){
      current.right = deleteRecursive(current.right, value);
    }
    return current;
  }

  private int findSmallestValue(Node root) {
    return root.left == null ? root.value : findSmallestValue(root.left);
  }
}
