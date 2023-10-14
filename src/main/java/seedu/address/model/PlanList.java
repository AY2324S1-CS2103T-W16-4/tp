package seedu.address.model;
import seedu.address.model.person.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Represents a list of Plans in the address book.
 * A `PlanList` contains a collection of `Plan` objects, and it provides methods for adding, deleting,
 * and sorting these plans. It is a part of the address book application.
 */
public class PlanList {

    private ArrayList<Plan> l = new ArrayList<>();

    /**
     * Creates an empty `PlanList`.
     * This constructor initializes an empty list of plans.
     */
    public PlanList() {};

    /**
     * Creates a `PlanList` with the provided list of plans.
     *
     * @param list The list of plans to initialize the `PlanList` with.
     */
    public PlanList(ArrayList<Plan> list) {
        this.l = list;
    }

    /**
     * Adds a plan to the list.
     *
     * @param t The `Plan` to be added.
     * @return `true` if the plan was added successfully, `false` if the plan already exists in the list.
     */
    public boolean add(Plan t) {
        if (l.contains(t)) {
            return false;
        }
        this.l.add(t);
        return true;
    }

    /**
     * Deletes a plan at the specified index.
     *
     * @param idx The index of the plan to be deleted.
     */
    public void del(int idx) {
        this.l.remove(idx - 1);
    }

    /**
     * Gets the number of plans in the list.
     *
     * @return The size of the plan list.
     */
    public int getSize() {
        return l.size();
    }

    /**
     * Retrieves a plan at the specified index.
     *
     * @param idx The index of the plan to retrieve.
     * @return The `Plan` object at the specified index.
     */
    public Plan get(int idx) {
        return this.l.get(idx - 1);
    }

    /**
     * Formats the list of plans as a single string.
     *
     * @return A string representation of all plans in the list.
     */
    public String format() {
        String res = "";
        for (int i = 0; i < l.size(); ++i) {
            res += l.get(i).toString();
        }
        return res;
    }

    /**
     * Sorts the list of plans by plan name in ascending order.
     *
     * @return A string representation of the plans sorted by plan name.
     */
    public String byName() {
        this.l.sort((p1, p2) -> p1.getPlanName().compareTo(p2.getPlanName()));
        String res = "";
        for (int i = 0; i < l.size(); ++i) {
            res += l.get(i).toString();
            res += '\n';
        }
        return res;
    }

    /**
     * Sorts the list of plans by plan date and time in ascending order.
     *
     * @return A string representation of the plans sorted by plan date and time.
     */
    public String byDateTime() {
        this.l.sort((p1, p2) -> p1.getPlanDateTime().compareTo(p2.getPlanDateTime()));
        String res = "";
        for (int i = 0; i < l.size(); ++i) {
            res += l.get(i).toString();
            res += '\n';
        }
        return res;
    }
}
