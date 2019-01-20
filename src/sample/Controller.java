package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.util.function.UnaryOperator;

public class Controller {

    @FXML
    public TextField alarmName;
    @FXML
    public Spinner hourSpinner;
    @FXML
    public Spinner minSpinner;
    @FXML
    public Spinner secSpinner;
    @FXML
    public CheckBox cbMon;
    @FXML
    public CheckBox cbTeu;
    @FXML
    public CheckBox cbWed;
    @FXML
    public CheckBox cbThu;
    @FXML
    public CheckBox cbFri;
    @FXML
    public CheckBox cbSat;
    @FXML
    public CheckBox cbSun;
    @FXML
    public Slider volumeSlider;
    @FXML
    public Label volumeValue;


    @FXML
    public void initialize() {
         volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> volumeValue.setText("" + newValue.intValue()));

        StringConverter<String> formatter;
        formatter = new StringConverter<String>() {
            @Override
            public String fromString(String string) {
                if(string.length()==2){
                    return string;
                } else if(string.length()<2) {
                    return "0" + string;
                }
                return "00";
            }

            @Override
            public String toString(String object) {
                if(object == null) return "00";
                else return object;
            }
        };

        UnaryOperator<TextFormatter.Change> filter;
        filter = change -> {
            String text = change.getText();
            for (int i = 0; i < text.length(); i++)
                if (!Character.isDigit(text.charAt(i)))
                    return null;
            return change;
        };

         hourSpinner.getEditor().setAlignment(Pos.CENTER);
         hourSpinner.getEditor().setTextFormatter(new TextFormatter<>(formatter, "00", filter));
         minSpinner.getEditor().setAlignment(Pos.CENTER);
         minSpinner.getEditor().setTextFormatter(new TextFormatter<>(formatter, "00", filter));
         secSpinner.getEditor().setAlignment(Pos.CENTER);
         secSpinner.getEditor().setTextFormatter(new TextFormatter<>(formatter, "00", filter));

    }

    public void quit() {
        Platform.exit();
    }

    public void save() {
        String alarmName;
        String timeAlarm;
        String days;
        String result;

        //TODO Add Checkbox repeat.
        boolean repreat;

        int volume;

        //Time of alarm
        timeAlarm = hourSpinner.getValue() + ":" + minSpinner.getValue() + ":" + secSpinner.getValue();

        //Repeat alarm
        days = "";
        days += cbMon.isSelected() ? "Monday ":"";
        days += cbTeu.isSelected() ? "Tuesday ":"";
        days += cbWed.isSelected() ? "Wednesday ":"";
        days += cbThu.isSelected() ? "Thursday ":"";
        days += cbFri.isSelected() ? "Friday ":"";
        days += cbSat.isSelected() ? "Saturday ":"";
        days += cbSun.isSelected() ? "Sunday ":"";

        if(days.equals("")) {
            days = "none";
        }

        alarmName = this.alarmName.getText();

        volume = (int) Math.floor( volumeSlider.getValue() );

        result = "Alarm Name: " + alarmName + "\n" +
                "Time alarm: " + timeAlarm + "\n" +
                "Repeat alarm on: " + days + "\n" +
                "Volume: " + volume;

        System.out.println(result);
        Platform.exit();
    }
}
