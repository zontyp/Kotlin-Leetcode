package Tree

class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if(p == null && q == null){
            return true
        }

        if(p != null && q != null && p.`val` == q.`val`){
            return isSameTree(p?.left,q?.left) && isSameTree(p?.right ,q?.right)
        }
        else{
            return false
        }


    }
}