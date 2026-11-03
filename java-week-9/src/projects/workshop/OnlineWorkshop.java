public class OnlineWorkshop extends Workshop {
    String meetingUrl;

    public OnlineWorkshop(int id, String title, int capacity, String meetingUrl){
        super(id, title, capacity);
                if (meetingUrl == null || meetingUrl.isBlank()) {
            throw new IllegalArgumentException("Meeting URL cannot be blank");
        }

        this.meetingUrl = meetingUrl.trim();
    }
        public String getMeetingUrl() {
        return meetingUrl;
    }

    @Override 
    public String joiningInstructions(){
        return "Join at " + meetingUrl + ".";
    }
}
