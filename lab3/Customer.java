public class Customer
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