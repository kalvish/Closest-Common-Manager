public class Main {
	static String Bill = "Bil";
	static String Dom = "Dom";
	static String Samir = "Samir";
	static String Michael = "Michael";
	static String Bob = "Bob";
	static String Peter = "Peter";
	static String Porter = "Porter";
	static String Milton = "Milton";
	static String Nina = "Nina";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree tree = new Tree();
        /*
         * The second parameter for the addNode method is the identifier
         * for the node's parent. In the case of the root node, either
         * null is provided or no second parameter is provided.
         */
        tree.addNode(Bill);
        tree.addNode(Dom, Bill);
        tree.addNode(Samir, Bill);
        tree.addNode(Michael, Bill);
        tree.addNode(Bob, Dom);
        tree.addNode(Peter, Dom);
        tree.addNode(Porter, Dom);
        tree.addNode(Milton, Peter);
        tree.addNode(Nina, Peter);

        tree.display(Bill);
        
		Company.Employee ceo = new Company.Employee(1, Bill);
		Company.Employee firstEmployee = new Company.Employee(1, Nina);
		Company.Employee secondEmployee = new Company.Employee(1, Bob);
		
		Company.Employee closestCommonManager = Company.closestCommonManager(ceo, firstEmployee, secondEmployee, tree);
		System.out.println("Closest manager is " + closestCommonManager.getName());
		
	}

}