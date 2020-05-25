package 赫夫曼编码;

import java.util.*;

public class TestHuffmanCode {
	public static void main(String[] args) {
		String msg = "can you can a can as a can canner can a can.";
		byte[] bytes = msg.getBytes();
		// 进行赫夫曼编码压缩
		byte[] b = huffmanZip(bytes);
		// System.out.println(bytes.length);
		// System.out.println(b.length);
		// 使用赫夫曼解码

	}

//进行赫夫曼编码压缩的方法
	private static byte[] huffmanZip(byte[] bytes) {
		// 先统计每一个byte出现的次数，并放入一个集合中
		List<Node> nodes = getNodes(bytes);
		// 创建一颗赫夫曼树
		Node tree = createHuffmanTree(nodes);
		System.out.println(tree);
		// 创建一个赫夫曼编码表
		Map<Byte, String> huffCodes = getCodes(tree);
		System.out.println(huffCodes);
		// 编码
		byte[] b = zip(bytes, huffCodes);

		return b;
	}

	/**
	 * 进行赫夫曼编码
	 * 
	 * @param bytes
	 * @param huffCodes
	 * @return
	 */
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(huffCodes.get(b));
		}

		// 定义长度
		int len;
		if (sb.length() % 8 == 0) {
			len = sb.length() / 8;

		} else {
			len = sb.length() / 8 + 1;

		}
		// System.out.println(sb.toString());
		// 用于存储压缩后的byte
		byte[] by = new byte[len];
		// 记录新的byte的位置
		int index = 0;
		for (int i = 0; i < sb.length(); i += 8) {
			String strByte;
			if (i + 8 > sb.length()) {
				strByte = sb.substring(i);
			} else {
				strByte = sb.substring(i, i + 8);
			}
			// System.out.println(strByte);
			// 转成二进制
			byte byt = (byte) Integer.parseInt(strByte, 2);
			by[index] = byt;
			index++;

		}
		return by;
	}

	// 用于临时存储路径
	static StringBuilder sb = new StringBuilder();
	// 用于存储赫夫曼编码
	static Map<Byte, String> huffCodes = new HashMap<>();

	/**
	 * 根据赫夫曼树获取赫夫曼编码
	 * 
	 * @param tree
	 * @return
	 */
	private static Map<Byte, String> getCodes(Node tree) {
		if (tree == null) {
			return null;
		}
		getCodes(tree.left, "0", sb);
		getCodes(tree.right, "1", sb);
		return huffCodes;

	}

	private static void getCodes(Node node, String code, StringBuilder sb) {
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(code);
		if (node.data == null) {
			getCodes(node.left, "0", sb2);
			getCodes(node.right, "1", sb2);
		} else {
			huffCodes.put(node.data, sb2.toString());
		}

	}

	/**
	 * 创建赫夫曼树
	 * 
	 * @param nodes
	 * @return
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			// 排序
			Collections.sort(nodes);
			// System.out.println(nodes);
			// 取出两个权值最低的二叉树
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			// 创建一颗新的二叉树
			Node parent = new Node(null, left.weight + right.weight);
			// 把之前取出来的两颗二叉树设置为新创建的二叉树的子树
			parent.left = left;
			parent.right = right;
			// 把前面取出来的两个二叉树删除
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}

		return nodes.get(0);
	}

	/**
	 * 把byte数组转为node集合
	 * 
	 * @param bytes
	 * @return
	 */
	private static List<Node> getNodes(byte[] bytes) {
		List<Node> nodes = new ArrayList<>();
		// 储存每一个byte出现了多少次
		Map<Byte, Integer> counts = new HashMap<>();
		// 统计每一个byte出现大的次数
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);

			} else {
				counts.put(b, count + 1);
			}
		}
		// System.out.println(counts);
		// 把每一个键值对转为一个node对象
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}

}
