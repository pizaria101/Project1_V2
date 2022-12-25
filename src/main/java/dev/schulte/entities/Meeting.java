package dev.schulte.entities;

import javax.persistence.*;

@Entity
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id")
    private int meetingId;

    @Column(name = "address")
    private String address;

    @Column(name = "time")
    private long time;

    @Column(name = "meeting_desc")
    private String meetingDesc;

    public Meeting() {
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMeetingDesc() {
        return meetingDesc;
    }

    public void setMeetingDesc(String meetingDesc) {
        this.meetingDesc = meetingDesc;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingId=" + meetingId +
                ", address='" + address + '\'' +
                ", time=" + time +
                ", meetingDesc='" + meetingDesc + '\'' +
                '}';
    }
}
