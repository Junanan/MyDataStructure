public class BSTtest {
	class BST {
		TreeNode root;

		public BST(TreeNode root) {
			this.root = root;
		}

		public void add(TreeNode node) {
			if (root == null) {
				root = node;
			} else {
				root.insert(node);
			}
		}

		public void Inorder() {
			if (root != null) {
				root.Inorder(root);
			}
		}

		public TreeNode search(String name) {
			if (root == null) {
				return null;
			} else {
				return root.search(name);
			}
		}

		public TreeNode successde(TreeNode node) {
			if (root == null)
				return null;
			return root.successde(node);
		}
		public TreeNode presuccessde(TreeNode node) {
			if (root == null)
				return null;
			return root.presuccessde(node);
		}
	}

	class TreeNode {
		student key;
		TreeNode left;
		TreeNode right;

		public TreeNode(student key) {
			this.key = key;
			left = right = null;
		}

		public TreeNode presuccessde(TreeNode x) {
			if (x != null && x.left != null)
				return Treemaxinum(x.left);
			return null;
		}

		private TreeNode Treemaxinum(TreeNode x) {
			if(x!=null&&x.right==null) return x;
			return TreeMininum(x.right);
		}

		public TreeNode successde(TreeNode x) {
			if (x != null && x.right != null)
				return TreeMininum(x.right);
			return null;

		}

		private TreeNode TreeMininum(TreeNode x) {
			if(x!=null&&x.left==null) return x;
			return TreeMininum(x.left);
		}

		public TreeNode search(String name) {
			if (this.key.getName().equals(name)) {
				return this;
			} else if (this.key.getName().compareTo(name) > 0) {
				if (left == null)
					return null;
				return left.search(name);
			} else {
				if (right == null)
					return null;
				return right.search(name);
			}
		}

		public void Inorder(TreeNode root) {
			if (root == null)
				return;
			Inorder(root.left);
			System.out.println(root.key);
			Inorder(root.right);

		}

		public void insert(TreeNode node) {
			if (node == null)
				return;
			if (node.key.compareTo(this.key) < 0) {
				if (this.left == null) {
					this.left = node;
				} else {
					this.left.insert(node);
				}
			} else {
				if (node.key.compareTo(this.key) > 0) {
					if (this.right == null) {
						this.right = node;
					} else {
						this.right.insert(node);
					}
				}
			}
		}

	}

	class student {
		private String name;
		private int id;

		public student(int id, String name) {
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public int compareTo(student o) {
			return this.name.compareTo(o.name);
		}

	}
}
