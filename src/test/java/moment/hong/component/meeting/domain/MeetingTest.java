package moment.hong.component.meeting.domain;

import lombok.extern.slf4j.Slf4j;
import moment.hong.component.meeting.domain.enumeration.MeetingStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MeetingTest {
    private MeetingStatus meetingStatus;

    @BeforeEach
    void setUp() {
        meetingStatus = MeetingStatus.AVAILABLE;
    }

    @Test
    void 미팅_생성_테스트() {
        //given & when
        Meeting meeting = createMeeting();
        //then
        미팅_생성_검증(meeting);
    }

    @Test
    void 미팅_상태_변경() {
        //given
        Meeting meeting = createMeeting();
        //when
        meeting.updateStatus(MeetingStatus.END);
        //then
        assertThat(meeting.getMeetingStatus()).isEqualTo(MeetingStatus.END);
    }

    @Test
    @DisplayName("localDateTime -> ZonedDateTime 변환 성공")
    void convertToZonedDateTime() {
        //given & when
        LocalDateTime localDateTime = LocalDateTime.parse("2023-05-15T00:00:00"); // Add time information
        ZonedDateTime zonedDateTime = Meeting.convertToZonedDateTime(localDateTime);
        //then
        assertThat(zonedDateTime).isEqualTo("2023-05-15T00:00+09:00[Asia/Seoul]");
    }

    private Meeting createMeeting() {
        return Meeting.builder()
                .meetingStatus(meetingStatus)
                .title("최고의 개발자")
                .description("꽤 괜찮은 개발자가 되기 위해 이것저것 합니다.")
                .meetingPlace("상암")
                .maximumPeople(4)
                .minimumPeople(1)
                .participants(3)
                .startDateTime(null)
                .endDateTime(null)
                .build();
    }

    private static void 미팅_생성_검증(Meeting meeting) {
        assertThat(meeting.getMeetingStatus()).isEqualTo(MeetingStatus.AVAILABLE);
        assertThat(meeting.getMeetingStatus().getDescription()).isEqualTo("참여 가능");
        assertThat(meeting.getId()).isNull();
        assertThat(meeting.getTitle()).isEqualTo("최고의 개발자");
        assertThat(meeting.getDescription()).isEqualTo("꽤 괜찮은 개발자가 되기 위해 이것저것 합니다.");
        assertThat(meeting.getMeetingPlace()).isEqualTo("상암");
        assertThat(meeting.getMaximumPeople()).isEqualTo(4);
        assertThat(meeting.getMinimumPeople()).isEqualTo(1);
        assertThat(meeting.getParticipants()).isEqualTo(3);
        assertThat(meeting.getStartDateTime()).isNull();
        assertThat(meeting.getEndDateTime()).isNull();
    }
}