/*   NBeersManager: manages what you drink.
    Copyright (C) 2016  Nicola Bena

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>
    */
package org.nbena.beersmanager.exe;

import java.io.OutputStream;






import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.swing.JFileChooser;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;
import org.nbena.beersmanager.conf.ConfigurationNew;
import org.nbena.beersmanager.conf.ConfigurationNew.ShowDefault;
import org.nbena.beersmanager.coreclasses.Beer;
import org.nbena.beersmanager.coreclasses.Brewery;
import org.nbena.beersmanager.coreclasses.Style;
import org.nbena.beersmanager.exceptions.RecomposingException;
import org.nbena.beersmanager.coreclasses.Fermentation;
import org.nbena.beersmanager.exe.ui.models.Model;
import org.nbena.beersmanager.exe.ui.models.Model.ExportType;
import org.nbena.beersmanager.json.coreclasses.Converter;
import org.nbena.beersmanager.json.coreclasses.JSONExporterCoreClasses;
import org.nbena.beersmanager.query.QueryRunner;
import org.nbena.beersmanager.query.QueryRunner.BeerFilterAlgorithm;
import org.nbena.beersmanager.query.QueryRunner.BreweryFilterAlgorithm;
import org.nbena.beersmanager.query.QueryRunner.StyleFilterAlgorithm;
import org.nbena.beersmanager.sclasses.BeerJSONSaveSpecialClass;
import org.nbena.beersmanager.sclasses.BreweryAverage;

/**
 * Utils contains a range of utilities methods, that logically are not a part of other classes.
 * @author nbena
 *
 */
public class Utils {
	
	//here things not strictly connected with business logic.

	public Utils() {
	}
	
	public static void printStyle(Style style, OutputStream output){
//		PrintStream out=new PrintStream(output);
//		out.println("-------");
//		out.println(" "+style.getStyleSubCategory()+" "+style.getStyleMainName()+", "+style.getFermentation()+" fermentation");
//		out.println(" "+style.getDescription()+"\n");
		PrintStream out = new PrintStream(output);
		out.println(styleToString(style));
	}
	
	public static void printBeer(Beer beer, OutputStream output){
//		PrintStream out=new PrintStream(output);
//		out.println("-------");
//		out.println(" "+beer.getBrewery().getName()+": "+beer.getName());
//		out.println(" "+beer.getStyle().getStyleMainName()+"  "+beer.getStyle().getStyleSubCategory());
////		out.println(" "+beer.getColor()+" - Fermentation: "+beer.getFermentation());
//		out.print("Fermentation "+beer.getFermentation().toFirstUpperCase());
//		out.println(" Alcool: "+beer.getAlcool()+"% ");
//		out.println(" Description: "+beer.getDescription());
//		out.println(" Mark: "+beer.getMark());
//		out.println(" Star: "+beer.getNumberOfStars());
//		if(beer.isTried()){
//			out.println(" Tried: yes");
//			out.println(" Place tried: "+beer.getPlaceTried()+ " Price: "+beer.getPrice());
//		}
//		else{
//			out.println(" Tried: no");
//		}
//		out.println();
		PrintStream out = new PrintStream(output);
		out.println(beerToString(beer));
	}
	
	public static void printBrewery(Brewery brewery, OutputStream output){
//		PrintStream out=new PrintStream(output);
//		out.println("-------");
//		out.println(" "+brewery.getName()+" - "+brewery.getTown()+" - "+brewery.getCountry()+" - "+brewery.getWebsite());
//		out.println(" "+brewery.getDescription()+"\n");
		PrintStream out = new PrintStream(output);
		out.println(breweryToString(brewery));
	}
	
//	public static void printBeers(List<Beer> beers, OutputStream output){
//		/*
//		PrintStream out=new PrintStream(output);
//		out.println("-------------Beers:--------------");
//		for(Beer beer: beers){
//			out.println("-------");
//			out.println(" "+beer.getBrewery().getName()+": "+beer.getName());
//			out.println(" "+beer.getStyle().getStyleMainName()+"  "+beer.getStyle().getStyleSubCategory());
//			out.println(" "+beer.getColor()+" - Fermentation: "+beer.getFermentation());
//			out.println(" Alcool: "+beer.getAlcool()+"% ");
//			out.println(" Description: "+beer.getDescription());
//			out.println(" Mark: "+beer.getMark());
//			out.println(" Star: "+beer.getNumberOfStars());
//			if(beer.isTried()){
//				out.println(" Tried: yes");
//				out.println(" Place tried: "+beer.getPlaceTried()+ " Price: "+beer.getPrice());
//			}
//			else{
//				out.println(" Tried: no"+"\n");
//			}
//		}
//		out.println();
//		*/
////		for(Beer b: beers){
////			printBeer(b, output);
////		}
////		printBeersNew(beers, output);
//	}
//	
//	public static void printBreweries(List<Brewery> breweries, OutputStream output){
//		/*
//		PrintStream out=new PrintStream(output);
//		out.println("-------------Breweries:--------------");
//		for(Brewery brewery: breweries){
//			out.println("-------");
//			out.println(" "+brewery.getName()+" - "+brewery.getTown()+" - "+brewery.getCountry()+" - "+brewery.getWebsite());
//			out.println(" "+brewery.getDescription()+"\n");
//		}
//		*/
////		for(Brewery b: breweries){
////			printBrewery(b, output);
////		}
////		printBreweriesNew(breweries, output);
//	}
	
//	public static void printStyles(List<Style> styles, OutputStream output){
//		/*
//		PrintStream out=new PrintStream(output);
//		out.println("-------------Style:--------------");
//		for(Style style: styles){
//			out.println(" "+style.getStyleSubCategory()+" "+style.getStyleMainName()+", "+style.getFermentation()+" fermentation");
//			out.println(" "+style.getDescription()+"\n");
//		}
//		*/
////		for(Style s: styles){
////			printStyle(s, output);
////		}
////		printStylesNew(styles, output);
//	}
	
	/**
	 * Creates a string representation of the configuration.
	 * @param c	the configuration you want to print.
	 * @return	the string representation of the object.
	 */
	public static String configurationToString(ConfigurationNew c){
		StringBuilder sb = new StringBuilder();
		sb.append("Beer sorting algorithm: "+ c.getBeerSortingAlgorithm().toString()+"\n");
		sb.append("Brewery sorting algorithm: "+ c.getBrewerySortingAlgorithm().toString()+"\n");
		sb.append("Style sorting algorithm: "+ c.getStyleSortingAlgorithm().toString()+"\n");
		
//		sb.append("Beer filtering algorithm: "+ c.getBeerFilterAlgorithm().toString()+"\n");
//		sb.append("\tBeer filtering value: "+c.getBeerFilterValue()+"\n");
//		sb.append("Brewery filtering algorithm: "+ c.getBreweryFilterAlgorithm().toString()+"\n");
//		sb.append("\tBrewery filtering value: "+c.getBreweryFilterValue()+"\n");
//		sb.append("Style filtering algorithm: "+ c.getStyleFilterAlgorithm().toString()+"\n");
//		sb.append("\tStyle filtering value: "+c.getStyleFilterValue()+"\n");
		
		sb.append("Default view: "+c.getDefaultView().toString()+"\n");
		return sb.toString();
	}
	
	/**
	 * Prints the current configuration in a string format.
	 * @param c	the configuration to print.
	 * @param output the OutputStream
	 * @see configurationToString()
	 */
	public static void printConfiguration(ConfigurationNew c, OutputStream output){
		PrintStream out = new PrintStream(output);
//		out.println("Beer sorting algorithm: "+ c.getBeerSortingAlgorithm().toString());
//		out.println("Brewery sorting algorithm: "+ c.getBrewerySortingAlgorithm().toString());
//		out.println("Style sorting algorithm: "+ c.getStyleSortingAlgorithm().toString());
//		
//		out.println("Beer filtering algorithm: "+ c.getBeerFilterAlgorithm().toString());
//		out.println("\tBeer filtering value: "+c.getBeerFilterValue());
//		out.println("Brewery filtering algorithm: "+ c.getBreweryFilterAlgorithm().toString());
//		out.println("\tBrewery filtering value: "+c.getBreweryFilterValue());
//		out.println("Style filtering algorithm: "+ c.getStyleFilterAlgorithm().toString());
//		out.println("\tStyle filtering value: "+c.getStyleFilterValue());
//		
//		out.print("Default view: "+c.getDefaultView().toString());
		out.print(configurationToString(c));
	}
	
	/**
	 * Creates a string representation of the beer.
	 * @param beer	the beer you want to print.
	 * @return	the string representation of the object.
	 */
	public static String beerToString(Beer beer){
		StringBuilder builder = new StringBuilder();
//		builder.append("-------");
		builder.append(beer.getBrewery().getBreweryName()+": "+beer.getName()+"\n");
		builder.append("\t"+beer.getStyle().getStyleMainName()+"  "+beer.getStyle().getStyleSubCategory()+"\n");
//		builder.append(" "+beer.getColor()+" - Fermentation: "+beer.getFermentation());
		builder.append("\tFermentazione "+Utils.getFermentationItalianString(beer.getFermentation())+"\n");
		builder.append("\tAlcool: "+beer.getAlcool()+"%\n");
		builder.append("\tDescrizione: "+beer.getDescription()+"\n");
		builder.append("\tVoto: "+beer.getMark()+"\n");
		builder.append("\tStelle: "+beer.getNumberOfStars()+"\n");
		if(beer.isTried()){
			builder.append("\tProvata: s�\n");
			builder.append("\tLuogo: "+beer.getPlaceTried()+ " Prezzo: "+beer.getPrice()+"\n");
		}
		else{
			builder.append(" Provata: no\n");
		}
		builder.append("\n");
		return builder.toString();
	}
	
	/**
	 * Creates a string representation of the brewery.
	 * @param brewery	the beer you want to print.
	 * @return	the string representation of the object.
	 */
	public static String breweryToString(Brewery brewery){
		StringBuilder builder = new StringBuilder();
		builder.append(brewery.getBreweryName()+" - "+brewery.getTown()+" - "+brewery.getCountry()+" - "+brewery.getWebsite()+"\n");
		builder.append("\t"+brewery.getBreweryDescription()+"\n");
		builder.append("\n");
		return builder.toString();
	}
	
	/**
	 * Creates a string representation of the style.
	 * @param style	the beer you want to print.
	 * @return	the string representation of the object.
	 */
	public static String styleToString(Style style){
		StringBuilder builder = new StringBuilder();
		builder.append(style.getStyleSubCategory()+" "+style.getStyleMainName()+", Fermentazione "+getFermentationItalianString(style.getFermentation())+"\n");
		builder.append("\t"+style.getDescription()+"\n");
		builder.append("\n");
		return builder.toString();
	}
	
	public static List<String> beersToString(List<Beer> beers){
		List<String> beersString = new LinkedList<String>();
		for(Beer b: beers){
			String s = beerToString(b);
			beersString.add(s);
		}
		return beersString;
	}
	
	/**
	 * Prints a string representation of the list of beers.
	 * In practice, for each object a string representation is printed.
	 * @param beers	the list of beer you want to print.
	 * @return	the string representation of the object.
	 * @see beerToString()
	 */
	public static void printBeers(List<Beer> beers, OutputStream out){
		PrintStream output = new PrintStream(out);
		for(Beer b : beers){
			output.println("----");
			output.println(beerToString(b));
		}
	}
	
