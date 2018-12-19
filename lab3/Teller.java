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
        in.close();
    }
}