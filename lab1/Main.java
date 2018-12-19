class Student
{
    int rollno;
    String name;
    Student()
    {
        this.rollno = 0;
        this.name = "jfkh";
    }
    Student(int r, String n)
    {
        this.rollno = r;
        this.name = n;
    }
}
class Main
{
    public static void main(String args[])
    {
        Student stu = new Student(27, "gjjh");
        
    }
}