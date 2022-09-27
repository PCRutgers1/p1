public enum Time {
    PILATES("09:30"),
    SPINNING("14:00"),
    CARDIO("14:00");

    private final String time;
    private Time(String time){
        this.time = time;
    }

} //define the time of a fitness class in hh:mm