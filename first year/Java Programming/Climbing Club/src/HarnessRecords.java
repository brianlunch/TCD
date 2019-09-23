import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HarnessRecords
{
    private ArrayList <Harness> HarnessArrayList = new <Harness> ArrayList();

    public void HarnessRecords() {
        HarnessArrayList = null;
    }

    public void HarnessRecords(ArrayList harnessArrayList) throws IOException {
        this.HarnessArrayList = harnessArrayList;
        Harness harness;
        FileReader harnessFile = null;
        try {
            harnessFile = new FileReader("src\\Harnesses.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(harnessFile);
        String harnessData;
        while((harnessData = bufferedReader.readLine()) != null)
        {
            String harnessProperties [] = harnessData.split("[,|, ]+");
            String make = harnessProperties[0];
            int model = Integer.parseInt(harnessProperties[1]);
            int timesUsed = Integer.parseInt(harnessProperties[2]);
            String instructorsName = harnessProperties[3];
            boolean onLoan;
            if(harnessProperties[4] == "yes")
                onLoan = true;
            else
                onLoan = false;
            String borrower = harnessProperties[5];
            if (onLoan) {
                harness = new Harness(make, model,timesUsed, instructorsName, onLoan, borrower);
            } else {
                harness = new Harness(make, model,timesUsed, instructorsName, onLoan);
            }
            harnessArrayList.add(harness);
        }
    }

    public boolean isEmpty(ArrayList harnessArrayList){

        if (harnessArrayList == null)
                return true;
        else
            return false;
    }

    public void addHarness(Harness harness, ArrayList harnessArrayList){
        harnessArrayList.add(harness);
    }

    public Harness findHarness(String make, int modelNumber, ArrayList harnessArrayList){
        for (int count = 0; count<harnessArrayList.size();count++)
        {
            Harness harness = (Harness) harnessArrayList.get(0);
            if(harness.getMake().equalsIgnoreCase(make) && harness.getModelNumber()==modelNumber)
                return harness;
        }
        return null;
    }
    public Harness checkHarness(String instructorName, String make, int modelNumber, ArrayList harnessArrayList){
        Harness harness = findHarness(make, modelNumber, harnessArrayList);
        if(harness != null && !harness.onLoan) {
            harness.checkHarness(instructorName);
            return harness;
        }
        else
            return null;
    }

    public Harness loanHarness(String borrower, ArrayList harnessArrayList){
        for (int count = 0; count<harnessArrayList.size();count++)
        {
            Harness harness = (Harness) harnessArrayList.get(count);
            if(harness.canHarnessBeLoaned()) {
                harness.loanHarness(borrower);
                return harness;
            }
        }
        return  null;
    }

    public Harness returnHarness(String make, int model, ArrayList harnessArrayList){
        Harness harness = findHarness(make,model,harnessArrayList);
        if(harness != null){
            harness.returnHarness(harness);
            return harness;
        }
        else
            return null;
    }

    public Harness removeHarness(String make, int model, ArrayList harnessArrayList){
        Harness harness;
        harness = findHarness(make, model, harnessArrayList);
        if(harness != null) {
            harnessArrayList.remove(findHarness(make, model, harnessArrayList));
            return harness;
        }
        else
            return null;
    }


}

