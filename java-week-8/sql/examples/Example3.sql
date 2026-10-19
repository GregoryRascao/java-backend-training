-- Example 3: FOREIGN KEY and relationship modeling
-- one-to-many: one student -> many enrollment
-- many-to-many: students <-> courses through enrollment

CREATE TABLE enrollment (
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    enrolled_at DATE,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO enrollment (student_id, course_id, enrolled_at)
VALUES
    (1, 10, '2026-03-01'),
    (1, 20, '2026-03-01'),
    (2, 20, '2026-03-01');

UPDATE enrollment
SET enrolled_at = '2026-03-02'
WHERE student_id = 2 AND course_id = 20;
