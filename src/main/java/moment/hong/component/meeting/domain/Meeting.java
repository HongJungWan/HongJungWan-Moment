package moment.hong.component.meeting.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import moment.hong.component.meeting.domain.enumeration.MeetingStatus;
import moment.hong.core.common.BaseEntity;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Meeting extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "meeting_status")
    private MeetingStatus meetingStatus;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "description", length = 700)
    private String description;

    @Column(name = "meeting_place", length = 300)
    private String meetingPlace;

    @Column(name = "maximum_people")
    private int maximumPeople;

    @Column(name = "minimum_people")
    private int minimumPeople;

    @Column(name = "participants")
    private int participants;

    @Column(name = "start_date_time")
    private ZonedDateTime startDateTime;

    @Column(name = "end_date_time")
    private ZonedDateTime endDateTime;

    @Builder
    public Meeting(MeetingStatus meetingStatus, String title, String description,
                   String meetingPlace, int maximumPeople, int minimumPeople, int participants,
                   ZonedDateTime startDateTime, ZonedDateTime endDateTime) {
        this.meetingStatus = meetingStatus;
        this.title = title;
        this.description = description;
        this.meetingPlace = meetingPlace;
        this.maximumPeople = maximumPeople;
        this.minimumPeople = minimumPeople;
        this.participants = participants;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public void updateStatus(MeetingStatus meetingStatus) {
        this.meetingStatus = meetingStatus;
    }
}