package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Funcionario;

public class CrudFuncionarioController implements Initializable {
	
	
    private ObservableList<Funcionario> listaObsFuncionario = FXCollections.observableArrayList();
	

	@FXML
    private TableColumn<Funcionario, String> listarSalario;
	
	@FXML
	private TableColumn<Funcionario, String> IdListar;

	@FXML
	private Label labelNomePesquisar;
	
	@FXML
	private TextField textoIdPesquisar;
	
    @FXML
    private Label labelDataNascimentoPesquisar;
    
    @FXML
    private TableColumn<Funcionario, String> listarNome;
    
    @FXML
    private TableColumn<Funcionario, String> listarDataNascimento;
    
    @FXML
    private Label labelSalarioPesquisar;

	@FXML
    private TextField IncluirsalarioFuncionario;

    @FXML
    private DatePicker AlterardataFuncionario;

    @FXML
    private TextField AlteraridFuncionario;

    @FXML
    private Button ExcluirButton;

    @FXML
    private TextField IncluirnomeFuncionario;

    @FXML
    private Button IncluirButton;

    @FXML
    private Label QuantidadeItens;

    @FXML
    private Button AlterarButton;

    @FXML
    private TextField AlterarnomeFuncionario;

    @FXML
    private Button PesquisarButton;

    @FXML
    private DatePicker IncluirdataFuncionario;

    @FXML
    private TextField AlterarsalarioFuncionario;

    @FXML
    private TextField ExcluiridFuncionario;

    @FXML
    private TableView<Funcionario> TVMostrar;
    


    private Main main;

    public void setMain(Main main) {

        this.main = main;
        
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		AtualizarQuantidade();
		AtualizarLista();
		

	}
	
	public void AtualizarLista() {
		IdListar.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("id"));
		listarNome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
		listarDataNascimento.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("dataNascimento"));
		listarSalario.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("salario"));
		TVMostrar.setItems(listaObsFuncionario);
		

	}
	@FXML
	void Pesquisar(ActionEvent event) {
		int idFuncionario = Integer.valueOf(textoIdPesquisar.getText()) - 1;
		Funcionario fun = listaObsFuncionario.get(idFuncionario);
		labelNomePesquisar.setText(fun.getNome());
		labelDataNascimentoPesquisar.setText(fun.getDataNascimento().toString());
		labelSalarioPesquisar.setText(String.valueOf(fun.getSalario()));
		
	    }

	@FXML
	 void BotaoSair(ActionEvent event) {
		System.exit(0);
	    }
	
	void AtualizarQuantidade() {
		QuantidadeItens.setText(String.valueOf(listaObsFuncionario.size()));
		
	}

    
    @FXML
    void IncluirFuncionario(ActionEvent event) {
    	
    listaObsFuncionario.add(new Funcionario(IncluirnomeFuncionario.getText(), IncluirdataFuncionario.getValue(),Float.parseFloat(IncluirsalarioFuncionario.getText())));
    
	AtualizarQuantidade();


    }

    @FXML
    void PesquisarFuncionario(ActionEvent event) {
    	int idFuncionario = Integer.valueOf(AlteraridFuncionario.getText()) - 1 ;
    	Funcionario fun = listaObsFuncionario.get(idFuncionario);
    	AlterarnomeFuncionario.setText(fun.getNome());
    	AlterardataFuncionario.setValue(fun.getDataNascimento());
    	AlterarsalarioFuncionario.setText(String.valueOf(fun.getSalario()));
    	TVMostrar.setItems(listaObsFuncionario);
    	
    }

    @FXML
    void AlterarFuncionario(ActionEvent event) {
    	int idFuncionario = Integer.valueOf(AlteraridFuncionario.getText())- 1;
    	Funcionario fun = listaObsFuncionario.get(idFuncionario);
    	
	    	fun.setNome(AlterarnomeFuncionario.getText());
	    	fun.setDataNascimento(AlterardataFuncionario.getValue());
	    	fun.setSalario(Float.parseFloat(AlterarsalarioFuncionario.getText()));
			AtualizarLista();
			
			
    }

   
    @FXML
    void ExcluirFuncionario(ActionEvent event) {
    	int idFuncionario = Integer.valueOf(ExcluiridFuncionario.getText()) - 1;
    	Alert alert = new Alert(AlertType.CONFIRMATION, "Deletar " + listaObsFuncionario.get(idFuncionario).getNome() + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
        	listaObsFuncionario.remove(idFuncionario);
        	AtualizarQuantidade();
        }
      
    	
    }

}


