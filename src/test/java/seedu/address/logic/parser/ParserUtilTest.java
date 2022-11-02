package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_STUDENT;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.student.Attendance;
import seedu.address.model.student.Response;
import seedu.address.model.student.StuEmail;
import seedu.address.model.student.StuName;
import seedu.address.model.student.Telegram;

public class ParserUtilTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";
    private static final String INVALID_RESPONSE = "rawr7";
    private static final String INVALID_TELEGRAM = "hello";
    private static final String INVALID_ATTENDANCE = "hihi";

    private static final String VALID_NAME = "Rachel Walker";
    private static final String VALID_PHONE = "123456";
    private static final String VALID_ADDRESS = "123 Main Street #0505";
    private static final String VALID_EMAIL = "rachel@example.com";
    private static final String VALID_TAG_1 = "friend";
    private static final String VALID_TAG_2 = "neighbour";
    private static final String VALID_RESPONSE = "81";
    private static final String VALID_TELEGRAM = "@hello";
    private static final String VALID_ATTENDANCE = "10";

    private static final String WHITESPACE = " \t\r\n";

    @Test
    public void parseIndex_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseIndex("10 a"));
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, ()
            -> ParserUtil.parseIndex(Long.toString(Integer.MAX_VALUE + 1)));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        // No whitespaces
        assertEquals(INDEX_FIRST_STUDENT, ParserUtil.parseIndex("1"));

        // Leading and trailing whitespaces
        assertEquals(INDEX_FIRST_STUDENT, ParserUtil.parseIndex("  1  "));
    }

    @Test
    public void parseStuName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseStuName((String) null));
    }

    @Test
    public void parseStuName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseStuName(INVALID_NAME));
    }

    @Test
    public void parseStuName_validValueWithoutWhitespace_returnsName() throws Exception {
        StuName expectedName = new StuName(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseStuName(VALID_NAME));
    }

    @Test
    public void parseStuName_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String nameWithWhitespace = WHITESPACE + VALID_NAME + WHITESPACE;
        StuName expectedName = new StuName(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseStuName(nameWithWhitespace));
    }

    @Test
    public void parseTelegram_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTelegram((String) null));
    }

    @Test
    public void parseTelegram_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTelegram(INVALID_TELEGRAM));
    }

    @Test
    public void parseTelegram_validValueWithoutWhitespace_returnsTelegram() throws Exception {
        Telegram expectedTelegram = new Telegram(VALID_TELEGRAM);
        assertEquals(expectedTelegram, ParserUtil.parseTelegram(VALID_TELEGRAM));
    }

    @Test
    public void parseEmail_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseStuEmail((String) null));
    }

    @Test
    public void parseEmail_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseStuEmail(INVALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithoutWhitespace_returnsEmail() throws Exception {
        StuEmail expectedEmail = new StuEmail(VALID_EMAIL);
        assertEquals(expectedEmail, ParserUtil.parseStuEmail(VALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithWhitespace_returnsTrimmedEmail() throws Exception {
        String emailWithWhitespace = WHITESPACE + VALID_EMAIL + WHITESPACE;
        StuEmail expectedEmail = new StuEmail(VALID_EMAIL);
        assertEquals(expectedEmail, ParserUtil.parseStuEmail(emailWithWhitespace));
    }

    // to replace with student class tests
    /*
    @Test
    public void parseAddress_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseAddress((String) null));
    }

    @Test
    public void parseAddress_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseAddress(INVALID_ADDRESS));
    }

    @Test
    public void parseAddress_validValueWithoutWhitespace_returnsAddress() throws Exception {
        Address expectedAddress = new Address(VALID_ADDRESS);
        assertEquals(expectedAddress, ParserUtil.parseAddress(VALID_ADDRESS));
    }

    @Test
    public void parseAddress_validValueWithWhitespace_returnsTrimmedAddress() throws Exception {
        String addressWithWhitespace = WHITESPACE + VALID_ADDRESS + WHITESPACE;
        Address expectedAddress = new Address(VALID_ADDRESS);
        assertEquals(expectedAddress, ParserUtil.parseAddress(addressWithWhitespace));
    }

    */

    @Test
    public void parseResponse_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseResponse(null));
    }

    @Test
    public void parseResponse_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseResponse(INVALID_RESPONSE));
    }

    @Test
    public void parseResponse_validValueWithoutWhitespace_returnsResponse() throws Exception {
        Response expectedResponse = new Response(VALID_RESPONSE);
        assertEquals(expectedResponse, ParserUtil.parseResponse(VALID_RESPONSE));
    }

    @Test
    public void parseAttendance_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseAttendance(null));
    }

    @Test
    public void parseAttendance_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseAttendance(INVALID_ATTENDANCE));
    }

    @Test
    public void parseAttendance_validValueWithoutWhitespace_returnsAttendance() throws Exception {
        Attendance expectedAttendance = new Attendance(VALID_ATTENDANCE);
        assertEquals(expectedAttendance, ParserUtil.parseAttendance(VALID_ATTENDANCE));
    }

}
