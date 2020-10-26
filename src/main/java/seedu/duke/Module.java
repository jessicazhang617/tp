package seedu.duke;

public class Module {
    String modName;
    String lecSlot;
    String tutSlot;
    String labSlot = null;
    int lecDay;
    int tutDay;
    int labDay;
    String lecTime;
    String tutTime;
    String labTime;

    public Module(String mod, String lec, String tut, String lab) {
        this.modName = mod;
        this.lecSlot = lec;
        this.tutSlot = tut;
        this.labSlot = lab;
        setSlot();
    }

    public Module(String mod, String lec, String tut) {
        this.modName = mod;
        this.lecSlot = lec;
        this.tutSlot = tut;
        setSlot();
    }

    public Module(String mod) {
        this.modName = mod;
    }

    public void setSlot() {
        String lecDay = this.lecSlot.substring(0, this.lecSlot.indexOf(" "));
        this.lecDay = weekOfDay(lecDay);
        this.lecTime = this.lecSlot.substring(this.lecSlot.indexOf(" ")).trim();
        String tutDay = this.tutSlot.substring(0, this.tutSlot.indexOf(" "));
        this.tutDay = weekOfDay(tutDay);
        this.tutTime = this.tutSlot.substring(this.tutSlot.indexOf(" ")).trim();
        if (this.labSlot != null) {
            String labDay = this.labSlot.substring(0, this.labSlot.indexOf(" "));
            this.labDay = weekOfDay(labDay);
            this.labTime = this.labSlot.substring(this.labSlot.indexOf(" ")).trim();
        }

    }

    public String lecText() {
        return this.lecTime + " " + this.modName + " lecture";
    }

    public String tutText() {
        return this.tutTime + " " + this.modName + " tutorial";
    }

    public String labText() {
        return this.labTime + " " + this.modName + " lab";
    }

    public int weekOfDay(String day) {
        int dayValue = 0;
        switch (day) {
        case "Sun":
            dayValue = 1;
            break;
        case "Mon":
            dayValue = 2;
            break;
        case "Tue":
            dayValue = 3;
            break;
        case "Wed":
            dayValue = 4;
            break;
        case "Thur":
            dayValue = 5;
            break;
        case "Fri":
            dayValue = 6;
            break;
        case "Sat":
            dayValue = 7;
            break;
        default:
            System.out.println("Sorry, the day value was not recognized. ");
            System.exit(1);
        }
        return dayValue;

    }
}