import java.util.ArrayList;

class Random_walk extends Game
{
    Random_walk(String name1, int movements1, String[] mov_ar1)
    {
        super(name1, movements1, mov_ar1);
    }
    public void play_game()
    {
        int x = 10;
        int y = 10;
        int s = 0;
        for (int i = 0; i < get_mov_ar().length; i ++)
        {
            if (get_mov_ar()[i].equals("R"))
                x += 1;
            else if (get_mov_ar()[i].equals("L"))
                x -= 1;
            else if (get_mov_ar()[i].equals("U"))
                y += 1;
            else
                y -= 1;
            if (y > 19 || x > 19)
            {
                System.out.println("RandomWalk:"+" "+"Lost");
                s = 1;
                break;
            }
            if (y == 0)
            {
                System.out.println("RandomWalk:"+" "+"Won");
                s = 2;
                break;
            }
            if (x < 0)
            {
                x = 0;
            }
        }
        if (s == 0)
        {
            System.out.println("RandomWalk:"+" "+"Game Over");
        }
    }
}