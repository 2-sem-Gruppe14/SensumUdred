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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.util.Duration;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UpDownAnimation {
    Double orignalHeight;
    GridPane grid;
    Pane pane;
    RowConstraints row;
    Duration cycleDuration = Duration.millis(500);

    public UpDownAnimation(GridPane grid, Pane pane, RowConstraints row) {
        this.orignalHeight = pane.getHeight();
        this.grid = grid;
        this.pane = pane;
        this.row = row;
    }
    
    public void hide(){
     Timeline timeline = new Timeline(
        new KeyFrame(cycleDuration,
                new KeyValue(row.maxHeightProperty(),0,Interpolator.EASE_BOTH)),
        new   KeyFrame(cycleDuration,
                new KeyValue(pane.opacityProperty(),0,Interpolator.EASE_BOTH)),
        new   KeyFrame(cycleDuration,
                new KeyValue(grid.maxHeightProperty(),orignalHeight-grid.getMaxHeight(),Interpolator.EASE_BOTH))
            );
            timeline.play();
    }
    
    public void show(){
         Timeline timeline = new Timeline(
        new KeyFrame(cycleDuration,
                new KeyValue(row.minHeightProperty(),orignalHeight,Interpolator.EASE_BOTH)),
        new   KeyFrame(cycleDuration,
                new KeyValue(pane.opacityProperty(),1,Interpolator.EASE_BOTH)),
        new   KeyFrame(cycleDuration,
                new KeyValue(grid.maxHeightProperty(),grid.getMaxHeight()+orignalHeight,Interpolator.EASE_BOTH))
            );
        timeline.play();
    }
    
    

}
