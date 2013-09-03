package fem;

public class Node
{
	private double X;
	private double Y;
	private NodeType Type;
	public int iX;
	public int iY;
	
	
	//////////CONSTRUCTORS///////////
	public Node() {
		this.X = 0;
		this.Y = 0;
		this.Type = NodeType.PinnedAttached;
	}

	public Node(double aX, double aY) {
		this.X = aX;
		this.Y = aY;
		this.Type = NodeType.PinnedAttached;
	}	
	
	public Node(double aX, double aY, NodeType aType) {
		this.X = aX;
		this.Y = aY;
		this.Type = aType;
	}
	
	public Node(Node n) {
		this.X = n.X;
		this.Y = n.Y;
		this.Type = n.Type;	
	}
	
	//////////PROPERTIES//////////////
	public double getX() {
		return X;
	}
	
	public double getY() {
		return Y;
	}
	
	public NodeType getType() {
		return Type;
	}

	//////////METHODS/////////////////
	public boolean IsEqual(Node aN) {
		if ((aN.getX() == this.getX()) && (aN.getY() == this.getY())) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

//60
