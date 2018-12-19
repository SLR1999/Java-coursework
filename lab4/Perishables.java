public class Perishables extends Item
{
    float weight;
    
    Perishables(String name, float price, float wgt)
    {
        super(name, price);
        weight = wgt;
    }
    public void set_weight(float wgt)
    {
        weight = wgt;
    }
    public float get_weight()
    {
        return weight;
    }
}