import sas.*;
import sasio.*;
import java.awt.Color;
import java.awt.Color.*;
public class GUI
{
    private View window;
    private Textfield tfName,tfDescription,tfGender,tfBloodType,tfAge,tfOrganDonor,tfDNR,tfHealthInsurance;
    private Button btnSubmit;
    private Queue queuePrivate, queuePublic;
    public GUI()
    {
        window = new View(1280,720,"Arzpraxis");
        window.setBackgroundColor(java.awt.Color.BLACK);
        tfName = new Textfield(60,40,200,30,"Name",window);
        tfName.setActivated(true);
        tfDescription = new Textfield(300,40,300,30,"Beschreibung Krankheit",window);
        tfGender = new Textfield(640,40,200,30,"Geschlecht(m/w/d)",window);
        tfAge = new Textfield(900,40,200,30,"Alter",window);
        tfOrganDonor = new Textfield(400,100,200,30,"Organspender (j/n)",window);
        tfDNR = new Textfield(640,100,200,30,"CPR/DNR (j/n)",window);
        tfHealthInsurance = new Textfield(900,100,200,30,"Privat (j/n)",window);
        
        btnSubmit = new Button(900,160,200,30,"Hinzufügen",java.awt.Color.WHITE);
        
        queuePrivate= new Queue();
        queuePublic = new Queue();
    }
    static void main(){
        GUI app = new GUI();
    }
    void execute(){
        
    }
    void input(){
        
    }
    void submit(){
        Patient patient;
        patient = new Patient();
        patient.setName(tfName.getText());
        patient.setDescription(tfDescription.getText());
        patient.setGender(tfGender.getText());
        patient.setAge(tfAge.getText());
        patient.setOrganDonor(tfOrganDonor.getText());
        patient.setDNR(tfDNR.getText());
        if(tfHealthInsurance.getText()=="j")
        {
            queuePrivate.enqueue(patient);
        }
        else
        {
            queuePublic.enqueue(patient);            
        }
    }
}
