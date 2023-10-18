package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new PlanName(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new PlanName(invalidName));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> PlanName.isValidName(null));

        // invalid name
        assertFalse(PlanName.isValidName("")); // empty string
        assertFalse(PlanName.isValidName(" ")); // spaces only
        assertFalse(PlanName.isValidName("^")); // only non-alphanumeric characters
        assertFalse(PlanName.isValidName("peter*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(PlanName.isValidName("peter jack")); // alphabets only
        assertTrue(PlanName.isValidName("12345")); // numbers only
        assertTrue(PlanName.isValidName("peter the 2nd")); // alphanumeric characters
        assertTrue(PlanName.isValidName("Capital Tan")); // with capital letters
        assertTrue(PlanName.isValidName("David Roger Jackson Ray Jr 2nd")); // long names
    }

    @Test
    public void equals() {
        PlanName name = new PlanName("Valid Name");

        // same values -> returns true
        assertTrue(name.equals(new PlanName("Valid Name")));

        // same object -> returns true
        assertTrue(name.equals(name));

        // null -> returns false
        assertFalse(name.equals(null));

        // different types -> returns false
        assertFalse(name.equals(5.0f));

        // different values -> returns false
        assertFalse(name.equals(new PlanName("Other Valid Name")));
    }
}
