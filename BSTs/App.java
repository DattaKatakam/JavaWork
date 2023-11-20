import java.io.IOException;
import java.util.Scanner;

public class App {

    /**
     * 
     * @param args main function
     * @throws Exception
     */
    
     public static void main(String[] args) throws Exception {
        BSTree bst = new BSTree();
		int[] treeElements= {20,16,19,25,26,21,8};
		// int[] treeElements= {20,10,11,25,27,8,21,6,35,9,40};
		for (int x : treeElements) {
			//adding values to nodes
			bst.nodeInfusion(x);
		}
		
        try {
            bst.PrintBST("GraphivizcodefileBeforeOperations.dot");
            System.out.println("GraphivizcodefileBeforeOperations.dot file is created in file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        boolean exitLoop = true;
        System.out.println("BSTree printing using preorder method");
        bst.inOrderBST(bst.BSTNodeRoot);
        System.out.println("-----deleting "+ 16 +" from BSTree-----");
        bst.popNodeBST(16);
        System.out.println("BSTree printing using preorder method");
        bst.inOrderBST(bst.BSTNodeRoot);
        do{ 
            System.out.println("""
                Choose option to perform suitable method:
                1. preOrder BST method
                2. postOrder BST method
                3. inOrder BST method 
                *. enter other than above options to exit the loop
            """);
            int chooseMethod = sc.nextInt();           
            switch (chooseMethod) {
                case 1:
                    System.out.println("BSTree printing using preorder method");
                    bst.preOrderBST(bst.BSTNodeRoot);
                    break;
                case 2:
                    System.out.println("BSTree printing using postorder method");
                    bst.postOrderBST(bst.BSTNodeRoot);
                    break;
                case 3:
                    System.out.println("BSTree printing using inorder method");
                    bst.inOrderBST(bst.BSTNodeRoot);
                    break;
                default:
                    System.out.println("choose correct option your option is wrong so exiting the method loop");
                    exitLoop=false;
                    break;
            }
        }while(exitLoop);

        System.out.println("----------**********----------**********----------");
        boolean exitLoop1=true;

        do{
            System.out.println("""
                Choose option to perform suitable method:\n1. search Value in BSTree
                2. find Minimum value in BStree\n3. find Maximum in BStree
                4. delete value from BSTree\n5. insert a node in BStree
                *. enter other than above options to exit the loop
                    """);
            int chooseMethod = sc.nextInt();
            switch (chooseMethod) {
                case 1:
                    System.out.println("enter int value to search in BSTree: ");
                    int searchValue = sc.nextInt();
                    System.out.println("Searching your value"+searchValue+" in BStree........");
                    if(bst.findNodeBST(searchValue)!=null){
                        System.out.println("your search value "+searchValue+" is found");
                    }
                    else System.out.println("your search value "+ searchValue+ " is not found");

                    break;
                case 2:
                    System.out.println("Getting Minimum value in BSTree....");
                    System.out.println("minimum value in BSTree is:"+bst.getMinValueBST());
                    break;
                case 3:
                    System.out.println("Getting Maximum value in BSTree....");
                    System.out.println("maximum value in BSTree is:"+bst.getMaxValueBST());
                    break;
                case 4:
                    System.out.println("enter value to remove from BSTree:");
                    int deletingValue = sc.nextInt();
                    System.out.println("-----deleting "+deletingValue+" from BSTree-----");
                    bst.popNodeBST(deletingValue);
                    break;
                case 5:
                    System.out.println("enter a value to insert in the BStree");
                    int insertVal = sc.nextInt();
                    System.out.println("your entered value is being inserted into BSTree...... ");
                    bst.nodeInfusion(insertVal);
                    break;
                default:
                    System.out.println("choose correct option your option is wrong so exiting the method loop");
                    exitLoop1=false;
                    break;
            }
            System.out.println("----------**********----------**********----------");

        }while(exitLoop1);
        sc.close();
        System.out.println("printing BSTree using Pre order method after all operations are performed........");
        bst.preOrderBST(bst.BSTNodeRoot);
        try {
            bst.PrintBST("GraphivizcodefileAfterOperations.dot");
            System.out.println("GraphivizcodefileAfterOperations.dot file is created in file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
