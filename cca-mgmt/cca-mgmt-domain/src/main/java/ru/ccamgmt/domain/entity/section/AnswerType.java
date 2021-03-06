package ru.ccamgmt.domain.entity.section;

/**
 * Created by Yuriy Stolyarenko on 25.10.2015.
 */
public enum AnswerType {

    /**
     * Check box answer type
     */
    CHECK_BOX("CHECK_BOX"),

    /**
     * Check box answer type
     */
    NEW_CHECK_BOX("NEW_CHECK_BOX"),

    /**
     * Drop down answer type
     */
    DROP_DOWN("DROP_DOWN"),
    /**
     * Singleline text answer type
     */
    TEXT_BOX("TEXT_BOX"),

    TEXT_TIME_BOX("TEXT_TIME_BOX"),

    SELECT_BOX("SELECT_BOX"),
    /**
     * Multiline text answer type
     */
    TEXT_AREA("TEXT_AREA"),

    TEXT_NUMBER_BOX("TEXT_NUMBER_BOX"),

    TEXT_DATE_BOX("TEXT_DATE_BOX");

    private AnswerType(String label) {
        this.label = label;
    }

    private String label;

    public String getLabel() {
        return label;
    }
}
