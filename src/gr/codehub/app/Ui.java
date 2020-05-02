package gr.codehub.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ui {

    public Choice menu(){
        Choice returnChoice;
        System.out.println("1. Add a product to Basket   2. Remove a product" +
                "    3. Display basket     4.  Clear basket     0. Back to menu" +
                "");

        int choice;
        Scanner scanner = new Scanner(System.in);
    try {
            choice = scanner.nextInt();
            switch(choice){
                case 1: return Choice.ADD;
                case 2: return Choice.REMOVE;
                case 3: return Choice.DISPLAY;
                case 4: return Choice.CLEAR;
                case 5: return Choice.TOTALCOST;
                case 6: return Choice.SAVE;
                case 7: return Choice.LOAD;
                case 0: return Choice.EXIT;
                default:return Choice.ERROR;
            }
        }
    catch(Exception e){
        return Choice.ERROR;
    }

    }

    //factory method design pattern
    public Product createProduct(){
        String code;
        String name;
        float price;
        int quantity;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the product code ");
        code = scanner.next();
        System.out.println("Give the product name ");
        name = scanner.next();
        System.out.println("Give the product price ");
        price = scanner.nextFloat();
        System.out.println("Give the product quantity ");
        quantity = scanner.nextInt();

        Product product = new Product(code, name, price, quantity);

        return product;

    }
    public Customer createCustomer(CustomerCatalog catalog){
        Scanner scanner = new Scanner(System.in);
        String name, surname, email, datestr;
        int customerscount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateofbirth=new Date();
        Customer customer = new Customer();
        System.out.println("Give name:");
        name = scanner.nextLine();
        System.out.println("Give surname:");
        surname = scanner.nextLine();
        System.out.println("Give email:");
        email = scanner.nextLine();
        System.out.println("Give birthdate (dd-MM-yyyy):");
        datestr = scanner.nextLine();
        try {
            dateofbirth = sdf.parse(datestr);
        } catch (Exception e) {
            System.out.println("Wrong Date Format!");
        }
        int cust_code= catalog.GetSize() + 1;
        Customer customer1 = new Customer(name, surname, email, cust_code,dateofbirth);

        return customer1;

    }

    public void logrole(){
        int selection=5;
        Basket basket = new Basket();
        CustomerCatalog catalog = new CustomerCatalog();
        do{
            System.out.println("1. Log in as Customer.   2.Log in as Manager.  0. Exit.");
            Scanner scanner = new Scanner(System.in);
            try{
                selection = scanner.nextInt();
            }
            catch(Exception e){
                System.out.println("Not a number.");
            }
            switch (selection){
                case 1:
                    manageBasket(basket);
                    break;
                case 2:
                    manageCustomers(catalog);
                    break;
                case 0:
                    System.out.println("Bye bye");
                    break;
            }

        }while (selection!=0);
    }
    public void manageCustomers(CustomerCatalog catalog){
        int custselection = 8;
        do {
            System.out.println("1. Add a customer   2. Remove a customer" +
                    "    3. Display customers     4.  Clear customers     0. Back to menu" +
                    "");
            Scanner scanner = new Scanner(System.in);
            try {
                custselection = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Not a number.");
            }
            switch (custselection) {
                case 1:

                    Customer customer = createCustomer(catalog);
                    catalog.addCustomer(customer);

                    break;
                case 2:
                    System.out.println("Give an index to remove");
                    int index= scanner.nextInt();
                    catalog.RemoveCustomer(index);
                    break;
                case 3:
                    catalog.DisplayCustomers();
                    break;
                case 4:
                    catalog.ClearCustomers();
                    break;
                case 0:
                    break;
            }
        }while(custselection!=0);
    }
    public void manageBasket(Basket basket){
        Choice choice;
        do {
            choice =  menu();

            switch (choice) {
                case ADD:
                    Product product =  createProduct();
                    basket.addProduct(product);
                    break;
                case REMOVE:
                    System.out.println("Give an index to remove");
                    Scanner scanner = new Scanner(System.in);
                    int index= scanner.nextInt();
                    basket.removeProduct(index);
                    break;
                case DISPLAY:
                    basket.displayProducts();
                    break;
                case CLEAR:
                    basket.clearProducts();
                    break;
                case TOTALCOST:
                    System.out.println("TotalCost= " + basket.getTotalCost());
                    break;
                case EXIT:
                    break;
                case SAVE:
                    basket.saveBasket("basket.txt");
                    break;
                case LOAD:
                    basket.loadBasket("basket.txt");
                    break;
                case ERROR:
                    System.out.println("You gave erroneous input");
                    break;

            }
        }while(choice!=Choice.EXIT);

    }




}