	/**
	 * Prints a string representation of the list of beers.
	 * In practice, for each object a string representation is printed.
	 * The total price is then printed.
	 * @param beers	the list of beer you want to print.
	 * @return	the string representation of the object.
	 * @see beerToString()
	 */
	public static void printBeersTotal(List<Beer> beers, OutputStream out){
		//get the totale here because we loop on the list
		PrintStream output = new PrintStream(out);
		double total = 0.0;
		for(Beer b: beers){
			output.println("----");
			output.println(beerToString(b));
			total+=b.getPrice();
		}
		output.print("Totale: "+total);
	}
	
	/**
	 * Prints a string representation of the list of breweries.
	 * In practice, for each object a string representation is printed.
	 * @param breweries	the list of breweries you want to print.
	 * @return	the string representation of the object.
	 * @see breweryToString()
	 */
	public static void printBreweries(List<Brewery> breweries, OutputStream out){
		PrintStream output = new PrintStream(out);
		for(Brewery b : breweries){
			output.println("----");
			output.println(breweryToString(b));
		}
	}
	
	/**
	 * Prints a string representation of the list of styles.
	 * In practice, for each object a string representation is printed.
	 * @param styles	the list of styles you want to print.
	 * @return	the string representation of the object.
	 * @see styleToString()
	 */
	public static void printStyles(List<Style> styles, OutputStream out){
		PrintStream output = new PrintStream(out);
		for(Style b : styles){
			output.println("----");
			output.println(styleToString(b));
		}
	}
	
	/**
	 * Get the <i>pwd</i>
	 * @return  the absolute path of the <i>pwd</i>
	 */
	public static String currentDirectory(){
		String path=new File(".").getAbsolutePath();
		return path.substring(0, path.length()-1);
	}
	
//	public static String jsonStyle(String directory){
//		return directory.concat("styles.json");
//	}
//	
//	public static String jsonBreweries(String directory){
//		return directory.concat("breweries.json");
//	}
//	
//	public static String jsonBeers(String directory){
//		return directory.concat("beers.json");
//	}
//	
//	public static String jsonConfiguration(String directory){
//		return directory.concat("config.json");
//	}
//	
//	public static String jsonCountries(String directory){
//		return directory.concat("country_list_it.json");
//	}
	
	public static String getOSIndipendentFolder(){
		String res = null;
		if(System.getProperty("os.name").equalsIgnoreCase("linux")){
			res = System.getProperty("user.home").concat("/.nbeers/");
		}else if (System.getProperty("os.name").equalsIgnoreCase("windows")){
			res = System.getProperty("user.home").concat("\\.nbeers\\");
		}
		return res;
	}
	
	public static String getStylesPath(){
		String directory = getOSIndipendentFolder();
		return directory.concat("styles.json");
	}
	
	public static String getBreweriesPath(){
		String directory = getOSIndipendentFolder();
		return directory.concat("breweries.json");
	}
	
	public static String getBeersPath(){
		String directory = getOSIndipendentFolder();
		return directory.concat("beers.json");
	}
	
	public static String getCountriesPath(){
		String directory = getOSIndipendentFolder();
		return directory.concat("country_list_it.json");
	}
	
	public static String getConfigurationPath(){
		String directory = getOSIndipendentFolder();
		return directory.concat("config.json");
	}
	
	
	public static List<Style> readStyles(File file) throws FileNotFoundException, JSONException{
		 return Converter.toNormalStyleList(JSONExporterCoreClasses.readStylesSpecial(new FileInputStream(file)));  
	}
	
	public static List<Brewery> readBreweries(File file) throws FileNotFoundException, JSONException{
		return JSONExporterCoreClasses.readBreweries(new FileInputStream(file));
	}
	
	private static String readGPL(File file) throws FileNotFoundException{
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(new FileInputStream(file));
		while(sc.hasNext()){
			String line = sc.nextLine();
			sb.append(line+"\n");
//			System.out.println(line);
		}
		sc.close();
		return sb.toString();
	}
	
	private static final String GPL = "Questo programma � coperto dalla licenza GPL v3. Il file license non � stato trovato,"
			+ " dovresti procurartnene una copia su www.gun.org/license";
	
	public static final String OTHER = "Questo programma utilizza librerie di terze parti: software di Apache Software Foundation e JSON.org";
	
	public static String readLicense(String path){
		String gpl = null;
		File file = new File(path);
		boolean normalText = false;
		if(file.exists()){
			try {
				gpl = readGPL(file);
			} catch (FileNotFoundException e) {
				normalText = true;
			}
		}
		
		if(normalText){
			gpl = GPL;
		}
		return gpl;
	}
	
	public static String gplPath(String pwd){
		return pwd+="license.txt";
	}
	
	@Deprecated
	public static String getStyleStringForExport(Style style){
		
		String s = 
				(style.getStyleMainName()+":::::")+
				(style.getStyleSubCategory()+":::::")+
				(style.getDescription()+":::::")+
				(style.getStyleCountryOrigin()+":::::")+
				(style.getFermentation().toString());
		
		return s;
	}
	
	@Deprecated
	public static String getBreweryStringForExport(Brewery b){
		String s =
				b.getBreweryName()+":::::"+
				b.getTown()+":::::"+
				b.getCountry()+":::::"+
				b.getBreweryDescription()+":::::"+
				b.getWebsite()+":::::"+
				Boolean.toString(b.isAuthenticTrappist());
		return s;
	}
	
	@Deprecated
	public static Style getStyleFromStringExport(String s){
		String[] array = s.split(":::::");
		Style style = new Style();
		style.setStyleMainName(array[0]);
		style.setStyleSubCategory(array[1]);
		style.setDescription(array[2]);
		style.setStyleCountryOrigin(array[3]);
		style.setFermentation(Fermentation.valueOf(array[4]));
		return style;
	}
	
	@Deprecated
	public static Brewery getBreweryFromStringExport(String s){
		String[] array = s.split(":::::");
		Brewery b = new Brewery();
		b.setBreweryName(array[0]);
		b.setTown(array[1]);
		b.setCountry(array[2]);
		b.setBreweryDescription(array[3]);
		b.setWebsite(array[4]);
		b.setAuthenticTrappist(Boolean.parseBoolean(array[5]));
		return b;
	}
	
	public static List<Beer> readBeersFromSpecial(File file, List<Brewery> breweries, List<Style> styles) throws FileNotFoundException, JSONException, RecomposingException{
		List<Beer> beersRead=new LinkedList<Beer>();
		List<BeerJSONSaveSpecialClass> beersSpecial;	  
		beersSpecial = JSONExporterCoreClasses.readBeersSpecial( new FileInputStream(file));
		beersRead = Converter.recompose(beersSpecial, breweries, styles);
		return beersRead;
	}
	
	public static List<Beer> readBeersFromBeerExportClass(File file) throws FileNotFoundException, JSONException{
		return JSONExporterCoreClasses.readBeersJSONExportSpecialClass(new FileInputStream(file));
	}
	
	public static void saveStyles(List<Style> styles, File file) throws FileNotFoundException, JSONException{
		JSONExporterCoreClasses.writeStyleSpecial(styles, new FileOutputStream(file));
	}
	
	public static void saveBreweries(List<Brewery> breweries, File file) throws FileNotFoundException, JSONException{
		JSONExporterCoreClasses.writeBrewery(breweries, new FileOutputStream(file));
	}
	
	public static void saveBeers(List<Beer> beers, File file) throws FileNotFoundException, JSONException{
		//List<BeerJSONSpecialClass> beersSpecial = Converter.toSpecialBeerList(beers);
		JSONExporterCoreClasses.writeBeerSpecial(beers, new FileOutputStream(file)); //already done by json
	}
	
	public static Object[] fromStyleToObjectArray(Style s){
		Object[] array=new Object[5];
		array[0]=s.getStyleMainName();
		array[1]=s.getStyleSubCategory();
		array[2]=getFermentationItalianString(s.getFermentation());
		array[3]=s.getStyleCountryOrigin();
		array[4]=s.getDescription();
		return array;
	}
	
	public static Object[] fromBeerToObjectArray(Beer b){
//		Object[] array=new Object[10];
		Object[] array=new Object[9];
		array[0]=b.getName();
		array[1]=b.getBrewery().getBreweryName();
		array[2]=b.getStyle().getStyleSubCategory()+" "+b.getStyle().getStyleMainName();
		array[3]=truncateDouble(b.getAlcool());
		array[4]=b.getMark();
		array[5]=b.getNumberOfStars();
		array[6]=Utils.getBooleanItalian(b.isTried());
		array[7]=b.getPlaceTried();
		array[8]=truncateDouble(b.getPrice());
//		array[9]=b.getDescription();
		return array;
	}
	
	private static String truncateDoubleString(double a){
		return new DecimalFormat("##.##").format(a).replaceAll(",", ".");
	}
	
	public static double truncateDouble(double a){
		return Double.parseDouble(truncateDoubleString(a));
	}
	
	public static Object[] fromBreweryToObjectArray(Brewery b){
		Object [] array=new Object[5];
		array[0]=b.getBreweryName();
		array[1]=b.getCountry();
		array[2]=b.getTown();
		array[3]=b.getBreweryDescription();
		array[4]=b.getWebsite();
		return array;
	}
	
	
	public static Object[] fromBreweryAverageToObjectArray(BreweryAverage b){
		Object [] array=new Object[6];
		array[0]=b.getBreweryName();
		array[1]=b.getCountry();
		array[2]=b.getTown();
		array[3] = (Double.isNaN(b.getAverage()) ? 0.0 : truncateDouble(b.getAverage()));
		array[4]=b.getBreweryDescription();
		array[5]=b.getWebsite();
////		array[5]= (  (b.getAverage()==Double.NaN) ? 0.0 : b.getAverage());
//		double res=b.getAverage();
//		if(b.getAverage()==Double.NaN){
//			res=0.0;
//		}
//		array[5]=res;
////		System.out.println(b.getAverage());
//		System.out.println("Brewery : "+b.getName()+", average: "+b.getAverage()+" is NaN?"+ (b.getAverage()==Double.NaN));
		return array;
	}
	
	public static Object[][] fromStylesToObjectMatrix(List<Style> styles){
		Object[][] array=new Object[styles.size()][5];
		for(int i=0;i<styles.size();i++){
			Style s=styles.get(i);
			array[i]=fromStyleToObjectArray(s);
		}
		return array;
	}
	
	public static Object[][] fromBeersToObjectMatrix(List<Beer> beers){
//		Object [][] array=new Object[beers.size()][10];
		Object [][] array=new Object[beers.size()][9];
		for(int i=0;i<beers.size();i++){
			Beer b=beers.get(i);
			array[i]=fromBeerToObjectArray(b);
		}
		return array;
	}
	
	public static Object[][] fromBreweriesToObjectMatrix(List<Brewery> breweries){
		Object [][] array=new Object[breweries.size()][5];
		for(int i=0;i<breweries.size();i++){
			Brewery b=breweries.get(i);
			array[i]=fromBreweryToObjectArray(b);
		}
		return array;
	}
	
	
	public static Object[][] fromBreweriesAverageToObjectMatrix(List<BreweryAverage> breweries){
		Object [][] array=new Object[breweries.size()][6];
		for(int i=0;i<breweries.size();i++){
			BreweryAverage b=breweries.get(i);
			array[i]=fromBreweryAverageToObjectArray(b);
		}
		return array;
	}
	
