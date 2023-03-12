import java.util.Random;

public class Board {
    private Field fields[][];
    private int column;
    private int row;

    Board(int c,int r )
    {
        if((c<=0)||(r<=0)) java.lang.System.exit(-1);
        fields= new Field[r][c];

        for(int i=0;i<r;++i)
        {
            for(int j=0;j<c;++j)
            {

                fields[i][j]=new Field();
            }
        }

        column=c;
        row=r;

        Random gen=new Random();
        int numOfMines=gen.nextInt(column*row/2)+1;
        //generates number of mines- max is 1/2 of fields
        deployMines(numOfMines,false);

    }

    private void deployMines(int n, boolean randrom)
    {
        if(randrom==true)
        {
            for(int i=0;i<n;++i)
            {
                int c,r;
                Random gen=new Random();

                do {
                    c=gen.nextInt(column);
                    r=gen.nextInt(row);
                }while(fields[r][c].checkMine()==true); //makes sure that field does already not has mine
                fields[r][c].addMine();

            }
        }else
        {
            for(int i=0;i<column;++i)
            {

                fields[0][i].addMine();
                if(i<row)
                {
                    fields[i][i].addMine();
                }

            }
        }

    }


    void debug_display()
    {
        for(int i=0;i<row;++i) {
            for (int j = 0; j < column; ++j) {
                fields[i][j].info();
            }
            System.out.println();
        }
    }

    boolean hasMine(int y,int x)
    {
        if((x<0)||(y<0)) return false;
        if((x>=column)||(y>=row)) return false;
        return fields[y][x].checkMine();
    }

    boolean hasFlag(int y,int x)
    {
        if((x<0)||(y<0)) return false;
        if((x>=column)||(y>=row)) return false;
        return fields[y][x].checkFlag();
    }

    boolean isRevealed(int y,int x)
    {
        if((x<0)||(y<0)) return false;
        if((x>=column)||(y>=row)) return false;
        return fields[y][x].checkRevealed();
    }

    void toggleFlag(int y,int x)
    {
        if((x<0)||(y<0)) return ;
        if((x>=column)||(y>=row)) return;
        if(fields[y][x].checkFlag()==true) fields[y][x].removeFlag();
        else fields[y][x].addFlag();

    }

    void reveal(int y,int x)
    {
        if((x<0)||(y<0)) return ;
        if((x>=column)||(y>=row)) return;
        fields[y][x].reveal();
    }

    int countMines(int y,int x)
    {
        int mines=0;

        if(hasMine(y,x-1)==true) mines++;
        if(hasMine(y,x+1)==true) mines++;
        if(hasMine(y-1,x)==true) mines++;
        if(hasMine(y+1,x)==true) mines++;
        if(hasMine(y-1,x-1)==true) mines++;
        if(hasMine(y-1,x+1)==true) mines++;
        if(hasMine(y+1,x-1)==true) mines++;
        if(hasMine(y+1,x+1)==true) mines++;
        return mines;
    }



    void display()
    {
        /* //Tests
        fields[0][0].reveal(); //[x]
        fields[1][2].reveal(); //[1]
        fields[1][0].addFlag(); //[F]
        fields[3][0].reveal();// []
      */
        for(int i=0;i<row;++i) {
            for (int j = 0; j < column; ++j) {



                  if(fields[i][j].checkRevealed()==false)
                  {
                      if(fields[i][j].checkFlag()==false) System.out.print("[.]");
                      else System.out.print("[?]");
                  }
                  else if(fields[i][j].checkMine()==true)
                  {
                      System.out.print("[x]");
                  }
                  else
                  {
                      if(countMines(i,j)==0) System.out.print("[ ]");
                      else System.out.print("["+countMines(i,j)+"]");
                  }

            }
            System.out.println();
        }
    }

    boolean doesExist(int c,int r)
    {
        if((c<0)||(r<0)) return false;
        if((c>column)||(r>row)) return false;
        return true;
    }
}

/*
2. Klasa reprezentująca całą planszę

Plansza jest prostokątnym obszarem o wymiarach M*N. Każdy "element" tego obszaru to zdefiniowane wcześniej "pole".

W klasie reprezentującej planszę należy stworzyć następujące funkcje

    konstruktor określający rozmiar planszy
    funkcja deployMines(int n, bool randrom) - ustawia na planszy n min
        w losowych pozycjach jeśli parametr random ma wartość true
        w pierwszym wierszu i na przekątnej jeśli parametr random ma wartość false (w tym przypadku wartość n jest ignorowana)
    debug_display() - pomocnicza funkcja wyświetlająca całą planszę (wywołuje funkcję info() dla każdego pola planszy)
    hasMine(int x, int y) - zwraca prawdę, jeśli na polu jest mina. Zwraca fałsz jeśli na polu nie ma miny albo jeśli podane współrzędne leżą poza planszą
    countMines(intx, int y) - funkcja liczy ile jest min w otoczeniu pola o współrzędnych x,y (wskazówka - użyj zdefiniowanej wcześniej funkcji hasMine() )
    display() - wyświetla planszę zgodnie z regułami gry, czyli
        [.] - jeśli pole jest zakryte i nie jest oznaczone flagą
        [?] - jeśli pole jest zakryte i jest oznaczone flagą
        [ ] - jeśli pole jest odkryte, nie ma na nim miny i w sąsiedztwie jest 0 min
        [3] - j.w., ale w otoczeniu pola są 3 miny
        [x] - na odkrytym polu jest mina (koniec gry !)
    reveal(x,y) - odkryj pole; jeśli na odkrytym polu jest mina, to w klasie plansza ustawiany jest znacznik sygnalizujący koniec gry

 */
