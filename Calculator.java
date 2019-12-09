import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Calculator extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    //create variables that make up expression
    private String expression = "";
    private String previousOperation = "";

    private String getText() {
        return expression;
    } 
    
    
    @Override
    public void start(Stage stage) {
        
        //create top textfield.
        TextField totalText = new TextField();

        //button 0
        Button button0 = new Button("0");
        button0.setPadding(new Insets(15, 15, 15, 15));
        //event on button 0
        button0.setOnAction(event ->
        {
            expression += "0";
            totalText.setText(getText());
        });
        
        //button 1
        Button button1 = new Button("1");
        button1.setPadding(new Insets(15, 15, 15, 15));
        //event on button 1
        button1.setOnAction(event ->
        {
            expression += "1";
            totalText.setText(getText());
        });
        
        //button 2
        Button button2 = new Button("2");
        button2.setPadding(new Insets(15, 15, 15, 15));
        //event on button 2
        button2.setOnAction(event ->
        {
            expression += "2";
            totalText.setText(getText());
        });
        
        //button 3
        Button button3 = new Button("3");
        button3.setPadding(new Insets(15, 15, 15, 15));
        //event on button 3
        button3.setOnAction(event ->
        {
            expression += "3";
            totalText.setText(getText());
        });
        
        //button 4
        Button button4 = new Button("4");
        button4.setPadding(new Insets(15, 15, 15, 15));
        //event on button 4
        button4.setOnAction(event ->
        {
            expression += "4";
            totalText.setText(getText());
        });
        
        //button 5
        Button button5 = new Button("5");
        button5.setPadding(new Insets(15, 15, 15, 15));
        //event on button 5
        button5.setOnAction(event ->
        {
            expression += "5";
            totalText.setText(getText());
        });
        
        //button 6
        Button button6 = new Button("6");
        button6.setPadding(new Insets(15, 15, 15, 15));
        //event on button 6
        button6.setOnAction(event ->
        {
            expression += "6";
            totalText.setText(getText());
        });
        
        //button 7
        Button button7 = new Button("7");
        button7.setPadding(new Insets(15, 15, 15, 15));
        //event on button 6
        button7.setOnAction(event ->
        {
            expression += "7";
            totalText.setText(getText());
        });
        
        //button 8
        Button button8 = new Button("8");
        button8.setPadding(new Insets(15, 15, 15, 15));
        //event on button 8
        button8.setOnAction(event ->
        {
            expression += "8";
            totalText.setText(getText());
        });
        
        //button 9
        Button button9 = new Button("9");
        button9.setPadding(new Insets(15, 15, 15, 15));
        //event on button 9
        button9.setOnAction(event ->
        {
            expression += "9";
            totalText.setText(getText());
        });
        
        //add button
        Button addButton = new Button("+");
        addButton.setPadding(new Insets(15, 15, 15, 15));
        //event on add button
        addButton.setOnAction(event ->
        {
            expression += "+";
            totalText.setText(getText());
        });
        
        
        //subtract button
        Button subtractButton = new Button("-");
        subtractButton.setPadding(new Insets(15, 15, 15, 15));
        //event on subtract button
        subtractButton.setOnAction(event ->
        {
            expression += "-";
            totalText.setText(getText());
        });
        
        //multiply button
        Button multiplyButton = new Button("*");
        multiplyButton.setPadding(new Insets(15, 15, 15, 15));
        //event on multiply button
        multiplyButton.setOnAction(event ->
        {
            expression += "*";
            totalText.setText(getText());
        });
        
        //divide button
        Button divideButton = new Button("/");
        divideButton.setPadding(new Insets(15, 15, 15, 15));
        //divide event
        divideButton.setOnAction(event ->
        {
            expression += "/";
            totalText.setText(getText());
        });
        
        //clear button
        Button clearButton = new Button("C");
        clearButton.setPadding(new Insets(20, 25, 20, 25));
        //event on clear button
        clearButton.setOnAction(event ->
        {
            expression = "";
            totalText.setText(getText());
        });
        
        //equals button
        Button equalsButton = new Button("=");
        equalsButton.setPadding(new Insets(20, 25, 20, 25));
        //event on equals button
        equalsButton.setOnAction(event ->
        {
            int lastIndex = 0;
            expression = totalText.getText();
            if (expression.indexOf('+') == -1 && expression.indexOf('-') == -1 && expression.indexOf('*') == -1 && expression.indexOf('/') == -1) {
                expression += previousOperation;
                //System.out.println(expression);
            }
            if (lastIndex <= expression.lastIndexOf('+')) {
                lastIndex = expression.lastIndexOf('+');
            }
            if (lastIndex <= expression.lastIndexOf('-')) {
                lastIndex = expression.lastIndexOf('-');
            }
            if (lastIndex <= expression.lastIndexOf('*')) {
                lastIndex = expression.lastIndexOf('*');
            }
            if (lastIndex <= expression.lastIndexOf('/')) {
                lastIndex = expression.lastIndexOf('/');
            }
            
            previousOperation = expression.substring(lastIndex);
            //System.out.println(previousOperation);
            
            totalText.setText(Engine.calc(expression));
        });
        
        
        //decimal button
        Button decimalButton = new Button(".");
        decimalButton.setPadding(new Insets(10, 10, 10, 10));
        //event on decimal button
        decimalButton.setOnAction(event ->
        {
            expression += ".";
            totalText.setText(getText());
        });
        
        
        //create hbox's, apply padding
        HBox hbox = new HBox(8, clearButton, totalText, equalsButton);
        HBox hbox2 = new HBox(15, button0, button1, button2, button3, button4);
        HBox hbox3 = new HBox(15, button5, button6, button7, button8, button9);
        HBox hbox4 = new HBox(15, addButton, subtractButton, multiplyButton, divideButton, decimalButton);
        
        //put all hbox's in one vbox
        VBox vbox = new VBox(hbox, hbox2, hbox3, hbox4); 
        
        //create scene, add vbox to scene
        Scene scene = new Scene(vbox);
        
        //set scene to the stage
        stage.setScene(scene);
        
        //display scene on stage
        stage.show();
        
    }
    
    
}