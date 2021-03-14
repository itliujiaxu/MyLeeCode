/*226. 翻转二叉树
        翻转一棵二叉树。
        示例：
        输入：
             4
           /   \
          2     7
         / \   / \
        1   3 6   9
        输出：
             4
           /   \
          7     2
         / \   / \
        9   6 3   1*/
public class InvertTree226 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode result = invertTree(root);
        System.out.println();
    }
    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        //保存左子树
        TreeNode temp = root.left;
        //左右子树交替递归，实现反转
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
