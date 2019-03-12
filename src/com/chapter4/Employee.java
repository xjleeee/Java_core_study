package com.chapter4;

import java.time.LocalDate;

/**
 * A Employee Test program
 */
public class Employee
{
    private final String name; //final类表示不能再进行修改，不能有set方法
    public static int nextId = 1; //静态域nextId为所有Emplyee对象共有
    private double salary;
    private LocalDate hireDay;
    private int id;
    public static final double PI = 3.1415;


    public Employee(String n,double s,LocalDate h){
//        String name 会屏蔽实例域中的name变量
        name = n;
        salary = s;
        hireDay = h;
        id = nextId;
        nextId ++;
    }
    public Employee(String n,double s,int year, int month,int day){
//        String name 会屏蔽实例域中的name变量
        name = n;
        salary = s;
        hireDay = LocalDate.of(year,month,day);
        id = nextId;
        nextId ++;
    }
    public Employee(String n,double s){
        name = n;
        salary = s;
        hireDay = LocalDate.of(1970,1,1);
        id = nextId;
        nextId ++;
    }
    public Employee(double aSalary){
        this("emplyee#"+nextId,aSalary);  //java 构造器可以可以调用同一个类的另一个构造器
    }

    public static int getNextId(){
        return nextId;
    }

    //声明为final，子类不能覆盖这个方法，确保在子类中不会改变语义
    public final String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay; //如果要访问一个可变数据域的拷贝就需要使用clone ： return (Date)hireDay.clone();
    }

    public void raiseSalary(int percent){
        double raise = percent/100+1;
        salary *= raise;
    }

    public void printAllInfo(){
//        System.out.printf("name:%s,salary:%.2f,hireDay:%tc",name,salary,hireDay);//报错  H != java.time.LocalDate
        System.out.println("name:"+name+",salary:"+salary+",hireDay:"+hireDay);
    }
    public boolean equals(Employee other){
        return name.equals(other.name);
    }
    public void printType(){
        System.out.println("Employee\n");
    }


    public static void main(String[] args) {
//        LocalDate date = LocalDate.of(1997,1,1);
        Employee[] employees = new Employee[4];
//      java的constructor必须使用new来调用，区别于C++
        Employee kris_wu = new Employee("kris wu",20000,LocalDate.of(1999,11,21));
        System.out.println(Employee.getNextId());
        Employee kris_li = new Employee("kris li",120000,LocalDate.of(1929,1,21));
        Employee kris_mo = new Employee("kris mo",2000,LocalDate.of(1919,1,1));
//      Employee[] employees = {kris_wu,kris_li,kris_mo};
        employees[0] = kris_wu;
        employees[1] = kris_li;
        employees[2] = kris_mo;
        employees[3] = new Employee(100);

        for (Employee employee:employees
                ) {
            employee.setSalary(employee.getSalary()*1.2);
        }
        employees[2].raiseSalary(100);
        for(int i=0;i<employees.length;i++){
//            if(employees[i].equals(kris_li))
                employees[i].printAllInfo();

        }
        System.out.println(Employee.getNextId());

    }

}