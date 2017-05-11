package com.maxGroup.BankSystem.supportClass;

import com.maxGroup.BankSystem.DAO.DAOexception;
import com.maxGroup.BankSystem.DAO.IGenDao;
import com.maxGroup.BankSystem.domain.Customer;
import com.maxGroup.BankSystem.domain.Manager;
import com.maxGroup.BankSystem.mysql.MySqlDaoFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Menu {
    private static final Logger log = Logger.getLogger(Menu.class);
    private static ArrayList<Manager> managers = new ArrayList<Manager>();
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    private static int choose = -1;

    public static void main(String[] args) {
        System.out.println("Welcome to shop");
        do {
            information();
            choose = chooses();
            done(choose);
        } while (choose != 0);
    }

    private static void done(int temp) {
        switch (temp) {
            case 1:
                try {
                    MySqlDaoFactory factory = new MySqlDaoFactory();
                    IGenDao dao = factory.getDAO(factory.getConnection(), Manager.class);
                    managers.add((Manager) dao.createEx(createManager()));
                } catch (DAOexception e) {
                    log.error("Dao Exception " + e);
                }
                break;
            case 2:
                try {
                    MySqlDaoFactory factory = new MySqlDaoFactory();
                    IGenDao dao = factory.getDAO(factory.getConnection(), Customer.class);
                    customers.add((Customer) dao.createEx(createCustomer()));
                } catch (DAOexception e) {
                    log.error("Dao Exception " + e);
                }
                break;
            case 3:
                Scanner in = new Scanner(System.in);
                for (Customer customer : customers) {
                    System.out.println(customer.toString());
                }
                System.out.println("Enter id customer which want to create new account");
                int id = Integer.parseInt(in.next());
                for (Customer customer : customers) {
                    if (customer.getId() == id) {
                        customer.createAccount();
                        break;
                    }
                }
                break;
            case 4:
                try {
                    MySqlDaoFactory factory = new MySqlDaoFactory();
                    IGenDao dao = factory.getDAO(factory.getConnection(), Manager.class);
                    managers = (ArrayList<Manager>) dao.readAll();
                } catch (DAOexception daOexception) {
                    log.error(daOexception);
                }
                break;
            case 5:
                try {
                    MySqlDaoFactory factory = new MySqlDaoFactory();
                    IGenDao dao = factory.getDAO(factory.getConnection(), Customer.class);
                    customers = (ArrayList<Customer>) dao.readAll();
                } catch (DAOexception daOexception) {
                    log.error(daOexception);
                }
                break;
            case 6:
                in = new Scanner(System.in);
                for (Customer customer : customers) {
                    System.out.println(customer.toString());
                }
                System.out.println("Enter id customer which want to delete account");
                id = Integer.parseInt(in.next());
                for (Customer customer : customers) {
                    if (customer.getId() == id) {
                        customer.deleteAccount();
                        break;
                    }
                }
                break;
            case 7:
                try {
                    in = new Scanner(System.in);
                    MySqlDaoFactory factory = new MySqlDaoFactory();
                    IGenDao dao = factory.getDAO(factory.getConnection(), Customer.class);
                    for (Customer customer : customers) {
                        System.out.println(customer.toString());
                    }
                    System.out.println("Enter id customer which do you want to delete");
                    id = Integer.parseInt(in.next());
                    for (Customer customer : customers) {
                        if (customer.getId() == id) {
                            if (dao.delete(customer)) customers.remove(customer);
                            break;
                        }
                    }
                } catch (DAOexception daOexception) {
                    log.error(daOexception);
                }
                break;
            case 8:
                try {
                    in = new Scanner(System.in);
                    MySqlDaoFactory factory = new MySqlDaoFactory();
                    IGenDao dao = factory.getDAO(factory.getConnection(), Manager.class);
                    for (Manager manager : managers) {
                        System.out.println(manager.toString());
                    }
                    System.out.println("Enter id manager which do you want to delete");
                    id = Integer.parseInt(in.next());
                    for (Manager manager : managers) {
                        if (manager.getId() == id) {
                            if (dao.delete(manager)) managers.remove(manager);
                            break;
                        }
                    }
                } catch (DAOexception daOexception) {
                    log.error(daOexception);
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }

    }

    private static int chooses() {
        Scanner in = new Scanner(System.in);
        int temp = -1;
        do {
            try {
                System.out.print("Please enter your choices: ");
                temp = Integer.parseInt(in.next());
                if (temp > 8) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Your choices not defined");
                log.error("Your choices not defined");
                log.error(e.getMessage());
                temp = -1;
            }
        } while (temp < 0);
        return temp;
    }

    private static void information() {
        System.out.println("You can:");
        System.out.println("1-Create new Manager");
        System.out.println("2-Create new Customer");
        System.out.println("3-Crete new Account for Customer");
        System.out.println("4-Read all Manager");
        System.out.println("5-Read all Customer");
        System.out.println("6-Delete Account by Customer");
        System.out.println("7-Delete Customer");
        System.out.println("8-Delete Manager");
        System.out.println("0-Exit");
    }

    private static Manager createManager() {
        Scanner in = new Scanner(System.in);
        Manager manager = new Manager();
        try {
            System.out.println("Enter name:");
            String name = in.nextLine();
            manager.setName(name);

            System.out.println("Enter surname:");
            String surname = in.nextLine();
            manager.setSurname(surname);

            System.out.println("Enter post:");
            String post = in.nextLine();
            manager.setPost(post);

            System.out.println("Enter day of born:");
            int day = Integer.parseInt(in.next());
            if (day < 1 || day > 31) throw new Exception("Day of born is less than 1 or more than 31");
            System.out.println("Enter month of born:");
            int month = Integer.parseInt(in.next());
            if (month < 1 || month > 12) throw new Exception("Month of born is less than 1 or more than 12");
            System.out.println("Enter year of born:");
            int year = Integer.parseInt(in.next());
            if (year < 1970) throw new Exception("Year of born is less than 1970");
            manager.setBorn(new GregorianCalendar(year, month, day));
        } catch (Exception e) {
            log.error("Exception " + e);
        }
        return manager;
    }

    private static Customer createCustomer() {
        Scanner in = new Scanner(System.in);
        Customer customer = new Customer();
        try {
            System.out.println("Enter name:");
            String name = in.nextLine();
            customer.setName(name);
            System.out.println("Enter surname:");
            String surname = in.nextLine();
            customer.setSurname(surname);
            System.out.println("Enter customer`s status(basic,gold,platinum):");
            String statusCustomer = in.nextLine();
            customer.setStatusCustomer(statusCustomer);
            System.out.println("Enter day of born:");
            int day = Integer.parseInt(in.next());
            if (day < 1 || day > 31) throw new Exception("Day of born is less than 1 or more than 31");
            System.out.println("Enter month of born:");
            int month = Integer.parseInt(in.next());
            if (month < 1 || month > 12) throw new Exception("Month of born is less than 1 or more than 12");
            System.out.println("Enter year of born:");
            int year = Integer.parseInt(in.next());
            if (year < 1970) throw new Exception("Year of born is less than 1970");
            customer.setBorn(new GregorianCalendar(year, month, day));
        } catch (Exception e) {
            log.error("Exception " + e);
        }
        return customer;
    }
}