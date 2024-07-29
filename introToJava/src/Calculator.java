//basic calculator
public class Calculator{
    public Calculator(){

    }
    public int add(int a,int b){
        return a+b;
    }
    public int subtract(int a,int b){
        return a-b;
    }
    public int multiply(int a,int b){
        return a*b;
    }
    public double divide(int a,int b){
        return (double)a/b;
    }
    public int modulo(int a,int b){
        return a%b;
    }


    public static void main(String[]args){
        Calculator kalk=new Calculator();
        System.out.println(kalk.add(5,7));
        System.out.println(kalk.subtract(45,11));
        System.out.println(kalk.multiply(5,7));
        System.out.println(kalk.divide(5,7));
        System.out.println(kalk.modulo(5,7));


    }
}
