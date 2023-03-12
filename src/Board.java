/*
Class Board represents board. It has a 2D table of fields (field class). It allows to read and modify state of fields
 */

import java.util.Random;

public class Board {
    private Field fields[][];
    private int column;
    private int row;
    private int numberOfMines;

    //constructor creates board of size defined by user
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

        //generates number of mines- max is 1/2 of fields
        Random gen=new Random();
        int numOfMines=gen.nextInt(column*row/2)+1;

        deployMines(numOfMines,false);

    }

    //allocates mines- randomly or in predefined way
    private void deployMines(int n, boolean randrom)
    {
        if(randrom==true) //randomly
        {
            for(int i=0;i<n;++i)
            {
                int c,r;
                Random gen=new Random();

                do {
                    c=gen.nextInt(column);
                    r=gen.nextInt(row);
                }while(fields[r][c].checkMine()==true); //makes sure that there is not mine on the field
                fields[r][c].addMine();
            }
            numberOfMines=n;
        }else //predefined way (first row and diagonal)
        {
            for(int i=0;i<column;++i)
            {
                fields[0][i].addMine();
                numberOfMines++;
                if(i<row) //makes sure that diagonal field exist
                {
                    fields[i][i].addMine();
                    numberOfMines++;
                }
            }
            numberOfMines--; //because mine at 0,0 was counted twice

        }

    }

    //display board with all the info (mine/reveal/flag)- test
    void debug_display()
    {
        for(int i=0;i<row;++i) {
            for (int j = 0; j < column; ++j) {
                fields[i][j].info();
            }
            System.out.println();
        }
    }

    //FUNCTIONS TO CHECK OR MODIFY FIELDS

    //Returns true if field has mine, false if it doesn't or if it doesn't exist
    boolean hasMine(int y,int x)
    {
        if((x<0)||(y<0)) return false;
        if((x>=column)||(y>=row)) return false;
        return fields[y][x].checkMine();
    }

    //Returns true if field has flag, false if it doesn't or if it doesn't exist
    boolean hasFlag(int y,int x)
    {
        if((x<0)||(y<0)) return false;
        if((x>=column)||(y>=row)) return false;
        return fields[y][x].checkFlag();
    }

    //Returns true if field is revealed, false if it doesn't or if it doesn't exist
    boolean isRevealed(int y,int x)
    {
        if((x<0)||(y<0)) return false;
        if((x>=column)||(y>=row)) return false;
        return fields[y][x].checkRevealed();
    }

    //toggles flag if field does exist
    void toggleFlag(int y,int x)
    {
        if((x<0)||(y<0)) return ;
        if((x>=column)||(y>=row)) return;
        if(fields[y][x].checkFlag()==true) fields[y][x].removeFlag();
        else fields[y][x].addFlag();

    }

    //reveals if field does exist
    void reveal(int y,int x)
    {
        if((x<0)||(y<0)) return ;
        if((x>=column)||(y>=row)) return;
        fields[y][x].reveal();
    }


    //count mines in 8 neighbour fields
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


   //Display board in game mode [.][ ][1][x][?]
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

    //Returns true if field does exist
    boolean doesExist(int c,int r)
    {
        if((c<0)||(r<0)) return false;
        if((c>column)||(r>row)) return false;
        return true;
    }

    //checks if user have won
    boolean checkWin()
    {
        int numOfFields=column*row;
        //numberOfMines
        int numOfReveal=0;

        for(int i=0;i<row;++i) {
            for (int j = 0; j < column; ++j)
            {
                if((fields[i][j].checkRevealed()==true)&&(fields[i][j].checkMine()==false)) numOfReveal++;
            }
        }

        if((numOfFields-numberOfMines)==numOfReveal) return true;
        return false;
    }
}

