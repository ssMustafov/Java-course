package com.sirma.itt.javacourse.objects.trees;

import java.math.BigDecimal;

/**
 * Shows how the tree classes can be used.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - args
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		System.out.println("Binary tree:");
		// insert new number in the tree, only if there is not already a number with same value
		binaryTree.insert(40);
		binaryTree.insert(78);
		binaryTree.insert(25);
		binaryTree.insert(10);
		binaryTree.insert(32);

		// print all elements in a sorted way
		System.out.println("In-order sort: " + binaryTree.getInOrderSort());
		System.out.println("Pre-order sort: " + binaryTree.getPreOrderSort());
		System.out.println("Post-order sort: " + binaryTree.getPostOrderSort());

		// search for element in the tree
		System.out
				.println("Does 25 exists in the binary tree: " + binaryTree.doesElementExists(25));

		System.out.println();
		System.out.println("Homo tree:");
		HomogeneousTree<String> homoTree = new HomogeneousTree<>();
		homoTree.insert("K");
		homoTree.insert("A");
		homoTree.insert("F");
		homoTree.insert("L");
		homoTree.insert("O");
		homoTree.insert("Y");
		homoTree.insert("D");
		System.out.println(homoTree.toString());

		System.out.println();
		System.out.println("Hetero tree:");
		HeterogeneousTree heteroTree = new HeterogeneousTree("root");
		heteroTree.insert(4);
		heteroTree.insert(1.259f);
		heteroTree.insert(new BigDecimal("9798798797879689"));
		heteroTree.insert(219832947892499L);
		heteroTree.insert("child");
		System.out.println(heteroTree.getInOrderSort());
		System.out.println(heteroTree.getPreOrderSort());
		System.out.println(heteroTree.getPostOrderSort());
	}

}
