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
package org.nbena.beersmanager.sclasses;

/*
import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
*/

/*
 * Tought about declare static inside XMLHelper class, but i choose to divide them to better work on two separated (and big) classes
 */
//@XmlRootElement(name="beer")
//@XmlAccessorType(XmlAccessType.FIELD)
/**
 * This class is a modified version of {@link #org.nbena.beersmanager.coreclasses.Beer()}, made to be saved into the beer file.
 * To save space, I modify the style and the brewery property of the "normal class" and replaced them by a normal string.
 * It means that when you read the beers, you need to re-create the normal class by linking each beer to its brewery and its style
 * basing on their name.
 * @author nbena
 * @see org.nbena.beersmanager.coreclasses.Beer
 *
 */
public class BeerJSONSaveSpecialClass {
	private String beerName;
	private String breweryName;
	private String styleMainName;
	private String styleSubcategory;
	private boolean isTried;
	private String placeTried;
	private double price;
	private double alcool;
	private int mark;
	private int numberOfStars;
	private String beerDescription;
//	private String color;
	//private byte[] image; //tell to xml to ignore
	private String imageFilePath;
	


	
	public String getImageFilePath() {
		return imageFilePath;
	}




	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}




	public BeerJSONSaveSpecialClass(String name, String breweryName, String styleMainName, String styleSubcategory) {
		this.beerName = name;
		this.breweryName = breweryName;
		this.styleMainName = styleMainName;
		this.styleSubcategory = styleSubcategory;
	}




	public BeerJSONSaveSpecialClass(String name, String breweryName, String styleMainName, String styleSubcategory, int numberOfStars) {
		this.beerName = name;
		this.breweryName = breweryName;
		this.styleMainName = styleMainName;
		this.styleSubcategory = styleSubcategory;
		this.numberOfStars=numberOfStars;
	}

	
	
	

//	public void setAssage(String placeTried, double price, double alcool, int mark, int numberOfStars, String description) {
//		this.placeTried = placeTried;
//		this.price = price;
//		this.alcool = alcool;
//		this.mark = mark;
//		this.numberOfStars = numberOfStars;
//		this.description = description;
//	}
//	
//	public void setAssage(String placeTried, double price, double alcool, int mark, int numberOfStars, String description, String color) {
//		this.placeTried = placeTried;
//		this.price = price;
//		this.alcool = alcool;
//		this.mark = mark;
//		this.numberOfStars = numberOfStars;
//		this.description = description;
//		this.color=color;
//	}
//	
//	public void setAssage(String placeTried, double price, double alcool, int mark, int numberOfStars, String description, byte[] image) {
//		this.placeTried = placeTried;
//		this.price = price;
//		this.alcool = alcool;
//		this.mark = mark;
//		this.numberOfStars = numberOfStars;
//		this.description = description;
//	}

	public BeerJSONSaveSpecialClass() {
	}

	/**
	 * @return the name
	 */
	public String getBeerName() {
		return beerName;
	}

	/**
	 * @param beerName the name to set
	 */
	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	/**
	 * @return the String
	 */
	public String getBreweryName() {
		return breweryName;
	}

	/**
	 * @param String the String to set
	 */
	public void setBreweryName(String breweryName) {
		this.breweryName = breweryName;
	}


	public String getStyleMainName() {
		return styleMainName;
	}




	public void setStyleMainName(String styleMainName) {
		this.styleMainName = styleMainName;
	}




	public String getStyleSubcategory() {
		return styleSubcategory;
	}




	public void setStyleSubcategory(String styleSubcategory) {
		this.styleSubcategory = styleSubcategory;
	}




	/**
	 * @return the isTried
	 */
	public boolean isTried() {
		return isTried;
	}

	/**
	 * @param isTried the isTried to set
	 */
	public void setTried(boolean isTried) {
		this.isTried = isTried;
	}

	/**
	 * @return the placeTried
	 */
	public String getPlaceTried() {
		return placeTried;
	}

	/**
	 * @param placeTried the placeTried to set
	 */
	public void setPlaceTried(String placeTried) {
		this.placeTried = placeTried;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the alcool
	 */
	public double getAlcool() {
		return alcool;
	}

	/**
	 * @param alcool the alcool to set
	 */
	public void setAlcool(double alcool) {
		this.alcool = alcool;
	}

	/**
	 * @return the mark
	 */
	public int getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}


	/**
	 * @return the description
	 */
	public String getBeerDescription() {
		return beerDescription;
	}

	/**
	 * @param beerDescription the description to set
	 */
	public void setBeerDescription(String beerDescription) {
		this.beerDescription = beerDescription;
	}

	
//	/**
//	 * @return the color
//	 */
//	public String getColor() {
//		return color;
//	}
//
//	/**
//	 * @param color the color to set
//	 */
//	public void setColor(String color) {
//		this.color = color;
//	}




	/**
	 * @return the numberOfStars
	 */
	public Integer getNumberOfStars() {
		return numberOfStars;
	}




	/**
	 * @param numberOfStars the numberOfStars to set
	 */
	public void setNumberOfStars(Integer numberOfStars) {
		this.numberOfStars = numberOfStars;
	}

	/*
	public boolean isComplete(){
		return name!=null && String!=null && style!=null && placeTried!=null && isTried!=null && price!=null && alcool!=null && mark!=null && numberOfStars!=null && description!=null; 
	}
	
	public boolean isVeryComplete(){
		return name!=null && String!=null && style!=null && placeTried!=null && isTried!=null && price!=null && alcool!=null && mark!=null && numberOfStars!=null && description!=null && image!=null; 
	}
	
	public boolean isMinimal(){
		return name!=null && String!=null && style!=null  && numberOfStars!=null; 
	}
	
	public boolean isVeryMinimal(){
		return name!=null && String!=null && style!=null; 
	}
	
	*/

}
