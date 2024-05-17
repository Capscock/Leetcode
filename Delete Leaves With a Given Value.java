class TreeNode {
    int val; // Value of the node
    TreeNode left; // Reference to the left child node
    TreeNode right; // Reference to the right child node
  
    // Constructor to initialize the node with no children
    TreeNode() {}
  
    // Constructor to initialize the node with a value
    TreeNode(int val) { this.val = val; }
  
    // Constructor to initialize the node with a value and references to left and right children
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // Removes all leaf nodes with a specified value from a binary tree.
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // If the root is null, the tree is empty, and we return null as there are no nodes to remove.
        if (root == null) {
            return null;
        }
      
        // Recursively remove leaf nodes from the left subtree.
        root.left = removeLeafNodes(root.left, target);
        // Recursively remove leaf nodes from the right subtree.
        root.right = removeLeafNodes(root.right, target);
      
        // Check if the current node is a leaf node with the target value.
        if (root.left == null && root.right == null && root.val == target) {
            // If so, remove this node by returning null to the parent call.
            return null;
        }
      
        // Return the possibly updated root to the previous recursive call.
        // If no changes were made, the original node is returned.
        return root;
    }
}
