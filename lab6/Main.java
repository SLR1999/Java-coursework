import java.lang.String;
import java.util.*;

class Main {

    public static String print_fun(ArrayList<String> ar)
    {
        String str = "";
        for (int i = 0; i < ar.size(); i ++)
        {
            str += ar.get(i) + " ";
        }
        return str;
    }
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String query;
        String[] reservedWords;
        String[] para;
        query = in.nextLine();
        reservedWords = query.split(" ");
        query = in.nextLine();
        para = query.split(" ");
        ArrayList<String> solution = new ArrayList<String>(para.length);
        ArrayList<String> input = new ArrayList<String>(para.length);
        for (int i = 0; i < para.length; i++) 
        {
            if (!para[i].equals("-"))
                input.add(para[i]);
        }
        Analyzer analyzer = new Analyzer(input, reservedWords);
        solution = analyzer.return_arraylist_without_punc_lower();
        solution.clear();
        solution = analyzer.return_1a();
        System.out.println("1a:" + " " + print_fun(solution));
        solution.clear();
        solution = analyzer.return_1b();
        System.out.println("1b:" + " " + print_fun(solution));
        solution.clear();
        solution = analyzer.return_1c();
        System.out.println("1c:" + " " + print_fun(solution));
        solution.clear();
        solution = analyzer.return_1d();
        System.out.println("1d:" + " " + print_fun(solution));
        solution.clear();
        solution = analyzer.return_2();
        System.out.println("2a:");
        for (String str : solution)
        {
            System.out.println(str);
        }
        solution.clear();
        solution = analyzer.return_3a();
        System.out.println("3a:" + " " + print_fun(solution));
        solution.clear();
        solution = analyzer.return_3b();
        System.out.println("3b:" + " " + print_fun(solution));
        solution.clear();
    }
}