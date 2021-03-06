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
package org.nbena.beersmanager.json.coreclasses;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.nbena.beersmanager.coreclasses.*;
import org.nbena.beersmanager.sclasses.BeerJSONExportSpecialClass;
import org.nbena.beersmanager.sclasses.BeerJSONSaveSpecialClass;
import org.nbena.beersmanager.sclasses.StyleJSONSpecialClass;




/**
 * This class is used to export/import data for the "DB".
 * @author nbena
 *
 */
public class JSONExporterCoreClasses {
	
	private static final String JSON_BEER_STYLE_MAIN_NAME = "styleMainName";
	private static final String JSON_BEER_ALCOOL = "alcool";
	private static final String JSON_BEER_TRIED = "tried";
	private static final String JSON_BEER_STYLE_SUBCATEGORY = "styleSubcategory";
	private static final String JSON_BEER_NUMBER_STARS = "numberOfStars";
//	private static final String JSON_BEER_COLOR = "color";
	private static final String JSON_BEER_PRICE = "price";
	private static final String JSON_BEER_NAME = "beerName";
	private static final String JSON_BEER_PLACE_TRIED = "placeTried";
	private static final String JSON_BEER_BREWERY_NAME = "breweryName";
	private static final String JSON_BEER_MARK = "mark";
	private static final String JSON_BEER_DESCRIPTION = "beerDescription";
	
	private static final String JSON_BREWERY_NAME = "breweryName";
	private static final String JSON_BREWERY_TOWN = "town";
	private static final String JSON_BREWERY_COUNTRY = "country";
	private static final String JSON_BREWERY_DESCRIPTION = "breweryDescription";
	private static final String JSON_BREWERY_WEBSITE = "website";
	private static final String JSON_BREWERY_TRAPPIST = "authenticTrappist";
	
	private static final String JSON_STYLE_MAIN_NAME = "styleMainName";
	private static final String JSON_STYLE_SUBCATEGORY = "styleSubCategory";
	private static final String JSON_STYLE_DESCRIPTION = "styleDescription";
	private static final String JSON_STYLE_COUNTRY_ORIIGIN = "styleCountryOrigin";
	private static final String JSON_STYLE_FERMENTATION = "fermentation";
	
	private static final String JSON_UNSPECIAL_BEER_BREWERY = "brewery";
	private static final String JSON_UNSPECIAL_BEER_STYLE = "style";

	
	public static void writeBrewery(List<Brewery> breweries, OutputStream out) throws JSONException{
		JSONArray array=new JSONArray(breweries);
		PrintStream ps=new PrintStream(out);
		ps.print(array.toString());
	}
	

	
//	public static void writeStyle(List<Style> styles, OutputStream out) throws Exception{
//		/*
//		JSONArray array=new JSONArray();
//		array.put(styles);
//		PrintStream ps=new PrintStream(out);
//		ps.print(array.toString());
//		*/
//		throw new Exception("Invalid method");
//	}
	
	/*
	public  void writeBeerSpecialClass(List<Beer> beers, OutputStream out) throws Exception{
		JSONArray array=new JSONArray();
		array.put(beers);
		PrintStream ps=new PrintStream(out);
		ps.print(array.toString());
	}
	*/
	
	/**
	 * 
	 * @param beers
	 * @param out
	 * @throws JSONException
	 * @deprecated use <code> {@link #writeBeerSpecial(List, OutputStream)} </code>.
	 */
	public static void writeBeer(List<Beer> beers, OutputStream out) throws JSONException{
		JSONArray array=new JSONArray(beers);
		PrintStream ps=new PrintStream(out);
		ps.print(array.toString());
		
		
	}
	
