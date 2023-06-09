package moment.hong.component.meeting.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import moment.hong.component.meeting.domain.enumeration.MeetingStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class EditMeetingForm {
    private MeetingStatus meetingStatus;
    private String title;
    private String description;
    private String meetingPlace;
    private int maximumPeople;
    private int minimumPeople;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endDateTime;

    @Builder
    public EditMeetingForm(MeetingStatus meetingStatus, String title, String description, String meetingPlace,
                           int maximumPeople, int minimumPeople, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.meetingStatus = meetingStatus;
        this.title = title;
        this.description = description;
        this.meetingPlace = meetingPlace;
        this.maximumPeople = maximumPeople;
        this.minimumPeople = minimumPeople;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}