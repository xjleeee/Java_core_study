package com.chapter4;

public class paramTest {

    public static int[] swap(int[] a){
        if(a.length == 2){
            int[] temp = {a[1],a[0]};
            return temp;
        }
        else
            return a;

    }


    public static void main(String[] args)
    {
        System.out.println("swapValue");
        int []a = {1,2};
        a = paramTest.swap(a);
        for(int x: a){
            System.out.println(x);
        }
        System.out.println();

        System.out.println("Test 1: 方法不能改变基本数据类型参数的值");
        System.out.println("testTriple");
        double percent = 10;
        System.out.println("before:"+percent);
        tripleValue(percent);
        System.out.println("after:"+percent);

        System.out.println("Test 2: 方法可以改变对象的参数");
        System.out.println("tripleSalary");
//        一个类可以使用所属包中的所有类和其他包中的公共类
        Employee x = new Employee("Kris",1000);
        System.out.println("before:"+x.getSalary());
        tripleSalary(x);
        System.out.println("after:"+x.getSalary());

        System.out.println("Test3: 方法不能把对象的值给新的对象");
        Employee ming = new Employee("kris1",1);
        Employee hong = new Employee("kris2",1);
        swap(ming,hong);
        System.out.println(ming.getName()+"\n"+hong.getName());



    }
    public static void tripleValue(double x){
        x = 3*x;
        System.out.println("method end:"+x);
    }
    public static void tripleSalary(Employee x){
        x.raiseSalary(200);
        System.out.println("method end:"+x.getSalary());
    }
    public static void swap(Employee x,Employee y){
        Employee temp;
        temp = x;
        x = y;
        y = temp;
    }

}
