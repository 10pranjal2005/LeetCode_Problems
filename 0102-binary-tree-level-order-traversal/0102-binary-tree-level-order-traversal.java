import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // If the tree is empty
        if (root == null) return result;
        
        // Use a queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes in the current level
            List<Integer> currentLevel = new ArrayList<>();
            
            // Process all nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                
                // Add left and right children to the queue if they exist
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            // Add the level to result
            result.add(currentLevel);
        }
        
        return result;
    }
}
