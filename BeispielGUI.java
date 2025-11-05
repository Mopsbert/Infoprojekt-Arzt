import sas.*;
import sasio.*;
/**
 * Diese Klasse dient der Darstellung einer möglichen GUI (Nutzeroberfläche)
 * mit sasio. Es werden die wesentlichen Bestandteile Label, Textfield und
 * Button beispielhaft erstellt und einige Funktionen angewendet.
 * Die Funktionsweise kann den Kommentaren entnommen werden bzw. durch
 * Erstellen eines Objekts von BeispielGUI und Ausführen der Methode fuehreAus().
 * 
 * @author Frau Seidl
 * @version Oktober 2025
 */
public class BeispielGUI
{
    private View fenster;
    private Label lbEingabe1, lbEingabe2, lbAusgabe;
    private Textfield tfEingabe1, tfEingabe2;
    private Button btnSubmit;
    
    /**
     * Konstruktor: das Fenster, die Beschriftungen, Textfelder und Buttons
     * werden erstellt und konfiguriert.
     */
    public BeispielGUI()
    {
        fenster = new View(400,400);
        //Label werden erstell. Diese dienen der Beschriftung bzw. Rückmeldung an den Nutzer.
        lbEingabe1 = new Label(20, 30, 100,20, "Eingabefeld:", java.awt.Color.WHITE);
        lbEingabe2 = new Label(200, 30, 180,20, "Noch ein Feld für Eingaben:", java.awt.Color.WHITE);
        lbAusgabe = new Label(20, 300, 400,30, "Rückmeldung: Blubb", java.awt.Color.WHITE);
        //Textfelder werden erstellt, in die Nutzer (wenn aktivert) etwas eintragen können:
        tfEingabe1 = new Textfield(20, 70, 150, 40, " ", fenster);
        tfEingabe1.setActivated(true); // damit ins Feld etwas eingetragen werden kann.
        tfEingabe2 = new Textfield(200,70,150, 40, "nicht aktiv ", fenster);
        //Ein Button wird erstellt
        btnSubmit = new Button(120, 170, 150,40, "Drück mich", java.awt.Color.GREEN);
        
        fuehreAus();
    }
    
    /**
     * Hauptmethode der Klasse BeispielGUI (fragt Buttons oder andere
     * Interaktion mit der Oberfläche ab)
     */
    public void fuehreAus(){
        while(true){
            fenster.wait(20);
            if(btnSubmit.clicked()){
                btnSubmitAction();
            }
        }
    }
    
    /**
     * Methode, die ausgeführt werden soll, wenn der Button 
     * btnSubmit gedrückt wurde.
     */
    private void btnSubmitAction(){
        //Auslesen des textfelds:
        String eingabe = tfEingabe1.getText();
        tfEingabe1.deleteText(); //Leert das Textfeld
        //Ausgabe anpassen:
        lbAusgabe.setLabelText("Zuletzt eingegeben: "+eingabe);
    }

    
}
