import java.util.*;

class Main
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String query;
        String[] req;
        String[] req1;
        query = in.nextLine();
        req = query.split(" ");
        while (!req[0].equals("End"))
        {
            query = in.nextLine();
            req1 = query.split(" ");
            if (req[0].equals("FlightSimple"))
            {
                Flight_simple fs_game = new Flight_simple(req[0], Integer.parseInt(req[1]), req1);
                GameConsole playGame = new GameConsole(fs_game);
                playGame.play_game();
            }
            if (req[0].equals("RandomWalk"))
            {
                Random_walk rw_game = new Random_walk(req[0], Integer.parseInt(req[1]), req1);
                GameConsole playGame = new GameConsole(rw_game);
                playGame.play_game();
            }
            query = in.nextLine();
            req = query.split(" ");
        }
    }
}