	public static Style getNakedStyle(Style s){
		Style naked=new Style();
		naked.setStyleMainName(s.getStyleMainName());
		return naked;
	}
	
	
	public static String getStyleStringSubMain(Style s){
		String returned = s.getStyleMainName();
		if(!s.getStyleSubCategory().equals("")){
			String sub= s.getStyleSubCategory();
			returned = sub.concat(" - ").concat(returned);
		}
		return returned;
	}
	
	
	public static String getStyleStringMainSub(Style s){
		String returned = s.getStyleMainName();
		if(!s.getStyleSubCategory().equals("")){
			String sub= s.getStyleSubCategory();
			returned = returned.concat(" - ").concat(sub);
		}
		return returned;
	}
	
	public static Style getMainStyleFromString(String s){
		Style style = new Style();
		style.setStyleMainName(s);
		return style;
	}
	
	/**
	 * @deprecated use instead {@link #getStyleFromStringMainSub(String)}
	 * @param s
	 * @return
	 */
	public static Style getStyleFromStringSubMain(String s){
		Style style = new Style();
//		String name = s.substring(0, s.lastIndexOf("-"));
//		name = removeInitialEndingBlankSpaces(name);
//		String sub = s.substring(s.lastIndexOf("-"), s.length());
//		sub = removeInitialEndingBlankSpaces(sub);
//		style.setStyleMainName(name);
//		style.setStyleSubCategory(sub);
		if(s.indexOf("-")==-1){
			style.setStyleMainName(s);
			style.setStyleSubCategory("");
		}else{
			String sub = s.substring(0, s.lastIndexOf("-"));
			sub = removeInitialEndingBlankSpaces(sub);
			style.setStyleSubCategory(sub);
			
			String main = s.substring(s.lastIndexOf("-")+1, s.length());
			main = removeInitialEndingBlankSpaces(main);
			style.setStyleMainName(main);
		}
//		System.out.println("The style obtained is: ");
//		System.out.println("Style name: '"+style.getStyleMainName()+"'");
//		System.out.println("Sub: '"+style.getStyleSubCategory()+"'");
//		Utils.printStyle(style, System.out);
		return style;
	}
	
	public static Style getStyleFromStringMainSub(String s){
		Style style = new Style();
		if(s.indexOf("-")==-1){
			style.setStyleMainName(s);
			style.setStyleSubCategory("");
		}else{
			String main = s.substring(0, s.lastIndexOf("-"));
			main = removeInitialEndingBlankSpaces(main);
			style.setStyleMainName(main);
			
			String sub = s.substring(s.lastIndexOf("-")+1, s.length());
			sub = removeInitialEndingBlankSpaces(sub);
			style.setStyleSubCategory(sub);
		}
		return style;
	}
	
	public static String getBreweryString(Brewery b){
		return b.getBreweryName()+"; "+b.getTown()+" ("+b.getCountry()+")";
	}
	
	public static List<String> getBreweryStringList(List<Brewery> breweries){
		List<String> strings = new LinkedList<String>();
		for(Brewery b: breweries){
			strings.add(getBreweryString(b));
		}
		return strings;
	}
	
	public static String[] getBreweryStringArray(List<Brewery> breweries){
		String[] strings = new String[breweries.size()];
		int i=0;
		for(Brewery b: breweries){
			strings[i]=getBreweryString(b);
			i++;
		}
		return strings;
	}
	
	
	public static List<String> getStyleStringListSubMain(List<Style> styles){
		List<String> strings = new LinkedList<String>();
		for(Style s: styles){
			strings.add(getStyleStringSubMain(s));
		}
		return strings;
	}
	
	public static String[] getStyleStringArraySubMain(List<Style> styles){
		String[] strings = new String[styles.size()];
		int i=0;
		for(Style s: styles){
			strings[i]=getStyleStringSubMain(s);
			i++;
		}
		return strings;
	}
	
	public static String[] getMainStyleStringArray(List<Style> styles){
		String [] strings = new String[styles.size()];
		int i=0;
		for(Style s: styles){
			strings[i++]=s.getStyleMainName();
		}
		return strings;
	}
	
	public static List<String> getStyleStringListMainSub(List<Style> styles){
		List<String> strings = new LinkedList<String>();
		for(Style s: styles){
			strings.add(getStyleStringMainSub(s));
		}
		return strings;
	}
	
	public static String[] getStyleStringArrayMainSub(List<Style> styles){
		String[] strings = new String[styles.size()];
		int i=0;
		for(Style s: styles){
			strings[i]=getStyleStringMainSub(s);
			i++;
		}
		return strings;
	}
	
	
	public static String removeInitialEndingBlankSpaces(String s){
		String replaced = s;
		if(replaced.charAt(0)==' '){
//			replaced = replaced.replaceFirst(" ", "");
			replaced = replaced.substring(1, replaced.length());
		}
		if(replaced.charAt(replaced.length()-1)== ' '){
			replaced = replaced.substring(0, replaced.length()-1);
		}
		return replaced;
	}
	
	public static Brewery getBreweryFromString(String s){
		Brewery b=new Brewery();
		String name = s.substring(0, s.indexOf(";"));
		String town = s.substring(s.indexOf(";"), s.lastIndexOf("(") );
		town = removeInitialEndingBlankSpaces(town);
		String country = s.substring(s.lastIndexOf("(")+1, s.lastIndexOf(")"));
		country = removeInitialEndingBlankSpaces(country);
		b.setBreweryName(name);
		b.setTown(town);
		b.setCountry(country);
		
//		System.out.println("Brewery is: ");
//		Utils.printBrewery(b, System.out);
		return b;
	}
	
	public static List<String> getBreweriesString(List<Brewery> breweries){
		List<String> strings=new LinkedList<String>();
		for(Brewery b: breweries){
			strings.add(getBreweryString(b));
		}
		return strings;
	}
	
	
	
	public static String getBooleanItalian(boolean b){
		return b==true ? "S�" : "No";
	}
	
	public static boolean getBooleanFromItalianString(String s){
		boolean b=true;
		if(s.equals("No")){
			b=false;
		}
		return b;
	}
	
	public static List<String> getMainStyleString(List<Style> styles){
		List<String> strings=new LinkedList<String>();
		for(Style s: styles){
			strings.add(s.getStyleMainName());
		}
		return strings;
	}
	
	public static String getFermentationItalianString(Fermentation f){
		String s=null;
		if(f==Fermentation.HIGH)
			s="Alta";
		else if(f==Fermentation.LOW)
			s="Bassa";
		else
			s="Spontanea";
		return s;
	}
	
	public static Fermentation getFermentationFromString(String s){
		Fermentation f = null;
		if(s.equals("Spontanea")){
			f = Fermentation.SPONTANEOUS;
		}
		else if(s.equals("Bassa")){
			f= Fermentation.LOW;
		}else{
			f= Fermentation.HIGH;
		}
		return f;
	}
	
	public static List<String> getFermentationsItalianString(){
		List<String> strings = new LinkedList<String>();
		for(Fermentation fermentation: Fermentation.values()){
			strings.add(getFermentationItalianString(fermentation));
		}
		return strings;
	}
	
	public static double parseDouble(String s){
		if(s.lastIndexOf(".")==-1){
			s=s.concat(".0");
		}
		return Double.parseDouble(s);
	}
	
	public static BreweryAverage fromBreweryToBreweryAverage(Brewery b, List<Beer> itsBeers){
		BreweryAverage av=new BreweryAverage();
		av.setAuthenticTrappist(b.isAuthenticTrappist());
		av.setCountry(b.getCountry());
		av.setBreweryDescription(b.getBreweryDescription());
		av.setBreweryName(b.getBreweryName());
		av.setTown(b.getTown());
		av.setWebsite(b.getWebsite());
		av.setAverage(itsBeers);
		return av;
	}
	
	public static BreweryAverage fromBreweryToBreweryAverage(Brewery b){
		BreweryAverage av=new BreweryAverage();
		av.setAuthenticTrappist(b.isAuthenticTrappist());
		av.setCountry(b.getCountry());
		av.setBreweryDescription(b.getBreweryDescription());
		av.setBreweryName(b.getBreweryName());
		av.setTown(b.getTown());
		av.setWebsite(b.getWebsite());
		av.setAverage(0.0);
		return av;
	}
	
	public static List<BreweryAverage> fromBreweriesToBreweriesAverage(List<Brewery> breweries, List<Beer> beers){
		List<BreweryAverage> breweriesAv=new LinkedList<BreweryAverage>();
		for(Brewery b: breweries){
			List<Beer> itsBeers=QueryRunner.BeerQuery.BeerFilter.beersFilteredByBrewery(beers, b);
			BreweryAverage av=fromBreweryToBreweryAverage(b, itsBeers);
			breweriesAv.add(av);
		}
		return breweriesAv;
	}
	
	public static List<BreweryAverage> fromBreweriesToBreweriesAverage(List<Brewery> breweries){
		List<BreweryAverage> breweriesAv=new LinkedList<BreweryAverage>();
		for(Brewery b: breweries){
			BreweryAverage av=fromBreweryToBreweryAverage(b);
			breweriesAv.add(av);
		}
		return breweriesAv;
	}
	
	public static Brewery fromBreweryAverageToBrewery(BreweryAverage brewery){
		Brewery b=new Brewery();
		b.setAuthenticTrappist(brewery.isAuthenticTrappist());
		b.setCountry(brewery.getCountry());
		b.setBreweryDescription(brewery.getBreweryDescription());
		b.setBreweryName(brewery.getBreweryName());
		b.setTown(brewery.getTown());
		b.setWebsite(brewery.getWebsite());
		return b;
	}
	
	public static List<Brewery> fromBreweriesAverageToBrewery(List<BreweryAverage> breweries){
		List<Brewery> normals=new LinkedList<Brewery>();
		for(BreweryAverage b: breweries){
			Brewery normal=fromBreweryAverageToBrewery(b);
			normals.add(normal);
		}
		return normals;
	}
	
