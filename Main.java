public class Main {
	public static int sumTree(BST<Integer> bsti) {
		if (bsti.isEmpty()) {
			return 0;
		} else {
			if (bsti.getLeft() == null && bsti.getRight() != null) {
				return (bsti.getDatum() + sumTree(bsti.getRight()));
			} else if (bsti.getLeft() != null && bsti.getRight() == null) {
				return (bsti.getDatum() + sumTree(bsti.getLeft()));
			} else if (bsti.getLeft() != null && bsti.getRight() != null) {
				return (bsti.getDatum() + sumTree(bsti.getLeft()) + sumTree(bsti.getRight()));
			} else {
				return bsti.getDatum();
			}
		}
	}

	public static void main(String[] args) {
		Randp r = new Randp(10);
		BST<Integer> bsti = new BST<Integer>(r.nextInt());
		for (int i = 0; i < 10; i++) {
			bsti.insert(r.nextInt());
		}
		bsti.printPreOrder();
		System.out.println();
		System.out.println("Sum: " + sumTree(bsti));
		System.out.println("Depth: " + bsti.depth());
		System.out.println("Number of nodes: " + bsti.countNodes());
		System.out.println("Contains number 8?: " + bsti.contains(8));
		System.out.println("Contains number 123?: " + bsti.contains(123));
	}

}
