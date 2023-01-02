package dev.schulte.services;

import dev.schulte.entities.Meeting;
import dev.schulte.repos.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService{

    @Autowired
    MeetingRepo meetingRepo;

    @Override
    public List<Meeting> getAllMeetings() {

        return this.meetingRepo.findAll();
    }

    @Override
    public Meeting createMeeting(Meeting meeting) {

        return this.meetingRepo.save(meeting);
    }
}
