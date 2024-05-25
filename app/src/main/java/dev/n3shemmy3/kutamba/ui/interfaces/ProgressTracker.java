package dev.n3shemmy3.kutamba.ui.interfaces;

import android.os.Handler;

/*
import androidx.media3.common.Player;


//https://stackoverflow.com/a/65182324/13176443
public class ProgressTracker implements Runnable {

    public interface PositionListener{
        public void progress(long position);
    }

    private final Player player;

    private final Handler handler;
    private PositionListener positionListener;

    public ProgressTracker(Player player, PositionListener positionListener) {
        this.player = player;
        this.positionListener = positionListener;
        handler = new Handler();
        handler.post(this);
    }

    public void run() {
        long position = player.getCurrentPosition();
        positionListener.progress(position);
        handler.postDelayed(this, 1000);
    }

    public void purgeHandler() {
        handler.removeCallbacks(this);
    }
}

 */