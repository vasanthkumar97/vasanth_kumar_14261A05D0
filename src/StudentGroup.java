import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		if (this.students==null) {
			throw new IllegalArgumentException();
			
		}
		
		
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		if(students.length<0) {
			throw new IllegalArgumentException();

		}
		for (int i=0;i<students.length;i++) {
		this.students[i]=students[i];
	}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if (index<0 || index>this.students.length)
		{
			throw new IllegalArgumentException();

		}
		return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student==null||index>this.students.length) {
			throw new IllegalArgumentException();

		}
		this.students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null) {
			throw new IllegalArgumentException();

		}
		Student[] temp_students = new Student[this.students.length+1];
		int i;
		temp_students[0]=student;
		
		for(i=0;i<this.students.length;i++) {
			temp_students[i+1]=this.students[i];
			
		}
		for(i=0;i<temp_students.length;i++) {
			this.students[i]=temp_students[i];
			
		}
		
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		this.students[this.students.length]=student;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student==null||index>this.students.length) {
			throw new IllegalArgumentException();

		}
		Student[] temp_students = new Student[this.students.length+1];
		int i;
		for (i=0;i<index;i++) {
			temp_students[i]=this.students[i];
		}
		temp_students[index]=student;
		for(i=i+0;i<this.students.length;i++) {
			temp_students[i+1]=this.students[i];
			
		}
		for(i=0;i<temp_students.length;i++) {
			this.students[i]=temp_students[i];
			
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index>this.students.length) {
			throw new IllegalArgumentException();

		}
		Student[] temp_students = new Student[this.students.length-1];
		int i;
		for (i=0;i<index;i++) {
			temp_students[i]=this.students[i];
		}
		for(i=i+1;i<this.students.length;i++) {
			temp_students[i-1]=this.students[i];
			
		}
		Arrays.copyOf(this.students, this.students.length-1);

		for(i=0;i<temp_students.length;i++) {
			this.students[i]=temp_students[i];
			
		}
		
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null) {
			throw new IllegalArgumentException();

		}
		Student[] temp_students = new Student[this.students.length-1];
		int i=0,count=0,j=0;
		for (i=0;i<this.students.length;i++) {
			if(this.students[i].equals(student)&&count==0) {
				count=1;
				continue;
			}
			temp_students[j]=this.students[i];
			j++;
		}
		Arrays.copyOf(this.students, this.students.length-1);

		for(i=0;i<temp_students.length;i++) {
			this.students[i]=temp_students[i];
			
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		Student[] temp_students = new Student[index+1];
		int i;
		if (index>this.students.length)
		{
			throw new IllegalArgumentException();
		}
		for(i=0;i<=index;i++) {
			temp_students[i]=this.students[i];
		}
		Arrays.copyOf(this.students, temp_students.length-1);
		for(i=0;i<temp_students.length;i++) {
			this.students[i]=temp_students[i];
			
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if (student==null)
		{
			throw new IllegalArgumentException();
		}
		Student[] temp_students = new Student[this.students.length-1];
		int i=0,j=0;
		for (i=0;i<this.students.length;i++) {
			
			temp_students[i]=this.students[i];
			if(this.students[i].equals(student)) {
				break;
			}
		}
		Arrays.copyOf(this.students, temp_students.length-1);
		for(j=0;j<=i;j++) {
			this.students[j]=temp_students[j];
			
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if (index>this.students.length)
		{
			throw new IllegalArgumentException();
		}
		int i,j;
		Student[] temp_students = new Student[index+1];
		
		for(i=index,j=0;i<this.students.length;i++) {
			temp_students[j]=this.students[i];
			j++;
		}
		Arrays.copyOf(this.students, temp_students.length-1);
		for(i=0;i<=index;i++) {
			this.students[i]=temp_students[i];
			
		}
		
		
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if (student==null)
		{
			throw new IllegalArgumentException();
		}
		int i;
		Student[] temp_students = new Student[this.students.length];
		for (i=0;i<this.students.length;i++) {
			
			temp_students[i]=this.students[i];
			if(this.students[i].equals(student)) {
				break;
			}
		}
		int index=i,j=0;
		for(i=index;i<this.students.length;i++) {
			temp_students[i]=this.students[i];
		}
		Arrays.copyOf(this.students, temp_students.length-1);
		for(i=0;i<=index;i++) {
			this.students[i]=temp_students[i];
			
		}
		
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		Student temp;
		//sorting with respect to id
		for(int i=0; i < this.students.length; i++){  
            for(int j=1; j < (this.students.length-i); j++){  
                     if(this.students[j-1].getId() > this.students[j].getId()){  
                            //swap elements  
                            temp = this.students[j-1];  
                            this.students[j-1] = this.students[j];  
                            this.students[j] = temp;  
                    }  
                     
            }  
    }  

	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if (date==null) {
			throw new IllegalArgumentException();
		}
		int count=0;
		Student[] temp_student=new Student[this.students.length];
		for(int i=0;i<this.students.length;i++) {
			if (this.students[i].getBirthDate()==date) {
				temp_student[count]= this.students[i];
				count++;
			}
		}
		if (temp_student.length>0) {
			Arrays.copyOf(temp_student, count-1);
			return temp_student;
			}
			return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if (firstDate==null||lastDate==null) {
			throw new IllegalArgumentException();
		}
		int count=0;
		int first_year=firstDate.getYear();
		int last_year=lastDate.getYear();
		int first_month=firstDate.getMonth();
		int last_month=lastDate.getMonth();
		int first_day=firstDate.getDay();
		int last_day=lastDate.getDay();


		Student[] temp_student=new Student[this.students.length];
		for(int i=0;i<this.students.length;i++) {
			int year=this.students[i].getBirthDate().getYear();
			int month=this.students[i].getBirthDate().getMonth();
			int day=this.students[i].getBirthDate().getDay();
			if (year>=first_year && month>=first_month && day >= first_day && year<=last_year && month<=last_month && day <= last_day) {
				temp_student[count]= this.students[i];
				count++;
			}
		}
		if (temp_student.length>0) {
			Arrays.copyOf(temp_student, count-1);
			return temp_student;
			}
			return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		if (date==null&&days<0) {
			throw new IllegalArgumentException();
		}
		
		int count=0;
		Student[] temp_student=new Student[this.students.length];
		int first_year=date.getYear();
		int first_day=date.getDay();
		int first_month=date.getMonth();
		for(int i=0;i<this.students.length;i++) {
			int year=this.students[i].getBirthDate().getYear();
			int month=this.students[i].getBirthDate().getMonth();
			int day=this.students[i].getBirthDate().getDay();
			if ((year==first_year && month==first_month)&&(day>=first_day||day<=first_day+days)) {
				temp_student[count]= this.students[i];
				count++;
			}
		}
		if (temp_student.length>0) {
			Arrays.copyOf(temp_student, count-1);
			return temp_student;
			}
			return null;
	}
	
	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		Date dob=this.students[indexOfStudent].getBirthDate();
		int year=dob.getYear();
		int month=dob.getMonth();
		int day=dob.getDay();
		Calendar now = Calendar.getInstance();
		int current_year = now.get(Calendar.YEAR);
		int current_month=now.get(Calendar.MONTH);
		int current_day=now.getMaximum(Calendar.DAY_OF_MONTH);
		if (current_month>=month) {
			if(current_month>month) {
				return (current_year-year)%100;
			}
			else {
			if (current_day>=day) {
				return (current_year-year)%100;
			}
			else {
				return (current_year-year-1)%100;
			}
			}
		}
		return (current_year-year)%100;
		
		
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		Student[] temp_student=new Student[this.students.length];
		int i,count=0;
		
		for (i=0;i<this.students.length;i++) {
			if (getCurrentAgeByDate(i)==age) {
				temp_student[count]=this.students[i];
				count++;
			}
		}
		if (temp_student.length>0) {
		Arrays.copyOf(temp_student, count-1);
		return temp_student;
		}
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max = this.students[0].getAvgMark();
		int count=0;
		Student[] st=new Student[this.students.length];
        for(int i = 0; i < this.students.length; i++)
        {
            if(max < this.students[i].getAvgMark())
            {
                max = this.students[i].getAvgMark();
            }
        }
        for(int i=0;i<this.students.length;i++) {
        	if (max==this.students[i].getAvgMark()) {
        		st[count]=this.students[i];
        		count++;
        	}
        }
        if (st.length>0) {
		Arrays.copyOf(st, count-1);
		return st;
        }
        
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if (student==null)
		{
			throw new IllegalArgumentException();
		}
		int i;
		for (i=0;i<this.students.length;i++) {
			
			if(this.students[i].equals(student)) {
				break;
			}
		}
		
		return this.students[i+1];
	}
}
