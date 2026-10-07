import java.util.*;
public class Basic{

    public static void main (String []args){
        String name,college;
        int age;
        float CGPA;
        char gender;

        Scanner sc = new Scanner(System.in);
        
        System.out.println("==============================");
        System.out.println("    STUDENT INFORMATION SYSTEM");
        System.out.println("==============================\n");
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your age: ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your college: ");
        college = sc.nextLine();
        System.out.print("Enter your CGPA: ");
        CGPA = sc.nextFloat();
        System.out.print("Enter your gender as M 0r F: ");
        gender = sc.next().charAt(0);
        System.out.println("--------------------------------");
        System.out.println("Student Details");
        System.out.println("--------------------------------");
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("College : " + college);
        System.out.println("CGPA : " + CGPA);
        System.out.println("Gender : " + gender);
        System.out.println("--------------------------------");
        System.out.println("Type Casting");
        System.out.println("--------------------------------");
        int cgpa = (int) CGPA;
        System.out.println(cgpa);
        System.out.println("--------------------------------");
        System.out.println("Operators");
        System.out.println("--------------------------------");
        int a,b;
        System.out.println("Enter two numbers: ");
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println("Addition       : " + (a + b));
        System.out.println("Subtraction    : " + (a - b));
        System.out.println("Multiplication : " + (a * b));
        if (b != 0)
        {
            System.out.println("Division       : " + (a / b));
            System.out.println("Remainder      : " + (a % b));
        }
        else
        {
            System.out.println("Division       : Cannot divide by zero");
            System.out.println("Remainder      : Cannot divide by zero");
        }
        System.out.println("--------------------------------");
        System.out.println("Math Operations");
        System.out.println("--------------------------------");
        int num1,num2;
        System.out.println("Enter two numbers: ");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        System.out.println(Math.max(num1, num2));
        System.out.println(Math.min(num1, num2));
        System.out.println(Math.pow(num1, num2));
        System.out.println(Math.sqrt(num1));
        System.out.println(Math.random());
        System.out.println("--------------------------------");
        System.out.println("String Operations");
        System.out.println("--------------------------------");
        String word;
        System.out.print("Enter Any Word: ");
        word = sc.next();
        System.out.println(word.length());
        System.out.println(word.toUpperCase());
        System.out.println(word.toLowerCase());
        System.out.println(word.charAt(0));
        System.out.println(word.charAt(word.length()-1));
        System.out.println("--------------------------------");
        System.out.println("Boolean");
        System.out.println("--------------------------------");
        Boolean vote = age >= 18;
        System.out.println("Eligible for Vote?: ");
        String message = vote ? "Yes, you are eligible for voting." : "No, you are not eligible for voting.";
        System.out.println(message);
        System.out.println("--------------------------------");
        System.out.println("Decision Making");
        System.out.println("--------------------------------");
        int mark;
        System.out.println("Enter Marks: ");
        mark = sc.nextInt();
        if (mark < 0 || mark > 100)
        {
        System.out.println("Invalid Marks");
        }
        else if (mark>=90){
            System.out.println("Grade: 'A' ");
        }
        else if (mark>=80){
            System.out.println("Grade: 'B' ");
        }
        else if (mark>=70){
            System.out.println("Grade: 'C' ");
        }
        else if (mark>=50){
            System.out.println("Grade: 'D' ");
        }
        else {
            System.out.println("Fail");
        }
        int day;
        System.out.print("Enter a number 1 to 7 : ");
        day = sc.nextInt();
        switch(day){
            case 1:
            System.out.println("Monday");
            break;
            case 2:
            System.out.println("Tuesday");
            break;
            case 3:
            System.out.println("Wednesday");
            break;
            case 4:
            System.out.println("Thursday");
            break;
            case 5:
            System.out.println("Friday");
            break;
            case 6:
            System.out.println("Saturday");
            break;
            case 7:
            System.out.println("Sunday");
            break;
            default:
            System.out.println("Invaild Input");
        }
        System.out.println("--------------------------------");
        // New switch statement
        String Day;
        System.out.print("Enter any Day in a Week: ");
        Day = sc.next();
        switch(Day){
            case "Monday" , "Tuesday" , "Wednesday" , "Thursday" , "Friday"  -> System.out.println("Working Day");
            case "Saturday" , "Sunday" -> System.out.println("Holiday");
            default -> System.out.println("Invaild Input");
        }
        // switch statement using expression 
        String result = "";
        result = switch(Day){
            case "Monday" , "Tuesday" , "Wednesday" , "Thursday" , "Friday"  -> "Working Day";
            case "Saturday" , "Sunday" -> "Holiday";
            default -> "Invaild Input";
        };
        System.out.println(result);
        //switch statement expression without using a arrow
        result = switch(Day){
            case "Monday" , "Tuesday" , "Wednesday" , "Thursday" , "Friday" : yield "Working Day";
            case "Saturday" , "Sunday" : yield "Holiday";
            default : yield "Invaild Input";
        };
        System.out.println(result);
        System.out.println("--------------------------------");
        System.out.println("While Loop");
        System.out.println("--------------------------------");
        int i = 1;
        while(i<=10){
            System.out.println(i);
            i++;
        }
        System.out.println("--------------------------------");
        System.out.println("For Loop");
        System.out.println("--------------------------------");
        int j = 1;
        for(j=1;j<=10;j++){
            System.out.println(j*5);
        }
        System.out.println("--------------------------------");
        System.out.println("Pattern");
        System.out.println("--------------------------------");
        for(i=1;i<=5;i++){
            for(j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}


