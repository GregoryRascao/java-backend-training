public class SwitchWithoutBreak {

    public static void main(String[] args)
    {
        int day = 10;
        String dayType;

        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                dayType = "Week day";
                break;
            case 6:
            case 7:
                dayType = "Yaay, Weekend";
                break;
            default:
                dayType = "Invalid day";
        }

        System.out.println("Day: " + dayType);
    }
}
