import java.util.*;
import java.lang.Math;
class Tournament
{
    private static int rounds = 1;
    private static int no_teams_act;
    private Team[] arr;
    private int no_teams;
    private int[][] relative_ar;

    Tournament(int rounds1, Team[] arr1, int no_teams1, int[][] relative_ar1, int no_teams_act1)
    {
        Tournament.rounds = rounds1;
        this.arr = new Team[no_teams];
        this.arr = arr1;
        this.no_teams = no_teams1;
        this.relative_ar = new int[no_teams1][no_teams1];
        this.relative_ar = relative_ar1;
        Tournament.no_teams_act = no_teams_act1;
    } 

    public void draw_order()
    {
        int k = 0, x = 0;
        Team[] fa = new Team[this.no_teams/2];
        while (x <= this.no_teams-1)
        {
            Match m = new Match(this.arr[x], this.arr[x+1]);
            fa[k] = m.getwinner(this.relative_ar);
            x = x + 2;
            k++;
        }
        System.out.print("Round"+" "+Tournament.rounds+" Winners"+':'+" ");
        for (int i = 0; i < this.no_teams/2; i ++)
            System.out.print(fa[i].getnum()+" ");
        System.out.println();
        Tournament.rounds += 1;
        this.arr = fa;
        this.no_teams = this.no_teams/2;
    }

    public void final_match()
    {
        for (int i = 0; i < Math.log(Tournament.no_teams_act)/Math.log(2); i ++)
        {
            draw_order();
        }
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i ++)
        {
            for (int j = 0; j < n; j ++) 
            {
                ar[i][j] = Integer.parseInt(in.next());
            }
        }
        Team[] arr = new Team[n];
        for (int i = 0; i < n; i ++){
            arr[i] = new Team(Integer.parseInt(in.next()));
        }
        Tournament t = new Tournament(rounds, arr, n, ar, n);
        t.final_match();
    }
}

class Team
{
    private int name;
    Team(int name1)
    {
        this.name = name1;;
    }
    public int getnum()
    {
        return this.name;
    }
}

class Match
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
