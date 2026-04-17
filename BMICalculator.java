import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;


    public class BMICalculator extends Application {

        @Override
        public void start (Stage palco){

            
            //Input labels
            Label weight = new Label("Insert your weight"); 
            Label height = new Label("Insert your height");
            Label result = new Label(); // -> Variable content

            //Input fields
            TextField weightField = new TextField();
                weightField.setPromptText("Weight in Kg"); // -> placeholder set
            TextField heightField = new TextField();
                heightField.setPromptText("Height in M"); // -> placeholder set

            //Action Button
            Button calculate = new Button("Calculate");

            

            
            calculate.setOnAction( e -> {

                try {
                    double weightValue = Double.parseDouble(weightField.getText().replace(',' , '.'));
                    double heightValue = Double.parseDouble(heightField.getText().replace(',' , '.'));

                    double bmi = weightValue / (heightValue * heightValue);
                    String phrase;

                        if (bmi < 18.5) {
                            phrase = "underweight";
                        } else if (bmi >= 18.5 && bmi < 25){
                            phrase = "Healthy Weight";
                        } else if (bmi >= 25 && bmi < 30){
                            phrase = "Overweight";
                        } else if (bmi >= 30 && bmi < 35){
                            phrase = "Obese Class 1";
                        } else if (bmi >= 35 && bmi < 40){
                            phrase = "Obese Class 2";
                        } else {
                            phrase = "Obese Class 3";
                        }



                    result.setText(String.format("Your BMI is: %.2f" + " - " + phrase, bmi));
                    
                } catch (NumberFormatException ex) {

                    result.setText(String.format("Insert valid informations"));
                }
                
            });

            HBox weightRow = new HBox(10, weight, weightField);
                weightRow.setAlignment(Pos.CENTER);
            HBox heightRow = new HBox(10, height, heightField);
                heightRow.setAlignment(Pos.CENTER);

            VBox window = new VBox(5, weightRow, heightRow, calculate, result);
            window.setAlignment(Pos.CENTER);

            Scene cena = new Scene(window, 300,200);
            palco.setTitle("BMI Calculator");
            palco.setScene(cena);
            palco.show();

        }

        public static void main(String[] args) {
            launch(args);
        }
    }