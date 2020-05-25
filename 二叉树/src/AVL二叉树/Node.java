package AVL������;

public class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	/**
	 * ��ȡ�������ĸ߶�
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
	 * ��ȡ�������ĸ߶�
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
	 * ���ص�ǰ�ڵ�ĸ߶�
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
		// �жϴ���ڵ�����ڵ�Ĵ�С
		// ���С
		if (node.value < this.value) {
			// �����ڵ�Ϊ��
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
		// ��ѯ�Ƿ�Ϊƽ�������
		// ��������ת
		if (leftHeight() - rightHeight() >= 2) {
			// ˫��ת
			if (left != null && left.leftHeight() < left.rightHeight()) {
				//������ת
				left.leftRotate();
				//������ת
				rightRotate();
			} else {
				// ����ת
				rightRotate();
			}
		}
		// ����ת
		if (leftHeight() - rightHeight() <= 2) {
			// ˫��ת
			if (right != null && right.rightHeight() < right.leftHeight()) {
				right.rightRotate();
				leftRotate();
			} else {
				// ����ת
				leftRotate();
			}

		}
	}
	/**
	 * ����ת
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
	 * ����ת
	 */
	private void rightRotate() {
		// ����һ���µĽڵ㣬ֻ���ڵ�ǰ�ڵ��ֵ
		Node newRight = new Node(value);
		// ���µĽڵ������������Ϊ��ǰ�ڵ��������
		newRight.right = right;
		// ���½ڵ������������Ϊ��ǰ�ڵ����������������
		newRight.left = left.right;
		// �ѵ�ǰ�ڵ��ֵ��Ϊ���ӽڵ��ֵ
		value = left.value;
		// �ѵ�ǰ�ڵ������������Ϊ��������������
		left = left.left;
		// �ѵ�ǰ�ڵ������������Ϊ�½ڵ�
		right = newRight;
	}
	/**
	 * �����������������
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
