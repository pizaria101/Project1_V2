package dev.schulte.Project1;

import dev.schulte.repos.ComplaintRepo;
import dev.schulte.repos.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ComplaintRepoTests {

    @Autowired
    ComplaintRepo complaintRepo;

    @Autowired
    MeetingRepo meetingRepo;
}
