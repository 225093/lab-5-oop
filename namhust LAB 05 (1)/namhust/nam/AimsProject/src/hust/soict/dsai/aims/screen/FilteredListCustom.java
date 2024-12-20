/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author ADMIN
 */
public class FilteredListCustom {
    private TextField tfFilter;
    private RadioButton radioBtnFilterId;
    private RadioButton radioBtnFilterTitle;
    private ObservableList<Media> originalList;
    private FilteredList<Media> filteredData;

    public FilteredListCustom(ObservableList<Media> list) {
        this.originalList = list;
        this.filteredData = new FilteredList<>(list, p -> true);

        // Initialize components
//        tfFilter = new TextField();
//        radioBtnFilterId = new RadioButton("By ID");
//        radioBtnFilterTitle = new RadioButton("By Title");
//
//        // Create toggle group for radio buttons
//        ToggleGroup group = new ToggleGroup();
//        radioBtnFilterId.setToggleGroup(group);
//        radioBtnFilterTitle.setToggleGroup(group);
//        radioBtnFilterId.setSelected(true);
//
//        // Add listener for filter changes
//        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
//            showFilteredMedia(newValue);
//        });
    }

    public void showFilteredMedia(String filterText, boolean radioBtnFilterId) {
        filteredData.setPredicate(media -> {
            if (filterText == null || filterText.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = filterText.toLowerCase();

            if (radioBtnFilterId) {
                return String.valueOf(media.getId()).toLowerCase().contains(lowerCaseFilter);
            } else {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
        });
    }

    public FilteredList<Media> getFilteredList() {
        return filteredData;
    }

    public TextField getFilterField() {
        return tfFilter;
    }

    public RadioButton getRadioBtnFilterId() {
        return radioBtnFilterId;
    }

    public RadioButton getRadioBtnFilterTitle() {
        return radioBtnFilterTitle;
    }
}
