package DAY_19_CSV;
import java.io.*;
import java.util.Scanner;

public class AverageSalaryCalculate {
    //to calculate the average of the salaries of all the employees
    public static double calculateAverageSalary() throws FileNotFoundException {
        File file = new File("C:/Users/91774/Downloads/employees.csv");
        Scanner sc = new Scanner(file);
        double average = 0;
        String line = sc.nextLine();
        while (sc.hasNext()) {
             line = sc.nextLine();
            String[] s = line.split(",");
            String employee_id = s[0];
            String first_name = s[1];
            String last_name = s[2];
            String email = s[3];
            String phoneNumber = s[4];
            String hire_date = s[5];
            String job_id = s[6];
            int salary = Integer.parseInt(s[7]);
            average+=salary;
            System.out.println("EmployeeId: " + employee_id + ", First Name: " + first_name + ", Last Name: " + last_name + ", Email: " + email + ", PhoneNumber: " + phoneNumber + ", Hire Date: " + hire_date + ", Job_id" + job_id + ", Salary: " + salary);
        }

        System.out.println("Average salary is : "+average/50);
        sc.close();
        return average/50;
    }
    //To find the employees whose salary is above than the average salary
    public static void aboveAverage(double average) throws IOException {
         File file = new File("C:/Users/91774/Downloads/employees.csv");
         Scanner sc = new Scanner(file);
         //Create new file
        File file1= new File("C:/Users/91774/Desktop/AVI soft/DAY_19_CSV/outputFile.csv");
//        file1.createNewFile();
        FileWriter fileWriter= new FileWriter(file1);
        fileWriter.write("Employee id"+ ", First Name"+", Last Name"+", Salary"+"\n");
         String line=sc.nextLine();
         while(sc.hasNext())
         {
             line=sc.nextLine();
             String arr[]=line.split(",");
             String employee_id=arr[0];
             String first_name=arr[1];
             String last_name=arr[2];
             int salary=Integer.parseInt(arr[7]);
             if(salary>average)
             {
                fileWriter.write(employee_id+ ", "+ first_name+", "+last_name+ ", "+ salary+"\n");
             }
         }
         fileWriter.close();
    }
    public static void main(String[] args) throws IOException
    {
        double average=calculateAverageSalary();
        aboveAverage(average);
    }
}


