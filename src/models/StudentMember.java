package models;

/**
 * This StudentMember class is a subclass of the Member class
 *
 * It stores the Student Id and College Name
 * It also holds the concrete implementation for the chosenPackage method
 * There is no validation on the entered data
 *
 * @author Gary Fleming 21/05/2017
 * @version 4.0
 */


public class StudentMember extends Member {

    private String studentId;
    private String collegeName;

    /**
     *
     * @param email students email
     * @param name students name
     * @param address students address
     * @param gender students gender
     * @param height students height
     * @param startingWeight students starting weight
     * @param chosenPackage students chosen package
     * @param studentId  students Id
     * @param collegeName students college name
     */
    public StudentMember( String email, String name, String address, String gender, double height, double startingWeight,
                          String chosenPackage, String studentId, String collegeName) {
        super(email, name, address, gender, height, startingWeight, chosenPackage);

        this.studentId = studentId;
        this.collegeName = collegeName;
    }

    /**
     * set chosenPackage
     */
    @Override
    public void chosenPackage(String chosenPackage) {
        if (chosenPackage.length() >= collegeName.length()){
            if (collegeName.equals(chosenPackage.substring(0, collegeName.length())))
                this.chosenPackage = chosenPackage;
            else
                this.chosenPackage = "Package 3";
        }else{
            this.chosenPackage = "Package 3";
        }
    }
    /**
     *
     * @return returns studentId
     */
    public String getStudentId(){
        return studentId;
    }
    /**
     *
     * @return returns collegeName
     */
    public String getCollegeName(){
        return collegeName;
    }
    /**
     *
     * @param studentId
     *              Sets student id
     */
    public void setStudentId(String studentId){
       this.studentId = studentId;
    }
    /**
     *
     * @param collegeName
     *              Sets students college name
     */
    public void setCollegeName(String collegeName){
        this.collegeName = collegeName;
    }

    /**
     *
     * @return User-friendly String representing the current Student Member
     */
    public String toString(){
        return super.toString() + "/ Student Id: " +  studentId + "/ College Name: " +  collegeName;
    }
}
