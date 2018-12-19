public class Test1
{
    public static void main(String[] args)
    {
        int N = 10;
        int M = 100000;
        // for (int i = 0; i < N; i ++){
        //     int[] box = new int[M];}
        int[][] boxes = new int[N][];
        for (int i = 0; i < N; i ++)
        {
            int[] box = new int[M];
            boxes[i] = box;
        }
    }
}