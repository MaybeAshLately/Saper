/*
Class Field represents single field of the board. It knows if the field has mine, is revealed and has flag and allows to modify those parameters
 */
public class Field {
    private boolean hasMine;
    private boolean isRevealed;
    private boolean hasFlag;

    //Constructor
    Field()
    {
        hasMine=false;
        isRevealed=false;
        hasFlag=false;
    }

    //adds mine
    void addMine()
    {
        hasMine=true;
    }

    //returns info about mine
    boolean checkMine()
    {
        return hasMine;
    }

    //reveals the field
    void reveal()
    {
        isRevealed=true;
    }

    //returns info if field is revealed
    boolean checkRevealed()
    {
        return isRevealed;
    }

    //adds flag
    void addFlag()
    {
        hasFlag=true;
    }

    //removes flag
    void removeFlag()
    {
        hasFlag=false;
    }

    //returns info about flag
    boolean checkFlag()
    {
        return hasFlag;
    }


    //returns info about all three parameters
    void info()
    {
        int hM,iR,hF;
        if(hasMine==false) hM=0;
        else hM=1;
        if(isRevealed==false) iR=0;
        else iR=1;
        if(hasFlag==false) hF=0;
        else hF=1;
        System.out.println("["+hM+iR+hF+"]");
    }
}
