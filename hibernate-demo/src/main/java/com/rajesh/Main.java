package com.rajesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Salary.class)
                .buildSessionFactory();

        Scanner sc = new Scanner(System.in);
        Session session;

        while (true) {
            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                // ================= ADD =================
                case 1:
                    session = factory.openSession();
                    session.beginTransaction();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter City: ");
                    String city = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double amount = sc.nextDouble();

                    Salary sal = new Salary(amount);
                    Employee emp = new Employee(name, address, city, sal);

                    session.persist(emp);

                    session.getTransaction().commit();
                    session.close();

                    System.out.println("✅ Employee Added!");
                    break;

                // ================= VIEW =================
                case 2:
                    session = factory.openSession();
                    session.beginTransaction();

                    List<Employee> list = session
                            .createQuery("from Employee", Employee.class)
                            .getResultList();

                    System.out.println("\n--- Employees ---");
                    for (Employee e : list) {
                        System.out.println(
                                e.getEmpNo() + " | " +
                                        e.getEmpName() + " | " +
                                        e.getAddress() + " | " +
                                        e.getCity() + " | Salary: " +
                                        e.getSalary().getAmount()
                        );
                    }

                    session.getTransaction().commit();
                    session.close();
                    break;

                // ================= UPDATE =================
                case 3:
                    session = factory.openSession();
                    session.beginTransaction();

                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    Employee update = session.get(Employee.class, uid);

                    if (update != null) {

                        System.out.print("Enter new name: ");
                        update.setEmpName(sc.nextLine());

                        System.out.print("Enter new address: ");
                        update.setAddress(sc.nextLine());

                        System.out.print("Enter new city: ");
                        update.setCity(sc.nextLine());

                        System.out.print("Enter new salary: ");
                        double newSalary = sc.nextDouble();

                        update.getSalary().setAmount(newSalary);

                        session.getTransaction().commit();
                        System.out.println("✅ Updated!");
                    } else {
                        System.out.println("❌ Employee not found!");
                    }

                    session.close();
                    break;

                // ================= DELETE =================
                case 4:
                    session = factory.openSession();
                    session.beginTransaction();

                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    Employee del = session.get(Employee.class, did);

                    if (del != null) {
                        session.remove(del);
                        session.getTransaction().commit();
                        System.out.println("✅ Deleted!");
                    } else {
                        System.out.println("❌ Employee not found!");
                    }

                    session.close();
                    break;

                // ================= EXIT =================
                case 5:
                    factory.close();
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= EMPLOYEE ENTITY =================
    @Entity(name = "Employee")   // 🔥 FIX ADDED
    @Table(name = "employee")
    static class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int empNo;

        private String empName;
        private String address;
        private String city;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "salary_id")
        private Salary salary;

        public Employee() {}

        public Employee(String empName, String address, String city, Salary salary) {
            this.empName = empName;
            this.address = address;
            this.city = city;
            this.salary = salary;
        }

        public int getEmpNo() { return empNo; }
        public String getEmpName() { return empName; }
        public void setEmpName(String empName) { this.empName = empName; }

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }

        public Salary getSalary() { return salary; }
        public void setSalary(Salary salary) { this.salary = salary; }
    }

    // ================= SALARY ENTITY =================
    @Entity(name = "Salary")   // 🔥 FIX ADDED
    @Table(name = "salary")
    static class Salary {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int salaryId;

        private double amount;

        public Salary() {}

        public Salary(double amount) {
            this.amount = amount;
        }

        public int getSalaryId() { return salaryId; }
        public double getAmount() { return amount; }
        public void setAmount(double amount) { this.amount = amount; }
        System.out.println("HE");
    }
}


