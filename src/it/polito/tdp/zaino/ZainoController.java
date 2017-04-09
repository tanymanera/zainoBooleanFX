package it.polito.tdp.zaino;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.zaino.model.Model;
import it.polito.tdp.zaino.model.Pezzo;
import it.polito.tdp.zaino.model.Zaino;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class ZainoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Zaino> boxProblema;

    @FXML
    private TextArea txtProblema;

    @FXML
    private TextArea txtSoluzione;

	private Model model;

    @FXML
    void handleCarica(ActionEvent event) {
    	
    	Zaino z = boxProblema.getValue() ;
    	
    	if(z==null) {
    		txtProblema.appendText("ERRORE: selezionare uno zaino\n");
    		return ;
    	}
    	
    	txtProblema.appendText("Problema selezionato: "+z.toString()+"\n") ;
    	model.selezionaZaino(z) ;
    	txtProblema.appendText("Pezzi: "+model.getProblemaCorrente().getPezzi().size()+"\n") ;
    	txtProblema.appendText(model.getProblemaCorrente().getPezzi().toString()+"\n");

    }

    @FXML
    void handleRisolvi(ActionEvent event) {

    	if(model.getProblemaCorrente() == null) {
    		txtSoluzione.appendText("ERRORE: caricare un problema\n");
    		return ;
    	}
    	
    	Set<Pezzo> soluz = model.solve() ;
    	
    	txtSoluzione.appendText("Soluzione trovata: " + soluz + "\n");
    	txtSoluzione.appendText("Numero di chiamate: "+model.getNumCalls()+"\n");
    	txtSoluzione.appendText("Tempo impiegato: "+model.getElapsedTime()+"ms\n");
    	
    }

    @FXML
    void initialize() {
        assert boxProblema != null : "fx:id=\"boxProblema\" was not injected: check your FXML file 'Zaino.fxml'.";
        assert txtProblema != null : "fx:id=\"txtProblema\" was not injected: check your FXML file 'Zaino.fxml'.";
        assert txtSoluzione != null : "fx:id=\"txtSoluzione\" was not injected: check your FXML file 'Zaino.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model ;
		
		boxProblema.getItems().addAll(this.model.getProblemi()) ;
	}
}
