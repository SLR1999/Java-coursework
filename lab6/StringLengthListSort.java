import java.lang.String;
import java.util.*;

public class StringLengthListSort implements Comparator<String>
{
    @Override
    public int compare(String s1, String s2) 
    {
        if (s1.length() == s2.length())
        {
            return s1.compareTo(s2);
        }
        return s1.length() - s2.length();
    }
}