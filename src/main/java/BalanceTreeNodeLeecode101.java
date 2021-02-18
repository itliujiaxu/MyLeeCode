/*101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

 

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
    3    3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class BalanceTreeNodeLeecode101 {
    public static void main(String args[]) throws Exception {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(2,new TreeNode(4),new TreeNode(3)));
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return root==null?true:helper(root.left,root.right);
    }

    private static boolean helper(TreeNode left, TreeNode right) {
        if(left==null&&right==null) return true;
        if(left==null||right==null||left.val!=right.val) return false;
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }
}
