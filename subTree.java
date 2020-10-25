//
// Binary trees are already defined with this interface:
class Tree<T> {
  Tree(T x) {
    value = x;
  }
  T value;
  Tree<T> left;
  Tree<T> right;
}
class subTree{
static boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
    if (t2 == null) 
        return true;

    if (t1 == null)
        return false;

    if (areIdentical(t1, t2)) 
        return true;
    
    return isSubtree(t1.left, t2)
            || isSubtree(t1.right, t2);
}


static boolean areIdentical(Tree<Integer> root1, Tree<Integer> root2) {
    if (root1 == null && root2 == null)
        return true;
    if (root1 == null || root2 == null)
        return false;
    return (root1.value.equals(root2.value)
            && areIdentical(root1.left, root2.left)
            && areIdentical(root1.right, root2.right));
}



public static void main(String[] args) {
    Tree<Integer> root1 = new Tree<Integer>(1);
    Tree<Integer> root2 = new Tree<Integer>(1);
    root1.left = new Tree<>(2);
    root1.right = new Tree<>(3);
    root1.left.left = new Tree<>(4);
    root1.left.right = new Tree<>(5);
    
    root2.left = new Tree<>(2);
    root2.right = new Tree<>(3);
    root2.left.left = new Tree<>(6);
    root2.left.right = new Tree<>(5);
    
    if (areIdentical(root1, root2))
        System.out.println ("Identical");
    else
        System.out.println ("Not Identical");
       
}
}