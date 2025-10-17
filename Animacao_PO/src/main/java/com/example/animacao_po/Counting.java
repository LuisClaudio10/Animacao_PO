package com.example.animacao_po;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Counting {
    private AnchorPane pane;
    private Label[] fonte;
    private Label seta;
    private Label i;
    private Label j;
    private Label maior;
    private Label pos;

    private Button[] vetor;
    public void show() {
        pane = new AnchorPane();
        seta = new Label();
        i = new Label();
        j = new Label();
        maior = new Label();
        pos = new Label();

        pane.setPrefSize(1200, 800);
        Stage stage = new Stage();
        Scene scene = new Scene(pane);
        stage.setTitle("PO");
        stage.setScene(scene);
        stage.show();

        maior.setLayoutX(750);
        maior.setLayoutY(0);
        maior.setText("maior = ?");
        maior.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");

        i.setLayoutX(750);
        i.setLayoutY(20);
        i.setText("i = ?");
        i.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");

        j.setLayoutX(750);
        j.setLayoutY(40);
        j.setText("j = ?");
        j.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");

        pos.setLayoutX(750);
        pos.setLayoutY(60);
        pos.setText("pos = ?");
        pos.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");

        seta.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;-fx-text-fill: blue;");
        seta.setText("->");
        pane.getChildren().addAll(i, j, maior, pos);

        Codigo();

        Label vet = new Label();
        vet.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;-fx-text-fill: red;");
        vet.setText("Vet");
        vet.setLayoutX(610);
        vet.setLayoutY(150);
        pane.getChildren().add(vet);

        vetor = new Button[10];
        preenche(10, vetor);

        PauseTransition pause = new PauseTransition(Duration.seconds(1)); // espera 1 seg
        pause.setOnFinished(e -> AnimaCodigo(vetor));
        pause.play();
    }
    // =================== Código/GUI Counting ===================
    public void Codigo()
    {
        fonte = new Label[25];
        for(int k = 0; k < 25; k++)
            fonte[k] = new Label();
        fonte[0].setText("public int[] CountingSort(){");
        fonte[1].setText("int maior, i, j, pos;");
        fonte[2].setText("maior = vet[0];");
        fonte[3].setText("for(i = 1; i < TL; i++)");
        fonte[4].setText("  if(vet[i] > maior)");
        fonte[5].setText("    maior = vet[i];");
        fonte[6].setText("int vetC[] = new int[maior + 1];");
        fonte[7].setText("for(i = 0; i < vetC.length; i++)");
        fonte[8].setText("  vetC[i] = 0;");
        fonte[9].setText("for(i = 0; i < TL; i++){");
        fonte[10].setText(" j = 0;");
        fonte[11].setText(" while(j < vet[i])");
        fonte[12].setText("  j++;");
        fonte[13].setText(" vetC[j] = vetC[j] + 1;");
        fonte[14].setText("}");
        fonte[15].setText("for(i = 1; i < vetC.length; i++)");
        fonte[16].setText("  vetC[i] = vetC[i] + vetC[i-1];");
        fonte[17].setText("int vetResultado[] = new int[TL];");
        fonte[18].setText("for(i = 0; i < TL; i++){");
        fonte[19].setText("  pos = vetC[vet[i]] - 1;");
        fonte[20].setText("  vetResultado[pos] = vet[i];");
        fonte[21].setText("  vetC[vet[i]] = vetC[vet[i]] - 1;");
        fonte[22].setText("}");
        fonte[23].setText("return vetResultado;");
        fonte[24].setText("}");

        double x = 60, y0 = 60, h = 22;
        for (int k = 0; k < fonte.length; k++) {
            Label ln = fonte[k];
            ln.setStyle("-fx-font-family: 'Consolas', 'Courier New', monospace; -fx-font-size: 16px;");
            ln.setLayoutX(x);
            if(k == 24)
                ln.setLayoutX(50);
            ln.setLayoutY(y0 + k * h);
            pane.getChildren().add(ln);
        }
        seta.setText("→");
        seta.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: blue;");
        seta.setLayoutX(x - 27);
        seta.setLayoutY(y0 + 0 * h + 5);
        pane.getChildren().add(seta);
    }
    public void preenche(int qtde, Button[] vet) {
        Random rnd = new Random();
        double x = 650;
        double y = 150;
        double w = 40;
        double h = 30;
        double gap = 5;
        double xindice;
        int num;
        for (int idx = 0; idx < qtde; idx++) {
            Button b = new Button();
            num = rnd.nextInt(10) + 1;
            b.setText("" + num);
            b.setMinSize(w, h);
            b.setStyle("-fx-font-family: Consolas; -fx-font-size: 18px;");
            b.setLayoutX(x);
            b.setLayoutY(y);
            pane.getChildren().add(b);
            vet[idx] = b;
            xindice = x;
            x += w + gap;
            Label lidx = new Label("" + idx);
            lidx.setPrefWidth(w);
            lidx.setAlignment(Pos.CENTER);
            lidx.setStyle("-fx-font-family: Consolas; -fx-font-size: 15px; -fx-text-fill: #666;");
            lidx.setLayoutX(xindice);
            lidx.setLayoutY(y + h + 3);
            pane.getChildren().add(lidx);
        }
    }
    private void moverSetaLinhas(int linhas) {
        Platform.runLater(() -> {
            seta.setLayoutY(seta.getLayoutY() + linhas * 22);
            seta.setTranslateY(0);
        });
    }
    // =================== Animação Counting (AnimaCodigo) ===================
    public void AnimaCodigo(Button[] vet) {
        Label tempi = new Label("i");
        tempi.setAlignment(Pos.CENTER);
        tempi.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: green;");
        Platform.runLater(() -> pane.getChildren().add(tempi));
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                moverSetaLinhas(1);
                Platform.runLater(() -> maior.setText("maior = " + vet[0].getText()));
                Thread.sleep(500);
                int m = Integer.parseInt(vet[0].getText());
                moverSetaLinhas(1);
                Thread.sleep(500);
                for(int k = 1; k < vet.length; k++) {
                    int tempK = k;
                    Platform.runLater(() -> {
                        i.setText("i = " + tempK);
                        double cx = vet[tempK].getLayoutX() + vet[tempK].getWidth() / 2.0;
                        double y  = vet[tempK].getLayoutY() + vet[tempK].getHeight() + 18;
                        tempi.setLayoutX(cx - 4);
                        tempi.setLayoutY(y);
                    });
                    moverSetaLinhas(1);
                    Thread.sleep(500);
                    int val = Integer.parseInt(vet[tempK].getText());
                    Platform.runLater(() -> vet[tempK].setStyle("-fx-background-color: red; -fx-text-fill: black;"));
                    if(val > m) {
                        moverSetaLinhas(1);
                        Thread.sleep(500);
                        m = val;
                        int mm = m;
                        Platform.runLater(() -> maior.setText("maior = " + mm));
                        moverSetaLinhas(-2);
                        Thread.sleep(500);
                    } else {
                        moverSetaLinhas(-1);
                        Thread.sleep(500);
                    }
                    Platform.runLater(() -> {
                        vet[tempK].setStyle("");
                        vet[tempK].setStyle("-fx-font-family: Consolas; -fx-font-size: 18px;");
                    });
                }
                tempi.setVisible(false);
                moverSetaLinhas(3);
                Thread.sleep(500);

                double x = 650;
                double y = 250;
                double w = 40;
                double h = 30;
                double gap = 5;
                double xindice = 0;
                Button vetc[] = new Button[m + 1];
                for(int k = 0; k < m + 1; k++)
                {
                    int tempk = k;
                    Button b = new Button();
                    b.setStyle("-fx-font-family: Consolas; -fx-font-size: 18px;");
                    b.setLayoutX(x);
                    b.setLayoutY(y);
                    b.setMinSize(w, h);
                    Platform.runLater(() -> pane.getChildren().add(b));
                    vetc[k] = b;
                    xindice = x;
                    x += w + gap;
                    Label idx = new Label();
                    int finalK = k;
                    Platform.runLater(() -> idx.setText("" + finalK));
                    idx.setPrefWidth(w);
                    idx.setAlignment(Pos.CENTER);
                    idx.setStyle("-fx-font-family: Consolas; -fx-font-size: 15px; -fx-text-fill: #666;");
                    idx.setLayoutX(xindice);
                    idx.setLayoutY(y + h + 3);
                    Platform.runLater(() -> pane.getChildren().add(idx));
                }
                Label vetC = new Label();
                vetC.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;-fx-text-fill: blue;");
                Platform.runLater(() -> vetC.setText("VetC"));
                vetC.setLayoutX(600);
                vetC.setLayoutY(255);
                Platform.runLater(() -> pane.getChildren().add(vetC));
                moverSetaLinhas(1);
                Thread.sleep(500);
                tempi.setVisible(true);
                for(int k = 0; k < vetc.length; k++)
                {
                    int tempk = k;
                    moverSetaLinhas(1);
                    Platform.runLater(() -> {
                        i.setText("i = " + tempk);
                        double cx = vetc[tempk].getLayoutX() + vetc[tempk].getWidth() / 2.0;
                        double xy  = vetc[tempk].getLayoutY() + vetc[tempk].getHeight() + 18;
                        tempi.setLayoutX(cx - 4);
                        tempi.setLayoutY(xy);
                    });
                    Thread.sleep(500);
                    int finalK1 = k;
                    Platform.runLater(() -> vetc[finalK1].setText("0"));
                    vetc[tempk].setMinSize(w, h);
                    Platform.runLater(() -> vetc[tempk].setStyle("-fx-font-family: Consolas; -fx-font-size: 18px;"));
                    moverSetaLinhas(-1);
                    Thread.sleep(500);
                }
                tempi.setDisable(false);
                moverSetaLinhas(2);
                Thread.sleep(500);
                tempi.setVisible(true);
                Label tempj = new Label("j");
                Platform.runLater(() -> {
                    pane.getChildren().add(tempj);
                    tempj.setStyle("-fx-font-size: 18px;-fx-font-weight: bold");
                    tempj.setTextFill(Color.BLUEVIOLET);
                });
                for(int k = 0; k < vet.length; k++)
                {
                    int tempk = k;
                    Platform.runLater(() -> vet[tempk].setTextFill(Color.RED));
                    moverSetaLinhas(1);
                    Thread.sleep(500);
                    int jp = 0;
                    Platform.runLater(() -> {
                        i.setText("i = " + tempk);
                        double cx = vet[tempk].getLayoutX() + vet[tempk].getWidth() / 2.0;
                        double Y  = vet[tempk].getLayoutY() + vet[tempk].getHeight() + 18;
                        tempi.setLayoutX(cx - 4);
                        tempi.setLayoutY(Y);
                    });
                    Thread.sleep(500);
                    moverSetaLinhas(1);
                    while(jp < Integer.parseInt(vet[k].getText())) {
                        moverSetaLinhas(1);
                        int temporario = jp;
                        jp++;
                        int tempjp = jp;
                        Platform.runLater(() -> {
                            j.setText("j = " + temporario);
                            double cx = vetc[tempjp].getLayoutX() + vetc[tempjp].getWidth() / 2.0;
                            double Y  = vetc[tempjp].getLayoutY() + vetc[tempjp].getHeight() + 18;
                            tempj.setLayoutX(cx - 4);
                            tempj.setLayoutY(Y);
                        });
                        moverSetaLinhas(-1);
                        Thread.sleep(500);
                    }
                    int jatual = jp;
                    Platform.runLater(() -> j.setText("j = " + jatual));
                    moverSetaLinhas(2);
                    Thread.sleep(500);
                    int tempjp2 = jp;
                    Platform.runLater(() -> {
                        int atual = Integer.parseInt(vetc[tempjp2].getText());
                        vetc[tempjp2].setText("" + (atual + 1));
                    });
                    Platform.runLater(() -> vet[tempk].setTextFill(Color.BLACK));
                    moverSetaLinhas(-4);
                    Thread.sleep(500);
                }
                Platform.runLater(() -> {
                    tempj.setVisible(false);
                    tempj.setManaged(false);
                    j.setText("j = ?");
                });
                moverSetaLinhas(6);
                Thread.sleep(500);
                for(int k = 1; k < vetc.length; k++)
                {
                    moverSetaLinhas(1);
                    Thread.sleep(500);
                    int tempk = k;
                    Platform.runLater(() -> {
                        i.setText("i = " + tempk);
                        tempi.setText("i");
                        double cx = vetc[tempk].getLayoutX() + vetc[tempk].getWidth() / 2.0;
                        double Y  = vetc[tempk].getLayoutY() + vetc[tempk].getHeight() + 18;
                        tempi.setLayoutX(cx - 4);
                        tempi.setLayoutY(Y);
                    });
                    Platform.runLater(() -> {
                        int atual = Integer.parseInt(vetc[tempk].getText());
                        int anterior = Integer.parseInt(vetc[tempk-1].getText());
                        int resultado = atual + anterior;
                        vetc[tempk].setText("" + resultado);
                    });
                    moverSetaLinhas(-1);
                    Thread.sleep(500);
                }
                moverSetaLinhas(2);
                Thread.sleep(500);

                double x2 = 650, y2 = 350, w2 = 40, h2 = 30, gap2 = 5, xindice2;
                Button resultado[] = new Button[10];
                for(int k = 0; k < resultado.length; k++)
                {
                    int tempk = k;
                    Button b = new Button();
                    b.setMinSize(w2, h2);
                    b.setStyle("-fx-font-family: Consolas; -fx-font-size: 18px;");
                    b.setLayoutX(x2);
                    b.setLayoutY(y2);
                    Platform.runLater(() -> pane.getChildren().add(b));
                    resultado[k] = b;
                    xindice2 = x2;
                    x2 += w2 + gap2;
                    Label idx = new Label();
                    int finalK = k;
                    Platform.runLater(() -> idx.setText("" + finalK));
                    idx.setPrefWidth(w2);
                    idx.setAlignment(Pos.CENTER);
                    idx.setStyle("-fx-font-family: Consolas; -fx-font-size: 15px; -fx-text-fill: #666;");
                    idx.setLayoutX(xindice2);
                    idx.setLayoutY(y2 + h2 + 3);
                    Platform.runLater(() -> pane.getChildren().add(idx));
                }
                Label Resultado = new Label();
                Resultado.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;-fx-text-fill: purple;");
                Platform.runLater(() -> Resultado.setText("VetResultado"));
                Resultado.setLayoutX(520);
                Resultado.setLayoutY(350);
                Platform.runLater(() -> pane.getChildren().add(Resultado));
                moverSetaLinhas(1);
                Thread.sleep(500);

                for(int k = 0; k < resultado.length; k++) {
                    int valor = Integer.parseInt(vet[k].getText());
                    int cont = Integer.parseInt(vetc[valor].getText());
                    int p = cont - 1;
                    int novoCont = cont - 1;
                    moverSetaLinhas(1); Thread.sleep(500);
                    moverSetaLinhas(1); Thread.sleep(500);
                    moverSetaLinhas(1); Thread.sleep(500);
                    int finalValor = valor;
                    Platform.runLater(() -> vetc[finalValor].setText(String.valueOf(novoCont)));
                    Platform.runLater(() -> {
                        pos.setText("pos = " + p);
                        tempi.setText("pos");
                        double cx = resultado[p].getLayoutX() + resultado[p].getWidth() / 2.0;
                        double Y  = resultado[p].getLayoutY() + resultado[p].getHeight() + 18;
                        tempi.setLayoutX(cx - 4);
                        tempi.setLayoutY(Y);
                    });
                    double gx = vet[k].getLayoutX();
                    double gy = vet[k].getLayoutY();
                    double dstX = resultado[p].getLayoutX();
                    double dstY = resultado[p].getLayoutY();
                    Button ghost = new Button(vet[k].getText());
                    ghost.setMinSize(vet[k].getWidth(), vet[k].getHeight());
                    ghost.setStyle(vet[k].getStyle());
                    ghost.setLayoutX(gx);
                    ghost.setLayoutY(gy);
                    Platform.runLater(() -> { pane.getChildren().add(ghost); ghost.toFront(); });
                    int passos = 60;
                    double dx = (dstX - gx) / passos;
                    double dy = (dstY - gy) / passos;
                    for (int s = 0; s < passos; s++) {
                        gx += dx; gy += dy;
                        double fx = gx, fy = gy;
                        Platform.runLater(() -> { ghost.setLayoutX(fx); ghost.setLayoutY(fy); });
                        try { Thread.sleep(18); } catch (InterruptedException ignored) {}
                    }
                    Platform.runLater(() -> {
                        ghost.setLayoutX(dstX);
                        ghost.setLayoutY(dstY);
                        resultado[p].setText(ghost.getText());
                        pane.getChildren().remove(ghost);
                    });
                    moverSetaLinhas(-3);
                    Thread.sleep(500);
                }
                moverSetaLinhas(5);
                Thread.sleep(500);
                return null;
            }
        };
        Thread thread = new Thread(task, "anima-codigo");
        thread.setDaemon(true);
        thread.start();
    }
}