	public static void writeBeerSpecial(List<Beer> beers, OutputStream out)throws JSONException{
		List<BeerJSONSaveSpecialClass> beerSpecial = Converter.toBeerJSONSaveSpecialClassList(beers);
		JSONArray array= new JSONArray(beerSpecial);
		PrintStream ps=new PrintStream(out);
		ps.print(array.toString());
	}
	
	
	public static void writeStyleSpecial(List<Style> styles, OutputStream out)throws JSONException{
		List<StyleJSONSpecialClass> styleSpecial = Converter.toSpecialStyleList(styles);
		JSONArray array= new JSONArray(styleSpecial);
		PrintStream ps=new PrintStream(out);
		ps.print(array.toString());
	}
	
	
//	public static String writeBeers(List<Beer> beers){
//		return new JSONArray(beers).toString();
//	}
//	
//	public static String writeBeersSpecial(List<Beer> beers){
//		List<BeerJSONSaveSpecialClass> beerSpecial = Converter.toBeerJSONSaveSpecialClassList(beers);
//		return new JSONArray(beerSpecial).toString();
//	}
//		
//	public static String writeBreweries(List<Brewery> breweries){
//		return new JSONArray(breweries).toString();
//	}
//	
//	public static String writeStyles(List<Style> styles){
//		return new JSONArray(styles).toString();
//	}
//	
//	public static String writeStylesSpecial(List<Style> styles){
//		List<StyleJSONSpecialClass> styleSpecial = Converter.toSpecialStyleList(styles);
//		return new JSONArray(styleSpecial).toString();
//	}
//	
//	public static String writeBeer(Beer b){
//		return new JSONObject(b).toString();
//	}
//	
//	public static String writeBrewery(Brewery b){
//		return new JSONObject(b).toString();
//	}
//	
//	public static String writeStyle(Style s){
//		return new JSONObject(s).toString();
//	}
//	
//	public static String writeStyleSpecial(Style s){
//		return new JSONObject(Converter.toStyleSpecialClass(s)).toString();
//	}
	
	
	public static BeerJSONSaveSpecialClass toBeerSpecialClass(JSONObject obj){
		BeerJSONSaveSpecialClass beer=new BeerJSONSaveSpecialClass();
		beer.setAlcool(obj.getDouble(JSON_BEER_ALCOOL));
		beer.setBreweryName(obj.getString(JSON_BEER_BREWERY_NAME));
//		beer.setColor(obj.getString(JSON_BEER_COLOR));
		beer.setBeerDescription(obj.getString(JSON_BEER_DESCRIPTION));
		beer.setMark(obj.getInt(JSON_BEER_MARK));
		beer.setBeerName(obj.getString(JSON_BEER_NAME));
		beer.setNumberOfStars(obj.getInt(JSON_BEER_NUMBER_STARS));
		beer.setPlaceTried(obj.getString(JSON_BEER_PLACE_TRIED));
		beer.setPrice(obj.getDouble(JSON_BEER_PRICE));
		beer.setStyleMainName(obj.getString(JSON_BEER_STYLE_MAIN_NAME));
		beer.setStyleSubcategory(obj.getString(JSON_BEER_STYLE_SUBCATEGORY));
		beer.setTried(obj.getBoolean(JSON_BEER_TRIED));
		return beer;
	}
	
	public static StyleJSONSpecialClass toStyleSpecialClass(JSONObject obj){
		StyleJSONSpecialClass style=new StyleJSONSpecialClass();
		style.setStyleMainName(obj.getString(JSON_STYLE_MAIN_NAME));
		style.setStyleSubCategory(obj.getString(JSON_STYLE_SUBCATEGORY));
		style.setStyleCountryOrigin(obj.getString(JSON_STYLE_COUNTRY_ORIIGIN));
		style.setFermentation(obj.getString(JSON_STYLE_FERMENTATION));
		style.setStyleDescription(obj.getString(JSON_STYLE_DESCRIPTION));
		return style;
	}
	
	public static Brewery toBrewery(JSONObject obj){
		Brewery brewery = new Brewery();
		brewery.setAuthenticTrappist(obj.getBoolean(JSON_BREWERY_TRAPPIST));
		brewery.setCountry(obj.getString(JSON_BREWERY_COUNTRY));
		brewery.setBreweryDescription(obj.getString(JSON_BREWERY_DESCRIPTION));
		brewery.setBreweryName(obj.getString(JSON_BREWERY_NAME));
		brewery.setTown(obj.getString(JSON_BREWERY_TOWN));
		brewery.setWebsite(obj.getString(JSON_BREWERY_WEBSITE));
		return brewery;
	}
	
//	public static Beer toBeer(JSONObject obj){
//		Brewery b = toBrewery(obj.getJSONObject(JSON_UNSPECIAL_BEER_BREWERY));
//		Style s =  Converter.toNormalStyle(toStyleSpecialClass(obj.getJSONObject(JSON_UNSPECIAL_BEER_STYLE))) ;
//		Beer beer=new Beer();
//		beer.setAlcool(obj.getDouble(JSON_BEER_ALCOOL));
////		beer.setBreweryName(obj.getString(JSON_BEER_BREWERY_NAME));
////		beer.setColor(obj.getString(JSON_BEER_COLOR));
//		beer.setDescription(obj.getString(JSON_BEER_DESCRIPTION));
//		beer.setMark(obj.getInt(JSON_BEER_MARK));
//		beer.setName(obj.getString(JSON_BEER_NAME));
//		beer.setNumberOfStars(obj.getInt(JSON_BEER_NUMBER_STARS));
//		beer.setPlaceTried(obj.getString(JSON_BEER_PLACE_TRIED));
//		beer.setPrice(obj.getDouble(JSON_BEER_PRICE));
////		beer.setStyleMainName(obj.getString(JSON_BEER_STYLE_MAIN_NAME));
////		beer.setStyleSubcategory(obj.getString(JSON_BEER_STYLE_SUBCATEGORY));
//		beer.setTried(obj.getBoolean(JSON_BEER_TRIED));
//		beer.setStyle(s);
//		beer.setBrewery(b);
//		return beer;
//	}
	
