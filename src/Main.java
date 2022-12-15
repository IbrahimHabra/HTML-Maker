import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        HTMLEditor htmlEditor = new HTMLEditor();
        ToggleButton inEditor = new ToggleButton("View in Editor");
        ToggleButton inWebPage = new ToggleButton("View in Browser");
        ToggleButton inHtml = new ToggleButton("View in Html Code");
        ToggleGroup toggleGroup = new ToggleGroup();
        TextArea textArea = new TextArea();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        String htmlText = "<html dir=\"ltr\"><head></head><body contenteditable=\"true\">" +
                "<p style=\"text-align: center;\">" +
                "<font color=\"#001a80\" face=\"Diwani Bent\" size=\"7\" style=\"background-color: rgb(255, 179, 128);\">" +
                "بسم الله الرحمن الرحيم</font></p><ul><li><font size=\"6\" style=\"background-color: rgb(179, 128, 179);\">" +
                "This program was made by&nbsp;</font></li></ul><p><span class=\"Apple-tab-span\" style=\"white-space:pre\">" +
                "\t\t\t</span><font size=\"7\" color=\"#28aaa1\">IBRAHIM HABRA</font></p><p></p><ul><li>" +
                "<font size=\"6\" style=\"background-color: rgb(128, 153, 255);\">Or you can say<font color=\"#b31a1a\"> " +
                "</font></font><font color=\"#b31a1a\"><font size=\"7\">(</font><b><font size=\"7\">IWIMAM</font>" +
                "</b></font><font size=\"7\"><font color=\"#b31a1a\">)" +
                "</font> </font><font size=\"5\">.</font></li></ul><p></p><br></body></html>";
        htmlEditor.setHtmlText(htmlText);
        textArea.setWrapText(true);
        inEditor.setToggleGroup(toggleGroup);
        inWebPage.setToggleGroup(toggleGroup);
        inHtml.setToggleGroup(toggleGroup);
        textArea.setEditable(false);
        htmlEditor.setTranslateX(20);
        htmlEditor.setTranslateY(20);
        htmlEditor.setPrefSize(700,400);
        textArea.setTranslateX(20);
        textArea.setTranslateY(20);
        textArea.setPrefSize(700,400);
        textArea.setBackground(new Background(new BackgroundFill(Color.KHAKI, new CornerRadii(5), Insets.EMPTY)));
        inEditor.setTranslateX(90);
        inHtml.setTranslateX(290);
        inWebPage.setTranslateX(490);
        inEditor.setTranslateY(440);
        inWebPage.setTranslateY(440);
        inHtml.setTranslateY(440);
        inEditor.setPrefSize(120,45);
        inHtml.setPrefSize(120,45);
        inWebPage.setPrefSize(120,45);
        webView.setTranslateX(20);
        webView.setTranslateY(20);
        webView.setPrefSize(700,400);
        webView.setVisible(false);
        textArea.setVisible(false);
        htmlEditor.setVisible(true);
        Group root = new Group();
        root.getChildren().addAll(htmlEditor,inEditor,inHtml,inWebPage,webView,textArea);
        primaryStage.setScene(new Scene(root,740, 510));
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setTitle("My little Text To Html !");
        toggleGroup.selectedToggleProperty().addListener((ObservableValue<?extends Toggle> ov,Toggle oldToggle,Toggle newToggle) -> {
            if (toggleGroup.getSelectedToggle().equals(inEditor)){
                htmlEditor.setVisible(true);
                webView.setVisible(false);
                textArea.setVisible(false);
            }
            else if (toggleGroup.getSelectedToggle().equals(inHtml)){
                textArea.setText(htmlEditor.getHtmlText());
                textArea.setVisible(true);
                webView.setVisible(false);
                htmlEditor.setVisible(false);
                System.out.println("done !");
            }
            else if(toggleGroup.getSelectedToggle().equals(inWebPage)){
                webEngine.loadContent(htmlEditor.getHtmlText());
                textArea.setVisible(false);
                webView.setVisible(true);
                htmlEditor.setVisible(false);
                System.out.println("done ! #2");
            }
        });
        inEditor.setSelected(true);
    }

    public static void main(String[] args) {
        launch(args);
    }}