//比较两颗树是否相同
import java.util.LinkedList;

public class TreeNode<E> {

	E e;

	LinkedList<TreeNode<E>> list;

	TreeNode(E t) {
		if (t == null) {
			throw new RuntimeException("not able null!");
		}

		e = t;
		list = new LinkedList<TreeNode<E>>() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean equals(Object o) {
				if (o == null) {
					return false;
				}

				if (!(o instanceof LinkedList)) {
					return false;
				}

				@SuppressWarnings("unchecked")
				LinkedList<TreeNode<E>> list = (LinkedList<TreeNode<E>>) o;
				if (list.size() != size()) {
					return false;
				}

				for (int i = 0, size = size(); i < size; i++) {
					if (!list.get(i).equals(get(i))) {
						return false;
					}
				}

				return true;
			};
		};
	}

	void addChild(TreeNode<E> node) {
		list.addLast(node);
	}

	LinkedList<TreeNode<E>> getChilds() {
		return list;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj instanceof TreeNode) {
			TreeNode<?> node = (TreeNode<?>) obj;
			return e.equals(node.e) && list.equals(node.list);
		}

		return false;
	}

	public static void main(String[] args) {
		TreeNode<String> root1 = new TreeNode<String>("aa");
		TreeNode<String> root2 = new TreeNode<String>("bb");
		TreeNode<String> root3 = new TreeNode<String>("aa");

		System.out.println(root1.equals(root2));
		System.out.println(root1.equals(root3));

		root1.addChild(root2);
		root3.addChild(root2);

		root1.addChild(root3);

		System.out.println(root1.equals(root3));

	}

}
