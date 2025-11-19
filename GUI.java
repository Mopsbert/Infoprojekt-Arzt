import sas.*;
import sasio.*;
import java.awt.Color;
import java.awt.Color.*;
/*
 * In dieser Klasse ist die gesamte Steurung und Benutzeroberfläche.
 */
public class GUI
{
    private View window;
    private Textfield tfName,tfDescription,tfGender,tfBloodType,tfAge,tfOrganDonor,tfDNR,tfHealthInsurance; //dies sind die Inputfelder
    private Text tlbName,tlbDescription,tlbGender,tlbBloodType,tlbAge,tlbOrganDonor,tlbDNR,tlbHealthInsurance; //dies sind die Bezeichnungnen unter den Inputfeldern
    private Button btnSubmit, btnNextPatient, btnPrivateN, btnPrivateT, btnPrivateF; //dies sind alle Buttons für die Bedienung
    private Text tlbOutName,tlbOutDescription,tlbOutGender,tlbOutBloodType,tlbOutAge,tlbOutOrganDonor,tlbOutDNR,tlbOutHealthInsurance; //dies sind die Bezeichnungen über den Outputfeldern
    private Text tOutName,tOutDescription,tOutGender,tOutBloodType,tOutAge,tOutOrganDonor,tOutDNR,tOutHealthInsurance; //dies sind die Outputfelder
    private Queue<Patient> queuePrivate, queuePublic; //die beiden Queues werden erstellt, eine für privatpatienten ein für kassenpatienten
    private Boolean privateInsurance = false;
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
        
        tlbName = new Text(60,70,"Name",java.awt.Color.GRAY);       
        tlbDescription = new Text(300,70,"Beschreibung Krankheit",java.awt.Color.GRAY);
        tlbGender = new Text(640,70,"Geschlecht(m/w/d)",java.awt.Color.GRAY);
        tlbAge = new Text(900,70,"Alter",java.awt.Color.GRAY);
        tlbOrganDonor = new Text(400,130,"Organspender (j/n)",java.awt.Color.GRAY);
        tlbDNR = new Text(640,130,"CPR/DNR (j/n)",java.awt.Color.GRAY);
        
        btnPrivateN = new Button(900,100,80,30,"Privat ?",java.awt.Color.WHITE);
        btnPrivateT = new Button(900,100,80,30,"Privat J",java.awt.Color.GREEN);
        btnPrivateF = new Button(900,100,80,30,"Privat X",java.awt.Color.RED);
        btnPrivateT.setHidden(true);
        btnPrivateF.setHidden(true);
        
        btnSubmit = new Button(900,200,200,30,"Hinzufügen",java.awt.Color.GREEN);
        btnNextPatient = new Button(60,420,250,30,"Nächsten Patient anzeigen",java.awt.Color.RED);
        
        tlbOutName = new Text(60,470,"Name:",java.awt.Color.GRAY);
        tlbOutName.setHidden(true);
        tlbOutDescription = new Text(300,470,"Beschreibung Krankheit:",java.awt.Color.GRAY);
        tlbOutDescription.setHidden(true);
        tlbOutGender = new Text(640,470,"Geschlecht:",java.awt.Color.GRAY);
        tlbOutGender.setHidden(true);
        tlbOutAge = new Text(900,470,"Alter:",java.awt.Color.GRAY);
        tlbOutAge.setHidden(true);
        tlbOutOrganDonor = new Text(300,530,"Organspender:",java.awt.Color.GRAY);
        tlbOutOrganDonor.setHidden(true);
        tlbOutDNR = new Text(640,530,"CPR/DNR:",java.awt.Color.GRAY);
        tlbOutDNR.setHidden(true);
        tlbOutHealthInsurance = new Text(900,530,"Privatversichert:",java.awt.Color.GRAY);
        tlbOutHealthInsurance.setHidden(true);
        
        tOutName = new Text(60,500,"-",java.awt.Color.WHITE);
        tOutName.setHidden(true);
        tOutDescription = new Text(300,500,"-",java.awt.Color.WHITE);
        tOutDescription.setHidden(true);
        tOutGender = new Text(640,500,"-",java.awt.Color.WHITE);
        tOutGender.setHidden(true);
        tOutAge = new Text(900,500,"-",java.awt.Color.WHITE);
        tOutAge.setHidden(true);
        tOutOrganDonor = new Text(300,560,"-",java.awt.Color.WHITE);
        tOutOrganDonor.setHidden(true);
        tOutDNR = new Text(640,560,"-",java.awt.Color.WHITE);
        tOutDNR.setHidden(true);
        tOutHealthInsurance = new Text(900,560,"-",java.awt.Color.WHITE);
        tOutHealthInsurance.setHidden(true);
        
