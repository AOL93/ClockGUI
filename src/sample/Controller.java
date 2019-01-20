package sample;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;

public class Controller {

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
         volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
             @Override
             public void changed(ObservableValue<? extends Number> observable,
                                 Number oldValue, Number newValue) {
                 volumeValue.setText("" + newValue.intValue());
             }
         });
    }

    public void quit() {
        Platform.exit();
    }

    public void save() {
        String timeAlarm;
        String repeat;
        String result;

        int volume;

        //Time of alarm
        timeAlarm = hourSpinner.getValue() + ":" + minSpinner.getValue() + ":" + secSpinner.getValue();

        //Repeat alarm
        repeat = "";
        repeat += cbMon.isSelected() ? "Monday ":"";
        repeat += cbTeu.isSelected() ? "Tuesday ":"";
        repeat += cbWed.isSelected() ? "Wednesday ":"";
        repeat += cbThu.isSelected() ? "Thursday ":"";
        repeat += cbFri.isSelected() ? "Friday ":"";
        repeat += cbSat.isSelected() ? "Saturday ":"";
        repeat += cbSun.isSelected() ? "Sunday ":"";

        if(repeat.equals("")) {
            repeat = "none";
        }

        volume = (int) Math.floor( volumeSlider.getValue() );

        result = "Time alarm: " + timeAlarm + "\n" +
                "Repeat alarm on: " + repeat + "\n" +
                "Volume: " + volume;

        System.out.println(result);
        Platform.exit();
    }
}
