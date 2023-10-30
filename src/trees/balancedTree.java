package trees;

public class balancedTree {

    class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    boolean isBalanced(Node root) {
        if(root == null) return true;
        int leftheight = getHeight(root.left);
        int rightheight = getHeight(root.right);
        if (Math.abs(leftheight - rightheight) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int getHeight(Node root){
        if(root == null){
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return Math.max(l,r)+1;
    }
}
