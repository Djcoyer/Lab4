/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4part1;
import javax.swing.JOptionPane;

/**
 *
 * @author CoyerDevynJoseph
 */
public class Lab4Part1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean dayValid = true;
        boolean monthValid = true;
        boolean yearValid = true;

        String input1 = JOptionPane.showInputDialog(
                " Enter a date value after January 1, 1600 and before the year "
                + "10000.\nEnter the date as one integer representing month "
                + "then day then year.\nUse two digits for day and month and four "
                + "digits for year\nfilling with 0 as needed for the "
                + "month and day \nin the format MMDDYYYY:  ");
        int mmddyyyy1 = Integer.parseInt(input1);

        String input2 = JOptionPane.showInputDialog(
                "Enter a second date value that is later than your previous date "
                        + "\nin the same format MMDDYYYY:   ");
        int mmddyyyy2 = Integer.parseInt(input2);

        System.out.println("date1 is "+mmddyyyy1+" date2 is "+mmddyyyy2);
        
        
        int mm1 = mmddyyyy1/1000000;  // *-* find the month value from mmddyyyy1
        int x = mm1/10;
        int dd1 =  Integer.parseInt(Integer.toString(mmddyyyy1).substring(1+x,3+x));
        int yyyy1 = Integer.parseInt(Integer.toString(mmddyyyy1).substring(3+x,7+x));
            
        int mm2 =   mmddyyyy2/1000000;   // *-* find the month value from mmddyyyy2
        int y = mm2/10;
        int dd2 = Integer.parseInt(Integer.toString(mmddyyyy2).substring(1+y,3+y));;
        int yyyy2 = Integer.parseInt(Integer.toString(mmddyyyy2).substring(3+y,7+y));;
        

        System.out.println("dd1 is "+dd1+" mm1 is "+mm1 + " yyyy1 is "+yyyy1);
        System.out.println("dd2 is "+dd2+" mm2 is "+mm2 + " yyyy2 is "+yyyy2);

        
        // For purposes of this validation, validate that no day value 
        // is greater than 31
        dayValid = (dd1 <=31 ? true: false);  // *-* Use test conditions and logical operators to validate dd1
        monthValid = (mm1 <= 12 ? true: false);
        yearValid =  (yyyy1 >= 1600 && yyyy1 <= 10000 ? true: false);
        dayValid = dayValid && (dd2 <= 31 ? true: false);
        monthValid = monthValid && (mm2 <= 12 ? true: false);
        yearValid = (yearValid && (yyyy2 >= 1600 && yyyy2 <= 10000) ? true: false);

        System.out.println(dayValid);
        System.out.println(monthValid);
        System.out.println(yearValid);
        
        int daysBetween = 0;
        int monthsBetween = 0;
        int monthsCheck = 0;

  

int yearDiff = yyyy2 - yyyy1;  // Number of years between dates
/*
        Calculate number of days between the two dates by:
        Finding the number of days until Dec 31 or day2 whichever comes first
           algorithm = num days in mm1 - dd1 plus each month count from mm1+1 to Dec or mm2
        Finding the number of days from Jan 1 to day2 if day1 and day2 in diff years
           algorithm = month count from Jan to mm2-1 plus dd2
        Adding days times number of years for intervening years
        */

        if (yearDiff == 0)  // Both dates in same year
        {
            monthsBetween = mm2 - mm1;  // if year is same, day2 must be after day1
            if (monthValid && (monthsBetween == 0))
            {
                daysBetween = dd2 - dd1;
            }
            else if (monthValid)
            {
                daysBetween = daysToEndOfMonth(dd1,mm1);
                daysBetween = daysOfMonth(daysBetween, mm1+1, mm2);
                daysBetween += dd2; 
            }
        }
        else if ((yearDiff > 0) && (monthValid)) // Year2 is after Year 1
        {
            System.out.println();
            daysBetween = daysToEndOfMonth(dd1,mm1);
            daysBetween = daysOfMonth(daysBetween,mm1+1,12+1);    
            daysBetween = daysOfMonth(daysBetween,1,mm2);    
            daysBetween += dd2;    
            daysBetween += // *-* add in 365 days for each year inbetween yyyy1 and yyyy2    
        }
        String date1 = mm1+"/"+dd1+"/"+yyyy1;
        String date2 = mm2+"/"+dd2+"/"+yyyy2;
        
        if (((yearDiff >= 0) && yearValid) && (monthValid && dayValid))
        {
            System.out.println("The number of days between "+date1
                    +" and "+date2+" is "+daysBetween);
        }
        else   // <> check for question 1.b regarding more detailed error output
        {
            System.out.println("The dates were invalid or were entered in the wrong order");    
        }
    }
    
    public static int daysToEndOfMonth(int dd, int mm)
    {
        int daysToEnd = 0;
        switch(mm)
        {
            case 4:
            case 6:
            case 9:
            case 11: daysToEnd = 30 - dd;
                    break;
            /*
              *-* Fill in the cases and actions for the remaining months
            */
       }
        return daysToEnd;
    }
    
}
    