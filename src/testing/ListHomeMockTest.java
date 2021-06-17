package testing;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import hotel.IData;
import hotel.ListHome;

public class ListHomeMockTest {

	//����һ��Mockery����
    private Mockery context=new Mockery();
    private IData iData=null;
    private ListHome lh=null;
	
	//�ù��������Mockeryʵ��������һ��ģ���iData����
    @Before
    public void setUp() throws Exception{
   	 iData=context.mock(IData.class);
   	 lh=new ListHome(iData);
   	 context.checking(new Expectations(){{
   		oneOf(iData).getStation(901);  //����getStation��ѯ����ס�ķ���
   		will(returnValue("Marty"));
   		 }});
   	context.checking(new Expectations(){{
   		oneOf(iData).getStation(801);  //����getStation��ѯ�շ���
   		will(returnValue("EMPTY"));
   		 }});
     }
    @Test
	public void testSearch() {
    	assertEquals("Marty",lh.search(901));
		assertEquals("EMPTY",lh.search(801));
	}

}
