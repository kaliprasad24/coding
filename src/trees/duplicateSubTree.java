package trees;

import java.util.ArrayList;

public class duplicateSubTree {

    class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    ArrayList<Integer> postOrder = new ArrayList<>();
//    int dupSub(Node root) {
//        // code here
//        postorder(root);
//        for(int i = 0;i<postOrder.size();i++){
//
//        }
//    }

    void postorder(Node root){
        if(root.left == null && root.right == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        postOrder.add(root.data);
    }
}
