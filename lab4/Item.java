public class Item
{
    private String item;
    private float price_per_unit;
    Item(String name, float price)
    {
        item = name; 
        price_per_unit = price;
    }
    public void set_item(String name)
    {
        item = name;
    }
    public String get_item()
    {
        return item;
    }
    public void set_price_per_unit(float price)
    {
        price_per_unit = price;
    }
    public float get_price_per_unit()
    {
        return price_per_unit;
    }
}