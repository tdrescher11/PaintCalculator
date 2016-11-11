package com.drescher;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

/**
 * @author thomas.drescher
 * application to determine number of gallons required to paint an interior room 
 * based on room specifications provided via command line arguments
 *
 */
public class PaintCalculator {
	public static final String PIPE = "\\|";
	public static final String CLASS_NAME = PaintCalculator.class.getSimpleName();
	
	public static void main(String[] args) {
		//parse args using custom args class and jcommander library
		CommandLineArgs cla = new CommandLineArgs();
		JCommander cmd = new JCommander(cla);
		cmd.setProgramName(CLASS_NAME);
		try {
	        cmd.parse(args);
	    } catch (ParameterException ex) {
	        System.out.println(ex.getMessage());
	        cmd.usage();
	        System.exit(1);
	    }

		//define arraylists to hold paintable/non paintable objects used later for calculations
		ArrayList<Surface> paintableSurfaces = new ArrayList<Surface>();
		ArrayList<Surface> nonPaintableSurfaces = new ArrayList<Surface>();

		//Add walls to paintable surfaces
		for (String w : cla.walls) {
			String[] parts = w.split(PIPE);
			Wall wall = new Wall();
			wall.setWidth(Integer.parseInt(parts[0]));
			wall.setHeight(Integer.parseInt(parts[1]));
			paintableSurfaces.add(wall);
		}
		
		//Add windows to non-paintable surfaces
		for (String w : cla.windows) {
			String[] parts = w.split(PIPE);
			Window window = new Window();
			window.setWidth(Integer.parseInt(parts[0]));
			window.setHeight(Integer.parseInt(parts[1]));
			nonPaintableSurfaces.add(window);
		}

		//Add doors to non-paintable surfaces
		for (String w : cla.doors) {
			String[] parts = w.split(PIPE);
			Door door = new Door();
			door.setWidth(Integer.parseInt(parts[0]));
			door.setHeight(Integer.parseInt(parts[1]));
			nonPaintableSurfaces.add(door);
		}
		
		//Set paint properties
		Paint paint = new Paint(Integer.parseInt(cla.paintCoverage), Integer.parseInt(cla.paintPrice), cla.paintSku);
		
		PaintCalculator pc = new PaintCalculator();
		
		//perform calculations, print results
		int paintableSurface = pc.calculateArea(paintableSurfaces);
		int nonPaintableSurface = pc.calculateArea(nonPaintableSurfaces);
		int totalPaintableSurfaceArea = paintableSurface - nonPaintableSurface;
		System.out.println("Total paintable surface area: " + totalPaintableSurfaceArea + " sq/ft");
				
		double totalGallons = pc.calculateGallons(paintableSurface, nonPaintableSurface, paint);
		DecimalFormat df = new DecimalFormat("#.00"); 
		System.out.println("Number of gallons required per coat: " + df.format(totalGallons));
		
		double totalPrice = pc.calculatePrice(paintableSurface, nonPaintableSurface, paint);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println("Cost per coat of paint #" + paint.getSku() + ": " + nf.format(totalPrice));
		
	}
	
	public int calculateArea(ArrayList<Surface> surface){
		int surfaceArea = 0;
		for (Surface s : surface) {
			   surfaceArea += s.calculateSurfaceArea();
			}
		return surfaceArea;
	}

	public double calculateGallons(double paintableSurfaceArea, double nonPaintableSurfaceArea, Paint p){
		double gallons = (paintableSurfaceArea - nonPaintableSurfaceArea) / p.getCoveragePerGallon();
		return gallons;
	}	
	
	public double calculatePrice(double paintableSurfaceArea, double nonPaintableSurfaceArea, Paint p){
		double gallons = calculateGallons(paintableSurfaceArea, nonPaintableSurfaceArea, p);
		double price = gallons * p.getPricePerGallon();
		return price;
	}
	
//	public double calculatePrice(double gallons, Paint p){
//		double price = gallons * p.getPricePerGallon();
//		return price;
//	}	

}
