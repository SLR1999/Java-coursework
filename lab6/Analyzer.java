import java.util.*;
import java.lang.*;

public class Analyzer 
{
    private String[] reserved_words;
    private ArrayList<String> input;

    Analyzer(ArrayList<String> input1, String[] reserved) 
    {
        reserved_words = reserved;
        input = input1;
    }

    public ArrayList<String> return_arraylist_without_punc_lower() 
    {
        ArrayList<String> input1 = new ArrayList<String>();
        for (int i = 0; i < input.size(); i++) 
        {
            String str = new String();
            str = input.get(i);
            str = str.replaceAll("[.,;:-]+", "");
            str = str.replace("\"", "");
            str = str.replace("\'", "");
            str = str.toLowerCase();
            input1.add(str);
        }
        return input1;
    }

    public ArrayList<String> return_1a() 
    {
        ArrayList<String> input1 = this.return_arraylist_without_punc_lower();
        Set<String> link_hash = new LinkedHashSet<String>(input1);
        input1 = new ArrayList<String>(link_hash);
        return input1;
    }

    public ArrayList<String> return_1b() 
    {
        ArrayList<String> input1 = this.return_1a();
        Collections.sort(input1);
        return input1;
    }

    public ArrayList<String> return_1c() 
    {
        ArrayList<String> input1 = this.return_1a();
        StringLengthListSort temp = new StringLengthListSort();
        Collections.sort(input1, temp);
        return input1;
    }

    public ArrayList<String> return_1d() 
    
    {
        ArrayList<String> input1 = this.return_1a();
        HashMap<String, Integer> frequencymap = new HashMap<String, Integer>();
        ArrayList<String> in = this.return_arraylist_without_punc_lower();
        ArrayList<Element> ae = new ArrayList<Element>();
        for (String a : in) 
        
        {
            if (frequencymap.containsKey(a))
                frequencymap.put(a, frequencymap.get(a) + 1);
            else
                frequencymap.put(a, 1);
        }
        // for (String str: frequencymap.keySet())
        // {
        // System.out.println(str+" "+frequencymap.get(str));
        // }
        // System.out.println(input1.size());
        for (int i = 0; i < input1.size(); i++) 
        
        {
            // System.out.println(frequencymap.get(input1.get(i))+" "+ i+" "+
            // input1.get(i));
            Element el = new Element(frequencymap.get(input1.get(i)), i, input1.get(i));
            ae.add(el);
        }
        Frequency temp = new Frequency();
        Collections.sort(ae, temp);
        ArrayList<String> input2 = new ArrayList<String>();
        for (Element str : ae) {
            input2.add(str.get_string());
        }
        return input2;
    }

    public ArrayList<String> return_2() 
    {
        ArrayList<String> input1 = this.return_arraylist_without_punc_lower();
        ArrayList<Character> input2 = new ArrayList<Character>();
        for (String str : input1) 
        {
            input2.add(str.charAt(0));
        }
        HashMap<Character, Integer> frequencymap = new HashMap<Character, Integer>();
        for (Character a : input2) 
        {
            if (frequencymap.containsKey(a))
                frequencymap.put(a, frequencymap.get(a) + 1);
            else
                frequencymap.put(a, 1);
        }
        input1.clear();
        for (Character str : frequencymap.keySet()) 
        {
            input1.add(str + " " + frequencymap.get(str));
        }
        Collections.sort(input1);
        return input1;
    }

    public ArrayList<String> return_3a() 
    
    {
        ArrayList<String> input1 = this.return_1a();
        ArrayList<ElementIndex> temp = new ArrayList<ElementIndex>();
        for (String str : reserved_words) 
        
        {
            ElementIndex el = new ElementIndex(input1.indexOf(str), str);
            temp.add(el);
        }
        ElementIndexsort eis = new ElementIndexsort();
        Collections.sort(temp, eis);
        input1.clear();
        for (ElementIndex t : temp) 
        
        {
            input1.add(t.get_string());
        }
        return input1;
    }

    public ArrayList<String> return_3b() 
    
    
    {
        ArrayList<String> input1 = this.return_arraylist_without_punc_lower();
        ArrayList<ElementFreq> temp = new ArrayList<ElementFreq>();
        for (String str : reserved_words) 
        {
            ElementFreq ef = new ElementFreq(Collections.frequency(input1, str), str);
            temp.add(ef);
        }
        ElementFreqsort efs = new ElementFreqsort();
        Collections.sort(temp, efs);
        input1.clear();
        for (ElementFreq t : temp) 
        {
            input1.add(t.get_string());
        }
        return input1;
    }
}