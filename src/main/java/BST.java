import java.util.*;

class BST {
  // do not change this
  private Node root;

  // do not change this
  public BST() {
    root = null;
  }

  // search
  //wrapper method
  public boolean search(int target) {
    boolean inTree = searchBST(root, target);
    System.out.print(target + " in tree: " + inTree);
    return searchBST(root, target);
  }
  private boolean searchBST(Node node, int target){ 
    //Edge cases for recursion, ensures that tree exists and that target is not at node
    if(node == null){
        return false;
      }
      else if (node.key == target){
        return true;
      }
      //searches to the right if target is larger than current node.val
      if(target < node.key){
        return searchBST(node.left, target);
      }
      //searches to the left if target is smaller thane node.val
      else{
        return searchBST(node.right, target);
      }
    }
  

  // insert
  //wrapper method
  public Node insert(int target) {
    root = insertBST(root, target);
    return root;
  }
  private Node insertBST(Node node, int val){
    //check if tree is empty
    if(node == null){
      node = new Node(val);
    }
    //recur down tree
    else if(val < node.key){
      node.left = insertBST(node.left, val);
    }
    else if(val == node.key){
      node.key = val;
    }
    else{
      node.right = insertBST(node.right, val);
    }
    return node;
  }
  // note: you may need to implement several supporting methods for delete
  // wrapper method
  public Node delete(int target) {
    root = deleteBST(root, target);
    return root;
  }
  public Node deleteBST(Node node, int val){
    //checks if tree is empty
    if(root == null){
      return root;
    }
    //recur down tree
    if(val < node.key){
      node.left = deleteBST(node.left, val);
    }
    else if(val > node.key){
      node.right = deleteBST(node.right, val);
    }
    //if val = root.key, delete node with key = val
    else{
      //handles nodes with one child
      if(node.left == null){
        return node.right;
      }
      else if(root.right == null){
        return root.left;
      }
      //handles nodes with two children by getting inOrder Succesor
      node.key = minVal(node.right);
      //delete inOrder Successor
      node.right = deleteBST(node.right, node.key);
    }
    return node;
}
//gets inOrder successor
public int minVal(Node node){
  int min = node.key;
  while(node.left != null){
    min = node.left.key;
    node = node.left;
  }
  return min;
}
 // in-order traversal
  public int[] traverse() {
    //creates list to dynamically store values
    List<Integer> BSTList = new ArrayList<Integer>();
    traverseNode(root, BSTList);
    /*creates an int[] array of same size as list
    /and loops values from list into array*/
    int[] treeKeys = new int[BSTList.size()];
    for(int y = 0; y < treeKeys.length; y++){
      //converts Integer[] to int[]
      treeKeys[y] = BSTList.get(y).intValue();
    }
    return treeKeys;
  }
  private void traverseNode(Node node, List list){
    if(node != null){
      traverseNode(node.left, list);
      //adds key to list
      list.add(node.key);
      traverseNode(node.right, list);
    }
}

  // you are welcome to add any supporting methods
  //returns root of BST
  public Node getRoot(){
    return this.root;
  }
}
