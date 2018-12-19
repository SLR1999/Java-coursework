import java.util.ArrayList;

public abstract class Game
{
    private String name;
    private int movements;
    private String[] mov_ar;
    Game (String name1, int movements1, String[] mov_ar1)
    {
        name = name1;
        movements = movements1;
        mov_ar = mov_ar1;
    }
    public void play_game()
    {

    }
    public String[] get_mov_ar()
    {
        return mov_ar;
    }
}