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
        System.out.println(queuePrivate.front());
    }
    void input(){
        if(tfName.clicked())
        {
            tfName.deleteText();
            disableTextfields();
            tfName.setActivated(true);
        }
        if(tfName.enterPressed())
        {
            tfName.setActivated(false);
            tfDescription.setActivated(true);
            tfDescription.deleteText();
        }
        if(tfDescription.clicked())
        {
            tfDescription.deleteText();
            disableTextfields();
            tfDescription.setActivated(true);
        }
        if(tfDescription.enterPressed())
        {
            tfDescription.setActivated(false);
            tfGender.setActivated(true);
            tfGender.deleteText();
        }
        if(tfGender.clicked())
        {
            tfGender.deleteText();
            disableTextfields();
            tfGender.setActivated(true);
        }
        if(tfGender.enterPressed())
        {
            tfGender.setActivated(false);
            tfAge.setActivated(true);
            tfAge.deleteText();
        }
        if(tfAge.clicked())
        {
            tfAge.deleteText();
            disableTextfields();
            tfAge.setActivated(true);
        }
        if(tfAge.enterPressed())
        {
            tfAge.setActivated(false);
            tfOrganDonor.setActivated(true);
            tfOrganDonor.deleteText();
        }
        if(tfOrganDonor.clicked())
        {
            tfOrganDonor.deleteText();
            disableTextfields();
            tfOrganDonor.setActivated(true);
        }
        if(tfOrganDonor.enterPressed())
        {
            tfOrganDonor.setActivated(false);
            tfDNR.setActivated(true);
            tfDNR.deleteText();
        }
        if(tfDNR.clicked())
        {
            tfDNR.deleteText();
            disableTextfields();
            tfDNR.setActivated(true);
        }
        if(tfDNR.enterPressed())
        {
            tfDNR.setActivated(false);
            tfHealthInsurance.setActivated(true);
            tfHealthInsurance.deleteText();
        }
        if(tfHealthInsurance.clicked())
        {
            tfHealthInsurance.deleteText();
            disableTextfields();
            tfHealthInsurance.setActivated(true);
        }
        if(tfDNR.enterPressed())
        {
            tfHealthInsurance.setActivated(false);
        }
    }
    private void disableTextfields(){
        tfName.setActivated(false);
        tfDescription.setActivated(false);
        tfGender.setActivated(false);
        tfAge.setActivated(false);
        tfOrganDonor.setActivated(false);
        tfDNR.setActivated(false);
        tfHealthInsurance.setActivated(false);
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
