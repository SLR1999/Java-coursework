import java.util.ArrayList;

public class Billers
{
    private Store store;
    private ArrayList<Cart> requests;

    Billers(Store store1, ArrayList<Cart> reqs)
    {
        store = store1;
        requests = reqs;
    }
    public float biller_fun()
    {
        Cart req;
        float s;
        float value;
        float sum = 0;
        for (int i = 0; i < requests.size(); i ++)
        {
            req = requests.get(i);
            s = store.store_fun(req.get_name());
            value = s*(req.get_quantity());
            // System.out.println("sum="+ sum);
            sum = sum+value;
            String str3 = String.format("%s %.1f %.1f", req.get_name(), req.get_quantity(), value);
            // System.out.println(req.get_name()+" "+req.get_quantity()+" "+value);
            //System.out.printf ("%s %0.1f %0.1f\n", req.get_name(), req.get_quantity(), value);
            System.out.println(str3);
        }

        return sum;

    }
}
