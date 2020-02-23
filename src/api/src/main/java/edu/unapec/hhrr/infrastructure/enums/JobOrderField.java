package edu.unapec.hhrr.infrastructure.enums;

public enum JobOrderField {
    MAXINUM_SALARY("maxinum_salary"),
    MINIMUN_SALARY("minimun_salary");

    private JobOrderField(String job) {}

    public String getStringValue() {
        return this.toString();
    }

}
