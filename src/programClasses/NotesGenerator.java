package programClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class NotesGenerator {
    public NotesGenerator (){

    }
    private String [] genNotesArray (){
        return new String[]{"Do", "Re", "Mi", "Fa", "Sol", "La", "Si"};
    }
    private char [] genDiesisBemolle (){
        Random rd = new Random();
        char [] diesisBemolle = new char[7];
        int value;
        for (int i = 0; i < diesisBemolle.length; i++){
            value = rd.nextInt(2); //generates between 0 and 1
            if (value == 0){
                diesisBemolle[i] = 'b';
            }
            else {
                diesisBemolle[i] = '#';
            }
        }
        return diesisBemolle;
    }

    public String getRandomNotes (){

        String [] notes = genNotesArray();
        char [] diesisBemolle = genDiesisBemolle();

        for (int i = 0; i< notes.length; i++){
            notes[i] += diesisBemolle[i];
        }
        List<String> newList = new ArrayList<>(List.of(notes)) ;
        Collections.shuffle( newList );


        //formatting
        String toReturn = newList.toString();
        toReturn = toReturn.replace("[", "");
        toReturn = toReturn.replace("]", "");
        toReturn = toReturn.replace(",", " ");
        return toReturn;
    }


}
