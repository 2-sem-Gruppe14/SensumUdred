/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.util.Duration;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UpDownAnimation {

    private Double orignalPaneHeight;
    private Double orignalAnchorPaneHeight;
    private AnchorPane anchorPane;
    private Pane pane;
    private RowConstraints row;
    private Duration cycleDuration = Duration.millis(250);
    private GridPane grid;

    public UpDownAnimation(AnchorPane anchorPane, GridPane grid, Pane pane, RowConstraints row) {
        this.orignalPaneHeight = row.getPrefHeight();
        this.orignalAnchorPaneHeight = anchorPane.getPrefHeight();
        this.anchorPane = anchorPane;
        this.pane = pane;
        this.grid = grid;
        this.row = row;
    }
    
    public UpDownAnimation(Pane pane){
        this.pane = pane;
        this.grid = (GridPane) pane.getParent();
        this.anchorPane = (AnchorPane) grid.getParent();
        this.row = grid.getRowConstraints().get(GridPane.getRowIndex(pane));
        this.orignalPaneHeight = row.getPrefHeight();
        this.orignalAnchorPaneHeight = anchorPane.getPrefHeight();
        
    }
    
    public void hide() {
        pane.setDisable(true);
        Timeline opacity = new Timeline(
            new KeyFrame(cycleDuration,
                    new KeyValue(pane.opacityProperty(), 0, Interpolator.EASE_BOTH))
        );
        opacity.play();
        
        Timeline resize = new Timeline(
            new KeyFrame(cycleDuration,
                    new KeyValue(row.prefHeightProperty(), 0, Interpolator.EASE_BOTH)),
            new KeyFrame(cycleDuration,
                    new KeyValue(anchorPane.prefHeightProperty(), anchorPane.getPrefHeight() - orignalPaneHeight, Interpolator.EASE_BOTH))
        );
        resize.setDelay(cycleDuration);
        resize.play();
    }

    public void show() {
        pane.setDisable(false);
        Timeline opacity = new Timeline(
            new KeyFrame(cycleDuration,
                    new KeyValue(pane.opacityProperty(), 1, Interpolator.EASE_BOTH))
        );
            opacity.setDelay(cycleDuration);
            opacity.play();
            
        Timeline resize = new Timeline(
            new KeyFrame(cycleDuration,
                    new KeyValue(row.prefHeightProperty(), orignalPaneHeight, Interpolator.EASE_BOTH)),
            new KeyFrame(cycleDuration,
                    new KeyValue(anchorPane.prefHeightProperty(), orignalAnchorPaneHeight, Interpolator.EASE_BOTH))
        );
            resize.play();
    }

}
