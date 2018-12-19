public class Hello
{
    public static void main(String[] args)
    {
        System.out.println("Hello there");
        String[] sentence = {"This", "is", "a", "short", "sentence"};
        String fin = "\0";
        int j = 0;
        for (int i = 0; i < sentence.length; i ++)
        {
            fin += sentence[i] + " ";
        }
        System.out.print(fin);
    }
}