        queuePrivate= new Queue<Patient>();
        queuePublic = new Queue<Patient>();
    }
    static void main(){
        GUI app = new GUI();
        while(true){
            app.input();
            app.window.wait(1);
        }
    }
    void execute(){
        if(queuePrivate.isEmpty() == false){
            tOutName.setText(queuePrivate.front().getName());
            tOutDescription.setText(queuePrivate.front().getDescription());  
            tOutGender.setText(queuePrivate.front().getGender());  
            tOutAge.setText(queuePrivate.front().getAge());
            tOutHealthInsurance.setText("Privatversichert");
            if(queuePrivate.front().getOrganDonor())
            {
                tOutOrganDonor.setText("Ja");  
            }
            else
            {
                tOutOrganDonor.setText("Nein");  
            }
            if(queuePrivate.front().getDNR())
            {
                tOutDNR.setText("Ja");  
            }
            else
            {
                tOutDNR.setText("Nein");  
            }
            queuePrivate.dequeue();
            unhideText();
        }
        else{
            if(queuePublic.isEmpty() == false){
                tOutName.setText(queuePublic.front().getName());
                tOutDescription.setText(queuePublic.front().getDescription());  
                tOutGender.setText(queuePublic.front().getGender());  
                tOutAge.setText(queuePublic.front().getAge());
                tOutHealthInsurance.setText("Kassenpatient");
                if(queuePublic.front().getOrganDonor())
                {
                    tOutOrganDonor.setText("Ja");  
                }
                else
                {
                    tOutOrganDonor.setText("Nein");  
                }
                if(queuePublic.front().getDNR())
                {
                    tOutDNR.setText("Ja");  
                }
                else
                {
                    tOutDNR.setText("Nein");  
                }
                queuePublic.dequeue();
                unhideText();
            }
            else{
                hideText();
            }
        }
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
        if(tfDNR.enterPressed())
        {
            tfHealthInsurance.setActivated(false);
        }
        if(btnPrivateN.clicked())
        {
            privateInsurance = true;
            btnPrivateN.setHidden(true);
            btnPrivateT.setHidden(false);
            btnPrivateF.setHidden(true);
        }
        if(btnPrivateT.clicked())
        {
            privateInsurance = false;
            btnPrivateT.setHidden(true);
            btnPrivateF.setHidden(false);
        }
        if(btnPrivateF.clicked()){
            privateInsurance = true;
            btnPrivateT.setHidden(false);
            btnPrivateF.setHidden(true);
        }
        if(btnSubmit.clicked()){
            submit();
            deleteText();
            btnPrivateN.setHidden(false);
            btnPrivateT.setHidden(true);
            btnPrivateF.setHidden(true);
        }
        if(btnNextPatient.clicked()){
            execute();
        }
    }
    private void unhideText(){
        tlbOutName.setHidden(false);
        tlbOutDescription.setHidden(false);
        tlbOutGender.setHidden(false);
        tlbOutAge.setHidden(false);
        tlbOutOrganDonor.setHidden(false);
        tlbOutDNR.setHidden(false);
        tlbOutHealthInsurance.setHidden(false);
        
        tOutName.setHidden(false);
        tOutDescription.setHidden(false);
        tOutGender.setHidden(false);
        tOutAge.setHidden(false);
        tOutOrganDonor.setHidden(false);
        tOutDNR.setHidden(false);
        tOutHealthInsurance.setHidden(false);
    }
    private void hideText(){
        tlbOutName.setHidden(true);
        tlbOutDescription.setHidden(true);
        tlbOutGender.setHidden(true);
        tlbOutAge.setHidden(true);
        tlbOutOrganDonor.setHidden(true);
        tlbOutDNR.setHidden(true);
        tlbOutHealthInsurance.setHidden(true);
        
        tOutName.setHidden(true);
        tOutDescription.setHidden(true);
        tOutGender.setHidden(true);
        tOutAge.setHidden(true);
        tOutOrganDonor.setHidden(true);
        tOutDNR.setHidden(true);
        tOutHealthInsurance.setHidden(true);
    }
    private void disableTextfields(){
        tfName.setActivated(false);
        tfDescription.setActivated(false);
        tfGender.setActivated(false);
        tfAge.setActivated(false);
        tfOrganDonor.setActivated(false);
        tfDNR.setActivated(false);
    }
    private void deleteText(){
        tfName.deleteText();
        tfDescription.deleteText();
        tfGender.deleteText();
        tfAge.deleteText();
        tfOrganDonor.deleteText();
        tfDNR.deleteText();
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
        if(privateInsurance)
        {
            queuePrivate.enqueue(patient);
            privateInsurance = false;
        }
        else
        {
            queuePublic.enqueue(patient);            
        }
    }
}