	private static final String BEER_SORTING_ALGORITHM_NAME = "Nome";
	private static final String BEER_SORTING_ALGORITHM_COUNTRY_OF_BREWERY_STYLE = "Nazione birrificio, stile";
	private static final String BEER_SORTING_ALGORITHM_COUNTRY_OF_BREWERY_NAME = "Nazione e nome birrifcio, nome birra";
	private static final String BEER_SORTING_ALGORITHM_FERMENTATION_STYLE_COUNTRY_OF_BREWERY = "Fermentazione, stile, nazione birrificio";
	private static final String BEER_SORTING_ALGORITHM_FERMENTATION_COUNTRY_OF_STYLE_BREWERY = "Fermentazione, nazione origine stile, birrificio";
	private static final String BEER_SORTING_ALGORITHM_MARK_STAR_ASCENDING = "Voto, stelle (ascendente)";
	private static final String BEER_SORTING_ALGORITHM_MARK_STAR_DESCENDING = "Voto, stelle (discendente)";
	private static final String BEER_SORTING_ALGORITHM_STAR_MARK_ASCENDING = "Stelle, voto (ascendente)";
	private static final String BEER_SORTING_ALGORITHM_STAR_MARK_DESCENDING = "Stelle, voto (discendente)";
	private static final String BEER_SORTING_ALGORITHM_ABV_ASCENDING = "ABV% (ascendente)";
	private static final String BEER_SORTING_ALGORITHM_PRICE_ASCENDING = "Prezzo (ascendente)";
	private static final String BEER_SORTING_ALGORITHM_ABV_DESCENDING = "ABV% (dicendente)";
	private static final String BEER_SORTING_ALGORITHM_PRICE_DESCENDING = "Prezzo (discendente)";
	
	
	public static String getBeerSortingAlgorithmDescription(QueryRunner.BeerSortingAlgorithm algorithm){
		String value = null;
		switch(algorithm){
		case COUNTRY_OF_BREWERY_STYLE:
			value = BEER_SORTING_ALGORITHM_COUNTRY_OF_BREWERY_STYLE;
			break;
		case FERMENTATIOM_STYLE_COUNTRY_OF_BREWERY:
			value = BEER_SORTING_ALGORITHM_FERMENTATION_STYLE_COUNTRY_OF_BREWERY;
			break;
		case FERMENTATION_COUNTRY_OF_STYLE_BREWERY:
			value = BEER_SORTING_ALGORITHM_FERMENTATION_COUNTRY_OF_STYLE_BREWERY;
			break;
		case MARK_STAR_ASCENDING:
			value = BEER_SORTING_ALGORITHM_MARK_STAR_ASCENDING;
			break;
		case MARK_STAR_DESCENDING:
			value = BEER_SORTING_ALGORITHM_MARK_STAR_DESCENDING;
			break;
		case STAR_MARK_ASCENDING:
			value = BEER_SORTING_ALGORITHM_STAR_MARK_ASCENDING;
			break;
		case STAR_MARK_DESCENDING:
			value =BEER_SORTING_ALGORITHM_STAR_MARK_DESCENDING ;
			break;
		case ABV_ASCENDING:
			value = BEER_SORTING_ALGORITHM_ABV_ASCENDING;
			break;
		case ABV_DESCENDING:
			value = BEER_SORTING_ALGORITHM_ABV_DESCENDING;
			break;
		case PRICE_ASCENDING:
			value = BEER_SORTING_ALGORITHM_PRICE_ASCENDING;
			break;
		case PRICE_DESCENDING:
			value = BEER_SORTING_ALGORITHM_PRICE_DESCENDING;
			break;
		case NAME:
			value = BEER_SORTING_ALGORITHM_NAME;
			break;
		case COUNTRY_OF_BREWERY_NAME:
			value = BEER_SORTING_ALGORITHM_COUNTRY_OF_BREWERY_NAME;
			break;
		
		}
		return value;
	}
	
	
	public static String[] getBeerSortingAlgorithmDescriptionList(){
		QueryRunner.BeerSortingAlgorithm[] algorithms = QueryRunner.BeerSortingAlgorithm.values();
		String [] values = new String[algorithms.length];
		for(int i=0;i<algorithms.length;i++){
			
			values[i]=getBeerSortingAlgorithmDescription(algorithms[i]);
		}
		Arrays.sort(values);
		return values;
	}
	
	public static QueryRunner.BeerSortingAlgorithm getBeerSortingAlgorithmFromDescription(String descriptionString){
		QueryRunner.BeerSortingAlgorithm algorithm;
		
		switch(descriptionString){
		case BEER_SORTING_ALGORITHM_COUNTRY_OF_BREWERY_STYLE:
			algorithm = QueryRunner.BeerSortingAlgorithm.COUNTRY_OF_BREWERY_STYLE;
			break;
		case BEER_SORTING_ALGORITHM_FERMENTATION_STYLE_COUNTRY_OF_BREWERY:
			algorithm = QueryRunner.BeerSortingAlgorithm.FERMENTATIOM_STYLE_COUNTRY_OF_BREWERY;
			break;
		case BEER_SORTING_ALGORITHM_FERMENTATION_COUNTRY_OF_STYLE_BREWERY:
			algorithm = QueryRunner.BeerSortingAlgorithm.FERMENTATION_COUNTRY_OF_STYLE_BREWERY;
			break;
		case BEER_SORTING_ALGORITHM_MARK_STAR_ASCENDING:
			algorithm = QueryRunner.BeerSortingAlgorithm.MARK_STAR_ASCENDING;
			break;
		case BEER_SORTING_ALGORITHM_MARK_STAR_DESCENDING:
			algorithm = QueryRunner.BeerSortingAlgorithm.MARK_STAR_DESCENDING;
			break;
		case BEER_SORTING_ALGORITHM_STAR_MARK_ASCENDING:
			algorithm = QueryRunner.BeerSortingAlgorithm.STAR_MARK_ASCENDING;
			break;
		case BEER_SORTING_ALGORITHM_STAR_MARK_DESCENDING:
			algorithm = QueryRunner.BeerSortingAlgorithm.STAR_MARK_DESCENDING;
			break;
		case BEER_SORTING_ALGORITHM_ABV_ASCENDING:
			algorithm = QueryRunner.BeerSortingAlgorithm.ABV_ASCENDING;
			break;
		case BEER_SORTING_ALGORITHM_PRICE_ASCENDING:
			algorithm = QueryRunner.BeerSortingAlgorithm.PRICE_ASCENDING;
			break;
		case BEER_SORTING_ALGORITHM_ABV_DESCENDING:
			algorithm = QueryRunner.BeerSortingAlgorithm.ABV_DESCENDING;
			break;
		case BEER_SORTING_ALGORITHM_PRICE_DESCENDING:
			algorithm = QueryRunner.BeerSortingAlgorithm.PRICE_DESCENDING;
			break;
		case BEER_SORTING_ALGORITHM_NAME:
			algorithm = QueryRunner.BeerSortingAlgorithm.NAME;
			break;
		case BEER_SORTING_ALGORITHM_COUNTRY_OF_BREWERY_NAME:
			algorithm = QueryRunner.BeerSortingAlgorithm.COUNTRY_OF_BREWERY_NAME;
			break;
		default:
			algorithm = null;
			break;
		}
		return algorithm;
		}
	
	
	private static final String BREWERY_SORTING_ALGORITHM_AVERAGE_ASCENDING = "Media (ascendente)";
	private static final String BREWERY_SORTING_ALGORITHM_AVERAGE_DESCENDING = "Media (discendente)";
	private static final String BREWERY_SORTING_ALGORITHM_COUNTRY_AVERAGE_ASCENDING = "Nazione, media (ascendente)";
	private static final String BREWERY_SORTING_ALGORITHM_COUNTRY_AVERAGE_DESCENDING = "Nazione, media (discendente)";
	private static final String BREWERY_SORTING_ALGORITHM_COUNTRY_NAME = "Nazione, nome birrificio";
	private static final String BREWERY_SORTING_ALGORITHM_NAME = "Nome birrificio";
	
	public static String getBrewerySortingAlgorithmDescription(QueryRunner.BrewerySortingAlgorithm algorithm){
		String value = null;
		switch(algorithm){
		case AVERAGE_ASCENDING:
			value = BREWERY_SORTING_ALGORITHM_AVERAGE_ASCENDING;
			break;
		case AVERAGE_DESCENDING:
			value = BREWERY_SORTING_ALGORITHM_AVERAGE_DESCENDING;
			break;
		case COUNTRY_AVERAGE_ASCENDING:
			value = BREWERY_SORTING_ALGORITHM_COUNTRY_AVERAGE_ASCENDING;
			break;
		case COUNTRY_AVERAGE_DESCENDING:
			value = BREWERY_SORTING_ALGORITHM_COUNTRY_AVERAGE_DESCENDING;
			break;
		case COUNTRY_NAME:
			value = BREWERY_SORTING_ALGORITHM_COUNTRY_NAME;
			break;
		case NAME:
			value = BREWERY_SORTING_ALGORITHM_NAME;
			break;
		
		}
		return value;
	}
	
	public static String[] getBrewerySortingAlgorithmDescriptionList(){
		QueryRunner.BrewerySortingAlgorithm[] algorithms = QueryRunner.BrewerySortingAlgorithm.values();
		String [] values = new String[algorithms.length];
		for(int i=0;i<algorithms.length;i++){
			
			
			values[i]=getBrewerySortingAlgorithmDescription(algorithms[i]);
		}
		Arrays.sort(values);
		return values;
	}
	
	public static QueryRunner.BrewerySortingAlgorithm getBrewerySortingAlgorithmFromDescription(String descriptionString){
		QueryRunner.BrewerySortingAlgorithm algorithm;
		switch(descriptionString){
		case BREWERY_SORTING_ALGORITHM_AVERAGE_ASCENDING:
			algorithm = QueryRunner.BrewerySortingAlgorithm.AVERAGE_ASCENDING;
			break;
		case BREWERY_SORTING_ALGORITHM_AVERAGE_DESCENDING:
			algorithm = QueryRunner.BrewerySortingAlgorithm.AVERAGE_DESCENDING;
			break;
		case BREWERY_SORTING_ALGORITHM_COUNTRY_AVERAGE_ASCENDING:
			algorithm = QueryRunner.BrewerySortingAlgorithm.COUNTRY_AVERAGE_ASCENDING;
			break;
		case BREWERY_SORTING_ALGORITHM_COUNTRY_AVERAGE_DESCENDING:
			algorithm = QueryRunner.BrewerySortingAlgorithm.COUNTRY_AVERAGE_DESCENDING;
			break;
		case BREWERY_SORTING_ALGORITHM_COUNTRY_NAME:
			algorithm = QueryRunner.BrewerySortingAlgorithm.COUNTRY_NAME;
			break;
		case BREWERY_SORTING_ALGORITHM_NAME:
			algorithm = QueryRunner.BrewerySortingAlgorithm.NAME;
			break;
		default:
			algorithm =null;
			break;
		}
		return algorithm;
	}
	
	private static final String STYLE_SORTING_ALGORITHM_COUNTRY_FERMENTATION = "Nazione, fermentazione";
	private static final String STYLE_SORTING_ALGORITHM_FERMENTATION_COUNTRY = "Fermentazione, nazione";
	private static final String STYLE_SORTING_ALGORITHM_FERMENTATION_CATEGORY = "Fermentazione, stile, sottostile";
	
	public static String getStyleSortingAlgorithmDescription(QueryRunner.StyleSortingAlgorithm algorithm){
		String value = null;
		switch(algorithm){
		case COUNTRY_FERMENTATION:
			value = STYLE_SORTING_ALGORITHM_COUNTRY_FERMENTATION;
			break;
		case FERMENTATION_COUNTRY:
			value = STYLE_SORTING_ALGORITHM_FERMENTATION_COUNTRY;
			break;
		case FERMENTATION_CATEGORY:
			value = STYLE_SORTING_ALGORITHM_FERMENTATION_CATEGORY;
			break;
		
		}
		return value;
	}
	

	
	
	public static String[] getStyleSortingAlgorithmDescriptionList(){
		QueryRunner.StyleSortingAlgorithm[] algorithms = QueryRunner.StyleSortingAlgorithm.values();
//		System.out.println("::::::::::::::::::::::::::"+algorithms.length);
		String [] values = new String[algorithms.length];
		for(int i=0;i<algorithms.length;i++){
			
			values[i]=getStyleSortingAlgorithmDescription(algorithms[i]);
		}
		Arrays.sort(values);
		return values;
	}
	
	public static QueryRunner.StyleSortingAlgorithm getStyleSortingAlgorithmFromDescription(String descriptionString){
		QueryRunner.StyleSortingAlgorithm algorithm;
		switch(descriptionString){
		case STYLE_SORTING_ALGORITHM_COUNTRY_FERMENTATION:
			algorithm = QueryRunner.StyleSortingAlgorithm.COUNTRY_FERMENTATION;
			break;
		case STYLE_SORTING_ALGORITHM_FERMENTATION_COUNTRY:
			algorithm = QueryRunner.StyleSortingAlgorithm.FERMENTATION_COUNTRY;
			break;
		case STYLE_SORTING_ALGORITHM_FERMENTATION_CATEGORY:
			algorithm = QueryRunner.StyleSortingAlgorithm.FERMENTATION_CATEGORY;
			break;
		default:
			algorithm = null;
			break;
		}
		return algorithm;
	}
	
