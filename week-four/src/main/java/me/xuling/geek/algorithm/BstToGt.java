package me.xuling.geek.algorithm;

/**
 * convert-bst-to-greater-tree
 *
 * @author jack
 * @since 2022/1/25
 **/
public class BstToGt {
    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        convertBST(root.right);
        pre += root.val;
        root.val = pre;
        convertBST(root.left);
        return root;
    }

    private int pre = 0;
}
