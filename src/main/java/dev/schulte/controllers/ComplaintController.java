package dev.schulte.controllers;

import dev.schulte.entities.Complaint;
import dev.schulte.entities.Status;
import dev.schulte.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @PostMapping("/complaints")
    public Complaint createComplaint(@RequestBody Complaint complaint){
        Complaint savedComplaint = this.complaintService.reportComplaint(complaint);
        return savedComplaint;
    }

    @GetMapping("/complaints")
    public List<Complaint> getAllComplaints(){
        List<Complaint> returnComplaints = this.complaintService.getAllComplaints();
        return returnComplaints;
    }

    @GetMapping("/complaints/{id}")
    public Complaint getComplaintById(@PathVariable String id){
        int complaintId = Integer.parseInt(id);
        Complaint returnComplaint = this.complaintService.getComplaintById(complaintId);
        return returnComplaint;
    }

    @PutMapping("/complaints/{id}/{status}")
    public Complaint updateComplaintStatus(@PathVariable String id, @PathVariable String status){
        int complaintId = Integer.parseInt(id);
        Complaint getComplaint = new Complaint();
        switch(status.toLowerCase()){

            case "addressed":
                getComplaint = this.complaintService.updateComplaintStatus(complaintId, Status.ADDRESSED);
                break;

            case "high":
                getComplaint = this.complaintService.updateComplaintStatus(complaintId, Status.HIGH_PRIORITY);
                break;

            case "low":
                getComplaint = this.complaintService.updateComplaintStatus(complaintId, Status.LOW_PRIORITY);
                break;

            case "ignore":
                getComplaint = this.complaintService.updateComplaintStatus(complaintId, Status.IGNORED);
                break;
        }

        return getComplaint;
    }

    @PutMapping("/complaints/{id}/{meeting_id}")
    public Complaint addComplaintToMeeting(@PathVariable String id, @PathVariable String meeting_id){
        int complaintId = Integer.parseInt(id);
        int meetingId = Integer.parseInt(meeting_id);
        return this.complaintService.addComplaintToMeeting(complaintId, meetingId);
    }
}
