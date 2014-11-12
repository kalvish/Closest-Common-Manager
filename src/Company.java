//Company.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
 
public class Company {
 
	
    // IMPORTANT: DO NOT MODIFY THIS CLASS
    public static class Employee {
 
        private final int id;
        private final String name;
        private List<Employee> reports;
 
        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
            this.reports = new ArrayList<Employee>();
        }
 
        public int getId() {
            return id;
        }
 
        public String getName() {
            return name;
        }
 
        public List<Employee> getReports() {
            return reports;
        }
 
        public void addReport(Employee employee) {
            reports.add(employee);
        }
    }
 
    /*
     * Read the attached PDF for more explanation about the problem
     * Note: Don't modify the signature of this function
     * @param ceo
     *
     * @param firstEmployee
     *            
     * @param secondEmployee
     *            
     * @return common manager for both employees that is closest to them.
     */
    @SuppressWarnings("unused")
    public static Employee closestCommonManager(Employee ceo, Employee firstEmployee, Employee secondEmployee, Tree tree) {
       // Implement me
    	
    	//Space complexity for each array -> number of nodes in the tree
        ArrayList<String> pathToFirstEmployee = new ArrayList<>();
      //Space complexity for each array -> number of nodes in the tree
        ArrayList<String> pathToSecondEmployee = new ArrayList<>();
        
        //Build the tree
        Iterator<Node> depthIterator = tree.iterator(ceo.getName());
        //Find the path until first name;
        //Depth first iteration -> Runtime complexity = O(b^d) , b is branching factor, d is depth of the tree
      //Depth first iteration -> Space complexity = O(longest path length searched)
        while (depthIterator.hasNext()) {
            Node node = depthIterator.next();
            
            pathToFirstEmployee.add(node.getIdentifier());
            
            ArrayList<String> chindlre = node.getChildren();
            //If either of them is closest manager
            if(chindlre.contains(firstEmployee.getName())){
            	break;
            }
            System.out.println(node.getIdentifier());
            
           
        }
        
        Iterator<Node> depthIterator2 = tree.iterator(ceo.getName());
        //Find the path until second name;
        while (depthIterator2.hasNext()) {
            Node node = depthIterator2.next();
            
            pathToSecondEmployee.add(node.getIdentifier());
            
            ArrayList<String> chindlre = node.getChildren();
            
            //If either of them is closest manager
            if(chindlre.contains(secondEmployee.getName())){
            	break;
            }
            System.out.println(node.getIdentifier());
            
           
        }
        
        Collections.reverse(pathToFirstEmployee);
        Collections.reverse(pathToSecondEmployee);
        
        //seatch if N = number of nodes , runtime complexity N^2
        for (String first : pathToFirstEmployee) {
			for (String second : pathToSecondEmployee) {
				if(first.equals(second)){
					return new Employee(-1, first);
				}
			}
		}
        return null;
    }
};