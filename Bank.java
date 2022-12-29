import java.util.Scanner;
class account{
    Scanner sc=new Scanner(System.in);
    String name;
    int acct_no;
    int balance,deposit;
    // String type;

    void deposit()
    {
         System.out.println("Enter amount for deposit\n");
         int amount=sc.nextInt();
         balance+=amount;
         System.out.println("deposite is successfull\n do you want to cheque your balance");
         System.out.println("1.YES\n2.NO");
         int choice=sc.nextInt();
         cheque_balance();

    }
    void details()
    {
        System.out.println("Name: "+name);
        System.out.println("account_no: "+acct_no);
        System.out.println("balance :"+balance);
    }
    void cheque_balance()
    {
        System.out.println("Balance is "+balance);
    }
}
class savings extends account
{
    double intrest=0;
    double rate=0.03;
    savings(String n,int a,int d)
    {
        name=n;
        acct_no=a;
        deposit=d;
        balance=deposit;
    }
    void details()
    {
        System.out.println("Account_type: Savings");
        super.details();
    }
    void withdrawal()
    {
        System.out.println("Enter amount for withdrawal\n");
        int amount=sc.nextInt();
        if(balance<amount)
        System.out.println("You can withdraw the amount less than "+balance);
        else
        {
            balance=balance-amount;
            System.out.println("withdrawal is successfull..!!!!!!!");
            System.out.println("\nDo you want cheque your balance\n");
            System.out.println("1.YES\n2.NO");
            int choice=sc.nextInt();
            if(choice==1)
            cheque_balance();
            return;
        }
    }
    void  get_intrest(int month)
    {
        month/=3;
        intrest=(balance*rate*month/4);
        System.out.println("\nPrevious balance: "+balance+"\nIntrest: "+intrest+"\nCurrent balance: "+(balance+intrest));
        balance+=intrest;
    }
}
class current extends account
{
    int cheque_no;
    double minBalance=10000;
    current(String n,int a,int d)
    {
        name=n;
        acct_no=a;
        deposit=d;
        balance=deposit;
    }
    void details()
    {
        System.out.println("\nAccount_type: Current");
        super.details();
    }
    void serviceCharge(double amount)
    {
            double charge=0;
            System.out.println("Serive charge 6% is applied because of low  balance\n");
             charge=.08*(minBalance-(balance-amount));
             System.out.println("Service charge is:"+charge);
             balance-=charge;
            return ;
    }
    void withdrawal()
    {
        int flag=0;
        System.out.println("Do you have cheque");
        System.out.println("1.YES\n2.NO");
        int choice1=sc.nextInt();
        if(choice1==1)
        {
            flag=1;
           System.out.println("enter cheque number");
           cheque_no=sc.nextInt();
        }
        System.out.println("Enter amount for withdrawal\n");
        int amount=sc.nextInt();
        if(balance<amount)
        System.out.println("You can withdraw the amount less than "+balance);
        else
        {   double scharge=0;
            if(balance-amount<minBalance)
            {
                System.out.println("\nBalance will become less than the minimum balance\nDo you want to proceed\n1.Yes\n2.No");
                int newChoice=sc.nextInt();
                if(newChoice==2)
                {
                  System.out.println("transaction failed");  
                   return;
                }
                serviceCharge(amount);
            }
            balance=balance-amount;
            if(flag==1)
            {
                System.out.println("Cheque Number: "+cheque_no);
            }
            System.out.println("withdrawal is successfull..!!!!!!!");
            System.out.println("Do you want cheque your balance\n");
            System.out.println("1.YES\n2.NO");
           int choice=sc.nextInt();
           if(choice==1)
           cheque_balance();
            return;
        }
    }
}
class Main
{
    public static void  main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
       String name;
       int acct_no;
       int deposit;
       int choice;
       System.out.println("Enter your name\n");
       name=sc.nextLine();
       System.out.println("Type of account\n");
       System.out.println("1.current\n2.Savings");
       choice=sc.nextInt();
       if(choice==2)
       {
           System.out.println("Enter amount for deposition and minimum ampunt 1000 rupees\n");
           deposit=sc.nextInt();
           System.out.println("Create account number \n");
           acct_no=sc.nextInt();
           savings s=new savings(name,acct_no,deposit);
           while(true)
           {
                System.out.println("\nEnter your choice\n1.deposite\n2.withdrawal\n3.Details of account\n4.intrest Calculate\n5.exit\n");
                int ch=sc.nextInt();
                if(ch==1)
                s.deposit();
                else if(ch==2)
                {
                    s.withdrawal();
                }else if(ch==3)
                {
                    s.details();
                }
                else if(ch==4)
                {
                    int m;
                    System.out.println("Enter duration for intrest calculate\n");
                    m=sc.nextInt();
                    s.get_intrest(m);
                }
                else if(ch==5)
                 break;
                else
                {
                    System.out.println("Invalid Choice..!!!!!\n");
                }
           }
       }
       else if(choice==1)
       {
            System.out.println("Enter amount for deposition\n");
           deposit=sc.nextInt();
           System.out.println("Create account number \n");
           acct_no=sc.nextInt();
           current c=new current(name,acct_no,deposit);
           while(true)
           {
                System.out.println("\nEnter your choice\n1.deposite\n2.withdrawal\n3.Details of account\n4.exit");
                int ch=sc.nextInt();
                if(ch==1)
                c.deposit();
                else if(ch==2)
                {
                    c.withdrawal();
                }else if(ch==3)
                {
                    c.details();
                }
                else if(ch==4)
                 break;
                else
                {
                    System.out.println("Invalid Choice..!!!!!\n");
                }
           }
       }
    }
}