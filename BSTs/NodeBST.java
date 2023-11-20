public class NodeBST{
    int key;
	
	NodeBST lNodeBST;
	NodeBST rNodeBST;
	
	//constructor definition
	NodeBST(int key){
		this.key = key;
	}
	
	//printing the string by overriding the toString method
	public String toString() {
		return "Value in node is " + this.key;
	}
}