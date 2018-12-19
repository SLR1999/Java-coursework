class Element
{
    private int frequency;
    private int index;
    private String str;
    Element(int freq, int in, String str1)
    {
        frequency = freq;
        index = in;
        str = str1;
    }
    public int get_frequency()
    {
        return frequency;
    }
    public int get_index()
    {
        return index;
    }
    public String get_string()
    {
        return str;
    }
}