package dev.schulte.services;

import dev.schulte.entities.Meeting;

import java.util.List;

public interface MeetingService {

    List<Meeting> getAllMeetings();

    Meeting createMeeting(Meeting meeting);
}
