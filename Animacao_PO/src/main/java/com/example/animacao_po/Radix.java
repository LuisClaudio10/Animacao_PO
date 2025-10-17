package com.example.animacao_po;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.util.Random;


public class Radix {
    private AnchorPane pane;
    public Label[] codigo;
    public Label[] indices;
    private Button[] vet;

    private Button botao_inicio, botao_embaralha;
    public TextField Seta;

    public void show() {
        pane = new AnchorPane();
        indices = new Label[3];

        botao_inicio = new Button("Iniciar");
        botao_inicio.setLayoutX(300);
        botao_inicio.setLayoutY(600);
        botao_inicio.setMinHeight(70);
        botao_inicio.setMinWidth(100);
        botao_inicio.setVisible(false);
        botao_inicio.setOnAction(e -> {
            botao_embaralha.setVisible(false);
            botao_inicio.setVisible(false);
            move_botoes();
        });

        botao_embaralha = new Button("Embaralhar");
        botao_embaralha.setLayoutX(550);
        botao_embaralha.setLayoutY(600);
        botao_embaralha.setMinHeight(70);
        botao_embaralha.setMinWidth(100);
        botao_embaralha.setOnAction(e -> {
            EmbaralharNumeros();
            botao_inicio.setVisible(true);
        });

        pane.getChildren().addAll(botao_embaralha, botao_inicio);

        InserirCodigo();
        MostraCodigo();

        Seta = new TextField("->");
        Seta.setStyle("-fx-font-size:20; -fx-text-fill: red; -fx-background-color: transparent;");
        Seta.setLayoutY(0);
        Seta.setLayoutX(0);
        pane.getChildren().add(Seta);

        Scene scene = new Scene(pane, 1200, 800);
        Stage novaJanela = new Stage();
        novaJanela.setTitle("Radix Sort");
        novaJanela.setScene(scene);
        novaJanela.show();
    }

    // ===================== Métodos utilitários do Radix =====================
    public void MostraCodigo(){
        for(int i=0; i<20; i++){ // colocando o código
            codigo[i].setLayoutY(i*25);
            codigo[i].setLayoutX(800);
            codigo[i].setMinHeight(40);
            codigo[i].setMinWidth(40);
            codigo[i].setFont(new Font(14));
            pane.getChildren().add(codigo[i]);
        }
    }
    public void InserirCodigo(){
        codigo = new Label[20];
        for (int i = 0; i < 20; i++) {
            codigo[i]= new Label();
        }
        codigo[0].setText("public void radixsort() {");
        codigo[1].setText("     int maior = vet[0];");
        codigo[2].setText("      for (int i = 1; i < TL; i++)");
        codigo[3].setText("          if (vet[i] > maior)");
        codigo[4].setText("            maior = vet[i];");
        codigo[5].setText("      for (int dig = 1; maior / digito > 0; digito *= 10){");
        codigo[6].setText("          int novo[] = new int[TL];");
        codigo[7].setText("          int contagem[] = new int[10];");
        codigo[8].setText("          for (int i = 0; i < TL; i++)");
        codigo[9].setText("              contagem[(vet[i] / dig) % 10]++;");
        codigo[10].setText("         for (int i = 1; i < 10; i++)");
        codigo[11].setText("             contagem[i] += contagem[i - 1];");
        codigo[12].setText("         for (int i = TL - 1; i >= 0; i--) {");
        codigo[13].setText("            contagem[(vet[i] / dig) % 10]--;");
        codigo[14].setText("            novo[contagem[(vet[i] / dig) % 10] - 1] = vet[i];");
        codigo[15].setText("         }");
        codigo[16].setText("      for (int i = TL-1; i >=0; i++)");
        codigo[17].setText("          vet[i] = novo[i];");
        codigo[18].setText("      }");
        codigo[19].setText("}");
    }

