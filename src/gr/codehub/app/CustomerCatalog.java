package gr.codehub.app;

import java.util.ArrayList;

public class CustomerCatalog {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public int GetSize(){ return customers.size(); }
    public void RemoveCustomer(int i){
        if (i>=0 && i <= customers.size()-1) {
            customers.remove(i);
        }
        else if(i>customers.size()-1)
        {
            System.out.println("There is no customer number "+i);
        }
    }
    public void DisplayCustomers(){
        //customers.forEach(System.out::println);
        for(Customer c : customers){
            System.out.println(c.toString());
        }
    }
    public void ClearCustomers(){customers.clear();}
}
