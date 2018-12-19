class Store
{
    private int bakery_num;
    private int dairy_num;
    private ArrayList<String> bak_ar = new ArrayList<String>();
    private ArrayList<String> dai_ar = new ArrayList<String>();
    private Bakery[] bakery;
    private Dairy[] dairy;
    Store(int bak_num, int dai_num)
    {
        bakery_num = bak_num;
        dairy_num = dai_num;
    }
    public void add_bak_ar(String req)
    {
        bak_ar.add(req);
    }
    public void add_dai_ar(String req)
    {
        dai_ar.add(req);
    }
    public void store_fun(int x, int y)
    {
        bakery = new Bakery[bakery_num];
        dairy = new Dairy[dairy_num];
        for (int i = 0; i < x; i ++)
        {
            bakery[i%bakery_num].add_stack(bak_ar.get(i));
        }
        for (int i = 0; i < y; i ++)
        {
            dairy[i%dairy_num].add_stack(dai_ar.get(i));
        }
    }
    public void sto_bak_fun()
    {
        for (int i = 0; i < bakery_num; i ++)
        {
            bakery[i].bak_fun();
        }
    }
    public void sto_dai_fun()
    {
        for (int i = 0; i < dairy_num; i ++)
        {
            dairy[i].dai_fun();
        }
    }
}