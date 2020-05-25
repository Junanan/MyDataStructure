package 线索二叉树;
public class Test {
	public static void main(String[] args) {
	//创建一棵树
		ThreadeBinaryTree ThreadeBinaryTree = new ThreadeBinaryTree();
	//创建一个根节点
	Threadenode root = new Threadenode(1);
	//把根节点赋给树
	ThreadeBinaryTree.setRoot(root);
	//创建右节点
	Threadenode rootr = new Threadenode(3);
	//创建左节点
	Threadenode rootl = new Threadenode(2);
	//设置为根节点的左节点
	root.setLeftNode(rootl);
	//设置为根节点的右节点
	root.setRightNode(rootr);
	//为第二层的左节点创建两个子节点
	rootl.setLeftNode(new Threadenode(4));
	Threadenode fivenode = new Threadenode(5);
	rootl.setLeftNode(fivenode);
	//为第二层右节点创建两个子节点
	rootr.setLeftNode(new Threadenode(6));
	rootr.setRightNode(new Threadenode(7));
	//前序遍历
	ThreadeBinaryTree.frontShow();
	System.out.println("===========");
	//中序遍历
	ThreadeBinaryTree.midShow();
	System.out.println("===========");
	//后序遍历
	ThreadeBinaryTree.backShow();
	//前序查找
	Threadenode result = ThreadeBinaryTree.frontsearch(3);
	System.out.println(result);
	//节点删除
	System.out.println("===========");
	//ThreadeBinaryTree.delete(3);
	ThreadeBinaryTree.frontShow();
	//中线索化二叉树
	ThreadeBinaryTree.threadnodes();
	//获取5节点的后继节点
	Threadenode afterFive = fivenode.rightNode;
	System.out.println(afterFive.value);
	}
}
