public class Droid{
    String name;
    int batteryLevel;
    public Droid(String droidName){
        name=droidName;
        batteryLevel=100;
    }
    public String toString(){
        return "Hello, I m the droid:" +name;
    }
    public void performTask(String task){
        System.out.println(name+" is performing task:" +task);
        batteryLevel-=10;
    }
    public int energyReport(){
        return batteryLevel;
    }
    public static void main(String[]args){
        Droid r2d2=new Droid("r2d2");
        System.out.println(r2d2);
        r2d2.performTask("managing");
        System.out.println(r2d2.energyReport());
        r2d2.performTask("calculating");
        System.out.println(r2d2.energyReport());
    }
}

