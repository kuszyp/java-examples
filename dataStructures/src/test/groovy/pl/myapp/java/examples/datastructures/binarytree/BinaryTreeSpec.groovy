package pl.myapp.java.examples.datastructures.binarytree

import spock.lang.Specification

class BinaryTreeSpec extends Specification {
  def "should properly define binary tree and display each node"() {
    given:
    BinaryTree tree = new BaseBinaryTree();

    when:
    tree.add(4)
    tree.add(8)
    tree.add(6)

    println(tree.root.toString())

    then:
    noExceptionThrown()
  }
}
