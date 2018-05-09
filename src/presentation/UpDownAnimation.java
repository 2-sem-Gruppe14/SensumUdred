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

    private static Double orignalPaneHeight;
    private static Double orignalAnchorPaneHeight;
    private AnchorPane anchorPane;
    private Pane pane;
    private RowConstraints row;
    private Duration cycleDuration = Duration.millis(500);
    private GridPane grid;

    public UpDownAnimation(AnchorPane anchorPane, GridPane grid, Pane pane, RowConstraints row) {
        this.orignalPaneHeight = row.getPrefHeight();
        this.orignalAnchorPaneHeight = anchorPane.getPrefHeight();
        this.anchorPane = anchorPane;
        this.pane = pane;
        this.grid = grid;
        this.row = row;
    }

    public void hide() {

        Timeline timeline = new Timeline(
                new KeyFrame(cycleDuration,
                        new KeyValue(row.prefHeightProperty(), 0, Interpolator.EASE_BOTH)),
                new KeyFrame(cycleDuration,
                        new KeyValue(pane.opacityProperty(), 0, Interpolator.EASE_BOTH)),
                new KeyFrame(cycleDuration,
                        new KeyValue(anchorPane.prefHeightProperty(), anchorPane.getPrefHeight() - orignalPaneHeight, Interpolator.EASE_BOTH))
        );

        timeline.play();
    }

    public void show() {

        Timeline timeline = new Timeline(
                new KeyFrame(cycleDuration,
                        new KeyValue(row.prefHeightProperty(), orignalPaneHeight, Interpolator.EASE_BOTH)),
                new KeyFrame(cycleDuration,
                        new KeyValue(pane.opacityProperty(), 1, Interpolator.EASE_BOTH)),
                new KeyFrame(cycleDuration,
                        new KeyValue(anchorPane.prefHeightProperty(), orignalAnchorPaneHeight, Interpolator.EASE_BOTH))
        );
        timeline.play();
    }

}
