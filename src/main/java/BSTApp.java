import java.util.*;

public class BSTApp{
  static int min = Integer.MAX_VALUE;
  static Node parent = null;
  public static void main(String[] args) {
    Random element = new Random();
    BST testBST1 = new BST();
    for(int i = 0; i < 10; i++){
      testBST1.insert(element.nextInt(10001));
    }
    System.out.println("Traverse gives a BST as " + Arrays.toString(testBST1.traverse()));
    System.out.println("The minium absolute difference is " + minDiff(testBST1.getRoot()));
    BST testBST2 = new BST();
    testBST2.insert(1);
    testBST2.insert(5);
    testBST2.insert(3);
    testBST2.insert(8);
    testBST2.insert(6);
    System.out.println("Traverse gives a BST as " + Arrays.toString(testBST2.traverse()));
    System.out.println("The minium absolute difference is " + minDiff(testBST2.getRoot()));
  }
  static public int minDiff(Node root) {
    // instantiates static method
    BSTApp diff = new BSTApp();
    diff.traverseApp(root);
    return min;
  }
  private void traverseApp(Node node){
    //traverses BST keeping track of differences between nodes
    if(node != null){
      traverseApp(node.left);
    
      if(parent != null && Math.abs(node.key - parent.key) < min){
        min = Math.abs(node.key - parent.key);
      }
      parent = node;
      traverseApp(node.right);
  }
}
}