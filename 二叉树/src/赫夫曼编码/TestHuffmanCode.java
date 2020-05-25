package �շ�������;

import java.util.*;

public class TestHuffmanCode {
	public static void main(String[] args) {
		String msg = "can you can a can as a can canner can a can.";
		byte[] bytes = msg.getBytes();
		// ���кշ�������ѹ��
		byte[] b = huffmanZip(bytes);
		// System.out.println(bytes.length);
		// System.out.println(b.length);
		// ʹ�úշ�������

	}

//���кշ�������ѹ���ķ���
	private static byte[] huffmanZip(byte[] bytes) {
		// ��ͳ��ÿһ��byte���ֵĴ�����������һ��������
		List<Node> nodes = getNodes(bytes);
		// ����һ�źշ�����
		Node tree = createHuffmanTree(nodes);
		System.out.println(tree);
		// ����һ���շ��������
		Map<Byte, String> huffCodes = getCodes(tree);
		System.out.println(huffCodes);
		// ����
		byte[] b = zip(bytes, huffCodes);

		return b;
	}

	/**
	 * ���кշ�������
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

		// ���峤��
		int len;
		if (sb.length() % 8 == 0) {
			len = sb.length() / 8;

		} else {
			len = sb.length() / 8 + 1;

		}
		// System.out.println(sb.toString());
		// ���ڴ洢ѹ�����byte
		byte[] by = new byte[len];
		// ��¼�µ�byte��λ��
		int index = 0;
		for (int i = 0; i < sb.length(); i += 8) {
			String strByte;
			if (i + 8 > sb.length()) {
				strByte = sb.substring(i);
			} else {
				strByte = sb.substring(i, i + 8);
			}
			// System.out.println(strByte);
			// ת�ɶ�����
			byte byt = (byte) Integer.parseInt(strByte, 2);
			by[index] = byt;
			index++;

		}
		return by;
	}

	// ������ʱ�洢·��
	static StringBuilder sb = new StringBuilder();
	// ���ڴ洢�շ�������
	static Map<Byte, String> huffCodes = new HashMap<>();

	/**
	 * ���ݺշ�������ȡ�շ�������
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
	 * �����շ�����
	 * 
	 * @param nodes
	 * @return
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			// ����
			Collections.sort(nodes);
			// System.out.println(nodes);
			// ȡ������Ȩֵ��͵Ķ�����
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			// ����һ���µĶ�����
			Node parent = new Node(null, left.weight + right.weight);
			// ��֮ǰȡ���������Ŷ���������Ϊ�´����Ķ�����������
			parent.left = left;
			parent.right = right;
			// ��ǰ��ȡ����������������ɾ��
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}

		return nodes.get(0);
	}

	/**
	 * ��byte����תΪnode����
	 * 
	 * @param bytes
	 * @return
	 */
	private static List<Node> getNodes(byte[] bytes) {
		List<Node> nodes = new ArrayList<>();
		// ����ÿһ��byte�����˶��ٴ�
		Map<Byte, Integer> counts = new HashMap<>();
		// ͳ��ÿһ��byte���ִ�Ĵ���
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);

			} else {
				counts.put(b, count + 1);
			}
		}
		// System.out.println(counts);
		// ��ÿһ����ֵ��תΪһ��node����
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}

}
