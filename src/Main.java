
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		
		StudentGroup sg=new StudentGroup(5);
		Student[] students=new Student[5];
		
		students[0]=new Student(1,"abc",fmt.parse("2013-05-06"),40);
		students[1]=new Student(0,"def",fmt.parse("2013-05-06"),40);
		students[2]=new Student(2,"ghj",fmt.parse("2013-05-06"),40);
		students[3]=new Student(3,"ijk",fmt.parse("2013-05-06"),40);
		students[4]=new Student(4,"lmn",fmt.parse("2013-05-06"),40);

		sg.setStudents(students);
		
		System.out.println(sg.getStudents());
		System.out.println(sg.getStudentsWithMaxAvgMark());
		System.out.println(sg.getStudentsByAge(4));
		System.out.println(sg.getCurrentAgeByDate(0));

		}

}
