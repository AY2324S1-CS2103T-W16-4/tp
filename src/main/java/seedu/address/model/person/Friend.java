package seedu.address.model.person;

import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Friend in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Friend extends Person {

    /**
     * Every field must be present and not null.
     */
    public Friend(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        super(name, phone, email, address, tags);
    }

    /**
     * Returns true if both friends have the same name.
     * This defines a weaker notion of equality between two friends.
     */
    public boolean isSameFriend(Friend otherFriend) {
        if (otherFriend == this) {
            return true;
        }

        return otherFriend != null
                && otherFriend.getName().equals(getName());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Friend)) {
            return false;
        }

        Friend otherFriend = (Friend) other;
        return name.equals(otherFriend.name)
                && phone.equals(otherFriend.phone)
                && email.equals(otherFriend.email)
                && address.equals(otherFriend.address)
                && tags.equals(otherFriend.tags);
    }

}
