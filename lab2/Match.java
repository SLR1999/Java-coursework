public class Match
{
    private Team team1 = new Team(2);
    private Team team2 = new Team(1);
    Match (Team A, Team B) 
    {
        this.team1 = A;
        this.team2 = B;
    }
    public Team getwinner(int[][] ar)
    {
        int s = ar[this.team1.getnum()-1][this.team2.getnum()-1];
        if (s == -1)
            return this.team1;
        else
            return this.team2;
    }
} 