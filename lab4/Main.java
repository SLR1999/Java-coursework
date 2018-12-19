import java.util.*;

public class Main
{
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String query;
        String[] req;
        query = in.nextLine();
        req = query.split(" ");
        ArrayList<Item> item_ar = new ArrayList<Item>();
        ArrayList<Perishables> per_ar = new ArrayList<Perishables>();
        ArrayList<NonPerishables> nonper_ar = new ArrayList<NonPerishables>();
        while (!req[0].equals("End"))
        {
            if (req.length == 2)
            {
                Item item = new Item(req[0],Float.parseFloat(req[1]));
                item_ar.add(item);
                Perishables per = new Perishables(req[0], Float.parseFloat(req[1]), 0);
                per_ar.add(per);
            }
            if (req.length == 3)
            {
                Item item = new Item(req[0],Float.parseFloat(req[1]));
                item_ar.add(item);
                NonPerishables nonper = new NonPerishables(req[0], Float.parseFloat(req[1]), Float.parseFloat(req[2]));
                nonper_ar.add(nonper);
            }
            query = in.nextLine();
            req = query.split(" ");
        }
        query = in.nextLine();
        req = query.split(" ");
        ArrayList<Cart> cart_ar = new ArrayList<Cart>();
        while (!req[0].equals("Checkout"))
        {
            Cart cart = new Cart(req[0], Float.parseFloat(req[1]));
            cart_ar.add(cart);
            query = in.nextLine();
            req = query.split(" ");
        } 
        Store store = new Store(item_ar, per_ar, nonper_ar);
        Billers biller = new Billers(store, cart_ar);
        float sum1 = 0, sum2 = 0;
        sum1 = biller.biller_fun();
        Packers packer = new Packers(store, cart_ar);
        sum2 = packer.packers_fun();
        String str1 = String.format("Total %.1f", (sum1+sum2));
        //System.out.printf("%s %0.1f", "Total", (sum1+sum2));
        System.out.println(str1);
    }

}