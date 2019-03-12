package com.chapter5;

import com.chapter4.Employee;

import java.time.LocalDate;

public class Manager extends Employee {
    private double bonus;

    public Manager(String n, double s, int year, int month, int day,double bonus) {
        super(n, s, year, month, day);
        this.bonus = bonus;
    }


    @Override
    public double getSalary() {
        return super.getSalary()+bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double aBonus) {
        bonus = aBonus;
    }
    public void printType(){
        System.out.println("Manager\n");
    }

    public static void main(String[] args){
        Employee[] employees = new Employee[4];
        employees[0] = new Manager("boss li",10000,1999,10,1,1000);
        employees[1] = new Manager("boss wang",11000,2000,10,1,2000);
        employees[2] = new Manager("boss zhao",12000,2001,10,1,3000);
        employees[3] = new Employee("li",2000,1990,1,1);
        for(Employee aEmployee:employees){
            System.out.println(aEmployee.getSalary());
            aEmployee.printType();
        }

    }
}

