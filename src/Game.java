/*
Class Game is responsible for manging the game
 */

import java.util.Scanner;

public class Game {

   private Board board;
   private boolean gameOver; //game status
    private boolean win;

    //constructor
    Game() {
        gameOver=false;
        win=false;
    }

    //Function that starts the game- it allows user to crate board of demanded size
    void start() {
        int row, col;
        System.out.println("Podaj rozmiar planszy");
        System.out.print("Kolumny: ");
        Scanner scan = new Scanner(System.in);
        col = scan.nextInt();
        while (col <= 0) { //makes sure size is valid
            System.out.println("Błędny rozmiar");
            System.out.print("Kolumny: ");
            col = scan.nextInt();
            System.out.println();
        }

        System.out.print("Wiersze: ");
        row = scan.nextInt();
        System.out.println();
        while (row <= 0) { //makes sure size is valid
            System.out.println("Bledny rozmiar");
            System.out.print("Wiersze: ");
            row = scan.nextInt();
            System.out.println();
        }

        board = new Board(col, row);
        System.out.println("Zasady");
        System.out.println("1. Aby odkryc pole wprowadź 'r' a nastepnie wspolrzedne pola");
        System.out.println("2. Aby umiescic/usunac flage wprowadz 'f' a nastepnie wspolrzedne pola");
        System.out.println("3. Na odkrytym polu wyswietlona zostanie liczba min znajdujacych sie na sasiednich polach");
        System.out.println("4. Odkrycie pola z mina oznacza przegrana");
        System.out.println("Powodzenia!");
        play();
    }

    //play the game after creation of board
    void play() {
        while((gameOver==false)&&(win==false))
        {
            board.display();
            String s;
            Scanner scan = new Scanner(System.in);

            char c=scan.next().charAt(0);

            if((c=='r')||(c=='R')) reveal();
            else if((c=='f')||(c=='F'))  flag();


        }

        if(gameOver==true)
        {
            //After game over
            board.display();
            System.out.println();
            System.out.println("GAME OVER!");
        }
        else
        {
            //user have won
            board.display();
            System.out.println();
            System.out.println("Gratulacje, odkryles wszystkie miny!");
        }

    }

    //function allows to toggle flag
    private void flag()
    {

        int col, row;
       do
       {
           Scanner scan = new Scanner(System.in);
           col = scan.nextInt();
           row= scan.nextInt();
       }while(board.doesExist(col,row)==false); //makes sure field does exist

       if(board.isRevealed(row,col)==true) return;

       board.toggleFlag(row,col);

    }

    //function allows to reveal field
    private void reveal()
    {
        int col, row;
        do
        {
            Scanner scan = new Scanner(System.in);
            col = scan.nextInt();
            row= scan.nextInt();
        }while(board.doesExist(col,row)==false);//makes sure field does exist

        if(board.isRevealed(row,col)==true) return;

         board.reveal(row,col);
         if(board.hasMine(row,col)==true) gameOver=true;
         checkWin();
    }

    //checks if user have won
    private void checkWin()
    {
    if(board.checkWin()==true) win=true;
    }
}
