package aplication.jogodavelha;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Objects;

public class VelhaController {

    int empate = 0;
    final String gamerX = "X";
    final String gamerO = "O";
    private String selected;
    @FXML
    private Button btn00;
    @FXML
    private Button btn01;
    @FXML
    private Button btn02;
    @FXML
    private Button btn10;
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;
    @FXML
    private Button btn20;
    @FXML
    private Button btn21;
    @FXML
    private Button btn22;
    @FXML
    private RadioButton radio2;
    @FXML
    private ToggleGroup radios;
    @FXML
    private RadioButton radio1;
    @FXML
    private Button btn_reset;
    @FXML
    private Button btn_close;
    @FXML
    private Label label_vin;

    private Button[] botoes;
    private Button[] column1;
    private Button[] column2;
    private Button[] column3;
    private Button[] line1;
    private Button[] line2;
    private Button[] line3;
    private Button[] diagonal1;
    private Button[] diagonal2;


    @FXML
    void startGamer() {
        for (Button btn : botoes) {
            btn.setOnAction(value ->  {
                btn.setText(selected);
                btn.setDisable(true);
                if (radio1.isSelected()) radio2.setSelected(true);
                else radio1.setSelected(true);
                if (checkWin(column1) || checkWin(column2) || checkWin(column3) ||
                    checkWin(line1) || checkWin(line2) || checkWin(line3) ||
                    checkWin(diagonal1) || checkWin(diagonal2)){
                    for (Button b : botoes) {
                        b.setDisable(true);
                    }
                    return;
                }
                empate ++;
                if (empate == 9) {
                    label_vin.setText("Empatou !");
                    return;
                }
                selectGamer();
            });
        }
    }

    public void createTests(){
        column1 = new Button[3];
        column2 = new Button[3];
        column3 = new Button[3];
        line1 = new Button[3];
        line2 = new Button[3];
        line3 = new Button[3];
        diagonal1 = new Button[3];
        diagonal2 = new Button[3];

        column1[0] = btn00;
        column1[1] = btn01;
        column1[2] = btn02;
        column2[0] = btn10;
        column2[1] = btn11;
        column2[2] = btn12;
        column3[0] = btn20;
        column3[1] = btn21;
        column3[2] = btn22;

        line1[0] = btn00;
        line1[1] = btn10;
        line1[2] = btn20;
        line2[0] = btn01;
        line2[1] = btn11;
        line2[2] = btn21;
        line3[0] = btn02;
        line3[1] = btn12;
        line3[2] = btn22;

        diagonal1[0] = btn00;
        diagonal1[1] = btn11;
        diagonal1[2] = btn22;
        diagonal2[0] = btn02;
        diagonal2[1] = btn11;
        diagonal2[2] = btn20;

    }

    boolean checkWin(Button[] tests){
        int countX = 0;
        int countO = 0;
        for (Button b : tests) {
            if (b.isDisable()){
                if (Objects.equals(b.getText(), "X")){ countX ++; }
                else countO ++;
            }
        }
        if (countX == 3 || countO == 3){
            for (Button b : tests) {
                b.setStyle("-fx-background-color: #3f8ca1;");
            }
            if (countX == 3) winMessage(gamerX);
            else winMessage(gamerO);
            return true;
        }
        return false;
    }

    public void winMessage(String gamer){
        label_vin.setText("Jogador " + "'" + gamer + "'" + " venceu !");
    }

    public void selectGamer(){
        if (radio1.isSelected()) {
            selected = gamerX;
            label_vin.setText("Jogador X");
        }
        if (radio2.isSelected()) {
            selected = gamerO;
            label_vin.setText("Jogador O");
        }
    }

    @FXML
    void actionReset() {
        btn_reset.setOnAction(value -> {
            restartButtons();
        });
    }

    void restartButtons(){
        for (Button btn : botoes) {
            btn.setText("");
            btn.setDisable(false);
            btn.setStyle("");
        }
        radio1.setSelected(true);
        label_vin.setText("");
        selectGamer();
        startGamer();

    }

    @FXML
    void actionClose(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize(){
        botoes = new Button[9];
        botoes[0] = btn00;
        botoes[1] = btn01;
        botoes[2] = btn02;
        botoes[3] = btn10;
        botoes[4] = btn11;
        botoes[5] = btn12;
        botoes[6] = btn20;
        botoes[7] = btn21;
        botoes[8] = btn22;
        label_vin.setText("");
        createTests();
        actionReset();
        restartButtons();

    }



}
