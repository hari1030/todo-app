import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class start {
	public static void main(String args[]) throws Exception
	{
		
		FileInputStream rd = new FileInputStream("dat.ser");
		ObjectInputStream oi = new ObjectInputStream(rd);
		ArrayList<Object> li = (ArrayList<Object>)oi.readObject();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		//System.out.println(year+" "+month+" "+day);
		for(int i=0;i<li.size();i++)
		{
				data te = new data();
				te=(data) li.get(i);
				if((year==te.ye)&&(month+1==te.mo)&&(day==te.da))
				System.out.println("id: "+i+"\tmsg: "+te.sub+"\tdate: "+te.da+"-"+te.mo+"-"+te.ye);
		}
		oi.close();
		rd.close();
	}
}
