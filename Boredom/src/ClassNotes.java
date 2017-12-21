import java.util.Scanner;
//make a menu for each of these and accept the choice that we would like to see output to.
//for loop
//while loop
//switch case
//array
/**
 * 
 * @author Liam Grover
 *
 */
public class ClassNotes
{
public static void main (String[] args)
{
int i;//for loop
int c = 0;//while loop
int ans;//if statement
int month;//switch statement
int[] black;//array
int p = 0;//size of array designated by user
int g;//for loop for array
String name;//stephen
Scanner keyboard = new Scanner(System.in);
//Show menu for choices
menu();
ans = keyboard.nextInt();
while (ans!= 10)
    {
        if (ans==1)
        {//for loop
for (i=0 ; i<5 ; i++)
    {
System.out.println("Stephen smells like poop");
    }
}
else if (ans==2)
    {//while loop
        while (c<5)
    {
System.out.println("Dan smells like poop");
c++;
    }
}
else if(ans==3)
    {//switch case
System.out.println("What number month would you like?");
month = keyboard.nextInt();
       String monthString;
       switch (month) {
           case 1:  monthString = "January";
                    break;
           case 2:  monthString = "February";
                    break;
           case 3:  monthString = "March";
                    break;
           case 4:  monthString = "April";
                    break;
           case 5:  monthString = "May";
                    break;
           case 6:  monthString = "June";
                    break;
           case 7:  monthString = "July";
                    break;
           case 8:  monthString = "August";
                    break;
           case 9:  monthString = "September";
                    break;
           case 10: monthString = "October";
                    break;
           case 11: monthString = "November";
                    break;
           case 12: monthString = "December";
                    break;
           default: monthString = "Invalid month";
                    break;
       }
       System.out.println(monthString);
}
else if(ans==4)
{//array
System.out.println("How many integers would you like to place int our database?");
p = keyboard.nextInt();
black = new int[p];
for(g=0; g<p; g++)
{
System.out.println("What would you like to place in the array at point : "+(g+1));
black[g]=keyboard.nextInt();
}
System.out.println("Here is your array.");
for (g=0; g<p; g++)
{
System.out.println("\n"+(g+1)+") "+black[g]);
}
}
else if(ans==5)
{//Stephen's
System.out.println("Just to make sure, what is your name?");
name = keyboard.nextLine();
name = name.toLowerCase();
if (name.equals("stephen"))
{
System.out.println("I hate you so much");
System.out.println("You made my coffee cold!!!!");
}
}
else if (ans==6)
{//Stars
String star = "*";
//diamond
System.out.println("    "+ star);
System.out.println("   "+star+star+star);
System.out.println("  "+star+star+star+star+star);
System.out.println("   "+star+star+star);
System.out.println("    "+ star+"\n\n");
//heart
System.out.println(" "+star+star+"   "+star+star);
System.out.println(star+star+star+star+" "+star+star+star+star);
System.out.println(" "+star+star+star+star+star+star+star);
System.out.println("  "+star+star+star+star+star);
System.out.println("   "+star+star+star);
System.out.println("    "+ star);
}
else if (ans==7)
{//"do" loop
int value;
do
{
System.out.println("You do not want to stay in the loop.");
System.out.println("Please enter an integer < 100 to get out of the loop.");
value= keyboard.nextInt();
}
while (value >= 100);
System.out.println("Congratulations you have escaped the loop :) \n");
}
else if (ans==8)
{//1+2+...+n
double n=1.00;
while(n<=100)
{
System.out.print(n+ "\t");
double total = ((1.00+n)*(n/2.00));
//this is the formula to calculate 1+2+.....+n
System.out.println(ans+ "\n");
n++;
}
//Do loop
//do 
//{
// System.out.print(n+ "\t");
// double total = ((1.00+n)*(n/2.00));
// //this is the formula to calculate 1+2+.....+n
// System.out.println(total+ "\n");
// n++;
//}
//while(n<=100);
//for loop
//for(n=1;n<=100;n++)
//{
// System.out.print(n+ "\t");
// double ans = ((1.00+n)*(n/2.00));
// //this is the formula to calculate 1+2+.....+n
// System.out.println(ans+ "\n");
//}
}
else if (ans==9)
{//table of powers
int x;
//setup top menu outside of loop so it doesn't repeat.
System.out.println("x^1 \t x^2 \t x^3 \t x^4");
for(x=1;x<=10;x++)
{
//setup the powers
int first = x;
int second = x*x;
int third = x*x*x;
int fourth = x*x*x*x;
//print the values
System.out.println(first+" \t "+second+" \t "+third+" \t "+fourth);
}
}
else 
{
System.out.println("Error in choice selection");
}
menu();
ans = keyboard.nextInt();
}

}
//Make a menu for the choices
public static void menu()
{
System.out.println("\n Which would you like to see output for?\n");
System.out.println("1) For loop");
System.out.println("2) While loop");
System.out.println("3) Switch case");
System.out.println("4) Array");
System.out.println("5) If youre name is Stephen");
System.out.println("6) Stars");
System.out.println("7) Do loop");
System.out.println("8) Learn the sum of 1+2+...+n");
System.out.println("9) Table of powers");
System.out.println("10) Quit");
}
}


