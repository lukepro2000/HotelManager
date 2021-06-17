package testing;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import hotel.IData;
import hotel.InHotel;

public class InHotelMockTest {

	//����һ��Mockery����
    private Mockery context=new Mockery();
    private IData iData=null;
    private InHotel ih=null;
	
	//�ù��������Mockeryʵ��������һ��ģ���iData����
    @Before
    public void setUp() throws Exception{
   	 iData=context.mock(IData.class);
   	 ih=new InHotel(iData);
   	 //����in_Out_Room����һ��
   	 context.checking(new Expectations(){{
   		allowing(iData).in_Out_Room(901, "Marty");
   		will(onConsecutiveCalls(returnValue("Marty�ɹ���ס901���䣡"),returnValue("�÷����Ѿ�������ס")));
   		 }});
     }
    @Test
	public void testIn() {
          //����
		assertEquals("Marty�ɹ���ס901���䣡",ih.in(901, "Marty"));
		assertEquals("�÷����Ѿ�������ס",ih.in(901, "Marty"));
	}
}
