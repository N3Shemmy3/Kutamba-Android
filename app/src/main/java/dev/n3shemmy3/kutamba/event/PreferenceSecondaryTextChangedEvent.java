package dev.n3shemmy3.kutamba.event;

public class PreferenceSecondaryTextChangedEvent {
    private final int position;
    private final String newSecondaryText;

    public PreferenceSecondaryTextChangedEvent(int position, String newSecondaryText) {
        this.position = position;
        this.newSecondaryText = newSecondaryText;
    }

    public int getPosition() {
        return position;
    }

    public String getNewSecondaryText() {
        return newSecondaryText;
    }
}
