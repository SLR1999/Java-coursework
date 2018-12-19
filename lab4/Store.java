import java.util.ArrayList;

public class Store
{
    private ArrayList<Item> items;
    private ArrayList<Perishables> perishables;
    private ArrayList<NonPerishables> nonperishables;
    Store(ArrayList<Item> items1, ArrayList<Perishables> perishables1, ArrayList<NonPerishables> nonperishables1)
    {
    items  = items1;
    perishables = perishables1;
    nonperishables = nonperishables1;
    }
    public ArrayList<Item> get_items()
    {
        return items;
    }
    public ArrayList<Perishables> get_perishables()
    {
        return perishables;
    }
    public ArrayList<NonPerishables> get_nonperishables()
    {
        return nonperishables;
    }
    public void set_items(ArrayList<Item> items1)
    {
        items = items1;
    } 
    public void set_perishables(ArrayList<Perishables> perishables1)
    {
        perishables = perishables1;
    }
    public void set_nonperishables(ArrayList<NonPerishables> nonperishables1)
    {
        nonperishables = nonperishables1;
    }
    public float store_fun(String name)
    {
        float s = 0;
        for (int i = 0; i < items.size(); i ++)
        {
            Item type = items.get(i);
            if (type.get_item().equals(name))
            {
                s = type.get_price_per_unit();
                break;
            }
        }
        return s;
    }
    public float store_fun1(String name)
    {
        float s = 0;
        for (int i = 0; i < perishables.size(); i ++)
        {
            Perishables perishable = perishables.get(i);
            if (perishable.get_item().equals(name))
            {
                s = 1;
                break;
            }
        }
        for (int i = 0; i < nonperishables.size(); i ++)
            {
                NonPerishables nonperishable = nonperishables.get(i);
                if (nonperishable.get_item().equals(name))
                {
                    s = 2;
                    break;
                }
            }
        return s;
    }
    public Perishables perishable_fun(String name)
    {
        Perishables per = new Perishables("X", 0, 0);
        for (int i = 0; i < perishables.size(); i ++)
        {
            per = perishables.get(i);
            if (per.get_item().equals(name))
                break;
        }
        return per;
    }
    public NonPerishables nonperishable_fun(String name)
    {
        NonPerishables per = new NonPerishables("X", 0, 0);
        for (int i = 0; i < nonperishables.size(); i ++)
        {
            per = nonperishables.get(i);
            if (per.get_item().equals(name))
                break;
        }
        return per;
    }
}
