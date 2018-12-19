import java.util.ArrayList;

class Flight_simple extends Game
{
    
    Flight_simple(String name1, int movements1, String[] mov_ar1)
    {
        super(name1, movements1, mov_ar1);
    }
    public void play_game()
    {
        int speed = 0;
        int height = 0;
        int s = 0;
        for (int i = 0; i < get_mov_ar().length; i ++)
        {
            if (get_mov_ar()[i].equals("R"))
                speed += 1;
            if (get_mov_ar()[i].equals("L"))
                speed -= 1;
            if (get_mov_ar()[i].equals("U") && speed > 2)
                height += 1;
            if (get_mov_ar()[i].equals("D"))
                height -= 1;
            if (height < 0 || speed < 0)
            {
                System.out.println("FlightSimple:"+" "+"Lost");
                s = 1;
                break;
            }
            if (height == 0 && speed == 0)
            {
                System.out.println("FlightSimple:"+" "+"Won");
                s = 2;
                break;
            }
        }
        if (s == 0)
        {
            System.out.println("FlightSimple:"+" "+"Game Over");
        }
    }
} 