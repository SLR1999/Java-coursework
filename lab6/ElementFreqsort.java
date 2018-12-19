import java.lang.String;
import java.util.*;

public class ElementFreqsort implements Comparator<ElementFreq>
{
    @Override
    public int compare(ElementFreq s1, ElementFreq s2) 
    {
        return s2.get_frequency()-s1.get_frequency();
    }
}