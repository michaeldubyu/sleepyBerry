/**
 * 
 */
package mypackage;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author michael
 *
 */
public class SleepTime 
{
int hourToSleep;
int minToSleep;

	public SleepTime(int hour, int min)
	{
		this.hourToSleep = hour;
		this.minToSleep = min;
	}
	
	public String getSleepyTimes()
	{
		//convert given hour and min desired into string of desired times to sleep
	
		Calendar wakeAt = Calendar.getInstance();
		wakeAt.set(Calendar.HOUR_OF_DAY,hourToSleep);
		wakeAt.set(Calendar.MINUTE,minToSleep);
		
		String times = "You should try to be asleep by : ";
				
		for (int i=0;i<5;i++)
		{
			minToSleep = (minToSleep-30) % 60;
			hourToSleep = (hourToSleep-1) % 24;			

			if (minToSleep < 0) minToSleep = minToSleep + 60;
			if (hourToSleep < 0) hourToSleep = hourToSleep + 24;
			
			String properMin;
			
			if (minToSleep < 10) 
			{
				properMin = "0" + minToSleep;
				times += (hourToSleep + ":" + properMin + ", ");	
			}
			else times += (hourToSleep + ":" + minToSleep + ", ");						
		}
		
		times += "and keep in mind the average human takes 14 minutes to fall asleep!";
		
		return times;
	}
	
	public int getHour()
	{
		return hourToSleep;
	}
	
	public int getMin()
	{
		return minToSleep;
	}
}
