//import Field.java

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");    }
}

/*
Proszę przygotować następujące klasy:

1. Klasa reprezentująca jedno pole w grze Saper.

Każde pole ma swój stan:

    czy posiada minę ?
    czy zostało odkryte ?
    czy zostało oznaczone flagą ?

W klasie proszę stworzyć

    konstruktor ustawiający parametry domyślne pola (brak miny, ukryte, brak flagi)
    funkcje pozwalające modyfikować i odczytywać stan pola
    pomocniczą funkcję info() wyświetlającą stan pola w postaci trzech liczb lub znaczników np. [010] (nie ma miny, odkryte, nie ma flagi)

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

// stary opis -----------------------------------------

Proszę opracować klasę reprezentującą planszę do gry Saper.

Klasa powinna posiadać informacje o:

    rozmiarze planszy (może być ustalony na stałe)

    stanie każdego z pól:

        ukryte lub odkryte

        bezpieczne lub z miną

        ma "flagę" lub jej nie ma

Wskazówka:

struct Pole
{
  bool jestMina;
  bool poleOdkryte;
  bool jestFlaga;
};

class Plansza
{
  Pole poleGry[20][20];
  int wysokosc;
  int szerokosc;

public:
  Plansza();
  void debug_display() const;
};


Waszym pierwszym zadaniem jest zaimplementowanie konstruktora klasy Plansza oraz napisanie funkcji debug_display().

Konstruktor ma:

    ustawić wysokosc i szerokosc planszy (na wartość nie większą niż 20 - bo taką sobie tablicę przygotowaliśmy)

    ustawić stan początkowy wszystkich pól planszy na: "nie ma miny", "pole zakryte", "nie ma flagi"

Funkcja debug_display() ma wyświetlić planszę w celu weryfikacji poprawności przeprowadzanych operacji - każde pole ma być wyświetlone jako ciąg 3 cyfr w nawiasach kwadratowych. Cyfra pierwsza informuje czy na polu jest mina, druga - czy pole jest odkryte, trzecia - czy na polu jest flaga. Cyfry mogą przyjąć wartość 0 lub 1. Przykład:

[100][000][000][000][000]
[000][000][100][010][000]
[000][000][000][001][000]

ETAP 2

Proszę dodać do klasy plansza kolejne funkcje. Każdą funkcje proszę przetestować (sprawdzić w main czy zachowuje się poprawnie)


// funkcja liczy ile jest min w otoczeniu pola o współrzędnych (x,y)
int licz_miny(int x, int y);

UWAGA: sugestia - dodaj funkcję pomocniczą
int czy_jest_mina(int x, int y);
Ta funkcja sprawdza czy x i y są prawidłowe (tzn czy sprawdzamy pole na planszy) i jeśli nie - zwraca zero. Jeśli x i y są poprawne, funkcja zwraca 1 jeśli na polu jest mina, zero jeśli jej nie ma.

// funkcja "odkrywa" pole.
void odkryj(int x, int y);

// funkcja "ustawia" flagę
void ustaw_flage(int x, int y);

// funkcja sprawdza czy (kiedykolwiek) odkryto pole zawierające minę - jeśli tak zwraca prawdę
bool czy_gra_skonczona();

// funkcja zwraca symbol reprezentujący zawartość pola o współrzędnych (x,y)
// Funkcja może zwrócić następujące symbole:
// _ (podkreślenie) - pole jest zakryte i nie posiada ustawionej flagi
// F (litera F) - pole jest zakryte i posiada ustawioną flagę
// " " (spacja) - pole jest odkryte, nie ma na nim miny i w jego otoczeniu nie ma żadnej miny
// 1...8 - pole jest odkryte, nie ma na nim miny i w jego otoczeniu jest od 1 do 8 min
// x (litera x) - pole jest odkryte i zawieta minę
char zawartosc_pola(int x, int y);
 */