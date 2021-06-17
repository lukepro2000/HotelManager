package testing;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import hotel.IData;
import hotel.MainRun;

public class MainRunMockTest {
	    private Mockery context=new Mockery();
	    private IData iData=null;
	    private MainRun mr=null;
		
		//�ù��������Mockeryʵ��������һ��ģ���iData����
	    @Before
	    public void setUp() throws Exception{
	   	 iData=context.mock(IData.class);
	   	 mr=new MainRun(iData);
	   	context.checking(new Expectations(){{
	   		allowing(iData).in_Out_Room(901, "Marty");  
	   		will(onConsecutiveCalls(returnValue("Marty�ɹ���ס901���䣡"),returnValue("�÷����Ѿ�������ס")));
  		 }});
	   	context.checking(new Expectations(){{
	   		allowing(iData).in_Out_Room(901, "EMPTY");  
	   		will(onConsecutiveCalls(returnValue("901�˷��ɹ���"),returnValue("�÷���û�п�����ס���˷�ʧ�ܣ�")));
	   		 }}); 
	   	context.checking(new Expectations(){{
	   		oneOf(iData).getStation(801);  
	   		will(returnValue("EMPTY"));
	   		 }});
	}
	
	@Test
	public void testCommandIn() {
		assertEquals("Marty�ɹ���ס901���䣡",mr.CommandIn("in",901,"Marty"));
		assertEquals("�÷����Ѿ�������ס",mr.CommandIn("in",901,"Marty"));
		assertEquals("����Ŵ�!",mr.CommandIn("in",999,"Thomas"));
	}
	@Test
	public void testCommandOut() {
		assertEquals("901�˷��ɹ���",mr.CommandOut("out",901));
		assertEquals("�÷���û�п�����ס���˷�ʧ�ܣ�",mr.CommandOut("out",901));
		assertEquals("����Ŵ�!",mr.CommandOut("out",999));
	}
	@Test
	public void testCommandsearch() {
		assertEquals("EMPTY",mr.CommandSearch("search", 801));
		assertEquals("����Ŵ�!",mr.CommandSearch("search", 999));
	}
	@Test
	public void testCommandExit() {
		assertEquals("�����˳�",mr.CommandExit("exit"));
		assertEquals("���������������������",mr.CommandExit("close"));
	}
}
