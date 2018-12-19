public class Requests
{
    
    private char req_type;
    private int req_id;
    private int amount;
    Requests(char type, int id)
    {
        this.req_type = type;
        this.req_id = id;
        this.amount = 0;
    }
    Requests(char type, int id, int amount)
    {
        this.req_type = type;
        this.req_id = id;
        this.amount = amount;
    }
    public int getReqid() 
    {
        return this.req_id; 
    }
    public char getReq_type() 
    {
        return this.req_type; 
    }
    public int get_amount()
    {
        if (this.req_type == 'D')
            return this.amount;
        else
        {
            this.amount = -1*this.amount;
            return this.amount;
        }  
    }
    public int get_time()
    {
        if (req_type == 'D')
            return 5;
        else if (req_type == 'W')
            return 10;
        else
            return 2;
    }
}