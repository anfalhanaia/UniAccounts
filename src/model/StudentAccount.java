
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Builder Pattern and Prototype Pattern
public class StudentAccount implements Cloneable {

    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String level;
    private String major;
    private boolean scholarship;
    private List<String> courses;

    // Constructor
    private StudentAccount(Builder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.level = builder.level;
        this.major = builder.major;
        this.scholarship = builder.scholarship;
        this.courses = new ArrayList<>(builder.courses);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLevel() {
        return level;
    }

    public String getMajor() {
        return major;
    }

    public boolean hasScholarship() {
        return scholarship;
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    // Prototype Pattern: clone the current account
    @Override
    public StudentAccount clone() {
        return new StudentAccount.Builder(
                this.id,
                this.fullName,
                this.email
        )
        .phone(this.phone)
        .level(this.level)
        .major(this.major)
        .scholarship(this.scholarship)
        .courses(this.courses)
        .build();
    }

    // Prototype Pattern: clone with new student information
    public StudentAccount clone(String id, String fullName, String email) {
        return new StudentAccount.Builder(id, fullName, email)
                .phone(this.phone)
                .level(this.level)
                .major(this.major)
                .scholarship(this.scholarship)
                .courses(this.courses)
                .build();
    }

    // Builder Pattern
    public static class Builder {

        private String id;
        private String fullName;
        private String email;
        private String phone = null;
        private String level = "L1";
        private String major = null;
        private boolean scholarship = false;
        private List<String> courses = new ArrayList<>();

        public Builder(String id, String fullName, String email) {
            this.id = id;
            this.fullName = fullName;
            this.email = email;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder level(String level) {
            this.level = level;
            return this;
        }

        public Builder major(String major) {
            this.major = major;
            return this;
        }

        public Builder scholarship(boolean scholarship) {
            this.scholarship = scholarship;
            return this;
        }

        public Builder courses(List<String> courses) {
            this.courses = new ArrayList<>(courses);
            return this;
        }

        public StudentAccount build() {

            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("ID is required");
            }

            if (fullName == null || fullName.trim().isEmpty()) {
                throw new IllegalArgumentException("Full name is required");
            }

            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("Invalid email");
            }

            if (!Arrays.asList("L1", "L2", "L3", "M1", "M2").contains(level)) {
                throw new IllegalArgumentException("Invalid level");
            }

            return new StudentAccount(this);
        }
    }
}

