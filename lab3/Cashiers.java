import java.util.*;

class Cashiers
{
    private int cashier_num;
    Stack<Requests> req_stack;
    private static int time;

    Cashiers(int cashier_number, int time_given)
    {
        this.cashier_num = cashier_number;
        this.req_stack = new Stack<Requests>();
        Cashiers.time = time_given;
    }
    public void set_t(int t)
    {
        Cashiers.time = t; 
    }

    public void set_cn(int n)
    {
        this.cashier_num = n;
    }
    
    public void pushReq(Requests req){
        this.req_stack.push(req);
    }

    public void cashier_fun(Teller t) 
    {
        int total_amount = 0;
        System.out.println("Cashier " + cashier_num);
        while (this.req_stack.empty() == false)
        {
            Requests req = req_stack.peek();
            Cashiers.time += req.get_time();
            t.updateTime(Cashiers.time);
            total_amount += req.get_amount();
            System.out.println("Request " + req.getReqid() + " " + Cashiers.time);
            req_stack.pop();
        }
        System.out.println("Total " + total_amount);
    }
}