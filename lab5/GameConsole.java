class GameConsole
{
    private Game games;
    GameConsole(Game games1)
    {
        games = games1;
    }
    public void play_game()
    {
        games.play_game();
        // if (games.get_name().equals("FlightSimple"))
        // {
        //     Flight_simple fs_game = (Flight_simple) games;
        //     fs_game.play_game();
        // }
        // if (games.get_name().equals("RandomWalk"))
        // {
        //     Random_walk rw_game = (Random_walk) games;
        //     rw_game.play_game();
        // } 
    }
}