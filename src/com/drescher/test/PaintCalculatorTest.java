package com.drescher.test;

import java.util.ArrayList;

import org.junit.Test;

import com.drescher.Paint;
import com.drescher.PaintCalculator;
import com.drescher.Surface;
import com.drescher.Wall;
import com.drescher.Window;

import junit.framework.TestCase;

public class PaintCalculatorTest extends TestCase{
	ArrayList<Surface> paintableSurfaces;
	ArrayList<Surface> nonPaintableSurfaces;
	Paint p;
	
	@Override
	protected void setUp() throws Exception {
		//set up test data
		p = new Paint(400, 50, "12345");
		paintableSurfaces = new ArrayList<Surface>();
		nonPaintableSurfaces = new ArrayList<Surface>();
		Wall wall1 = new Wall (20,10);
		Wall wall2 = new Wall (20,10);
		Wall wall3 = new Wall (20,10);
		Wall wall4 = new Wall (20,10);
		paintableSurfaces.add(wall1);
		paintableSurfaces.add(wall2);
		paintableSurfaces.add(wall3);
		paintableSurfaces.add(wall4);
		
		Window window1 = new Window (4,5);
		nonPaintableSurfaces.add(window1);	
	}
	
	@Test
	public void testMain() {
		//mock up command line arguments
		PaintCalculator.main(new String[]{"-wall","20|10","-wall","25|10","-wall","20|10","-wall","25|10","-door","3|7","-window","3|5","-window","3|5","-window","5|7","-paintPrice","50","-paintSku","12345","-paintCoverage","350"});
	}

	@Test
	public void testCalculateArea() {
		PaintCalculator tester = new PaintCalculator();
		assertEquals("Surface are must be 800", 800, tester.calculateArea(paintableSurfaces));
	}

	@Test
	public void testCalculateGallons() {
		PaintCalculator tester = new PaintCalculator();
		assertEquals("Gallons must equal 2", 2.0, tester.calculateGallons(1200,400,p));
	}

	@Test
	public void testCalculatePrice() {
		PaintCalculator tester = new PaintCalculator();
		assertEquals("Price must equal 100", 100.0, tester.calculatePrice(1200,400,p));
	}

}
