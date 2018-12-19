public class NonPerishables extends Item
{
    float units;
    
    NonPerishables(String name, float price, float unit)
    {
        super(name, price);
        units = unit; 
    }
    public void set_units(float unit)
    {
        units = unit;
    }
    public float get_unit()
    {
        return units;
    }
}