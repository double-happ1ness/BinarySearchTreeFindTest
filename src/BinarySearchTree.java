// this is a cut down version of the class specifically for the Find test
// the complete version is in the Library folder on Moodle

public class BinarySearchTree implements SortedADT {

    private class BinarySearchTreeNode {
        private Comparable object;
        private BinarySearchTreeNode left;
        private BinarySearchTreeNode right;
    }
    private BinarySearchTreeNode root;
    private BinarySearchTreeNode current;
    private BinarySearchTreeNode parent;
    
    public String toString(){
        String treeDetails = new String();
        if (this.root != null) {
            treeDetails+=this.getTree(this.root,0);
        }
        else{
            treeDetails+="tree is empty";
        }
        return treeDetails;
    }

    private String getTree(BinarySearchTreeNode current, Integer level) {
        String treeDetails = new String();
        level++;
        if (current != null) {
            treeDetails += this.getTree(current.right, level);
            for (Integer i = 0; i < level; i++) {
                treeDetails += "    ";
            }
            treeDetails += current.object + "\n";
            treeDetails += this.getTree(current.left, level);

        } else {
            for (Integer i = 0; i < level; i++) {
                treeDetails += "    ";
            }
            treeDetails += "null\n";
        }
        return treeDetails;
    }

    public void insert(Comparable object) throws NotUniqueException {
        /* Algorithm
            create a new tree node
            add the object to the new node
            if tree is empty then
                make root refer to the new node
            else
                insert the new node in the tree 
            end if
         */
        BinarySearchTreeNode newNode = new BinarySearchTreeNode();
        newNode.object = object;
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.insert(newNode,this.root);
        }
    }

    private void insert(BinarySearchTreeNode newNode,BinarySearchTreeNode current)
        throws NotUniqueException{
        /* Algorithm
            if new object matches current object then
                // attempt to add a duplicate
                throw not unique exception
            end if
            if new object is less than the current object then
                if current node does not have a left subtree then
                    make left of current the new node
                else
                    insert the new node in the left subtree
                end if
            else
                if current node does not have a right subtree then
                    make right of current the new node
                else
                    insert the new node in the right subtree
                end if
            end if
         end if
         */
        if (newNode.object.compareTo(current.object) == 0)
            throw new NotUniqueException();
        if (newNode.object.compareTo(current.object) < 0) {
            if (current.left == null) {
                current.left = newNode;
            } else {
                this.insert(newNode,current.left);
            }
        } else if (current.right == null) {
            current.right = newNode;
        } else {
            this.insert(newNode,current.right);
        }
    }
    
    public Comparable find(Comparable object) throws NotFoundException {
        // add code here
          return this.find(object,this.root);      
    }

    private Comparable find(Comparable object, BinarySearchTreeNode current)
        throws NotFoundException{
        /* Algorithm
            if node available then
                if current object matches object to find then
                    object found
                else
                    if object to find is less than the current object then
                        search the left subtree
                    else
                        search the right subtree
                    end if
                end if
            else
                // object is not in the tree
                throw not found exception
            end if
         */
        Comparable foundObject;
        // add code here
        if (current != null) {
            if (object.compareTo(current.object) == 0) {
                this.current=current;
                foundObject = current.object;
            } else{
                this.parent=current;
                if (object.compareTo(current.object) < 0) {
                    foundObject = this.find(object,current.left);
                } else {
                    foundObject = this.find(object,current.right);
                }
            }
        } else{
            throw new NotFoundException();
        }
        return foundObject;
    }

}
