import java.lang.*;
import java.util.*;

//create table student(RID int, Name varchar(255), Salary int);
//Database table / Schema
class Student
{
	public int RID;
	public String Name;
	public int Salary;

	private static int Generator;

	static
	{
		Generator = 0;
	} 

	public Student(String str, int value)
	{
		this.RID = ++Generator;
		this.Name = str;
		this.Salary = value;
	}

	public void DisplayData()
	{
		System.out.println(this.RID +"\t"+ this.Name +"\t"+ this.Salary);
	}
}

class DBMSx
{

	public LinkedList <Student> lobj;

	public DBMSx()
	{
		lobj = new LinkedList<>();
	}

	//Insert into student Piyush 1000;
	//Select * from student;
	public void StartDBMS()
	{
		Scanner scanobj = new Scanner(System.in);

		System.out.println("Marvellous Customised DBMS started successfully.....");
		String Query ="";

		while(true)
		{
			System.out.print("Marvellous DBMS console >");
			Query = scanobj.nextLine().toLowerCase();

			String tokens[] = Query.split(" ");
			int QuerySize = tokens.length;

			if(QuerySize == 1)
			{
				if("help".equals(tokens[0]))
				{
					System.out.println("This application is used to demonstrate the customised DBMS");
					System.out.println("Exit : Terminate DBMS");
					System.out.println("Display all data : select * from student");
					System.out.println("Display data by RID  : select RID enter_RID from student");
					System.out.println("Display data by Name  : select NAME enter_NAME from student");
					System.out.println("Insert data : Insert into student name salary");
					System.out.println("Delete record by Name : delete from student where name enter_name");
					System.out.println("Delete record by RID : delete from student where RID enter_RID");
				}
				else if("exit".equals(tokens[0]))
				{
					System.out.println("Thankyou for using Marvellous DBMS");
					break;
				}
			}
			else if(QuerySize == 4)
			{
				if("select".equals(tokens[0]))
				{
					if("*".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							DisplayAll();
						}
					}
					else if("rid".equals(tokens[1]))
					{
						DisplaySpecific(Integer.parseInt(tokens[2]));
					}
					else if("name".equals(tokens[1]))
					{
						DisplaySpecific(tokens[2]);
					}
				}
			}
			else if(QuerySize == 5)
			{
				//Insert into student Piyush 1000;
				if("insert".equals(tokens[0]))
				{
					if("into".equals(tokens[1]))
					{
						InsertData(tokens[3],Integer.parseInt(tokens[4]));
					}
				}
			}
			else if(QuerySize == 6)
			{
				if("delete".equals(tokens[0]))
				{
					if("where".equals(tokens[3])
					{
						if("name".equals(tokens[4]))
						{
							DeleteSpecific(tokens[5]);
						}
						else if("rid".equals(tokens[4]))
						{
							DeleteSpecific(Integer.parseInt(tokens[5]));
						}

					} 
				}
			}
		}

	} 


	public void InsertData(String str, int value)
	{
		Student sobj = new Student(str,value);
		lobj.add(sobj);
	}

	//Display without any condition
	public void DisplayAll()
	{
		for(Student sref : lobj)
		{
			sref.DisplayData();
		}
	}

	//Display By RID
	public void DisplaySpecific(int rid)
	{
		for(Student sref : lobj)
		{
			if(sref.RID == rid)
			{
				sref.DisplayData();
				break;
			}
		}
	}

	//Display By Name
	public void DisplaySpecific(String str)
	{
		for(Student sref : lobj)
		{
			if(str.equals(sref.Name))
			{
				sref.DisplayData();
			}
		}
	}

	//Delete by RID
	public void DeleteSpecific(int rid)
	{
		int index = 0;

		for(Student sref : lobj)
		{
			if(sref.RID == rid)
			{
				lobj.remove(index);
				break;
			}
			index++;
		}
	}

	//Delete by Name
	public void DeleteSpecific(String str)
	{
		int index = 0;

		for(Student sref : lobj)
		{
			if(str.equals(sref.Name))
			{
				lobj.remove(index);
				break;
			}
			index++;
		}
	}

	public void AggregateMax()
	{
		int iMax = 0;
		Student temp = null;

		for(Student sref : lobj)
		{
			if(sref.Salary > iMax)
			{
				iMax = sref.Salary;
				temp = sref;
			}
		}

		System.out.println("Information of student having maximum salary : ");
		temp.DisplayData();
	}

	public void AggregateMin()
	{
		int iMin = (lobj.getFirst()).Salary;
		Student temp = lobj.getFirst();

		for(Student sref : lobj)
		{
			if(sref.Salary < iMin)
			{
				iMin = sref.Salary;
				temp = sref;
			}
		}

		System.out.println("Information of student having minimum salary : ");
		temp.DisplayData();
	}

	public void AggregateSum()
	{
		long iSum = 0;

		for(Student sref : lobj)
		{
				iSum = iSum + sref.Salary;
		}

		System.out.println("Summation of salaries is : "+ iSum);
	}

	public void AggregateAvg()
	{
		int iSum = 0;

		for(Student sref : lobj)
		{
			iSum = iSum + sref.Salary;
		}

		System.out.println("Average of salaries is : "+iSum /(lobj.size()));
	}

	public void AggregateCount()
	{
		System.out.println("Count is : "+lobj.size());
	}

}

class Mydbms
{
	public static void main(String arg[])
	{
		DBMSx dobj = new DBMSx();

		dobj.StartDBMS();
		// dobj.InsertData("Piyush",1000);
		// dobj.InsertData("Sakshi",3000);
		// dobj.InsertData("Sachin",2000);
		// dobj.InsertData("Suraj",10000);
		// dobj.InsertData("Atharva",8000);
		// dobj.InsertData("Supriya",9000);

		
		// // dobj.DisplaySpecific(2);
		// // dobj.DisplaySpecific("Piyush");

		// // dobj.DeleteSpecific(2);
		// // dobj.DeleteSpecific("Piyush");
		// // dobj.DisplayAll();

		// dobj.AggregateMax();
		// dobj.AggregateMin();
		// dobj.AggregateSum();
		// dobj.AggregateAvg();
		// dobj.AggregateCount();

	}
}

