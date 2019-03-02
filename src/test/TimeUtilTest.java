package test;

import com.util.time.TimeUtil;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TimeUtilTest {

    @Test
    public void convertToBasic() {
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        String answer = "20190227";

        // when
        String output = TimeUtil.convertToBasic(ld);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToMMdd() {
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        String answer = "0227";

        // when
        String output = TimeUtil.convertToMMdd(ld);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToHHmmss() {
        // given
        LocalTime lt = LocalTime.of(12, 34, 56);
        String answer = "123456";

        // when
        String output = TimeUtil.convertToHHmmss(lt);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToBasic_yyyyMMdd() {
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalTime lt = LocalTime.of(12, 34, 56);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        String answer = "20190227";

        // when
        String output = TimeUtil.convertToBasic(ldt);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToYyyyMMddHHmmss() {
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalTime lt = LocalTime.of(12, 34, 56);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        String answer = "20190227123456";

        // when
        String output = TimeUtil.convertToYyyyMMddHHmmss(ldt);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToYyyyMMddHHmmss2() {
        //yyyyMMdd HH:mm:ss
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalTime lt = LocalTime.of(12, 34, 56);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        String answer = "20190227 12:34:56";

        // when
        String output = TimeUtil.convertToYyyyMMddHHmmss2(ldt);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertFromBasic() {
        // given
        String date = "20190227";
        LocalDate answer = LocalDate.of(2019, 2, 27);

        // when
        LocalDate output = TimeUtil.convertFromBasic(date);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertFromYyMMdd() {
        // given
        String date = "190227";
        LocalDate answer = LocalDate.of(2019, 2, 27);

        // when
        LocalDate output = TimeUtil.convertFromYyMMdd(date);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void getStartOfMonth() {
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalDate answer = LocalDate.of(2019, 2, 1);

        // when
        LocalDate output = TimeUtil.getStartOfMonth(ld);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToUtc() {
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalTime lt = LocalTime.of(12, 34, 56);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);

        LocalDate ld2 = LocalDate.of(2019, 2, 27);
        LocalTime lt2 = LocalTime.of(12, 34, 56).minusHours(9);
        LocalDateTime answer = LocalDateTime.of(ld2, lt2);

        // when
        LocalDateTime output = TimeUtil.convertToUtc(ldt);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToMMddHHmmss() {
        //MMddHHmmss
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalTime lt = LocalTime.of(12, 34, 56);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        String answer = "0227123456";

        // when
        String output = TimeUtil.convertToMMddHHmmss(ldt);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToUtcMMddHHmmss() {
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalTime lt = LocalTime.of(12, 34, 56);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);

        String answer = "0227033456";

        // when
        String output = TimeUtil.convertToUtcMMddHHmmss(ldt);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToLocalDateTime() {
        // given
        Calendar cal = Calendar.getInstance();
        cal.set(2019, 1, 27, 12, 34, 56);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();

        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalTime lt = LocalTime.of(12, 34, 56);
        LocalDateTime answer = LocalDateTime.of(ld, lt);

        // when
        LocalDateTime output = TimeUtil.convertToLocalDateTime(date);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToDate() {
        // given
        Calendar cal = Calendar.getInstance();
        cal.set(2019, 1, 27, 12, 34, 56);
        cal.set(Calendar.MILLISECOND, 0);
        Date answer = cal.getTime();

        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalTime lt = LocalTime.of(12, 34, 56);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);

        // when
        Date output = TimeUtil.convertToDate(ldt);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertFromMMddHHmmss() {
        //MMddHHmmss
        // given
        String input = "190227123456";

        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalTime lt = LocalTime.of(12, 34, 56);
        LocalDateTime answer = LocalDateTime.of(ld, lt);

        // when
        LocalDateTime output = TimeUtil.convertFromMMddHHmmss(input);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertFromYyyyMMddHHmmss() {
        //yyyyMMddHHmmss
        // given
        String input = "20190227123456";

        LocalDate ld = LocalDate.of(2019, 2, 27);
        LocalTime lt = LocalTime.of(12, 34, 56);
        LocalDateTime answer = LocalDateTime.of(ld, lt);

        // when
        LocalDateTime output = TimeUtil.convertFromYyyyMMddHHmmss(input);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToYyyyMM() {
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        String answer = "201902";

        // when
        String output = TimeUtil.convertToYyyyMM(ld);

        // then
        Assert.assertThat(output, is(answer));
    }

    @Test
    public void convertToYyyyMMdd() {
        // given
        LocalDate ld = LocalDate.of(2019, 2, 27);
        String answer = "20190227";

        // when
        String output = TimeUtil.convertToYyyyMMdd(ld);

        // then
        Assert.assertThat(output, is(answer));
    }
}
