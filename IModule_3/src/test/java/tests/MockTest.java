package tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import test.TheCat;
import test.WorkWithResult;

@ExtendWith(MockitoExtension.class)
public class MockTest {

	@Test
	public void MockitoTest () {
	    List <TheCat> mockCat = Mockito.mock(List.class);
	    TheCat cat = new TheCat ("Черныш", 17);
	    when(mockCat.get(0)).thenReturn(cat);
	    
	    WorkWithResult wwr = new WorkWithResult(mockCat);
	    TheCat testCat = wwr.getCat(1);
	    
	    assertEquals(cat, testCat);
	    verify(mockCat, times(1)).get(0);
	}

}


