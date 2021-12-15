package programClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class NotesGenerator {
    public NotesGenerator (){
        hasAccidentals = false;

    }
    private String [] genNotesArray (){
        return new String[]{"Do", "Re", "Mi", "Fa", "Sol", "La", "Si"};
    }
    private char [] genAccidentals(){
        Random rd = new Random();
        char [] accidentals = new char[7];
        int value;
        for (int i = 0; i < accidentals.length; i++){
            value = rd.nextInt(2); //generates between 0 and 1
            if (value == 0){
                accidentals[i] = 'b';
            }
            else {
                accidentals[i] = '#';
            }
        }
        return accidentals;
    }

    private void addAccidentals(String [] notes){
        char [] accidentals = genAccidentals();
        for (int i = 0; i< notes.length; i++){
            notes[i] += accidentals[i];
        }
    }

    private String formatString (List<String> notes){
        String toReturn = notes.toString();
        toReturn = toReturn.replace("[", "");
        toReturn = toReturn.replace("]", "");
        toReturn = toReturn.replace(",", " ");
        return toReturn;
    }

    public String getRandomNotes (){

        String [] notes = genNotesArray();
        if (hasAccidentals){
            addAccidentals(notes);
        }

        List<String> newList = new ArrayList<>(List.of(notes)) ;
        Collections.shuffle( newList );

        //formatting
        return formatString(newList);
    }

    public void setHasAccidentals(boolean hasAccidentals) {
        this.hasAccidentals = hasAccidentals;
    }

    private boolean hasAccidentals;

}