	private static final String BEER_FILTERING_ALGORITHM_NONE = "Nessuno";
	private static final String BEER_FILTERING_ALGORITHM_BY_FERMENTATION_HIGH = "Fermentazione alta";
	private static final String BEER_FILTERING_ALGORITHM_BY_FERMENTATION_LOW = "Fermentazione bassa";
	private static final String BEER_FILTERING_ALGORITHM_BY_FERMENTATION_SPONTANEOUS = "Fermentazione spontanea";
	private static final String BEER_FILTERING_ALGORITHM_BY_COUNTRY = "Nazione";
	private static final String BEER_FILTERING_ALGORITHM_BY_STYLE_PROVENIENCE = "Nazione origine stile";
	private static final String BEER_FILTERING_ALGORITHM_BY_MINIMUM_STARS = "Stelle (minime)";
	private static final String BEER_FILTERING_ALGORITHM_BY_MINIMUM_MARK = "Voto (minimo)";
	private static final String BEER_FILTERING_ALGORITHM_BY_MINIMUM_ABV = "ABV (minimo)";
	private static final String BEER_FILTERING_ALGORITHM_BY_IS_TRIED_YES = "Provate";
	private static final String BEER_FILTERING_ALGORITHM_BY_IS_TRIED_NO = "Non provate";
	private static final String BEER_FILTERING_ALGORITHM_BY_STYLE = "Stile e sottostile";
	private static final String BEER_FILTERING_ALGORITHM_BY_MAIN_STYLE = "Stile (solo principale)";
	private static final String BEER_FILTERING_ALGORITHM_BY_BREWERY = "Birrificio";
	private static final String BEER_FILTERING_ALGORITHM_BY_EXACT_ABV = "(ABV (esatto))";
	private static final String BEER_FILTERING_ALGORITHM_BY_EXACT_STARS = "Stelle (esatte)";
	private static final String BEER_FILTERING_ALGORITHM_BY_TRAPPIST_YES = "Trappiste";
	private static final String BEER_FILTERING_ALGORITHM_BY_TRAPPIST_NO = "Non trappiste";
	private static final String BEER_FILTERING_ALGORITHM_BY_EXACT_MARK = "Voto (esatto)";
	private static final String BEER_FILTERING_ALGORITHM_BY_PLACE_TRIED = "Luogo di bevuta";
	
	
	public static String getBeerFilterAlgorithmDescription(BeerFilterAlgorithm algorithm){
		String value = null;
		switch(algorithm){
		case BY_MINIMUM_ABV:
			value = BEER_FILTERING_ALGORITHM_BY_MINIMUM_ABV;
			break;
		case BY_COUNTRY:
			value = BEER_FILTERING_ALGORITHM_BY_COUNTRY;
			break;
		case BY_FERMENTATION_HIGH:
			value = BEER_FILTERING_ALGORITHM_BY_FERMENTATION_HIGH;
			break;
		case BY_FERMENTATION_LOW:
			value = BEER_FILTERING_ALGORITHM_BY_FERMENTATION_LOW;
			break;
		case BY_FERMENTATION_SPONTANEOUS:
			value = BEER_FILTERING_ALGORITHM_BY_FERMENTATION_SPONTANEOUS;
			break;
		case BY_MINIMUM_MARK:
			value = BEER_FILTERING_ALGORITHM_BY_MINIMUM_MARK;
			break;
		case BY_MINIMUM_STARS:
			value = BEER_FILTERING_ALGORITHM_BY_MINIMUM_STARS;
			break;
		case BY_STYLE_PROVENIENCE:
			value = BEER_FILTERING_ALGORITHM_BY_STYLE_PROVENIENCE;
			break;
		case BY_IS_TRIED_YES:
			value = BEER_FILTERING_ALGORITHM_BY_IS_TRIED_YES;
			break;
		case BY_IS_TRIED_NO:
			value = BEER_FILTERING_ALGORITHM_BY_IS_TRIED_NO;
			break;
		case BY_MAIN_STYLE:
			value = BEER_FILTERING_ALGORITHM_BY_MAIN_STYLE;
			break;
		case NONE:
			value = BEER_FILTERING_ALGORITHM_NONE;
			break;
		case BY_STYLE:
			value = BEER_FILTERING_ALGORITHM_BY_STYLE;
			break;
		case BY_BREWERY:
			value = BEER_FILTERING_ALGORITHM_BY_BREWERY;
			break;
		case BY_EXACT_ABV:
			value = BEER_FILTERING_ALGORITHM_BY_EXACT_ABV;
			break;
		case BY_EXACT_MARK:
			value = BEER_FILTERING_ALGORITHM_BY_EXACT_MARK;
			break;
		case BY_EXACT_STAR:
			value = BEER_FILTERING_ALGORITHM_BY_EXACT_STARS;
			break;
		case BY_TRAPPIST_NO:
			value = BEER_FILTERING_ALGORITHM_BY_TRAPPIST_NO;
			break;
		case BY_TRAPPIST_YES:
			value = BEER_FILTERING_ALGORITHM_BY_TRAPPIST_YES;
			break;
		case BY_PLACE_TRIED:
			value = BEER_FILTERING_ALGORITHM_BY_PLACE_TRIED;
			break;
		default:
				break;
		
		}
		return value;
	}
	
	public static String[] getBeerFilterAlgorithmDescriptionList(){
		BeerFilterAlgorithm[] algorithms = BeerFilterAlgorithm.values();
		String[] values = new String[algorithms.length];
		for(int i=0;i<algorithms.length;i++){
			values[i]=getBeerFilterAlgorithmDescription(algorithms[i]);
		}
		return values;
	}
	
	public static BeerFilterAlgorithm getBeerFilterAlgorithmFromDescription(String descriptionString){
		BeerFilterAlgorithm value;
		switch(descriptionString){
		case BEER_FILTERING_ALGORITHM_BY_MINIMUM_ABV:
			value = BeerFilterAlgorithm.BY_MINIMUM_ABV;
			break;
		case BEER_FILTERING_ALGORITHM_BY_COUNTRY:
			value = BeerFilterAlgorithm.BY_COUNTRY;
			break;
		case BEER_FILTERING_ALGORITHM_BY_FERMENTATION_HIGH:
			value = BeerFilterAlgorithm.BY_FERMENTATION_HIGH;
			break;
		case BEER_FILTERING_ALGORITHM_BY_FERMENTATION_LOW:
			value = BeerFilterAlgorithm.BY_FERMENTATION_LOW;
			break;
		case BEER_FILTERING_ALGORITHM_BY_FERMENTATION_SPONTANEOUS:
			value = BeerFilterAlgorithm.BY_FERMENTATION_SPONTANEOUS;
			break;
		case BEER_FILTERING_ALGORITHM_BY_MINIMUM_MARK:
			value = BeerFilterAlgorithm.BY_MINIMUM_MARK;
			break;
		case BEER_FILTERING_ALGORITHM_BY_MINIMUM_STARS:
			value = BeerFilterAlgorithm.BY_MINIMUM_STARS;
			break;
		case BEER_FILTERING_ALGORITHM_BY_STYLE_PROVENIENCE:
			value = BeerFilterAlgorithm.BY_STYLE_PROVENIENCE;
			break;
		case BEER_FILTERING_ALGORITHM_BY_IS_TRIED_YES:
			value =BeerFilterAlgorithm.BY_IS_TRIED_YES;
			break;
		case BEER_FILTERING_ALGORITHM_BY_IS_TRIED_NO:
			value =BeerFilterAlgorithm.BY_IS_TRIED_NO;
			break;
		case BEER_FILTERING_ALGORITHM_BY_MAIN_STYLE:
			value = BeerFilterAlgorithm.BY_MAIN_STYLE;
			break;
		case BEER_FILTERING_ALGORITHM_NONE:
			value = BeerFilterAlgorithm.NONE;
			break;
		case BEER_FILTERING_ALGORITHM_BY_STYLE:
			value = BeerFilterAlgorithm.BY_STYLE;
			break;
		case BEER_FILTERING_ALGORITHM_BY_BREWERY:
			value = BeerFilterAlgorithm.BY_BREWERY;
			break;
		case BEER_FILTERING_ALGORITHM_BY_EXACT_STARS:
			value = BeerFilterAlgorithm.BY_EXACT_STAR;
			break;
		case BEER_FILTERING_ALGORITHM_BY_EXACT_MARK:
			value = BeerFilterAlgorithm.BY_EXACT_MARK;
			break;
		case BEER_FILTERING_ALGORITHM_BY_EXACT_ABV:
			value = BeerFilterAlgorithm.BY_EXACT_ABV;
			break;
		case BEER_FILTERING_ALGORITHM_BY_TRAPPIST_YES:
			value = BeerFilterAlgorithm.BY_TRAPPIST_YES;
			break;
		case BEER_FILTERING_ALGORITHM_BY_TRAPPIST_NO:
			value = BeerFilterAlgorithm.BY_TRAPPIST_NO;
			break;	
		case BEER_FILTERING_ALGORITHM_BY_PLACE_TRIED:
			value = BeerFilterAlgorithm.BY_PLACE_TRIED;
			break;
		default:
			value = null;
			break;
		
		}
		return value;
	}

	
	private static final String BREWERY_FILTERING_ALGORITHM_NONE = "Nessuno";
	private static final String BREWERY_FILTERING_ALGORITHM_BY_COUNTRY = "Nazione";
//	private static final String BREWERY_FILTERING_ALGORITHM_BY_BEST_AVERAGES = "Media (minima)";
//	private static final String BREWERY_FILTERING_ALGORITHM_BY_BEST_AVERAGE_LIST= "I primi 20 con media maggiore di";
	private static final String BREWERY_FILTERING_ALGORITHM_BY_TRAPPIST_YES = "Trappista";
	private static final String BREWERY_FILTERING_ALGORITHM_BY_TRAPPIST_NO = "Non trappista";

	
	public static String getBreweryFilterAlgorithmDescription(BreweryFilterAlgorithm algorithm){
		String value = null;;
		switch(algorithm){
		case COUNTRY:
			value = BREWERY_FILTERING_ALGORITHM_BY_COUNTRY;
			break;
		case NONE:
			value = BREWERY_FILTERING_ALGORITHM_NONE;
			break;
		case TRAPPIST_YES:
			value = BREWERY_FILTERING_ALGORITHM_BY_TRAPPIST_YES;
			break;
		case TRAPPIST_NO:
			value = BREWERY_FILTERING_ALGORITHM_BY_TRAPPIST_NO;
			break;

		}
		return value;
	}
	
	public static String[] getBreweryFilterAlgorithmDescriptionList(){
		BreweryFilterAlgorithm[] algorithms = BreweryFilterAlgorithm.values();
		String[] values = new String[algorithms.length];
		for(int i=0;i<algorithms.length;i++){
			values[i]=getBreweryFilterAlgorithmDescription(algorithms[i]);
		}
		return values;
	}
	
