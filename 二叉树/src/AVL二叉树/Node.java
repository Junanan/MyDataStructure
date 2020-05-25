package AVL二叉树;

public class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	/**
	 * 获取左子树的高度
	 * 
	 * @return
	 */
	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	/**
	 * 获取右子树的高度
	 * 
	 * @return
	 */
	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}

	/**
	 * 返回当前节点的高度
	 * 
	 * @return
	 */
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}

	public void add(Node node) {
		if (node == null) {
			return;
		}
		// 判断传入节点与根节点的大小
		// 如果小
		if (node.value < this.value) {
			// 如果左节点为空
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (node.value > this.value) {
				if (this.right == null) {
					this.right = node;
				} else {
					this.right.add(node);
				}
			}
		}
		// 查询是否为平衡二叉树
		// 进行右旋转
		if (leftHeight() - rightHeight() >= 2) {
			// 双旋转
			if (left != null && left.leftHeight() < left.rightHeight()) {
				//先左旋转
				left.leftRotate();
				//后右旋转
				rightRotate();
			} else {
				// 单旋转
				rightRotate();
			}
		}
		// 左旋转
		if (leftHeight() - rightHeight() <= 2) {
			// 双旋转
			if (right != null && right.rightHeight() < right.leftHeight()) {
				right.rightRotate();
				leftRotate();
			} else {
				// 单旋转
				leftRotate();
			}

		}
	}
	/**
	 * 左旋转
	 */
	private void leftRotate() {
		Node newleft = new Node(value);
		newleft.left = left;
		newleft.right = right.left;
		value = right.value;
		right = right.right;
		left = newleft;
	}
	/**
	 * 右旋转
	 */
	private void rightRotate() {
		// 创建一个新的节点，只等于当前节点的值
		Node newRight = new Node(value);
		// 把新的节点的右子树设置为当前节点的右子树
		newRight.right = right;
		// 把新节点的左子树设置为当前节点的左子树的右子树
		newRight.left = left.right;
		// 把当前节点的值换为左子节点的值
		value = left.value;
		// 把当前节点的左子树设置为左子树的左子树
		left = left.left;
		// 把当前节点的右子树设置为新节点
		right = newRight;
	}
	/**
	 * 中序遍历二叉排序树
	 * 
	 * @param node
	 */
	public void midshow(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			midshow(node.left);
		}
		System.out.println(node.value);
		if (node.right != null) {
			midshow(node.right);
		}
	}
	public Node search(int value) {
		if (value == this.value) {
			return this;
		} else if (this.value > value) {
			if (left == null) {
				return null;
			}
			return left.search(value);
		} else {
			if (right == null) {
				return null;
			}
			return right.search(value);
		}
	}

	public Node searchParent(int value) {
		if (this.left != null && this.left.value == value || this.right != null && this.right.value == value) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.searchParent(value);
			} else if (value > this.value && this.right != null) {
				return this.right.searchParent(value);
			}
			return null;
		}
	}
}
