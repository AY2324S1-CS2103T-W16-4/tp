package seedu.address.model.plan;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.PlanName;

class PlanNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new seedu.address.model.plan.PlanName(null));
    }

    @Test
    public void constructor_invalidPlanName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new seedu.address.model.plan.PlanName(invalidName));
    }

    @Test
    public void isValidPlanName() {
        // null name
        assertThrows(NullPointerException.class, () -> seedu.address.model.plan.PlanName.isValidPlanName(null));

        // invalid name
        assertFalse(PlanName.isValidName("")); // empty string
        assertFalse(PlanName.isValidName(" ")); // spaces only
        assertFalse(PlanName.isValidName("^")); // only non-alphanumeric characters
        assertFalse(PlanName.isValidName("dota*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(PlanName.isValidName("play some dota")); // alphabets only
        assertTrue(PlanName.isValidName("12345")); // numbers onlyß
        assertTrue(PlanName.isValidName("play some dota 2")); // alphanumeric characters
        assertTrue(PlanName.isValidName("Capital Tan")); // with capital letters
        assertTrue(PlanName.isValidName("David Roger Jackson Ray Jr 2nd")); // long names
    }

    @Test
    public void equals() {
        seedu.address.model.plan.PlanName planName = new seedu.address.model.plan.PlanName("Valid Name");

        // same values -> returns true
        assertTrue(planName.equals(new seedu.address.model.plan.PlanName("Valid Name")));

        // same object -> returns true
        assertTrue(planName.equals(planName));

        // null -> returns false
        assertFalse(planName.equals(null));

        // different types -> returns false
        assertFalse(planName.equals(5.0f));

        // different values -> returns false
        assertFalse(planName.equals(new seedu.address.model.plan.PlanName("Other Valid Name")));
    }
}