	public static BreweryFilterAlgorithm getBreweryFilterAlgorithmFromDescription(String descriptionString){
		BreweryFilterAlgorithm value;
		switch(descriptionString){
		case BREWERY_FILTERING_ALGORITHM_BY_COUNTRY:
			value = BreweryFilterAlgorithm.COUNTRY;
			break;
		case BREWERY_FILTERING_ALGORITHM_NONE:
			value = BreweryFilterAlgorithm.NONE;
			break;
		case BREWERY_FILTERING_ALGORITHM_BY_TRAPPIST_YES:
			value = BreweryFilterAlgorithm.TRAPPIST_YES;
			break;
		case BREWERY_FILTERING_ALGORITHM_BY_TRAPPIST_NO:
			value = BreweryFilterAlgorithm.TRAPPIST_NO;
		default:
			value=null;
			break;
		}
		return value;
	}
	
	
	private static final String STYLE_FILTER_ALGORITHM_BY_FERMENTATION_HIGH = "Fermentazione alta";
	private static final String STYLE_FILTER_ALGORITHM_BY_FERMENTATION_LOW = "Fermentazione bassa";
	private static final String STYLE_FILTER_ALGORITHM_BY_FERMENTATION_SPONTANEOUS = "Fermentazione spontanea";
	private static final String STYLE_FILTER_ALGORITHM_BY_COUNTRY = "Nazione";
	private static final String STYLE_FILTER_ALGORITHM_NONE = "Nessuna";
	private static final String STYLE_FILTER_ALGORITHM_BY_MAIN_STYLE = "Stile principale";
	
	public static String getStyleFilterAlgorithmDescription(StyleFilterAlgorithm algorithm){
		String value = null;
		switch(algorithm){
		case BY_COUNTRY:
			value = STYLE_FILTER_ALGORITHM_BY_COUNTRY;
			break;
		case BY_FERMENTATION_HIGH:
			value = STYLE_FILTER_ALGORITHM_BY_FERMENTATION_HIGH;
			break;
		case BY_FERMENTATION_LOW:
			value = STYLE_FILTER_ALGORITHM_BY_FERMENTATION_LOW;
			break;
		case BY_FERMENTATION_SPONTANEOUS:
			value = STYLE_FILTER_ALGORITHM_BY_FERMENTATION_SPONTANEOUS;
			break;
		case BY_MAIN_STYLE:
			value = STYLE_FILTER_ALGORITHM_BY_MAIN_STYLE;
			break;
		case NONE:
			value = STYLE_FILTER_ALGORITHM_NONE;
			break;		
		}
		return value;
	}
	
	public static String[] getStyleFilterAlgorithmDescriptionList(){
		StyleFilterAlgorithm[] algorithms = StyleFilterAlgorithm.values();
		String[] values = new String[algorithms.length];
		for(int i=0;i<algorithms.length;i++){
			values[i]=getStyleFilterAlgorithmDescription(algorithms[i]);
		}
		return values;
	}
	
	public static StyleFilterAlgorithm getStyleFilterAlgorithmFromDescription(String descriptionString){
		StyleFilterAlgorithm value;
		switch(descriptionString){
		case STYLE_FILTER_ALGORITHM_BY_COUNTRY:
			value = StyleFilterAlgorithm.BY_COUNTRY;
			break;
		case STYLE_FILTER_ALGORITHM_BY_FERMENTATION_HIGH:
			value = StyleFilterAlgorithm.BY_FERMENTATION_HIGH;
			break;
		case STYLE_FILTER_ALGORITHM_BY_FERMENTATION_LOW:
			value = StyleFilterAlgorithm.BY_FERMENTATION_LOW;
			break;
		case STYLE_FILTER_ALGORITHM_BY_FERMENTATION_SPONTANEOUS:
			value = StyleFilterAlgorithm.BY_FERMENTATION_SPONTANEOUS;
			break;
		case STYLE_FILTER_ALGORITHM_BY_MAIN_STYLE:
			value = StyleFilterAlgorithm.BY_MAIN_STYLE;
			break;
		case STYLE_FILTER_ALGORITHM_NONE:
			value = StyleFilterAlgorithm.NONE;
			break;	
		default:
			value = null;
			break;
		}
		return value;
	}
	
	
	
	
	private static final String BEER = "Birre";
	private static final String BREWERY = "Birrifici";
	private static final String STYLE = "Stili";
	
	public static String getViewDefaultDescription(ShowDefault view){
		String value = null;
		switch(view){
		case BEER:
			value = BEER;
			break;
		case BREWERY:
			value = BREWERY;
			break;
		case STYLE:
			value = STYLE;
			break;
		}
		return value;
		
	}
	
	public static String[] getDefaultViewDescriptionList(){
		ShowDefault[] values = ShowDefault.values();
		String[] strings = new String[values.length];
		int i=0;
		for(ShowDefault value: values){
			strings[i]=getViewDefaultDescription(value);
			i++;
		}
		return strings;
	}
	
	public static ShowDefault getViewDefaultFromDescription(String description){
		ShowDefault value = null;
		switch(description){

		case BEER:
			value = ShowDefault.BEER;
			break;
		case BREWERY:
			value = ShowDefault.BREWERY;
			break;
		case STYLE:
			value = ShowDefault.STYLE;
			break;
		}
		
		return value;
	}

	
	public static class Constants{
		public static final Object[] TABLE_HEADER_BEERS = {
				"Nome",
				"Birrificio",
				"Stile",
				"ABV %",
				"Voto",
				"Stelle",
				"Provata",
				"Luogo",
				"Prezzo"/*,*/
				/*"Descrizione"*/
		};
		
		public static final Object[] TABLE_HEADER_BREWERY = {
				"Nome",
				"Nazione",
				"Città",
				"Descizione",
				"Web"
		};
		
		public static final Object[] TABLE_HEADER_BREWERY_AVERAGE = {
				"Nome",
				"Nazione",
				"Città",
				"Media",
				"Descizione",
				"Web"
		};
		
		public static final Object[] TABLE_HEADER_STYLE = {
				"Stile",
				"Sottostile",
				"Fermentazione",
				"Paese d'origine",
				"Descrizione"
		};
		
		public static final String[] EXCEL_OLD ={
				"Microsoft excel 2003-2007 (xls)",
				"xls"
		};
		
		public static final String[] EXCEL_NEW ={
				"Microsoft excel 2010-2016 (xlsx)",
				"xlsx"
		};
		
		public static final String[] JSON ={
				"JavaScript Object Notation (json)",
				"json"
		};
		
		public static final String[] PDF ={
				"Portable Document Format (pdf)",
				"pdf"
		};
		
		public static final String[] TXT ={
				"Text file (txt)",
				"txt"
		};
		
		public static final String RENAME_STYLE_STRING = "Rinomina questo stile";
		public static final String RENAME_STYLE_TITLE = "Nuovo nome";
		public static final String RENAME_STYLE_MESSAGE = "Inserisci il nuovo nome dello stile";
		
		public static final String NEW_STYLE_STRING = "Nuovo";
		public static final String NEW_STYLE_TITLE = "Nuovo stile";
		public static final String NEW_STYLE_MESSAGE = "Inserisci il nome del nuovo stile:";
		
		public static final String QUESTION = "Domanda";
		public static final String CONFIRMATION_BEFORE_EXIT = "Ci sono dei dati da salvare. Uscire comunque?";
		public static final String CONFIRMATION_BEFORE_DELETE = "Vuoi davvero eliminare questi dati?";
		public static final String CONFIRMATION_BEFORE_DELETE_STYLE = "Vuoi davvero eliminare questo stile?"
				+ "\nSarà necessario anche eliminare tutte le birre appartenenti ad esso.";
		public static final String CONFIRMATION_BEFORE_DELETE_BREWERY = "Vuoi davvero eliminare questo birrificio?"
				+ "\nSarà necessario anche eliminare tutte le birre prodotte da esso.";
		public static final String CONFIRMATION_OVERRIDE_FILE = "Il file esiste già. Vuoi sovrascriverlo?";
		public static final String CONFIRMATION_SELECTED_THINGS = "Vuoi esportare solo gli elementi selezionati?";
		
		public static final String FILTER_BY_TITLE = "Filtra";
		
		public static final String BEERS_FILTER_BY_STYLE = "Scegli lo stile principale";
		public static final String BEER_FILTER_BY_STYLE_AND_SUB = "Scegli lo stile:";
		public static final String BEERS_FILTER_BY_NATION = "Scegli la nazione di produzione:";
		public static final String BEERS_FILTER_BY_ORIGIN_STYLE = "Scegli la nazione di origine dello stile:";
		public static final String BEERS_FILTER_BY_BREWERY = "Scegli il birrificio";
		public static final String BEERS_FILTER_BY_MINIMUM_MARK = "Scegli il voto minimo:";
		public static final String BEERS_FILTER_BY_EXACT_MARK = "Scegli il voto esatto:";
		public static final String BEERS_FILTER_BY_MINIMUM_STAR = "Scegli le stelle minime:";
		public static final String BEERS_FILTER_BY_EXACT_STAR = "Scegli le stelle esatte:";
		public static final String BEERS_FILTER_BY_MINIMUM_ABV = "Scegli l'ABV minimo:";
		public static final String BEERS_FILTER_BY_EXACT_ABV = "Scegli l'ABV esatto:";
		public static final String BEERS_FILTER_BY_PLACE_TRIED = "Scegli il luogo:";
		
		public static final String BREWERIES_FILTER_BY_COUNTRY = "Scegli la nazione:";
			
		public static final String STYLES_FILTER_BY_ORIGIN_COUNTRY = "Scegli la nazione di origine dello stile";
		public static final String STYLES_FILTER_BY_MAIN_STYLE = "Scegli lo stile principale";
		
		public static final String DEFAULT_PRICE = "0.0";
		public static final String DEFAULT_MARK = "0";
		public static final String DEFAULT_ABV = "0.0";
		public static final String DEFAULT_STAR = "0";
		
		
		
		public static final String NO_PLACES = "Non ci sono luoghi su cui effettuare la ricerca";
		public static final String NO_NATIONS = "Non ci sono nazioni su cui effettuare la ricerca";
		public static final String NO_STYLES = "Non ci sono stili su cui effettuare la ricerca";
		public static final String NO_BREWERY = "Non ci sono birrifici su cui effettuare la ricerca";
		
		
		public static final String WRITE_ALSO_TOTALE_PRICE = "Vuoi scrivere anche il prezzo totale?";
		
		public static final String ERROR = "Errore";
		
		public static final String SHOULD_SELECT_3_FILE = "Seleziona i file per l'import delle birre: servono anche i relativi file\n"
				+ "dei loro birrifici e stili";
		
		public static final String MUST_SELECT_3_FILE = "Per poter importare una o più birre, è necessario importare anche i relativi file"
				+ "dei loro birrifici e stili";
		
		public static final String WARN_BREWERY_STYLE_ALREADY_HERE = "Assicurati che i birrifici e gli stili delle birre da importati siano"
				+ "già presenti nel database locale";
		
		public static final String WARN_DEFAULT_CONFIGURATION = "A causa dell'errore precedente, verrà usata e salvata la configurazione di default";
		public static final String ERR_NO_COUNTRY = "A causa dell'errore precedente, non è possibile caricare la lista delle nazioni.\n"
				+ "Il programma non può funzionare senza.";
		
