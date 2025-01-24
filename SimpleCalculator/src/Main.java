import java.util.Scanner;

public class Main {
    static double add(double a,double b){
        return a+b;
    }
    static double sub(double a,double b){
        return a-b;
    }
    static double mul(double a,double b){
        return a*b;
    }
    static double div(double a,double b){
        if (b!=0){
            return a/b;
        }else {
            System.out.println("number cant devisible by zero");
            return 0;
        }
    }

    public  static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("simple calculator");
        System.out.println("1-addition");
        System.out.println("2-subtraction");
        System.out.println("3-multiplication");
        System.out.println("4-division");

        System.out.println("enter your operation(1-4):");
        int choice = sc.nextInt();

        System.out.println("enter the first number:");
        double num1 = sc.nextDouble();
        System.out.println("enter the second number:");
        double num2 = sc.nextDouble();

        double result = 0;
        switch (choice){
            case 1:
                result = add(num1,num2);
                break;
            case 2:
                result = sub(num1,num2);
                break;
            case 3:
                result = mul(num1,num2);
                break;
            case 4:
                result = div(num1,num2);
                break;
        }

        System.out.println("the result is : "+result);
    }
}
