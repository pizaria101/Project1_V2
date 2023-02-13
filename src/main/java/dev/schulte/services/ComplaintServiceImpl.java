package dev.schulte.services;

import dev.schulte.entities.Complaint;
import dev.schulte.entities.Status;
import dev.schulte.exceptions.BlankDescriptionException;
import dev.schulte.exceptions.ComplaintNotFoundException;
import dev.schulte.exceptions.NoComplaintFoundException;
import dev.schulte.repos.ComplaintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService{

    @Autowired
    ComplaintRepo complaintRepo;

    @Override
    public Complaint reportComplaint(Complaint complaint) {

        if(complaint.getComplaintDesc().length() == 0){
            throw new BlankDescriptionException("Description cannot be blank");
        }

        return this.complaintRepo.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {

        return this.complaintRepo.findAll();
    }

    @Override
    public Complaint getComplaintById(int complaintId) {

        Optional<Complaint> possibleComplaint = this.complaintRepo.findById(complaintId);

        if(possibleComplaint.isPresent()){
            return possibleComplaint.get();
        }else{
            throw new NoComplaintFoundException("No complaint found");
        }

    }

    @Override
    public Complaint updateComplaintStatus(int complaintId, Status status) {

        Optional<Complaint> possibleComplaint = this.complaintRepo.findById(complaintId);

        if(possibleComplaint.isPresent()){
            Complaint complaint = possibleComplaint.get();

            complaint.setStatus(status);

            return this.complaintRepo.save(complaint);
        }else{
            throw new ComplaintNotFoundException("Complaint not found");
        }

    }

    @Override
    public Complaint addComplaintToMeeting(int complaintId, int meetingId) {

        Optional<Complaint> possibleComplaint = this.complaintRepo.findById(complaintId);

        if(possibleComplaint.isPresent()){
            Complaint complaint = possibleComplaint.get();

            complaint.setMeetingId(meetingId);

            return this.complaintRepo.save(complaint);
        }else{
            throw new ComplaintNotFoundException("Complaint not found");
        }
    }
}
