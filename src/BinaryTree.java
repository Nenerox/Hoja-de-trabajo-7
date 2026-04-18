public class BinaryTree<E> {
    protected E val; 
	protected BinaryTree<E> left, right;
	
	public BinaryTree(E value) {
        this.val = value;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }
	
	public BinaryTree<E> left()
	{
		return left;
	}
	
	public BinaryTree<E> right()
	{
		return right;
	}
	
	public void setLeft(BinaryTree<E> newLeft)
	{
		this.left = newLeft;
	}

	public void setRight(BinaryTree<E> newRight)
	{
		this.right = newRight;
	}
	
	public E value()
	{
		return val;
	}
	
	public void setValue(E value)
	{
		this.val = value;
	}

	public boolean isEmpty()
	{
		return val == null;
	}
	
}