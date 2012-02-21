package mypackage;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

public class MyUi extends UiApplication 
{ 
    public static void main(String[] args) 
    { 
        MyUi theApp = new MyUi(); 
        theApp.enterEventDispatcher(); 
    } 
    public MyUi() 
    { 
        pushScreen(new MyUiScreen()); 
    } 
}
class MyUiScreen extends MainScreen 
{
    public MyUiScreen() 
    {
        setTitle("When do you wish to wake up?"); 
        
        String choices[] = {"0000","0100","0200","0300","0400","0500","0600","0700","0800","0900","1000","1100",
        		"1200","1300","1400","1500","1600","1700","1800","1900","2000","2100","2200","2300"};
        int iSetTo = 0;
        final ObjectChoiceField hour = new ObjectChoiceField("Hour",choices,iSetTo);
        add(hour);
        
        int iStartAt   = 00;
        int iEndAt     = 59;
        int iIncrement = 1;
        iSetTo         = 0;
        
        final NumericChoiceField min = new NumericChoiceField("Minute",iStartAt,iEndAt,iIncrement,iSetTo);
        add(min);
        
        LabelField credit = new LabelField("Credit to sleepyti.me, using their method of calculating times to sleep and various stats.");
        
        ButtonField mySubmitButton = new ButtonField("Submit"){
        	protected boolean navigationClick( int status, int time)
        	{
        		SleepTime sleep = new SleepTime(hour.getSelectedIndex(), min.getSelectedValue());
        		Dialog.alert(sleep.getSleepyTimes());
        		return true;
        	}
        };
        add(mySubmitButton);
        add(credit);

        
    }
    
    public boolean onSavePrompt()
    {
        return true;
    }
}