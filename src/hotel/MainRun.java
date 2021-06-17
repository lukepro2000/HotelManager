package hotel;

import java.util.Scanner;
public class MainRun {
	private static ListHome lh=null;
	private static InHotel ih=null;
	private static OutHotel oh=null;
	static IData id ;
	public MainRun(IData iData){
		this.id=iData;
	}
	public MainRun(){

	}
	 public String CommandExit(String command) {
		 if ("exit".equalsIgnoreCase(command)) {
				return "�����˳�";
			} else {
				return "���������������������";
			}
		}
	 
	 public String CommandSearch(String command,int roomNo) {
		 String result="����Ŵ�!";
			if( validRoomNo(roomNo)){
				lh=new ListHome(id);
				result=lh.search(roomNo);
				}
			return result;
	}
	
	 public String CommandIn(String command,int roomNo,String name) {
		String result="����Ŵ�!";
				if( validRoomNo(roomNo)){
					ih=new InHotel(id);
					result=ih.in(roomNo, name);; 
					}
				return result;
	}
	 public String CommandOut(String command,int roomNo) {
		 String result="����Ŵ�!";
				if( validRoomNo(roomNo)){
					oh=new OutHotel(id);
					result=oh.out(roomNo);
					}	
				return result;
			}
	private static  boolean validRoomNo(int roomNo){
		if((roomNo/100>10)||(roomNo/100<1)||(roomNo%100>12)||(roomNo%100<1))
			{
				return false;}
			else 
				{return true;}		
	}
	
}

