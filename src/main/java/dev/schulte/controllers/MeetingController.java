package dev.schulte.controllers;

import dev.schulte.entities.Meeting;
import dev.schulte.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @GetMapping("/meetings")
    public List<Meeting> getAllMeetings(){
        return this.meetingService.getAllMeetings();
    }

    @PostMapping("/meetings")
    public Meeting createMeeting(@RequestBody Meeting meeting){
        return this.meetingService.createMeeting(meeting);
    }
}
