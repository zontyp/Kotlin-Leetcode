package Tree
/*
LC 236
3
💡 Intuition Reinforced:
You explore the tree bottom-up to find the deepest node / lca

The first node where you see p in one subtree and q in the other → that’s the lowest common ancestor.

      3
     / \
    5   1

left = 5, right = 1 → Both sides return non-null → Return 3 as LCA

      3
     /
    5   ← p
   /
  1     ← q

left = 5, right = null → Return 5 as LCA

3
\
5   ← p
\
1 ← q

left = null, right = 5 → Return 5 as LCA

🧠 Intuition Behind Postorder
In postorder, at each node:

You ask: Did I find p or q in the left?

You ask: Did I find p or q in the right?

If both are non-null, then current node is the LCA.

Otherwise, return the non-null result to your parent.

This is a perfect "bottom-up" approach.

🔍 Why Not Inorder?
Inorder is good for sorted binary trees (like BSTs),
not for decisions like "does my left and right subtree
each contain one of the target nodes p, q?"

In Leetcode 236 (Lowest Common Ancestor of a Binary Tree),
we use postorder traversal (left → right → root) instead of
 preorder (root → left → right) or inorder (left → root → right) because of how we build the result.

✅ Why Postorder Works Best Here
The goal is:

Find the lowest node in the tree that has both p and q in its subtree.

This requires:

We first explore left and right subtrees fully

Only after that, we make a decision at the current root

This "explore children first, then combine results" logic is postorder traversal.

we need to find if p, q is in left or right .
also we need to find the deepest node - so we need a bottom up approach - not a top down approach

if p , q are on either side then that root is lca
if q is descendant then p is lca ,
if p is descendant then q is lca
 */

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || root == p || root == q) return root

    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    return when {
        left != null && right != null -> root
        else -> left ?: right
    }
}

fun main() {
    // Sample Tree:
    //      3
    //     / \
    //    5   1
    //   / \
    //  6   2
    //     / \
    //    7   4

    val root = TreeNode(3)
    val node5 = TreeNode(5)
    val node1 = TreeNode(1)
    val node6 = TreeNode(6)
    val node2 = TreeNode(2)
    val node7 = TreeNode(7)
    val node4 = TreeNode(4)

    root.left = node5
    root.right = node1
    node5.left = node6
    node5.right = node2
    node2.left = node7
    node2.right = node4

    val p = node5
    val q = node1

    val lca = lowestCommonAncestor(root, p, q)
    println("Lowest Common Ancestor of ${p.`val`} and ${q.`val`} is: ${lca?.`val`}")
}
