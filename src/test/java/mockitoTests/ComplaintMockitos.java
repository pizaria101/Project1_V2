package mockitoTests;

import dev.schulte.entities.Complaint;
import dev.schulte.entities.Status;
import dev.schulte.repos.ComplaintRepo;
import dev.schulte.repos.MeetingRepo;
import dev.schulte.services.ComplaintService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class ComplaintMockitos {

    @Autowired
    ComplaintRepo complaintRepo;

    @Autowired
    MeetingRepo meetingRepo;

    @Autowired
    ComplaintService complaintService;

    @Test
    public void create_complaint_mock(){
        ComplaintRepo complaintTestRepo = Mockito.mock(ComplaintRepo.class);
        Complaint complaint = new Complaint(0, "", Status.UNREVIEWED, -1);

        Mockito.when(complaintTestRepo.save(complaint)).thenReturn(complaint);
        Assertions.assertThrows(RuntimeException.class, () ->{
            this.complaintService.reportComplaint(complaint);
        });
    }

    @Test
    public void get_complaint_by_id_mock(){
        ComplaintRepo complaintTestRepo = Mockito.mock(ComplaintRepo.class);
        Assertions.assertThrows(RuntimeException.class, () ->{
            this.complaintService.getComplaintById(1);
        });
    }

    @Test
    public void update_complaint_status_mock(){
        ComplaintRepo complaintTestRepo = Mockito.mock(ComplaintRepo.class);
        Assertions.assertThrows(RuntimeException.class, () ->{
            this.complaintService.updateComplaintStatus(1, Status.HIGH_PRIORITY);
        });
    }

    @Test
    public void add_complaint_to_meeting_mock(){
        ComplaintRepo complaintTestRepo = Mockito.mock(ComplaintRepo.class);
        Assertions.assertThrows(RuntimeException.class, () ->{
            this.complaintService.addComplaintToMeeting(1, -1);
        });
    }
}
