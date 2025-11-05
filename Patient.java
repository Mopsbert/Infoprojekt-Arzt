import sas.*;
import sasio.*;
public class Patient
{
    String name, description,gender,bloodType;
    int age;
    boolean organDonor,DNR;
    public Patient()
    {

    }

    public void setName(String n)
    {
        name = n;
    }

    public void setDescription(String n)
    {
        description = n;
    }

    public void setGender(String n)
    {
        gender = n;
    }

    public void setBloodType(String n)
    {
        bloodType = n;
    }

    public void setAge(String n)
    {
        age = Integer.valueOf(n);
    }

    public void setOrganDonor(String n)
    {
        if(n == "yes") organDonor =true;
        else organDonor = false;
    }

    public void setDNR(String n)
    {
        if(n == "yes") DNR =true;
        else DNR = false;
    }
    
    public String getName()
    {
        return(name);
    }

    public String getDescription()
    {
        return(description);
    }

    public String getGender()
    {
        return(gender);
    }

    public String getBloodType()
    {
        return(bloodType);
    }

    public int getAge()
    {
        return(age);
    }

    public Boolean getOrganDonor()
    {
        return(organDonor);
    }

    public Boolean getDNR()
    {
        return(DNR);
    }
}

