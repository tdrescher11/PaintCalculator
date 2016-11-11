package com.drescher;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

public class CommandLineArgs {
	public static final String WALL = "-wall";
	public static final String DOOR = "-door";
	public static final String WINDOW = "-window";
	public static final String TRIM = "-trim";
	public static final String PAINT_SKU = "-paintSku";
	public static final String PAINT_COVERAGE = "-paintCoverage";
	public static final String PAINT_PRICE = "-paintPrice";
	
	
	@Parameter(names = WALL, description = "Width and Height of a Wall in a pipe separated format (ex: for a wall measuing 10x20 use: '-wall 10|20')", required = true)
	public List<String> walls = new ArrayList<>();

	@Parameter(names = DOOR, description = "Width and Height of a door in a pipe separated format (ex: for a door measuing 3x7 use: '-door 3|6')")
	public List<String> doors = new ArrayList<>();
	
	@Parameter(names = WINDOW, description = "Width and Height of a window in a pipe separated format (ex: for a window measuing 3x5 use: '-window 3|5')")
	public List<String> windows = new ArrayList<>();

	@Parameter(names = TRIM, description = "Width and Height of trim in a pipe separated format (ex: for trim on a wall measuing 10x20 use: '-trim 10|20')")
	public List<String> trim = new ArrayList<>();

	//for logging/display purposes only
	@Parameter(names = PAINT_SKU, description = "The sku of the paint product", required = true)
	public String paintSku;
	
	@Parameter(names = PAINT_COVERAGE, description = "The coverage per gallon of paint (in square feet)", required = true)
	public String paintCoverage;
	
	@Parameter(names = PAINT_PRICE, description = "The price per gallon of the paint product", required = true)
	public String paintPrice;
}
