package seedu.address.model.person;

/**
 * A list of friends that enforces uniqueness between its elements and does not allow nulls.
 * A friend is considered unique by comparing using {@code Person#isSamePerson(Person)}. As such, adding and updating of
 * friends uses Person#isSamePerson(Person) for equality so as to ensure that the friend being added or updated is
 * unique in terms of identity in the UniqueFriendList. However, the removal of a friend uses Person#equals(Object) so
 * as to ensure that the friend with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see Person#isSamePerson(Person)
 */
public class UniqueFriendList extends UniquePersonList {}
