import sas.*;
import sasio.*;
import java.awt.Color;
import java.awt.Color.*;
public class GUI
{
    private View window;
    private Textfield tfName,tfDescription,tfGender,tfBloodType,tfAge,tfOrganDonor,tfDnr,tfUrgency;
    private Button btnSubmit;
    
    public GUI()
    {
        window = new View(1280,720,"Arzpraxis");
        window.setBackgroundColor(java.awt.Color.BLACK);
        tfName = new Textfield(60,40,200,30,"Name",window);
        tfName.setActivated(true);
        tfDescription = new Textfield(300,40,300,30,"Beschreibung Krankheit",window);
        tfGender = new Textfield(640,40,200,30,"Geschlecht(m/w/d)",window);
        tfAge = new Textfield(900,40,100,30,"Alter",window);
        tfOrganDonor = new Textfield(400,100,200,30,"Organspender (j/n)",window);
        tfDnr = new Textfield(640,100,200,30,"CPR/DNR (j/n)",window);
        tfUrgency = new Textfield(900,100,200,30,"Dringlich (j/n)",window);
    }
}
