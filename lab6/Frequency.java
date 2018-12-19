import java.lang.String;
import java.util.*;

public class Frequency implements Comparator<Element>
{
    @Override
    public int compare(Element x, Element y)
    {
        if (x.get_frequency() == y.get_frequency())
        {
            return (x.get_index()-y.get_index());
        }
        return (x.get_frequency() - y.get_frequency());
    }
}