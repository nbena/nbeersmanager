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
package org.nbena.beersmanager.exe.ui.views;

import java.awt.BorderLayout;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ViewAddNewStyle extends JDialog implements StyleDialog{

	private final JPanel contentPanel = new JPanel();
	
	private JTextField textFieldStyleSubcategory;
	private JEditorPane editorDescription;
	private JComboBox<String> comboBoxCountry;
	private JComboBox<String> comboBoxMainStyle;
	private JComboBox<String> comboBoxFermentation;
	
	private JScrollPane scrollPane;
	
	private JButton okButton;
	private JButton cancelButton;
	
	public void addActionListenerOkButton(ActionListener listener){
		okButton.addActionListener(listener);
	}
	
	public void addActionListenerCancelButton(ActionListener listener){
		cancelButton.addActionListener(listener);
	}
	
	
	public void fillComboFermentation(List<String> items){
		//do it here because index of items must be always the same.
		for(String item: items){
			comboBoxFermentation.addItem(item);
		}
	}
	

	/**
	 * Do not update the fermentation when click on a low-fermentation style.
	 * @param styles
	 */
	private void fillComboStyle(List<String> styles){
		for(String s: styles){
			comboBoxMainStyle.addItem(s);
		}
	}

	
	private void fillComboCountry(List<String> countries){
		for(String c: countries){
			comboBoxCountry.addItem(c);
		}
	}
	
	public void fillThings(List<String> styles, List<String> fermentations, List<String> countries){
		fillComboStyle(styles);
		fillComboCountry(countries);
		fillComboFermentation(fermentations);
	}
	
	
	public void setStyleMainName(String t){
		comboBoxMainStyle.setSelectedItem(t);
	}
	
	public void setStyleSubcategory(String t){
		textFieldStyleSubcategory.setText(t);
	}
	
	public void setFermentation(String t){
		comboBoxFermentation.setSelectedItem(t);
	}
	
	public void setStyleCountry(String t){
		comboBoxCountry.setSelectedItem(t);
	}
	
	public void setDescription(String t){
		editorDescription.setText(t);
		editorDescription.setCaretPosition(0);
	}
	
	public String getStyleMainName(){
		return (String)comboBoxMainStyle.getSelectedItem();
	}
	
	public String getStyleSubcategory(){
		return textFieldStyleSubcategory.getText();
	}
	
	public String getStyleCountry(){
		return (String)comboBoxCountry.getSelectedItem();
	}
	
	public String getDescription(){
		return editorDescription.getText();
	}
	
	public String getFermentation(){
		return (String)comboBoxFermentation.getSelectedItem();
	}
	
	public void addActionComboBoxSelectedItem(ActionListener listener){
		comboBoxMainStyle.addActionListener(listener);
	}
	
	public void addComboBoxItem(String t){
		comboBoxMainStyle.addItem(t);
		comboBoxMainStyle.setSelectedItem(t);
	}
	
	public void removeComboBoxSelection(){
		comboBoxMainStyle.setSelectedIndex(-1);
	}
	
	public void closeComboBox(){
		comboBoxMainStyle.setPopupVisible(false);
	}
	
	@Deprecated
	public void addComboBoxItem(String oldS,String newS){
//		comboBoxMainStyle.removeItem(oldS);
		comboBoxMainStyle.addItem(newS);
		comboBoxMainStyle.setSelectedItem(newS);
	}
	
	public void setOkButtonEnabled(boolean enabled){
		okButton.setEnabled(enabled);
	}
	
	public int getComboBoxSelectedItemIndex(){
		return comboBoxMainStyle.getSelectedIndex();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewAddNewStyle dialog = new ViewAddNewStyle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setContentType(String type){
		editorDescription.setContentType(type);
	}

	/**
	 * Create the dialog.
	 */
	public ViewAddNewStyle() {
		setBounds(100, 100, 509, 446);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblTitleLabel = new JLabel("");
			GridBagConstraints gbc_lblTitleLabel = new GridBagConstraints();
			gbc_lblTitleLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitleLabel.gridx = 0;
			gbc_lblTitleLabel.gridy = 0;
			contentPanel.add(lblTitleLabel, gbc_lblTitleLabel);
		}
		{
			JLabel lblStyleMain = new JLabel("Stile principale:");
			GridBagConstraints gbc_lblStyleMain = new GridBagConstraints();
			gbc_lblStyleMain.insets = new Insets(0, 0, 5, 5);
			gbc_lblStyleMain.gridx = 1;
			gbc_lblStyleMain.gridy = 2;
			contentPanel.add(lblStyleMain, gbc_lblStyleMain);
		}
		{
			comboBoxMainStyle = new JComboBox<String>();
			GridBagConstraints gbc_comboBoxMainStyle = new GridBagConstraints();
			gbc_comboBoxMainStyle.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxMainStyle.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxMainStyle.gridx = 3;
			gbc_comboBoxMainStyle.gridy = 2;
			contentPanel.add(comboBoxMainStyle, gbc_comboBoxMainStyle);
		}
		{
			JLabel lblSottostile = new JLabel("Sottostile:");
			GridBagConstraints gbc_lblSottostile = new GridBagConstraints();
			gbc_lblSottostile.insets = new Insets(0, 0, 5, 5);
			gbc_lblSottostile.gridx = 1;
			gbc_lblSottostile.gridy = 4;
			contentPanel.add(lblSottostile, gbc_lblSottostile);
		}
		{
			textFieldStyleSubcategory = new JTextField();
			GridBagConstraints gbc_textFieldStyleSubcategory = new GridBagConstraints();
			gbc_textFieldStyleSubcategory.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldStyleSubcategory.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStyleSubcategory.gridx = 3;
			gbc_textFieldStyleSubcategory.gridy = 4;
			contentPanel.add(textFieldStyleSubcategory, gbc_textFieldStyleSubcategory);
			textFieldStyleSubcategory.setColumns(10);
		}
		{
			JLabel lblFermentation = new JLabel("Fermentazione:");
			GridBagConstraints gbc_lblFermentation = new GridBagConstraints();
			gbc_lblFermentation.insets = new Insets(0, 0, 5, 5);
			gbc_lblFermentation.gridx = 1;
			gbc_lblFermentation.gridy = 6;
			contentPanel.add(lblFermentation, gbc_lblFermentation);
		}
		{
			comboBoxFermentation = new JComboBox<String>();
			GridBagConstraints gbc_comboBoxFermentation = new GridBagConstraints();
			gbc_comboBoxFermentation.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxFermentation.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxFermentation.gridx = 3;
			gbc_comboBoxFermentation.gridy = 6;
			contentPanel.add(comboBoxFermentation, gbc_comboBoxFermentation);
		}
		{
			JLabel lblOriginCountry = new JLabel("Paese d'origine:");
			GridBagConstraints gbc_lblOriginCountry = new GridBagConstraints();
			gbc_lblOriginCountry.insets = new Insets(0, 0, 5, 5);
			gbc_lblOriginCountry.gridx = 1;
			gbc_lblOriginCountry.gridy = 8;
			contentPanel.add(lblOriginCountry, gbc_lblOriginCountry);
		}
		{
			comboBoxCountry = new JComboBox<String>();
			GridBagConstraints gbc_comboBoxCountry = new GridBagConstraints();
			gbc_comboBoxCountry.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxCountry.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxCountry.gridx = 3;
			gbc_comboBoxCountry.gridy = 8;
			contentPanel.add(comboBoxCountry, gbc_comboBoxCountry);
		}
		{
			JLabel lblDescrizione = new JLabel("Descrizione:");
			GridBagConstraints gbc_lblDescrizione = new GridBagConstraints();
			gbc_lblDescrizione.insets = new Insets(0, 0, 0, 5);
			gbc_lblDescrizione.gridx = 1;
			gbc_lblDescrizione.gridy = 10;
			contentPanel.add(lblDescrizione, gbc_lblDescrizione);
		}
		{
			scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 3;
			gbc_scrollPane.gridy = 10;
			contentPanel.add(scrollPane, gbc_scrollPane);
		}
		{
			editorDescription = new JEditorPane();
//			GridBagConstraints gbc_textAreaDescription = new GridBagConstraints();
//			gbc_textAreaDescription.fill = GridBagConstraints.BOTH;
//			gbc_textAreaDescription.gridx = 3;
//			gbc_textAreaDescription.gridy = 10;
//			contentPanel.add(textAreaDescription, gbc_textAreaDescription);
			scrollPane.setViewportView(editorDescription);
//			textAreaDescription.setLineWrap(true);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Ok");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.setEnabled(false);
			}
			{
				cancelButton = new JButton("Annulla");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}

}
