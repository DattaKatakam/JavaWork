import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class BSTree {
    public NodeBST BSTNodeRoot;
    
    /**
     * node is infused into BSTree and also root node is created
     * @param key as value of node
     */
    public void nodeInfusion(int key){
        NodeBST n = new NodeBST(key);
        
        if(BSTNodeRoot!=null){
            NodeBST tempNode = BSTNodeRoot;
            NodeBST parentNode;
            while(!false){
                parentNode = tempNode;
                if(key<tempNode.key){
                    tempNode=tempNode.lNodeBST;
                    if(tempNode==null){
                        parentNode.lNodeBST=n;
                        return;
                    }
                }
                else{
                    tempNode = tempNode.rNodeBST;
                    if(tempNode==null){
                        parentNode.rNodeBST=n;
                        return;
                    }
                }
            }
        }
        else{
            BSTNodeRoot=n;
        }
       
    }

    /**
     * Gets node with min value when we move towards right side BSTree
     * @return the node with the maximum value from BSTree
     */
    public NodeBST getMaxValueBST(){
        NodeBST maxValue=BSTNodeRoot;
		
		while(maxValue.rNodeBST!=null) {
			
			maxValue=maxValue.rNodeBST; 
        }
		return maxValue;
    }

    /**
     * Gets node with min value when we move towards left side BSTree
     * @return the node with the minimum value from BSTree
     */
    public NodeBST getMinValueBST(){
        NodeBST minValue=BSTNodeRoot;
		
		while(minValue.lNodeBST!=null) {
			//right most value of BST gives Maximum value in BST
			minValue=minValue.lNodeBST; //we can get this when we move towards right part of tree
        }
		return minValue;
    }
    
    /**
     * Exchanges the position of a node in BSTree.
     *
     * @param nodeChange the node to be exchanged
     * @return the next node that exchanges the current node
     */
    public NodeBST nodePositionExchange(NodeBST nodeChange){
        NodeBST exchangeNodeBST = nodeChange;
        NodeBST fNode = nodeChange.rNodeBST;
        NodeBST changeNodeParent = nodeChange;
        
        while(fNode!=null){
            changeNodeParent = exchangeNodeBST;
            exchangeNodeBST=fNode;
            fNode=fNode.lNodeBST;
        }
        if(exchangeNodeBST!=nodeChange.rNodeBST){
            changeNodeParent.lNodeBST=exchangeNodeBST.rNodeBST;
            exchangeNodeBST.rNodeBST=nodeChange.rNodeBST;
        }
        return exchangeNodeBST;
    }

    /**
     * Prints the nodes of BSTree by inorder Method.
     *
     * @param focusNode the node to start printing from root node
     */
    
     public void inOrderBST(NodeBST focusNode){
        if(!(focusNode==null)){
            inOrderBST(focusNode.lNodeBST);
            System.out.println(focusNode);
            inOrderBST(focusNode.rNodeBST);
        }
    }
    
    /**
     * Prints the nodes of BSTree by preorder Method.
     *
     * @param focusNode the node to start printing from root node
     */
    
     public void preOrderBST(NodeBST focusNode){
        if(!(focusNode==null)){
            System.out.println(focusNode);
            preOrderBST(focusNode.lNodeBST);
            preOrderBST(focusNode.rNodeBST);
        }
    }

    /**
     * Prints the nodes of BSTree by postorder Method.
     *
     * @param focusNode the node to start printing from root node
     */
    
     public void postOrderBST(NodeBST focusNode){
        if(!(focusNode==null)){
            postOrderBST(focusNode.lNodeBST);
            postOrderBST(focusNode.rNodeBST);
            System.out.println(focusNode);
        }
    }

    /**
     * Gets the node if it is present else returns null
     * @param key is sent as input parameter to search node value in BSTree
     * @return cNodeBST (node in BSTree) or null
     */
    public NodeBST findNodeBST(int key){
        NodeBST cNodeBST = BSTNodeRoot;
        while (!(cNodeBST.key==key)) {
            if(key>cNodeBST.key) cNodeBST=cNodeBST.rNodeBST;
            else cNodeBST=cNodeBST.lNodeBST;
            if(cNodeBST==null) return null;
        }
        return cNodeBST;
    }

    /**
     * deletes the value in BSTree if present else BStree is unchanged
     * @param value is sent as input parameter to be deleted from BSTree if present
     */
    public void popNodeBST(int value){
        NodeBST tempNodeBST = BSTNodeRoot, parenNodeBST=BSTNodeRoot;
        boolean lNodeBSTParent = true;
        while (tempNodeBST.key!=value) {
            parenNodeBST = tempNodeBST;
            if(value<tempNodeBST.key){
                lNodeBSTParent=true;
                tempNodeBST=tempNodeBST.lNodeBST;
            }
            else{
                lNodeBSTParent=false;
                tempNodeBST=tempNodeBST.rNodeBST;
            }
            if(tempNodeBST==null){
                System.out.println("value is not found in BST, BSTree is unchanged");
                return;
            }
        }

        if(tempNodeBST.rNodeBST==null && tempNodeBST.lNodeBST!=null){
            if(tempNodeBST==BSTNodeRoot) BSTNodeRoot=tempNodeBST.lNodeBST;
            else if (lNodeBSTParent) parenNodeBST.lNodeBST=tempNodeBST.lNodeBST;
            else parenNodeBST.rNodeBST=tempNodeBST.lNodeBST;
        }
        else if(tempNodeBST.rNodeBST==null && tempNodeBST.lNodeBST==null){
            if(tempNodeBST==BSTNodeRoot) BSTNodeRoot=null;
            else if(lNodeBSTParent) parenNodeBST.lNodeBST=null;
            else parenNodeBST.rNodeBST=null;
        }
        else if (tempNodeBST.rNodeBST!=null && tempNodeBST.lNodeBST==null) {
            if(tempNodeBST==BSTNodeRoot) BSTNodeRoot=tempNodeBST.rNodeBST;
            else if(lNodeBSTParent) parenNodeBST.lNodeBST=tempNodeBST.rNodeBST;
            else parenNodeBST.rNodeBST=tempNodeBST.rNodeBST;
        }
        else{
            NodeBST exchangeNode = nodePositionExchange(tempNodeBST);
            if(tempNodeBST==BSTNodeRoot) BSTNodeRoot=exchangeNode;
            else if(lNodeBSTParent) parenNodeBST.lNodeBST=exchangeNode;
            else parenNodeBST.rNodeBST=exchangeNode;
            exchangeNode.lNodeBST=tempNodeBST.lNodeBST;
        }

        System.out.println("value you entered "+value+" is deleted from BSTree");
    }

    /**
     * creates file "Graphivizcodefile.dot" which contains BSTree with preorder method in dot language
     * @throws IOException
     */
    public void PrintBST(String fileName) throws IOException{
        int nullInstance =0;
        //String fileName = "Graphivizcodefile.dot";
        FileWriter fw = new FileWriter(fileName);
        fw.write("Graphiviz dot code{\n");
        Stack<NodeBST> storageStack = new Stack<>();
        NodeBST cNode = BSTNodeRoot;
        while (cNode != null || !storageStack.empty()) {
            if (cNode != null) {
                storageStack.push(cNode);
                if(cNode.lNodeBST!=null) fw.write(cNode.key+ " -> " + cNode.lNodeBST.key+";\n");
                else {
                    fw.write("nil"+nullInstance+"[shape=point];\n");
                    fw.write(cNode.key+ "-> nil"+nullInstance+";\n");
                    nullInstance++;
                }
                cNode = cNode.lNodeBST;
            }
            else{
                NodeBST nInstance = storageStack.pop();
                if(nInstance.rNodeBST != null){
                    fw.write(nInstance.key + " => " + nInstance.rNodeBST.key + ";\n");
                }else {
                    fw.write("nil"+nullInstance+"[shape=point];\n");
                    fw.write(nInstance.key+ "-> nil"+nullInstance+";\n");
                    nullInstance++;
                }
                cNode = nInstance.rNodeBST;
            }
        }
        fw.write("}\n");
        fw.close();
    }
}
