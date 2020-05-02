package gr.codehub.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
    String name;
    String surname;
    String email;
    int cust_code;
    Date dateofbirth;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getCust_code() {
        return cust_code;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCust_code(int cust_code) {
        this.cust_code = cust_code;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
    Customer(String name, String surname, String email, int cust_code,Date dateofbirth){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cust_code = cust_code;
        this.dateofbirth = dateofbirth;
    }
    Customer(String email, int cust_code, Date dateofbirth){
        this.name = "UNKNOWN";
        this.surname = "UNKNOWN";
        this.email = email;
        this.cust_code =cust_code ;
        this.dateofbirth =dateofbirth;
    }
    Customer(){

    }

    @Override
    public String toString() {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "Customer{" +
                "Name= '" + name + '\'' +
                ", Surname= '" + surname + '\'' +
                ", E-mail= '" + email +'\'' +
                ", Date Of Birth= " + dateFormat.format(dateofbirth) +
                ", customer code= " + cust_code +
                '}';
    }
    //fields

    //constructors

    //getter methods, accessors

    //setter methods,  mutators, modifiers

    //toString


}
