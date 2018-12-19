import java.lang.String;
import java.util.*;

public class ElementIndexsort implements Comparator<ElementIndex>
{
    @Override
    public int compare(ElementIndex s1, ElementIndex s2) 
    {
        return s1.get_index()-s2.get_index();
    }
}