		public static final String ERR_SAVE_EXCEPTION = "Errore mentra si salvava questo errore"; //when trying to save an exception, there is no
		//need to show another exception dialog if an error occurs
		public static final String ERR_SAVE_DEFAULT_CONFIG = "Errore mentre si salvava la configurazione di default.\nAl prossimo avvio si ritetnterà.";
		
		
		public static final String WARN_BREWERY_NAME = "Il nome non può contenere ';'";
		public static final String WARN_BREWERY_TOWN = "La città non può contenere ';'";
		
		
//		public static final Integer MARK_SPINNER_STEP_VALUE = new Integer(1);
//		public static final Integer MARK_SPINNER_MIN_VALUE = new Integer(0);
//		public static final Integer MARK_SPINNER_MAX_VALUE = new Integer(5);
//		public static final Integer MARK_SPINNER_DEF_VALUE = new Integer(MARK_SPINNER_MIN_VALUE);
//		
//		public static final Double ABV_SPINNER_STEP_VALUE = new Double(00.10);
//		public static final Double ABV_SPINNER_MIN_VALUE = new Double(00.00);
//		public static final Double ABV_SPINNER_MAX_VALUE = new Double(99.00);
//		public static final Double ABV_SPINNER_DEF_VALUE = new Double(05.00);
//		
//		public static final Double PRICE_SPINNER_STEP_VALUE = new Double(00.01);
//		public static final Double PRICE_SPINNER_MIN_VALUE = new Double(00.10);
//		public static final Double PRICE_SPINNER_MAX_VALUE = new Double(99.0);
//		public static final Double PRICE_SPINNER_DEF_VALUE = new Double(05.00);
		
		
		public static final int MARK_SPINNER_STEP_VALUE = 1;
		public static final int MARK_SPINNER_MIN_VALUE = 0;
		public static final int MARK_SPINNER_MAX_VALUE = 100;
		public static final int MARK_SPINNER_DEF_VALUE = 50;
		
		public static final double ABV_SPINNER_STEP_VALUE = 00.10;
		public static final double ABV_SPINNER_MIN_VALUE = 00.00;
		public static final double ABV_SPINNER_MAX_VALUE = 99.00;
		public static final double ABV_SPINNER_DEF_VALUE = 05.00;
		
		public static final double PRICE_SPINNER_STEP_VALUE = 00.10;
		public static final double PRICE_SPINNER_MIN_VALUE = 00.10;
		public static final double PRICE_SPINNER_MAX_VALUE = 99.0;
		public static final double PRICE_SPINNER_DEF_VALUE = 05.00;
		
	}
	
	public static String getFileExtension(File f){
		String filePath=f.getAbsolutePath();
		return filePath.substring(filePath.lastIndexOf("."), filePath.length()).replace(".", "").toLowerCase();
	}
	
	public static ExportType getExportType(File f){
		ExportType export;
		String ext=getFileExtension(f);
		if(ext.equals("xls")){
			export=ExportType.EXCEL_OLD;
		}
		else if(ext.equals("xlsx")){
			export=ExportType.EXCEL_NEW;
		}
		else if(ext.equals("json")){
			export=ExportType.JSON;
		}
		else if(ext.equals("pdf")){
			export=ExportType.PDF;
		}else{
			export=ExportType.TXT;
		}
		return export;
	}
	
	public static FileNameExtensionFilter[] getAllFileFilters(){
//		FileNameExtensionFilter[] filters = new FileNameExtensionFilter[5];
		FileNameExtensionFilter[] filters = new FileNameExtensionFilter[4];
		filters[0]=new FileNameExtensionFilter(Constants.EXCEL_NEW[0], Constants.EXCEL_NEW[1]);
		filters[1]=new FileNameExtensionFilter(Constants.EXCEL_OLD[0], Constants.EXCEL_OLD[1]);
		filters[2]=new FileNameExtensionFilter(Constants.JSON[0], Constants.JSON[1]);
//		filters[3]=new FileNameExtensionFilter(Constants.PDF[0], Constants.PDF[1]);
		filters[3]=new FileNameExtensionFilter(Constants.TXT[0], Constants.TXT[1]);
		return filters;
	}
	
	public static FileNameExtensionFilter[] getSingleFileFilterAsArray(Model.ExportType type){
		FileNameExtensionFilter[] filters = new FileNameExtensionFilter[1];
		switch(type){
		case EXCEL_NEW:
			filters[0]=new FileNameExtensionFilter(Constants.EXCEL_NEW[0], Constants.EXCEL_NEW[1]);
			break;
		case EXCEL_OLD:
			filters[0]=new FileNameExtensionFilter(Constants.EXCEL_OLD[0], Constants.EXCEL_OLD[1]);
			break;
		case JSON:
			filters[0]=new FileNameExtensionFilter(Constants.JSON[0], Constants.JSON[1]);
			break;
		case PDF:
			filters[0]=new FileNameExtensionFilter(Constants.PDF[0], Constants.PDF[1]);
			break;
		case TXT:
			filters[0]=new FileNameExtensionFilter(Constants.TXT[0], Constants.TXT[1]);
			break;
		
		}
		return filters;
	}
	
	public static boolean checkIfExtensionIsPresent(File f){
		boolean returned=true;
		try{
			getFileExtension(f);
		}catch(StringIndexOutOfBoundsException e){
			returned=false;
		}
		return returned;
	}
	
	public static String getJFileChooserSelectedExtension(JFileChooser chooser){
		FileNameExtensionFilter filter=(FileNameExtensionFilter)chooser.getFileFilter();
		return filter.getExtensions()[0];
	}
	
	public static Function<List<Beer>, List<Beer>> getBeerSortingAlgorithm(QueryRunner.BeerSortingAlgorithm algorithm){
		Function<List<Beer>, List<Beer>> function=null;
		switch(algorithm){
		case COUNTRY_OF_BREWERY_STYLE:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByCountryOfBreweryStyle;
			break;
		case FERMENTATIOM_STYLE_COUNTRY_OF_BREWERY:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByFermentationStyleCountryOfBrewery;
			break;
		case FERMENTATION_COUNTRY_OF_STYLE_BREWERY:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByFermentationCountryOfStyleBrewery;
			break;
		case MARK_STAR_ASCENDING:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByMarkStarAscending;
			break;
		case STAR_MARK_ASCENDING:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByStarMarkAscending;
			break;
		case MARK_STAR_DESCENDING:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByMarkStarDescending;
			break;
		case STAR_MARK_DESCENDING:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByStarMarkDescending;
			break;
		case ABV_ASCENDING:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByABVAscending;
			break;
		case ABV_DESCENDING:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByABVDescending;
			break;
		case PRICE_ASCENDING:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByPriceAscending;
			break;
		case PRICE_DESCENDING:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByPriceDescending;
			break;
		case NAME:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByName;
			break;
		case COUNTRY_OF_BREWERY_NAME:
			function=QueryRunner.BeerQuery.BeerSort::beersSortedByCountryOfBreweryThenName;
			break;
		}
		return function;
	}
	
	
	public static Function<List<BreweryAverage>, List<BreweryAverage>> getBreweriesSortingAlgorithm(QueryRunner.BrewerySortingAlgorithm algorithm){
		Function<List<BreweryAverage>, List<BreweryAverage>> function=null;
		switch(algorithm){
		case AVERAGE_ASCENDING:
			function=QueryRunner.BreweryQuery.BrewerySort::breweriesSortedByAverageAscending;
			break;
		case COUNTRY_AVERAGE_ASCENDING:
			function=QueryRunner.BreweryQuery.BrewerySort::breweriesSortedByCountryThenAverageAscending;
			break;
		case AVERAGE_DESCENDING:
			function=QueryRunner.BreweryQuery.BrewerySort::breweriesSortedByAverageDescending;
			break;
		case COUNTRY_AVERAGE_DESCENDING:
			function=QueryRunner.BreweryQuery.BrewerySort::breweriesSortedByCountryThenAverageDescending;
			break;
		case COUNTRY_NAME:
			function=QueryRunner.BreweryQuery.BrewerySort::breweriesSortedByCountryThenNameWithAverage;
			break;
		case NAME:
			function=QueryRunner.BreweryQuery.BrewerySort::breweriesSortedByNameWithAverage;
			break;
		}
		return function;
	}
	
	public static Function<List<Style>, List<Style>> getStylesSortingAlgorithm(QueryRunner.StyleSortingAlgorithm algorithm){
		Function<List<Style>, List<Style>> function=null;
		switch(algorithm){
		case COUNTRY_FERMENTATION:
			function=QueryRunner.StyleQuery.StyleSort::styleSortedByCountryThenFermentationy;
			break;
		case FERMENTATION_COUNTRY:
			function=QueryRunner.StyleQuery.StyleSort::styleSortedByFermentationThenCountry;
			break;
		case FERMENTATION_CATEGORY:
			function=QueryRunner.StyleQuery.StyleSort::stylesSortedByFermentationCategorySubcategory;
			break;
		}
		return function;
	}
	
	
	public static String [] getStyleENGLISH(){
		QueryRunner.StyleSortingAlgorithm[] algorithms = QueryRunner.StyleSortingAlgorithm.values();
		String [] values = new String[algorithms.length];
		for(int i=0;i<algorithms.length;i++){
			String value = algorithms[i].toString().replaceAll("_", " ").toLowerCase();
			String first = new String(new char[]{value.charAt(0)}).toUpperCase();
			value.substring(1, value.length());
			first.concat(value);
			values[i]=value;
		}
		return values;
	}
	
	public String[] getBeerENGLISH(){
		QueryRunner.BeerSortingAlgorithm[] algorithms = QueryRunner.BeerSortingAlgorithm.values();
		String [] values = new String[algorithms.length];
		for(int i=0;i<algorithms.length;i++){
			String value = algorithms[i].toString().replaceAll("_", " ").toLowerCase();
			String first = new String(new char[]{value.charAt(0)}).toUpperCase();
			value.substring(1, value.length());
			first.concat(value);
			values[i]=value;
		}
		return values;
		}
	
	public String[] getBreweryENGLISH(){
		QueryRunner.BrewerySortingAlgorithm[] algorithms = QueryRunner.BrewerySortingAlgorithm.values();
		String [] values = new String[algorithms.length];
		for(int i=0;i<algorithms.length;i++){
			String value = algorithms[i].toString().replaceAll("_", " ").toLowerCase();
			String first = new String(new char[]{value.charAt(0)}).toUpperCase();
			value.substring(1, value.length());
			first.concat(value);
			values[i]=value;
		}
		return values;
	}
	
	
	public static String getStackTrace(Exception e){
		StringWriter w = new StringWriter();
		e.printStackTrace(new PrintWriter(w));
		return w.toString();
	}
	
