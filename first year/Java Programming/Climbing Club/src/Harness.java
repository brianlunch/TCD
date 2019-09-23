/* SELF ASSESSMENT

Harness Class: Member variables (8 marks)
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment: 8 - I think so, im unsure about making variables private (did it mean final)

Harness Class: Harness constructor 1 & constructor 2 (6 marks)
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment: 6 - i did this

Harness Class: checkHarness method (5 marks)
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment: 5 - i have done this

Harness Class: isHarnessOnLoan method (2 marks)
My method has no parameters and returns the value of the loan status variable.
Comment: 2 - it does this

Harness Class: canHarnessBeLoaned method (4 marks)
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment: 4 -it returns a boolean

Harness Class: loanHarness method (6 marks)
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment: 6 - it does as described

Harness Class: returnHarness method (5 marks)
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment: 5 - no parameters are taken and does this

Harness Class: toString method (3 marks)
My method returns a String representation of all the member variables.
Comment: 3 - used toString()

HarnessRecords Class: member variables (3 marks)
I declare the member variable as a private collection of Harnesses
Comment: 3 - i do

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks)
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the Java I/O to read data from a text file I created containing sets of Harness characteristics. I use these set of characteristics to create Harness objects and add them to the collection.
Comment: 7 - not sure if my file reader is correct

HarnessRecords Class: isEmpty method (1 marks)
I return true if the collection is null/empty and, false otherwise.
Comment: 1 - it does

HarnessRecords Class: addHarness method (5 marks)
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment: 5 - my program does this

HarnessRecords Class: findHarness method (6 marks)
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment: 6 - loops thru and finds a harness

HarnessRecords Class: checkHarness method (6 marks)
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment: 6 - it does this

HarnessRecords Class: loanHarness method (7 marks)
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment: 7 - it loans the harness

HarnessRecords Class: returnHarness method (7 marks)
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment: 7 - it returns the harness

HarnessRecords Class: removeHarness method (8 marks)
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment:8 - it removes the harness

GUI (Java main line) (5 marks)
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: 0 - i left my program too late to complete to do this
*/


public class Harness {

    static final int MAX_TIMES_USED = 25;
    String make;
    int modelNumber;
    int timesUsed;
    String instructorName;
    boolean onLoan;
    String borrower;

    public Harness(String make, int modelNumber, int timesUsed, String instructorName, boolean onLoan, String borrower) {
        this.make = make;
        this.modelNumber = modelNumber;
        this.timesUsed = timesUsed;
        this.instructorName = instructorName;
        this.onLoan = onLoan;
        this.borrower = borrower;
    }
    public Harness(String make, int modelNumber, int timesUsed, String instructorName, boolean onLoan) {
        this.make = make;
        this.modelNumber = modelNumber;
        this.timesUsed = timesUsed;
        this.instructorName = instructorName;
        this.onLoan = onLoan;
    }
    public Harness(String make, int modelNumber, String instructorName) {
        this.make = make;
        this.modelNumber = modelNumber;
        this.instructorName = instructorName;
        this.timesUsed = 0;
        this.onLoan = false;
        this.borrower=null;
    }

    public void checkHarness(String instructorName){
        if(!onLoan) {
            timesUsed = 0;
            this.instructorName = instructorName;
        }
    }

    public boolean isHarnessOnLoan(){
    return onLoan;
    }

    public boolean canHarnessBeLoaned(){
    if(!isHarnessOnLoan() && timesUsed < MAX_TIMES_USED)
    {
        return true;
    }
    return false;
    }

    public void loanHarness(String borrower){
        if(canHarnessBeLoaned())
            this.borrower = borrower;
            this.onLoan = true;
    }

    public static int getMaxTimesUsed() {
        return MAX_TIMES_USED;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(int timesUsed) {
        this.timesUsed = timesUsed;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public void returnHarness(Harness harness){
        if(isHarnessOnLoan())
        {
            harness.onLoan = false;
            borrower = null;
        }
    }

    @Override
    public String toString() {
        return "Harness{" +
                "make='" + make + '\'' +
                ", modelNumber=" + modelNumber +
                ", timesUsed=" + timesUsed +
                ", instructorName='" + instructorName + '\'' +
                ", onLoan=" + onLoan +
                ", borrower='" + borrower + '\'' +
                '}';
    }
}
