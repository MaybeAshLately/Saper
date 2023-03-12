import java.util.Scanner;

public class Game {

    Board board;
    boolean gameOver;

    Game() {
        gameOver=false;
    }

    void start() {
        int row, col;
        System.out.println("Podaj rozmiar planszy");
        System.out.print("Kolumny: ");
        Scanner scan = new Scanner(System.in);
        col = scan.nextInt();
        while (col <= 0) {
            System.out.println("Błędny rozmiar");
            System.out.print("Kolumny: ");
            col = scan.nextInt();
            System.out.println();
        }

        System.out.print("Wiersze: ");
        row = scan.nextInt();
        System.out.println();
        while (row <= 0) {
            System.out.println("Bledny rozmiar");
            System.out.print("Wiersze: ");
            row = scan.nextInt();
            System.out.println();
        }

        board = new Board(col, row);
        System.out.println("Zasady");
        System.out.println("1. Aby odkryc pole wprowadź '1' a nastepnie wspolrzedne pola");
        System.out.println("2. Aby umiescic/usunac flage wprowadz '2' a nastepnie wspolrzedne pola");
        System.out.println("3. Na odkrytym polu wyswietlona zostanie liczba min znajdujacych sie na sasiednich polach");
        System.out.println("4. Odkrycie pola z mina oznacza przegrana");
        System.out.println("Powodzenia!");
        play();
    }

    private void flag()
    {

        int col, row;
       do
       {
           Scanner scan = new Scanner(System.in);
           col = scan.nextInt();
           row= scan.nextInt();
       }while(board.doesExist(col,row)==false);

       if(board.isRevealed(row,col)==true) return;

       board.toggleFlag(row,col);

    }

    private void reveal()
    {
        int col, row;
        do
        {
            Scanner scan = new Scanner(System.in);
            col = scan.nextInt();
            row= scan.nextInt();
        }while(board.doesExist(col,row)==false);
        if(board.isRevealed(row,col)==true) return;

         board.reveal(row,col);
         if(board.hasMine(row,col)==true) gameOver=true;
    }

    void play() {
        while(gameOver==false)
        {
            board.display();
            int s;
            Scanner scan = new Scanner(System.in);
            s = scan.nextInt();
            if(s==1) flag();
            else if(s==2)  reveal();
        }
       System.out.println("GAME OVER!");
    }
}
