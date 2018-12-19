public class Cart
{
    String name;
    float quantity;
    Cart(String names, float quantity1)
    {
        name = names;
        quantity = quantity1;
    }
    public void set_name(String names)
    {
        name = names;
    }
    public void set_quantity(float quantity1)
    {
        quantity = quantity1;
    }
    public float get_quantity()
    {
        return quantity;
    }
    public String get_name()
    {
        return name;
    }
}