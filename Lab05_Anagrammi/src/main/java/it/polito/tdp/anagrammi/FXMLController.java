package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;
    
    @FXML
    private Button btnCercaCorretti;

    @FXML
    private Button btnCerca;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCerca(ActionEvent event) {
    	
    	txtCorretti.clear();
    	txtErrati.clear();

    	String parola = txtInput.getText();
    	
    	List<Parola> anagrammi = model.getAnagrammi(parola, false);
    	
    	for(Parola p : anagrammi) {
    		if(p.esiste())
    			txtCorretti.appendText(p.toString()+"\n");
    		else
    			txtErrati.appendText(p.toString()+"\n");
    	}
    }

    @FXML
    void doCercaCorretti(ActionEvent event) {

    	txtCorretti.clear();
    	txtErrati.clear();

    	String parola = txtInput.getText();
    	
    	List<Parola> anagrammi = model.getAnagrammi(parola, true);
    	
    	for(Parola p : anagrammi) {
    		txtCorretti.appendText(p.toString()+"\n");
    	}
    	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorretti != null : "fx:id=\"btnCercaCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		
	}
}
