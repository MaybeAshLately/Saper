/* Saper
Programowanie w jezyku Java- laboratorium, PWR
Maciej Gużewski 259656
12.03.2023
 */

public class Main {
    static void field_test()
    {
      Field f;
      f=new Field();
      f.info();
      f.addFlag();
      f.info();
      f.addMine();
      f.info();
      f.reveal();
      f.info();
      f.removeFlag();
      f.info();
      System.out.println(f.checkMine());
      System.out.println(f.checkRevealed());
      System.out.println(f.checkFlag());
    }


    static void board_test()
    {
        Board b;
        b=new Board(4,4);
        b.debug_display();
        System.out.println(b.countMines(0,0));
        System.out.println(b.countMines(2,2));
        System.out.println();
        b.display();

    }

  static void playGame()
  {

      Game g;
      g=new Game();
      g.start();
  }

    public static void main(String[] args) {
        //field_test();
       // board_test();
        playGame();


           }
}