	/**
	 * Transform a country list made so:
	 * Country-Name (COUNTRY-ACRONIM) 
	 * to a JSON array:
	 * [
	 * "Country-Name",...]
	 * @param input the file where the file input is
	 * @param output the file where the output will be written
	 * @throws FileNotFoundException while trying to open Scanner object (reading) and PrintStream (output)
	 */
	public static void fromTxtCountryListToJSONArray(File input, File output) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileInputStream(input));
		PrintStream out = new PrintStream(new FileOutputStream(output));
		
		while(sc.hasNext()){
			String s = sc.nextLine();
			String r = s;
			String a = "\"";
			String av = "\",";
			
			int l = s.lastIndexOf(" ");
			if(l!=-1){
				r=a.substring(0, l);
				r = a.concat(r).concat(av);
			}
						
			
			out.println(r);
		}
		

		out.close();
		sc.close();
	}
	
	public static List<String> getCountries(String fileName) throws JSONException, FileNotFoundException{
		JSONArray array = new JSONArray(new JSONTokener(new FileInputStream(new File(fileName))));
		List<String> countries = new LinkedList<String>();
		for(int i=0;i<array.length();i++){
			countries.add(array.getString(i));
		}
		return countries;
	}
	
	public static BiFunction <List<Style>, Object, List<Style>> getStyleFilteringAlgorithm(QueryRunner.StyleFilterAlgorithm algorithm){
		BiFunction <List<Style>, Object, List<Style>> function = null;
		switch(algorithm){
		case BY_COUNTRY:
			function = (List<Style> styles, Object o) -> QueryRunner.StyleQuery.StyleFilter.stylesFilteredByCountryOrigin(styles, (String)o);
			break;
		case BY_FERMENTATION_HIGH:
			function = (List<Style> styles, Object o) -> QueryRunner.StyleQuery.StyleFilter.stylesFilteredByFermentation(styles, Fermentation.HIGH);
			break;
		case BY_FERMENTATION_LOW:
			function = (List<Style> styles, Object o) -> QueryRunner.StyleQuery.StyleFilter.stylesFilteredByFermentation(styles, Fermentation.LOW);
			break;
		case BY_FERMENTATION_SPONTANEOUS:
			function = (List<Style> styles, Object o) -> QueryRunner.StyleQuery.StyleFilter.stylesFilteredByFermentation(styles, Fermentation.SPONTANEOUS);
			break;
		case BY_MAIN_STYLE:
			function = (List<Style> styles, Object o) -> QueryRunner.StyleQuery.StyleFilter.stylesFilteredByMainStyle(styles, (Style)o);
			break;
		case NONE:
			function = (List<Style> styles, Object o) -> styles;
			break;
		
		}
		return function;
	}
	
	public static BiFunction<List<Brewery>,Object,  List<Brewery>> getBreweryFilteringAlgorithm(QueryRunner.BreweryFilterAlgorithm algorithm){
		BiFunction<List<Brewery>, Object, List<Brewery>> function = null;
		switch(algorithm){
		case COUNTRY:
			function = (List<Brewery> breweries, Object o) -> QueryRunner.BreweryQuery.BreweryFilter.breweriesFilteredByCountry(breweries, (String)o);
			break;
		case NONE:
			function = (List<Brewery> breweries, Object o) -> breweries;
			break;
		case TRAPPIST_NO:
			function = (List<Brewery> breweries, Object o) -> QueryRunner.BreweryQuery.BreweryFilter.breweriesFilteredByTrappist(breweries, false);
			break;
		case TRAPPIST_YES:
			function = (List<Brewery> breweries, Object o) -> QueryRunner.BreweryQuery.BreweryFilter.breweriesFilteredByTrappist(breweries, true);
			break;		
		}
		return function;
	}
	
	public static BiFunction<List<BreweryAverage>,Object,  List<BreweryAverage>> getBreweryAverageFilteringAlgorithm(QueryRunner.BreweryFilterAlgorithm algorithm){
		BiFunction<List<BreweryAverage>, Object, List<BreweryAverage>> function = null;
		switch(algorithm){
		case COUNTRY:
			function = (List<BreweryAverage> breweries, Object o) -> QueryRunner.BreweryQuery.BreweryFilter.breweriesAverageFilteredByCountry(breweries, (String)o);
			break;
		case NONE:
			function = (List<BreweryAverage> breweries, Object o) -> breweries;
			break;
		case TRAPPIST_NO:
			function = (List<BreweryAverage> breweries, Object o) -> QueryRunner.BreweryQuery.BreweryFilter.breweriesAverageFilteredByTrappist(breweries, false);
			break;
		case TRAPPIST_YES:
			function = (List<BreweryAverage> breweries, Object o) -> QueryRunner.BreweryQuery.BreweryFilter.breweriesAverageFilteredByTrappist(breweries, true);
			break;		
		}
		return function;
	}
	
	
	
	public static BiFunction<List<Beer>, Object, List<Beer>> getBeerFilteringAlgorithm(QueryRunner.BeerFilterAlgorithm algorithm){
		BiFunction<List<Beer>, Object, List<Beer>> function = null;
		switch(algorithm){
		case BY_MINIMUM_ABV:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByMinimumAlcool(beers,(Double)o);
			break;
		case BY_COUNTRY:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByBreweryCountry(beers, (String)o);
			break;
		case BY_FERMENTATION_HIGH:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByFermentation(beers, Fermentation.HIGH);
			break;
		case BY_FERMENTATION_LOW:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByFermentation(beers, Fermentation.LOW);
			break;
		case BY_FERMENTATION_SPONTANEOUS:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByFermentation(beers, Fermentation.SPONTANEOUS);
			break;
		case BY_MINIMUM_MARK:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByMiminumMark(beers, (Integer)o);
			break;
		case BY_MINIMUM_STARS:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByMinimumNumberOfStars(beers, (Integer)o);
			break;
		case BY_STYLE_PROVENIENCE:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByStyleProvenience(beers, (String)o);
			break;
		case BY_IS_TRIED_NO:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByIsTried(beers, false);
			break;
		case BY_IS_TRIED_YES:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByIsTried(beers, true);
			break;
		case BY_MAIN_STYLE:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByMainStyle(beers, (Style)o);
			break;
		case NONE:
			function = (List<Beer> beers, Object o) -> beers;
			break;
		case BY_STYLE:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByStyle(beers, (Style)o);
			break;
		case BY_BREWERY:
			function =  (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByBrewery(beers, (Brewery)o);
			break;
		case BY_EXACT_ABV:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByExatcAlcool(beers, (Double)o);
			break;
		case BY_EXACT_MARK:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByExactMark(beers, (Integer)o);
			break;
		case BY_EXACT_STAR:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByExactNumberOfStars(beers, (Integer)o);
			break;
		case BY_TRAPPIST_NO:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByTrappist(beers, false);
			break;
		case BY_TRAPPIST_YES:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByTrappist(beers, true);
			break;
		case BY_PLACE_TRIED:
			function = (List<Beer> beers, Object o) -> QueryRunner.BeerQuery.BeerFilter.beersFilteredByPlaceTried(beers, (String)o);
			break;
		}
		return function;
	}
	
	
	public static String[] toArray(List<String> list){
		String[] array = new String[list.size()];
		for(int i=0;i<list.size();i++){
			array[i]=list.get(i);
		}
		return array;
	}
	
	
	public static List<Beer> createList(Beer b){
		List<Beer> beers = new LinkedList<Beer>();
		beers.add(b);
		return beers;
	}
	
	public static List<BreweryAverage> createList(BreweryAverage b){
		List<BreweryAverage> breweries = new LinkedList<BreweryAverage>();
		breweries.add(b);
		return breweries;
	}
	
	public static List<Style> createList(Style s){
		List<Style> styles = new LinkedList<Style>();
		styles.add(s);
		return styles;
	}
	
	
	public static List<Beer> subListBeer(List<Beer> beers, int [] position){
		List<Beer> subBeers = new LinkedList<Beer>();
//		for(int i: position){
//			subBeers.add(beers.get(i));
//		}
		
//		System.out.println("Beer at pos in utils "+position[0]);
//		Utils.printBeer(beers.get(position[0]), System.out);
		
		for(int i=0;i<position.length;i++){
			subBeers.add(beers.get(position[i]));
		}
		return subBeers;
	}
	
	public static List<BreweryAverage> subListBreweryAverage(List<BreweryAverage> breweries, int [] position){
		List<BreweryAverage> subBreweries = new LinkedList<BreweryAverage>();
		for(int i: position){
			subBreweries.add(breweries.get(i));
		}
		return subBreweries;
	}
	
	public static List<Brewery> subListBrewery(List<Brewery> breweries, int [] position){
		List<Brewery> subBreweries = new LinkedList<Brewery>();
		for(int i: position){
			subBreweries.add(breweries.get(i));
		}
		return subBreweries;
	}
	
	public static List<Style> subListStyle(List<Style> beers, int [] position){
		List<Style> subStyles = new LinkedList<Style>();
		for(int i: position){
			subStyles.add(beers.get(i));
		}
		return subStyles;
	}
	
	
	public static Point getPointForPopupMenu(JPopupMenu popup, JTable table){
		return SwingUtilities.convertPoint(popup, new Point(0,0), table);
	}
	
	public static Point getPointForPopupMenu(JPopupMenu popup, Point p, JTable table){
		return SwingUtilities.convertPoint(popup, p, table);
	}
	
	public static double getSum(List<Beer> beers){
		double res=0;
		for(Beer b: beers){
			res+=b.getPrice();
		}
		return res;
	}
	
	public static boolean isOnlySpace(String s){
		boolean ret = true;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!=' '){
				ret = false;
				i = s.length(); 
			}
		}
		return ret;
		
	}
	
	/**
	 * Method that checks if a brewery name is ok. It must not contains ";".
	 * @param name	the name of the brewery
	 * @return	<code>true</code> if the name does not contain ";".
	 */
	public static boolean isBreweryNameOk(String name){
		return !name.contains(";");
	}
	

	
	
	
//	public static String errorWhileToItalianString(ErrorWhile error){
//		String ret=null;
//		switch(error){
//		case ADDING:
//			ret = "aggiunta: ";
//			break;
//		case DELETING:
//			ret = "cancellazione: ";
//			break;
//		case DELETING_TRAVERSAL:
//			ret = "cancellazione dati relativi a questo oggetto: ";
//			break;
//		case SAVING:
//			ret = "salvataggio ";
//			break;
//		case UPDATING:
//			ret = "aggiornamento ";
//			break;
//		case UPDATING_TRAVERSAL:
//			ret = "modifica dati relativi a questo oggetto: ";
//			break;		
//		}
//		return ret;
//	}
//	
//	public static String errorWhileAppendCause(String s, ErrorWhile error){
//		String ret = s;
//		if(error == ErrorWhile.ADDING){
//			ret+= " E' probabile che l'oggetto sia gi� presente.";
//		}else if(error == ErrorWhile.DELETING_TRAVERSAL || error == ErrorWhile.UPDATING_TRAVERSAL){
//			ret += "E' dovuto ad un errore interno.";
//		}else if(error == ErrorWhile.SAVING){
//			ret += " Controllare che il file non sia gi� in uso";
//		}else {
//			//delte, update
//			ret += "La ricerca dell'oggetto � fallita. Pu� darsi che un oggetto uguale sia gi� presente.";
//		}
//		return ret;
//	}
	
	

	
	public static String shortDesc(Object o){
		String s = "";
		if (o instanceof Beer){
			s = createShortDescBeer((Beer)o);
		}else if(o instanceof Brewery || o instanceof BreweryAverage){
			s = createShortDescBrewery((Brewery)o);
		}else if(o instanceof Style){
			s = createShortDescStyle((Style)o);
		}
		return s;
	}
	
	public static String createShortDescBeer(Beer b){
		StringBuilder builder = new StringBuilder();
		builder.append("birra: ");
		builder.append(b.getName());
		return builder.toString();
	}
	
	public static String createShortDescBrewery(Brewery b){
		StringBuilder builder = new StringBuilder();
		builder.append("birrificio: ");
		builder.append(b.getBreweryName());
		return builder.toString();
	}
	
	public static String createShortDescStyle(Style style){
		StringBuilder builder = new StringBuilder();
		builder.append("stile: ");
		builder.append(style.getStyleMainName());
		builder.append(" ");
		builder.append(style.getStyleSubCategory());
		return builder.toString();
	}
	
	public static boolean isNotBlankWebsite(String website){
		return !(website.equals(" ") || website.equals(""));
	}

}
