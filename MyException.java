// Write a program that demonstrates handling of exceptions in inheritance tree. 
// Create a base class called “Father” and derived class called “Son” which  extends the base class. 
// In Father class, implement a constructor which takes  the age and throws the exception WrongAge( ) when the input age<0. 
// In Son  class, implement a constructor that cases both father and son’s age and  throws an exception if son’s age is >=father’s age.
import java.util.*;
class father extends Exception{
    int f_age;
    father(int a)
    {
        f_age=a;
    }
    public String toString()
    {
        return "Age : "+f_age+"\n Wrong age Input\nage should be greater than 0";
    }
}
class son extends father{
    int s_age;
    son(int f,int s)
    {
        super(f);
        s_age=s;
    }
    public String toString()
    {
        return "\nson age:"+s_age+"\n"+"father age:"+f_age+"\n"+"Son age should be less than father age";
    }
}
class MyException
{
    static void WrongAge(int f_age,int s_age) throws son,father
    {
        if(f_age<=0 || s_age<=0)
        throw new father(f_age);
        else if(s_age>=f_age)
        throw new son(f_age,s_age);
    }
    static void WrongAge(int age) throws father{
        if(age<=0)
        throw new father(age);
    }
    public static void main(String []args)
    {
        int f_age,s_age;
        Scanner sc=new Scanner(System.in);
    
        try{ 
            System.out.println("Enter father age\n");
           f_age=sc.nextInt();
          WrongAge(f_age);
          System.out.println("Enter son age\n");
           s_age=sc.nextInt();
           WrongAge(s_age);
            WrongAge(f_age,s_age);
            System.out.println("No error occured\n"+"son age:"+s_age+"\n"+"father age:"+f_age);
        }
        catch(son s)
        {
             System.out.println("\nError caught\n"+s);
        }
        catch(father f)
        {
            System.out.println("\nError caught\n"+f);
        }
        
        
    }
}