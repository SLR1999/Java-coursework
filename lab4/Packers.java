import java.util.ArrayList;

public class Packers
{
    private Store store;
    private ArrayList<Cart> request;
    Packers(Store stores, ArrayList<Cart> req)
    {
        store = stores;
        request = req;
    }
    public float packers_fun()
    {
        Perishables perishable;
        float perishable_sum = 0, perishable_val = 0;
        NonPerishables nonperishable;
        float nonperishable_sum = 0, nonperishable_val = 0;
        float check = 0;
        for (int i = 0; i < request.size(); i ++)
        {
            Cart req = request.get(i);
            check = store.store_fun1(req.get_name());
            if (check == 1)
            {
            //perishable = store.perishable_fun(req.get_name());
            perishable_sum += req.get_quantity();
            }
        }
        if (perishable_sum-5 <= 0)
            perishable_val = 0;
        else
        {
            perishable_val = (perishable_sum-5)*5;
        }
        for (int i = 0; i < request.size(); i ++)
        {
            Cart req = request.get(i);
            check = store.store_fun1(req.get_name());
            if (check == 2)
            {
            nonperishable = store.nonperishable_fun(req.get_name());
            nonperishable_sum += (nonperishable.get_unit())*req.get_quantity();
            }
        }
        if (nonperishable_sum-4 <= 0)
            nonperishable_val = 0;
        else
        {
            nonperishable_val = (nonperishable_sum-4)*2;
        }
        String str2 = String.format("Shipping %.1f", (perishable_val+nonperishable_val));
        //System.out.printf("%s %0.1f", "Shipping", (perishable_val+nonperishable_val));
        //System.out.println("sum="+ perishable_val+nonperishable_val);
        System.out.println(str2);
        return (perishable_val+nonperishable_val);
    }
}
