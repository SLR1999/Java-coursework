import java.util.*;

class Teller
{
    static private int req_id = 0;
    static private int time = 0;
    private Cashiers[] ca_ar;
    private ArrayList<Requests> re_ar = new ArrayList<Requests>();
    public int no_cashiers(int n)
    {
        if (n % 3 == 0)
            return n/3;
        else
            return (n/3)+1;
    }


    public void tel_fun(ArrayList<Requests> reqar, int n)
    {
        for (int i = 0; i < n; i ++)
        {
            this.ca_ar[i%no_cashiers(n)].req_stack.push(reqar.get(i));
        }
    }

    public void activate(int s){
        for (int i = 0; i < s; i ++)
            {
                this.ca_ar[i].cashier_fun(this);
            }
    }

    public int updateReqId(){
        Teller.req_id += 1;
        return Teller.req_id;
    }

    public void updateTime(int t){
        Teller.time = t;
    }

    public void setca_ar(int s){
        this.ca_ar = new Cashiers[s];
        for(int i = 0; i < s; i ++)
        {
            this.ca_ar[i] = new Cashiers(i+1, Teller.time);
        }
    }

    public void add_re_ar(Requests r){
        this.re_ar.add(r);
    }

    public Cashiers[] getca_ar()
    {
        return this.ca_ar;
    }

    public ArrayList<Requests> getre_ar()
    {
        return this.re_ar;
    }

    public static void main(String args[])
    {
        String[] req;
        Scanner in = new Scanner(System.in);
        String query;
        query = in.nextLine();
	System.out.println(query);
        req = query.split(" ");
        Teller tell = new Teller();
        int l = 0, s;
        while (req[0].charAt(0) != 'E')
        {
            if (req[0].charAt(0) == 'B')
            {
                s = tell.no_cashiers(l);
                tell.setca_ar(s);
                tell.tel_fun(tell.getre_ar(), l);
                l = 0;
                tell.activate(s);
                tell = new Teller();

            }
            else
            {
                if(req[0].charAt(0) == 'D' || req[0].charAt(0) == 'W'){
                    Requests r = new Requests(req[0].charAt(0), tell.updateReqId(), Integer.parseInt(req[2]));
                    tell.add_re_ar(r);
                    l += 1;
                }
                else
                {
                    Requests r = new Requests(req[0].charAt(0), tell.updateReqId());
                    tell.add_re_ar(r);
                    l += 1;
                }
            }
            query = in.nextLine();
            req = query.split(" ");
        }
        s = tell.no_cashiers(l);
        tell.setca_ar(s);
        tell.tel_fun(tell.getre_ar(), l);
        tell.activate(s);
    }
}

class Requests
{
    
    private char req_type;
    private int req_id;
    private int amount;
    Requests(char type, int id)
    {
        this.req_type = type;
        this.req_id = id;
        this.amount = 0;
    }
    Requests(char type, int id, int amount)
    {
        this.req_type = type;
        this.req_id = id;
        this.amount = amount;
    }
    public int getReqid() 
    {
        return this.req_id; 
    }
    public char getReq_type() 
    {
        return this.req_type; 
    }
    public int get_amount()
    {
        if (this.req_type == 'D')
            return this.amount;
        else
        {
            this.amount = -1*this.amount;
            return this.amount;
        }  
    }
    public int get_time()
    {
        if (req_type == 'D')
            return 5;
        else if (req_type == 'W')
            return 10;
        else
            return 2;
    }
}

class Customer
{
    private int cus_id;
    private Requests reqs = new Requests('D', 0, 0);
    Customer (int id1, Requests request1)
    {
        this.cus_id = id1;
        this.reqs = request1;
    }
    public int getcusid()
    {
        return this.cus_id;
    }
    public char getreqtype()
    {
        return this.reqs.getReq_type();
    }
    
}


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
