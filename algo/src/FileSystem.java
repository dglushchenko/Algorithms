/*
Create a file system model
*/
public class Node {
	private String name;
}

public class ExpandableNode extends Node {
	private ExpandableNode[] expandableNodes;
	private LeafNode[] leafNodes;
}

public class LeafNode extends Node {
}

public class Directory extends ExpandableNode {
}

public class File extends LeafNode {
}