    private void await(int tempo){
        try { Thread.sleep(tempo); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public void EmbaralharNumeros(){
        if(vet!=null){
            for(int i = 0; i < vet.length; i++){
                pane.getChildren().remove(vet[i]);
            }
            if (indices[0] != null) pane.getChildren().remove(indices[0]);
        }
        indices[0] = new Label("0        1          2         3          4         5         6         7         8         9         10        11");
        indices[0].setStyle("-fx-background-color: transparent; -fx-font-size: 13px;");
        indices[0].setLayoutX(200);
        indices[0].setLayoutY(240);
        pane.getChildren().add(indices[0]);
        Random random = new Random();
        vet = new Button[12];
        for(int i=0; i<12; i++){ // criando o vetor com os botões
            vet[i] = new Button(random.nextInt(999)+"");
            vet[i].setLayoutY(200);
            vet[i].setLayoutX(180+i*40);
            vet[i].setMinHeight(40);
            vet[i].setMinWidth(40);
            vet[i].setFont(new Font(14));
            pane.getChildren().add(vet[i]);
        }
    }

    public void CriaContagem(int altura, int tl, Button vet1[]){
        if(vet1!=null){
            if(tl<12) {
                for (int i = 1; i < indices.length; i++) {
                    if (indices[i] != null) pane.getChildren().remove(indices[i]);
                }
            } else {
                for(int i = 0; i < vet1.length; i++){
                    if (vet1[i] != null) pane.getChildren().remove(vet1[i]);
                }
            }
        }
        if(tl<12){
            indices[1] = new Label("0        1          2         3          4         5         6         7         8         9");
            indices[1].setStyle("-fx-background-color: transparent; -fx-font-size: 13px;");
            indices[1].setLayoutX(200);
            indices[1].setLayoutY(340);
            pane.getChildren().add(indices[1]);
        }else{
            indices[2] = new Label("0        1          2         3          4         5         6         7         8         9         10        11");
            indices[2].setStyle("-fx-background-color: transparent; -fx-font-size: 13px;");
            indices[2].setLayoutX(200);
            indices[2].setLayoutY(440);
            pane.getChildren().add(indices[2]);
        }

        for(int i=0; i<tl; i++){ // criando o vetor com os botões
            vet1[i] = new Button("0");
            vet1[i].setLayoutY(altura+200);
            vet1[i].setLayoutX(180+i*40);
            vet1[i].setMinHeight(40);
            vet1[i].setMinWidth(40);
            vet1[i].setFont(new Font(14));
            pane.getChildren().add(vet1[i]);
        }
    }

    // ===================== Animação do Radix (move_botoes) =====================
    public void move_botoes() {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws InterruptedException {

                TextField textarea = new TextField();
                Platform.runLater(()->{
                    textarea.setText("maior= "+vet[0].getText());
                    textarea.setStyle("-fx-background-color: transparent; -fx-font-size: 16px;");
                });
                Seta.setLayoutY(25);
                Seta.setLayoutX(780);
                TextField varI = new TextField("i = "+0);
                TextField varDig = new TextField("Dig = "+1);
                varI.setStyle("-fx-font-size: 16px;-fx-background-color: transparent; ");
                varDig.setStyle("-fx-font-size: 16px;-fx-background-color: transparent;");
                varI.setLayoutX(200);
                varI.setLayoutY(500);
                varDig.setLayoutX(340);
                varDig.setLayoutY(500);
                textarea.setLayoutX(480);
                textarea.setLayoutY(500);
                Platform.runLater(()->{
                    pane.getChildren().add(textarea);
                    pane.getChildren().add(varI);
                    pane.getChildren().add(varDig);
                    vet[0].setStyle("-fx-background-color: green;");
                });
                await(500);
                int maior = 0;
                Seta.setLayoutY(2*25);
                Platform.runLater(()-> varI.setText("i = "+1));

                for (int i = 1; i < vet.length; i++) {
                    int finalI = i;
                    int finalMaior = maior;
                    Seta.setLayoutY(3*25);
                    Platform.runLater(()-> vet[finalI].setStyle("-fx-border-color: red; -fx-border-width: 2px;"));
                    await(500);

                    if(Integer.parseInt(vet[maior].getText())<Integer.parseInt(vet[i].getText())){
                        Seta.setLayoutY(4*25);
                        Platform.runLater(()->{
                            vet[finalMaior].setStyle("");
                            textarea.setText("maior= "+vet[finalI].getText());
                            vet[finalI].setStyle("-fx-background-color: green;");
                        });
                        await(500);
                        maior = i;
                    }else{
                        Platform.runLater(()-> vet[finalI].setStyle(""));
                    }

                    Platform.runLater(()-> varI.setText("i = "+ (finalI+1)));
                    Seta.setLayoutY(2*25);
                    await(500);
                }

                Seta.setLayoutY(5*25);
                int nummaior= Integer.parseInt(vet[maior].getText());


                Seta.setLayoutY(5*25);
                await(500);
                for(int dig=1;nummaior/dig>0;dig*=10){

                    Button contagem[] = new Button[10];
                    Button novo[] = new Button[vet.length];

                    int finalMaior1 = maior;
                    Seta.setLayoutY(6*25);
                    Platform.runLater(()->{
                        vet[finalMaior1].setStyle("");
                        CriaContagem(100,10,contagem);
                    });
                    await(500);
                    Seta.setLayoutY(7*25);
                    Platform.runLater(()-> CriaContagem(200, vet.length, novo));
                    await(500);
                    Seta.setLayoutY(8*25);
                    int finalDig = dig;
                    Platform.runLater(()-> varDig.setText("dig = "+ finalDig));

                    Platform.runLater(()-> varI.setText("i = "+0));
                    for (int i = 0; i < vet.length; i++) {
                        int pos = (Integer.parseInt(vet[i].getText()) / dig) % 10;
                        int finali = i;
                        Seta.setLayoutY(9*25);
                        Platform.runLater(() -> {
                            vet[finali].setStyle("-fx-background-color: green;");
                            contagem[pos].setStyle("-fx-background-color: green;");
                            int aux = Integer.parseInt(contagem[pos].getText());
                            aux++;
                            contagem[pos].setText("" + aux);
                        });
                        await(500);
                        Platform.runLater(() -> {
                            vet[finali].setStyle("");
                            contagem[pos].setStyle("");
                        });
                        Seta.setLayoutY(8*25);
                        Platform.runLater(()-> varI.setText("i = "+ (finali+1)));
                        await(500);
                    }

                    Seta.setLayoutY(10*25);
                    await(500);
                    Platform.runLater(()-> varI.setText("i ="+1));
                    for(int i=1;i<10;i++){
                        int finalI = i;
                        Platform.runLater(()->{
                            contagem[finalI -1].setStyle("-fx-background-color: green;");
                            contagem[finalI].setStyle("-fx-background-color: green;");
                            int aux1 = Integer.parseInt(contagem[finalI].getText());
                            int aux =  Integer.parseInt(contagem[finalI-1].getText());
                            aux+=aux1;
                            contagem[finalI].setText(""+aux);
                        });
                        Seta.setLayoutY(11*25);
                        await(500);
                        Platform.runLater(() -> {
                            contagem[finalI].setStyle("");
                            contagem[finalI-1].setStyle("");
                        });
                        Seta.setLayoutY(10*25);
                        Platform.runLater(()-> varI.setText("i = "+ (finalI+1)));
                        await(500);
                    }

                    Seta.setLayoutY(12*25);
                    await(500);
                    Platform.runLater(()-> varI.setText("i = "+11));
                    for (int i=11; i>=0;i--){
                        int finalI = i;
                        int finalDig1 = dig;
                        double x1 = vet[i].getLayoutX(), y1 =  vet[i].getLayoutY();
                        Seta.setLayoutY(13*25);
                        await(500);
                        Platform.runLater(()->{
                            int num = Integer.parseInt(vet[finalI].getText());
                            vet[finalI].setStyle("-fx-background-color: green;");
                            contagem[(num/finalDig1)%10].setStyle("-fx-background-color: green;");
                            int pos = Integer.parseInt(contagem[(num/finalDig1)%10].getText())-1;
                            contagem[(num/finalDig1)%10].setText(""+pos);
                            novo[pos].setStyle("-fx-background-color: red;");
                        });

                        Seta.setLayoutY(14*25);
                        await(500);
                        for (int j = 0; j < 10; j++) {
                            Platform.runLater(() ->vet[finalI].setLayoutY(vet[finalI].getLayoutY() + 5));
                            try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                        }
                        int num1 = Integer.parseInt(vet[finalI].getText());
                        int pos1 = Integer.parseInt(contagem[(num1/finalDig1)%10].getText());

                        while(vet[i].getLayoutX()>novo[pos1].getLayoutX()){
                            Platform.runLater(() ->vet[finalI].setLayoutX(vet[finalI].getLayoutX() -1));
                            try { Thread.sleep(1); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                        }
                        while(vet[i].getLayoutX()<novo[pos1].getLayoutX()){
                            Platform.runLater(() ->vet[finalI].setLayoutX(vet[finalI].getLayoutX() +1));
                            try { Thread.sleep(1); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                        }

                        for (int j = 0; j < 30; j++) {
                            Platform.runLater(() ->vet[finalI].setLayoutY(vet[finalI].getLayoutY() + 5));
                            try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                        }
                        Platform.runLater(()->{
                            int num = Integer.parseInt(vet[finalI].getText());
                            int pos = Integer.parseInt(contagem[(num/finalDig1)%10].getText());
                            novo[pos].setStyle("-fx-background-color: green;");
                            novo[pos].setText(""+num);
                        });

                        await(500);
                        Platform.runLater(() -> {
                            int num = Integer.parseInt(vet[finalI].getText());
                            contagem[(num/finalDig1)%10].setStyle("");
                            int pos = Integer.parseInt(contagem[(num/finalDig1)%10].getText());
                            novo[pos].setStyle("");
                            vet[finalI].setStyle("");
                            vet[finalI].setLayoutY(y1);
                            vet[finalI].setLayoutX(x1);
                        });
                        Seta.setLayoutY(12*25);
                        Platform.runLater(()-> varI.setText("i = "+ (finalI-1)));
                        await(500);
                    }

                    Seta.setLayoutY(16*25);
                    await(500);
                    Platform.runLater(()-> varI.setText("i = "+0));

                    for (int i = 0; i < vet.length; i++) {
                        int finalI = i;
                        Platform.runLater(()-> novo[finalI].setStyle("-fx-background-color: green;"));
                        Seta.setLayoutY(17*25);
                        await(500);
                        double y = novo[i].getLayoutY();
                        for (int j = 0; j < 40; j++) {
                            Platform.runLater(() -> novo[finalI].setLayoutY(novo[finalI].getLayoutY() - 5));
                            try { Thread.sleep(10); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                        }
                        Platform.runLater(()->{
                            int aux1 = Integer.parseInt(novo[finalI].getText());
                            vet[finalI].setText(""+aux1);
                        });
                        Seta.setLayoutY(16*25);
                        await(500);
                        Platform.runLater(()->{
                            novo[finalI].setLayoutY(y);
                            novo[finalI].setStyle("");
                        });
                        Platform.runLater(()-> varI.setText("i = "+ (finalI+1)));
                    }
                    Platform.runLater(()->{
                        for (int i = 0; i < novo.length; i++) {
                            pane.getChildren().remove(novo[i]);
                        }
                        for(int i = 0; i<contagem.length; i++){
                            pane.getChildren().remove(contagem[i]);
                        }

                    });

                    Seta.setLayoutY(5*25);
                }
                Platform.runLater(()->{
                    pane.getChildren().remove(varI);
                    pane.getChildren().remove(varI);
                    pane.getChildren().remove(varDig);
                    pane.getChildren().remove(varDig);
                    pane.getChildren().remove(textarea);
                    botao_embaralha.setVisible(true);
                    botao_inicio.setVisible(true);
                    pane.getChildren().remove(indices[1]);
                    pane.getChildren().remove(indices[2]);
                });
                return null;
            }
        };
        Thread thread = new Thread(task, "radix-move-botoes");
        thread.setDaemon(true);
        thread.start();
    }
}
