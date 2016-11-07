//----------------------------------------------------------------------------
// BSTNode.java               by Dale/Joyce/Weems                    Chapter 8
//
// Implements Comparable nodes for a binary search tree.
//----------------------------------------------------------------------------

public class BSTIntegerNode
{
  // Used to hold references to BST nodes for the linked implementation
  protected int info;                // The info in a BST node
  protected BSTIntegerNode left;       // A link to the left child node
  protected BSTIntegerNode right;      // A link to the right child node

  public BSTIntegerNode(int info)
  {
    this.info = info;
    left = null;
    right = null;
  }
 
  public void setInfo(int info)
  // Sets info of this BSTNode.
  {
    this.info = info;
  }

  public int getInfo()
  // Returns info of this BSTNode.
  {
    return info;
  }
 
  public void setLeft(BSTIntegerNode link)
  // Sets left link of this BSTNode.
  {
    left = link;
  }

  public void setRight(BSTIntegerNode link)
  // Sets right link of this BSTNode.
  {
    right = link;
  }

  public BSTIntegerNode getLeft()
  // Returns left link of this BSTNode.
  {
    return left;
  }

  public BSTIntegerNode getRight()
  // Returns right link of this BSTNode.
  {
    return right;
  }
}
 
 