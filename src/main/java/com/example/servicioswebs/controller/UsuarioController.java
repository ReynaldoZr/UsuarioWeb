package com.example.servicioswebs.controller;

import com.example.servicioswebs.model.Usuario;
import com.example.servicioswebs.service.UsuarioService;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class UsuarioController {

    @FXML
    private Button btnConsultar;

    @FXML
    private Label lblEstado;

    @FXML
    private TableView<Usuario> tablaUsuarios;

    @FXML
    private TableColumn<Usuario, Integer> colId;

    @FXML
    private TableColumn<Usuario, String> colFirstName;

    @FXML
    private TableColumn<Usuario, String> colLastName;

    @FXML
    private TableColumn<Usuario, String> colEmail;

    @FXML
    private TableColumn<Usuario, String> colPhone;

    @FXML
    private TableColumn<Usuario, String> colDateOfBirth;

    @FXML
    private TableColumn<Usuario, String> colCountry;

    @FXML
    private TableColumn<Usuario, String> colCity;

    @FXML
    private TableColumn<Usuario, String> colAddress;

    @FXML
    private TableColumn<Usuario, Double> colAnnualIncome;

    @FXML
    private TableColumn<Usuario, Integer> colCreditScore;

    @FXML
    private TableColumn<Usuario, Boolean> colHasUnpaidDebt;

    @FXML
    private TableColumn<Usuario, Double> colUnpaidDebtAmount;

    @FXML
    private TableColumn<Usuario, String> colStatus;

    private final UsuarioService usuarioService = new UsuarioService();

    @FXML
    public void initialize() {
        tablaUsuarios.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAnnualIncome.setCellValueFactory(new PropertyValueFactory<>("annualIncome"));
        colCreditScore.setCellValueFactory(new PropertyValueFactory<>("creditScore"));
        colHasUnpaidDebt.setCellValueFactory(new PropertyValueFactory<>("hasUnpaidDebt"));
        colUnpaidDebtAmount.setCellValueFactory(new PropertyValueFactory<>("unpaidDebtAmount"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @FXML
    private void onConsultarUsuarios() {
        lblEstado.setText("Consultando API REST...");

        Task<List<Usuario>> task = new Task<>() {
            @Override
            protected List<Usuario> call() throws Exception {
                return usuarioService.obtenerUsuarios();
            }
        };

        btnConsultar.disableProperty().bind(task.runningProperty());

        task.setOnSucceeded(e -> {
            List<Usuario> usuarios = task.getValue();
            tablaUsuarios.setItems(FXCollections.observableArrayList(usuarios));
            lblEstado.setText("Clientes encontrados: " + usuarios.size());
        });

        task.setOnFailed(e -> {
            Throwable error = task.getException();
            String mensaje = (error != null && error.getMessage() != null)
                    ? error.getMessage()
                    : "Error al consultar la API";
            lblEstado.setText(mensaje);
        });

        Thread hilo = new Thread(task);
        hilo.setDaemon(true);
        hilo.start();
    }
}
