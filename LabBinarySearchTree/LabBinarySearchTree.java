
package labbinarysearchtree;

public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public LabBinarySearchTree(){
        //Bu metodu değiştirmeyin
    }
    public LabBinarySearchTree(BTNode<T> root) {
        //Bu metodu değiştirmeyin
        super(root);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public BTNode<T> successor(T value) {
        BTNode<T> current = find(getRoot(), value);
        if(current==null || current.right==null)
            return null;
        else{
            current=current.right;
            while(current.left!=null){
                current=current.left;
            }
        }  
        
        return current;
    }

    @Override
    public BTNode<T> predecessor(T value) {
        
        BTNode<T> current = find(getRoot(), value);
        if(current==null || current.left==null)
            return null;
        else{
            current=current.left;
            while(current.right!=null){
                current=current.right;
            }
        }  
        
        return current;
    }

    @Override
    public BTNode<T> findParent(BTNode<T> node) {
       
        
        
      
        
        
        
        
        return null;
    }


}