	public static BeerJSONExportSpecialClass toBeerJSONExportSpecialClass(JSONObject obj){
		Brewery b = toBrewery(obj.getJSONObject(JSON_UNSPECIAL_BEER_BREWERY));
		BeerJSONExportSpecialClass beer=new BeerJSONExportSpecialClass();
		beer.setAlcool(obj.getDouble(JSON_BEER_ALCOOL));
//		beer.setBreweryName(obj.getString(JSON_BEER_BREWERY_NAME));
//		beer.setColor(obj.getString(JSON_BEER_COLOR));
		beer.setBeerDescription(obj.getString(JSON_BEER_DESCRIPTION));
		beer.setMark(obj.getInt(JSON_BEER_MARK));
		beer.setBeerName(obj.getString(JSON_BEER_NAME));
		beer.setNumberOfStars(obj.getInt(JSON_BEER_NUMBER_STARS));
		beer.setPlaceTried(obj.getString(JSON_BEER_PLACE_TRIED));
		beer.setPrice(obj.getDouble(JSON_BEER_PRICE));
//		beer.setStyleMainName(obj.getString(JSON_BEER_STYLE_MAIN_NAME));
//		beer.setStyleSubcategory(obj.getString(JSON_BEER_STYLE_SUBCATEGORY));
		beer.setTried(obj.getBoolean(JSON_BEER_TRIED));
		beer.setBrewery(b);
		StyleJSONSpecialClass style = toStyleSpecialClass(obj.getJSONObject(JSON_UNSPECIAL_BEER_STYLE));
		beer.setStyle(style);
		return beer;
	}
	
	public static List<BeerJSONSaveSpecialClass> readBeersSpecial(InputStream in)throws JSONException{
		JSONArray array =new JSONArray(new JSONTokener(in));
		LinkedList<BeerJSONSaveSpecialClass> beers=new LinkedList<BeerJSONSaveSpecialClass>();
		for (int i=0;i<array.length();i++){
			BeerJSONSaveSpecialClass b=toBeerSpecialClass(array.getJSONObject(i));
			beers.add(b);
		}
		return beers;
	}
	
//	public static List<Beer> readBeersUnspecial(InputStream in)throws JSONException{
//		JSONArray array = new JSONArray(new JSONTokener(in));
//		List<Beer> beers = new LinkedList<Beer>();
//		for(int i=0;i<array.length();i++){
//			beers.add(toBeer(array.getJSONObject(i)));
//		}
//		return beers;
//	}
	
	
//	public static Brewery readBrewery(String in){
//		JSONObject json = new JSONObject(new JSONTokener(in));
//		return toBrewery(json);
//	}
//	
//	public static Style readStyle(String in){
//		JSONObject json = new JSONObject(new JSONTokener(in));
//		return Converter.toNormalStyle(toStyleSpecialClass(json));
//	}
	
	public static List<StyleJSONSpecialClass> readStylesSpecial(InputStream in)throws JSONException{
		JSONArray array =new JSONArray(new JSONTokener(in));
		LinkedList<StyleJSONSpecialClass> styles=new LinkedList<StyleJSONSpecialClass>();
		for (int i=0;i<array.length();i++){
			StyleJSONSpecialClass b=toStyleSpecialClass(array.getJSONObject(i));
			styles.add(b);
		}
		return styles;
	}
	
	public static List<Brewery> readBreweries(InputStream in)throws JSONException{
		JSONArray array =new JSONArray(new JSONTokener(in));
		LinkedList<Brewery> breweries=new LinkedList<Brewery>();
		for (int i=0;i<array.length();i++){
			Brewery b=toBrewery(array.getJSONObject(i));
			breweries.add(b);
		}
		return breweries;
	}
	
	
	public static void writeBeerJSONExportSpecialClass(List<Beer> beers, OutputStream out){
		List<BeerJSONExportSpecialClass> specialBeers = Converter.toBeerJSONExportSpecialClassList(beers);
		JSONArray array = new JSONArray(specialBeers);
		PrintStream output = new PrintStream(out);
		output.print(array.toString());
//		System.out.println(array.toString());
	}
	
	public static List<Beer> readBeersJSONExportSpecialClass(InputStream in){
		JSONArray array = new JSONArray(new JSONTokener(in));
		List<Beer> beers = new LinkedList<Beer>();
		for(int i=0;i<array.length();i++){
			BeerJSONExportSpecialClass beer = toBeerJSONExportSpecialClass(array.getJSONObject(i));
			beers.add(Converter.toNormalBeerFromJSONExportSpecialClass(beer));
		}
		return beers;
	}
	
	

}
