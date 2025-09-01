package pl.myapp.java.examples.datastructures.binarytree

import spock.lang.Rollup
import spock.lang.Specification

class BinaryTreeSpec extends Specification {
  def "should properly define binary tree and display each node"() {
    given:
    BinaryTree tree = new BaseBinaryTree();

    when:
    tree.add(6)
    tree.add(4)
    tree.add(8)
    tree.add(3)
    tree.add(5)
    tree.add(7)
    tree.add(9)

    println(tree.root.toString())

    then:
    noExceptionThrown()
  }

  @Rollup
  def "should return true when node with given value exists and false if is do not exists in the tree"() {
    given:
    BinaryTree tree = new BaseBinaryTree()
    [12, 8, 5, 4, 11, 18, 17].each { tree.add(it) }

    when:
    boolean result = tree.containsNode(value)

    then:
    assert result == expects

    where:
    value | expects
    4     | true
    8     | true
    0     | false
    11    | true
    10    | false
    19    | false
  }
}
