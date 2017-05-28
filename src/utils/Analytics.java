package utils;

import models.Assessment;
import models.Member;

/**
 * This class handles the following methods
 *          CalculateBMI which returns the BMI for the member based on the calculations
 *          DetermineBMICategory returns the category the BMI belongs to
 *          IsIdealBodyWeight returns a boolean to indicate if members has ideal weight
 *          ConvertWeightKGtoPounds formula
 *          ConvertHeightMetresToInches formula
 *          ToTwoDecimalPlaces ensures all double data returned is restricted to to decimal places
 *
 * @author Gary Fleming 21/05/2107
 * @version 4.0
 */
public class Analytics {

    /**
     * This static method calculates the BMI value for the member.
     *
     * The formula used for BMI is weight divided by the square of the height.
     *
     * @return the BMI value for the member.  The number returned is truncated to two decimal places.
     **/
    public static double calculateBMI( Member member, Assessment assessment){
        if (member.getHeight() <= 0)
            return 0;
        else
            return toTwoDecimalPlaces(member.getStartingWeight() / (member.getHeight() * member.getHeight()));
    }

    /**
     * This static method determines the BMI category that the member belongs to.
     *
     * The category is determined by the magnitude of the members BMI according to the following:
     *
     *     BMI less than    15   (exclusive)                      is "VERY SEVERELY UNDERWEIGHT"
     *     BMI between      15   (inclusive) and 16   (exclusive) is "SEVERELY UNDERWEIGHT"
     *     BMI between      16   (inclusive) and 18.5 (exclusive) is "UNDERWEIGHT"
     *     BMI between      18.5 (inclusive) and 25   (exclusive) is "NORMAL"
     *     BMI between      25   (inclusive) and 30   (exclusive) is "OVERWEIGHT"
     *     BMI between      30   (inclusive) and 35   (exclusive) is "MODERATELY OBESE"
     *     BMI between      35   (inclusive) and 40   (exclusive) is "SEVERELY OBESE"
     *     BMI greater than 40   (inclusive)                      is "VERY SEVERELY OBESE"
     *
     *
     * @return
     * The format of the String is similar to this (note the double quotes around the category):
     *     "NORMAL".
     */
    public static String determineBMICategory(double bmiValue)
    {
        if      (bmiValue < 15)    return "\"VERY SEVERELY UNDERWEIGHT\"";
        else if (bmiValue >= 15 && bmiValue < 16)    return "\"SEVERELY UNDERWEIGHT\"";
        else if (bmiValue >= 16 && bmiValue < 18.5)  return "\"UNDERWEIGHT\"";
        else if (bmiValue >= 18.5 && bmiValue < 25)  return "\"NORMAL\"";
        else if (bmiValue >= 25 && bmiValue < 30)    return "\"OVERWEIGHT\"";
        else if (bmiValue >= 30 && bmiValue < 35)    return "\"MODERATELY OBESE\"";
        else if (bmiValue >= 35 && bmiValue < 40)    return "\"SEVERELY OBESE\"";
        else if (bmiValue > 40)                      return "\"VERY SEVERELY OBESE\"";
        return "Wrong Data";
    }

    /**
     * This static method returns a boolean to indicate if the member has an ideal
     * body weight based on the Devine formula.
     *
     * <pre>
     * For males, an ideal body weight is:   50 kg + 2.3 kg for each inch over 5 feet.
     * For females, an ideal body weight is: 45.5 kg + 2.3 kg for each inch over 5 feet.
     *
     * Note:  if no gender is specified, return the result of the female calculation.
     *
     * </pre>
     *
     * @return Returns true if the result of the devine formula is within 2 kgs (inclusive) of the
     *         starting weight; false if it is outside this range.
     */
    public static boolean isIdealBodyWeight( Member member, Assessment assessment)
    {
        double fiveFeet = 60.0;
        double idealBodyWeight;

        double inches = convertHeightMetresToInches(member,assessment);

        if (inches <= fiveFeet){
            if (member.getGender().equals("M")){
                idealBodyWeight = 50;
            }
            else{
                idealBodyWeight = 45.5;
            }
        }
        else{
            if (member.getGender().equals("M")){
                idealBodyWeight = 50 + ((inches - fiveFeet) * 2.3);
            }
            else{
                idealBodyWeight = 45.5 + ((inches - fiveFeet) * 2.3);
            }
        }
        return (      (idealBodyWeight <= (member.getStartingWeight() + 2.0))
                && (idealBodyWeight >= (member.getStartingWeight() - 2.0))
        );
    }

    /**
     * This method returns the member weight converted from KGs to pounds.
     * @return member weight converted from KGs to pounds.
     *         The number returned is truncated to two decimal places.
     **/
    public static double convertWeightKGtoPounds( Member member, Assessment assessment){
        return toTwoDecimalPlaces(member.getStartingWeight() * 2.2);
    }

    /**
     * This method returns the member height converted from metres to inches.
     * @return member height converted from metres to inches using the formula: meters
     * multiplied by 39.37.  The number returned is truncated to two decimal places.
     **/
    public static double convertHeightMetresToInches( Member member, Assessment assessment){
        return toTwoDecimalPlaces(member.getHeight() * 39.37);
    }

    /*
     * This is a private helper method.  It ensures that all double data returned from this class
     * is restricted to two decimal places.  Note:  this method does not round
     */
    private  static double toTwoDecimalPlaces( double num){
        return (int)(num *100 ) / 100.0;
    }
}
