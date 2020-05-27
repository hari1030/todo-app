import java.io.*;
import java.util.*;
public class Todo
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException, ClassCastException
	{
		FileOutputStream wr;
		ObjectOutputStream os;
		FileInputStream rd;
		ObjectInputStream oi;
		ArrayList<Object> li;
		data te;
		int choice,si=2;
		Scanner in=new Scanner(System.in);
		/*File file=new File("dat.ser");
		file.createNewFile();
		wr=new FileOutputStream("dat.ser");
		os=new ObjectOutputStream(wr);
		li=new ArrayList<Object>();
		te=new data();
		System.out.println("enter subject, date, month and year");
		te.sub=in.nextLine();
		te.da=in.nextInt();
		te.mo=in.nextInt();
		te.ye=in.nextInt();
		li.add(te);
		os.writeObject(li);
		os.close();
		wr.close();
		*/
		while(true)
		{
		System.out.println("1.list\n2.add\n3.delete\n4.updatae\n5.back");
		choice=in.nextInt();
		int id;
		switch(choice)
		{
		case 1:
			rd=new FileInputStream("dat.ser");
			oi =new ObjectInputStream(rd);
			li=(ArrayList<Object>)oi.readObject();
			for(int i=0;i<li.size();i++)
			{
					te=new data();
					te=(data) li.get(i);
					System.out.println("id: "+i+"\tmsg: "+te.sub+"\tdate: "+te.da+"-"+te.mo+"-"+te.ye);
			}
			oi.close();
			rd.close();
			break;
		case 2:
			rd=new FileInputStream("dat.ser");
			oi =new ObjectInputStream(rd);
			li=(ArrayList<Object>)oi.readObject();
			te=new data();
			System.out.println("enter subject, date, month and year");
			in.nextLine();
			te.sub=in.nextLine();
			te.da=in.nextInt();
			te.mo=in.nextInt();
			te.ye=in.nextInt();
			oi.close();
			rd.close();
			li.add(te);
			wr=new FileOutputStream("dat.ser");
			os=new ObjectOutputStream(wr);
			os.writeObject(li);
			os.close();
			wr.close();
			break;
		case 3:
			rd=new FileInputStream("dat.ser");
			oi =new ObjectInputStream(rd);
			li=(ArrayList<Object>)oi.readObject();
			System.out.println("enter id to delete");
			id=in.nextInt();
			li.remove(id);
			wr=new FileOutputStream("dat.ser");
			os=new ObjectOutputStream(wr);
			os.writeObject(li);
			os.close();
			wr.close();
			break;
		case 4:
			rd=new FileInputStream("dat.ser");
			oi =new ObjectInputStream(rd);
			li=(ArrayList<Object>)oi.readObject();
			System.out.println("enter id to updatae");
			id=in.nextInt();
			li.remove(id);
			System.out.println("enter new subject, date, month and year");
			te=new data();
			in.nextLine();
			te.sub=in.nextLine();
			te.da=in.nextInt();
			te.mo=in.nextInt();
			te.ye=in.nextInt();
			li.add(id,te);
			wr=new FileOutputStream("dat.ser");
			os=new ObjectOutputStream(wr);
			os.writeObject(li);
			os.close();
			wr.close();
			break;
		case 5:
			System.exit(0);
		}
		}
	}
}
