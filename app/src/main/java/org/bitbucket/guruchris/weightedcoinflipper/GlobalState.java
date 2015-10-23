package org.bitbucket.guruchris.weightedcoinflipper;

import android.app.Application;

public class GlobalState extends Application{
    private int streak = 0;
    private double weighting = .5; //Odds that coin will be heads
    private boolean isHeads = true;

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public double getWeighting() {
        return weighting;
    }

    public void setWeighting(double weighting) {
        this.weighting = weighting;
    }

    public boolean isHeads() {
        return isHeads;
    }

    public void setIsHeads(boolean isHeads) {
        this.isHeads = isHeads;
    }
}
