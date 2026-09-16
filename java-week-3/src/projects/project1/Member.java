package projects.project1;

import java.util.Objects;

public abstract class Member {
    private String memberId;
    private String name;

    Member(String memberId, String name) {
        if (memberId == null || memberId.isBlank()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }

        this.memberId = memberId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Member other)) {
            return false;
        }

        return memberId.equals(other.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }

    @Override
    public String toString() {
        return name + " (" + memberId + ")";
    }
}

class StudentMember extends Member {
    public StudentMember(String memberId, String name) {
        super(memberId, name);
    }
}

class TeacherMember extends Member {

    public TeacherMember(String memberId, String name) {
        super(memberId, name);
    }
}